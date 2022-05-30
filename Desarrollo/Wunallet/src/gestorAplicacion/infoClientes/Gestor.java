package gestorAplicacion.infoClientes;
import java.util.ArrayList;

public interface Gestor{
	public static final float sobregiroMaximo = 600000;
	
//	Modificar
	public default void eliminarCuenta() {
		
	}
	
	
	public abstract void sumarCuenta(float valorTransferencia);
	public abstract void restarCuenta(float valorTransferencia);
	
}
