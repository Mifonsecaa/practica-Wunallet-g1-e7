package cLogica;
import java.util.ArrayList;

public abstract class Cuenta implements Gestor{
	
	protected int nroCuenta;
	protected Usuario titular;
	protected float saldo;
	protected Banco banco;
	protected String tipoDeCuenta;
	protected ArrayList<Transaccion> historialTransferencia = new ArrayList<Transaccion>();
	
	
	public Cuenta(int nroCuenta, Usuario titular,float saldo,Banco banco,String tipoDeCuenta) {
		this.nroCuenta = nroCuenta;
		this.titular = titular;
		this.saldo = saldo;
		this.banco = banco;
		this.tipoDeCuenta = tipoDeCuenta;
		
	}
	
//	-------------------------------------- Metodos get-set --------------------------------------

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public int getNroCuenta() {
		return this.nroCuenta;
	}
	
	public void setTitular(Usuario titular) {
		this.titular = titular;
	}
	public Usuario getTitular() {
		return this.titular;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float getSaldo() {
		return this.saldo;
	}
	
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	public Banco getBanco() {
		return this.banco;
	}
	
	public void setTipoCuenta(String tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}
	public String getTipoCuenta() {
		return this.tipoDeCuenta;
	}
	
	
	//--------------------------------------------------------------------------------------

	public void verHistorial() {
		for(int i=0;i<historialTransferencia.size();i++) {
			System.out.print(historialTransferencia.get(i));
		}
	}
	
}
