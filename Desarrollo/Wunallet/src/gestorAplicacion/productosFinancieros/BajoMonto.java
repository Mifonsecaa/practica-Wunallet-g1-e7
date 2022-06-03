package gestorAplicacion.productosFinancieros;

import java.util.ArrayList;

import gestorAplicacion.infoClientes.Banco;
import gestorAplicacion.infoClientes.Transaccion;
import gestorAplicacion.infoClientes.Usuario;
import java.io.Serializable;



public class BajoMonto extends Ahorro implements Serializable{
	private float limiteMensual;
	private float acumuladorTransferencia;
	
    // El Array de clase de clientes de encarga de guardar todas las instancias de
    // Cliente para poder guardar y cargarlas en la serializacion
	private static ArrayList<BajoMonto> bajoMonto = new ArrayList<>();
	
	
	public BajoMonto(int nroCuenta, Usuario titular,float saldo,Banco banco,String tipoDeCuenta,float tasaDeInteres,float limiteMensual,float acumuladorTransferencia) {
		super(nroCuenta,titular,saldo,banco,tipoDeCuenta,tasaDeInteres);
		this.limiteMensual = limiteMensual;
		this.acumuladorTransferencia = acumuladorTransferencia;
//		banco.getListaCuentas().add(this);
		bajoMonto.add(this);

		
//		titular.getCuentasAsocidas().add(this);
	}
	
//	-------------------------------------- Metodos get-set --------------------------------------
//	get-set limiteMensual
	
    public static ArrayList<BajoMonto> getBajoMonto() {
        return bajoMonto;
    }

    public static void setBajoMonto(ArrayList<BajoMonto> bajoMonto) {
        BajoMonto.bajoMonto = bajoMonto;
    }
	
	
	public void setLimiteMensual(float limiteMensual) {
		this.limiteMensual = limiteMensual;
	}
	public float getlimiteMensual() {
		return this.limiteMensual;
	}	
//	get-set acumuladorTransferencia
	public void setAcumuladorTransferencia(float acumuladorTransferencia) {
		this.acumuladorTransferencia = acumuladorTransferencia;
	}
	public float getAcumuladorTransferencia() {
		return this.acumuladorTransferencia;
	}	
	
	public ArrayList<Transaccion> getHistorialTransferencia(){
		return this.historialTransferencia;
	}
	
	public void setHistorialTransferencia(ArrayList<Transaccion> historial){
		this.historialTransferencia = historial;
	}
	
	
	public boolean transferir(Cuenta cuentaDestino, float valorTransferencia) {
		
		if(this.saldo >= valorTransferencia && valorTransferencia + acumuladorTransferencia <= limiteMensual ) {
			

			this.restarSaldo(valorTransferencia);

			cuentaDestino.sumarSaldo(valorTransferencia);
			
			Transaccion trans = new Transaccion(this,cuentaDestino,valorTransferencia);
			
			historialTransferencia.add(trans);
			cuentaDestino.historialTransferencia.add(trans);

			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean transferir(Credito credito) {
		
		if(this.saldo >= credito.getCuotaMensual()&& credito.getCuotaMensual() + acumuladorTransferencia <= limiteMensual ) {
			

			
			
			this.restarSaldo(credito.getCuotaMensual());

			
			
			credito.setDeuda(credito.getDeuda()-credito.getCuotaMensual());
			
			Transaccion trans = new Transaccion(this,credito.getBanco().getNombreBanco(),credito.getCuotaMensual());
			
			historialTransferencia.add(trans);
			
			
			return true;
			
		}
		
		else {
			return false;
		}

	}
	
	
	public boolean romperTopes() {
		boolean salida = false;
		if(this.getSaldo()<costoRomperTopes) {
			salida=false;
		}else {
			Ahorro nuevaCuentaAhorro = new Ahorro(this.getNroCuenta(),this.getTitular(),(this.getSaldo()-costoRomperTopes),this.getBanco(),"ahorro",this.getTasaDeInteres());
			nuevaCuentaAhorro.setHistorialTransferencia(this.getHistorialTransferencia());
			salida=true;
		}
		return salida;
	}
	

}
