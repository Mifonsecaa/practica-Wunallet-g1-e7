package cGrafica;
import java.util.Scanner;
import cLogica.Usuario;
import cLogica.Banco;
import cLogica.Credito;
import cLogica.PerfilCreditico;
import cLogica.Cuenta;
import cLogica.Ahorro;
import cLogica.Corriente;
import cLogica.BajoMonto;


public class Banquero {

	static Scanner sc = new Scanner(System.in);
	
	static long readLong() {
		return sc.nextLong();
	}
	
	static int readInt() {
		return sc.nextInt();
	}
	
	static String readln() {
		sc.nextLine();
		return sc.nextLine();
	}
	
	
	
	public static void main (String args[]) {
		
//	Creación de algunos bancos
	Banco Unalombia = new Banco("Unalombia");
	Banco PooBanco = new Banco("PooBanco");
	Banco QuitaVivienda = new Banco("QuitaVivienda");
	
//	Creación de algunos usuarios
	Usuario juanPerez = new Usuario(null,1000000,10109878,null);
	Usuario hernestoPerez = new Usuario(null,1000000,98783268,null);
	
//	Creación de algunas cuentas
//	Ahorro(int nroCuenta, Usuario titular,float saldo,Banco banco,String tipoDeCuenta,float tasaDeInteres)
//	BajoMonto(int nroCuenta, Usuario titular,float saldo,Banco banco,String tipoDeCuenta,float tasaDeInteres,float limiteMensual,float acumuladorTransferencia) 
//	Corriente(int nroCuenta, Usuario titular,float saldo,Banco banco,String tipoDeCuenta,float sobregiroActual)
	
	Cuenta cuenta1 = new Ahorro(89,juanPerez, (float)10000.0 ,QuitaVivienda,"ahorro",(float)32.0);
	Cuenta cuenta2 = new BajoMonto(69,hernestoPerez, (float)1000000.0,PooBanco, "bajoMonto", (float)5.0,(float)3000000.0,(float)3000000.0);
	Cuenta cuenta3 = new Corriente(23,juanPerez,(float)50000000.0,Unalombia,"corriente",(float)2000000);
	
		
		int optionUser;
		Usuario usuario;
		do {
			System.out.println("¿Que usuario desea realizar?");
			System.out.println(" 1. Juan Perez");
			System.out.println(" 2. Hernesto Perez");
			System.out.println(" 0. Salida segura");
			System.out.print("Ingrese la opcion :");
			optionUser = (int) readLong();
				
			
			switch (optionUser) {
//			Primer usuario.
			case 1: usuario = juanPerez; 
					funcionalidadesEjecucion(usuario);
					break;
					
				
//			Segundo usuario.
			case 2: usuario = hernestoPerez;
					funcionalidadesEjecucion(usuario);
					break;
				
			}
		} while(optionUser != 5);
		

		
		
		
		
		
	}
	
	
	public static void funcionalidadesEjecucion(Usuario usuario) {
		int option;
		
		
		do {
			System.out.println("¿Que operacion desea realizar?");
			System.out.println(" 1. Inscribir cuenta");
			System.out.println(" 2. Romper topes");
			System.out.println(" 3. Solicitar credito");
			System.out.println(" 4. Ver historial de transacciones");
			System.out.println(" 5. Tranferir");
			System.out.println(" 6. Salida segura");
			System.out.println(" 7. Volver al menu de usuarios");
			System.out.print("Ingrese la opcion :");
			
			option = (int) readLong();
			
			switch(option) {
//			case 1: System.out.print("Metodo que ejecuta a inscribir cuentas");break;
			case 1: inscribirCuenta(usuario);break;
			case 2: System.out.print("Metodo que ejecuta a romper topes");break;
			case 3: System.out.print("Metodo que ejecuta a solicitar credito");break;
			case 4: System.out.print("Metodo que ejecuta a ver historial de transacciones");break;
			case 5: System.out.print("Metodo que ejecuta a tranferir");break;
			case 6: break;
//			Hacen lo mismo xD
			case 7: break;
			}
			
		}while(option != 7);
	}
	
	
	
	
//	-------------------------------------- Metodos --------------------------------------	
	
	
	
	static void inscribirCuenta(Usuario usuario) {
		
		System.out.println("-------------- Inscribir cuenta ------------------");
		
		
		
//		Selección del banco - InscribirCuenta.SeleccionBanco
	
		System.out.println("-------------- Seleección del banco --------------");
		int c = 0;
		for(Banco i: Banco.listaBancos) {
			System.out.println((c+1) + ". " + i.getNombreBanco());
			c++;
		}
		System.out.println("Seleccione de qué banco es la cuenta que desea inscribir: ");
		int numBanco = readInt();
		
		
		String nombreBanco = null;
		
        Banco banco = Banco.listaBancos.get(numBanco-1);
		nombreBanco = banco.getNombreBanco();
		System.out.println(" Usted seleccioó " + nombreBanco);

		
//		Seleccione el tipo de cuenta - InscribirCuenta.SeleccionTipoCuenta
		
		System.out.println("-------------- Seleección tipo de cuenta --------------");
		System.out.println("1. Cuenta de bajo monto ");
		System.out.println("2. Cuenta de ahorros");
		System.out.println("3. Cuenta corriente ");
		System.out.println("4. Volver al menú de funcionalidades");
		System.out.println("Seleccione el tipo de cuenta: ");
		int tipCuenta = readInt(); 
		
		String tipoCuenta = null;
		
		switch(tipCuenta) {
		case 1: tipoCuenta = "bajoMonto";break;
		case 2: tipoCuenta = "ahorro";break;
		case 3: tipoCuenta = "corriente";break;
		}
//		System.out.println(" Usted seleccioó " + tipoCuenta);
		
//		Selección del banco - InscribirCuenta.IngresoNumeroCuenta
		
		System.out.println("--------- Insersión del número de cuenta --------------");
		System.out.println("Ingrese el número de la cuenta: ");
		int numeroCuenta = readInt();
		
//		Comprobación de la existencia de la cuenta
		
		Cuenta existeCuenta = banco.extraerCuenta(numeroCuenta);
		if (existeCuenta != null) {
			
		}else {
			System.out.println("Numero de cuenta "+numeroCuenta+" no existe en el banco:" + nombreBanco);
			return ;
			
		}
		
//		Selección del banco - InscribirCuenta.IngresoNumeroCedula
		
		System.out.println("--------- Insersión del número de cédula --------------");
		System.out.println("Ingrese el número de cedula: ");
		int numeroCc = readInt();

//		Comprobación de la existencia del usuario
		
		Usuario existeUsuario = existeCuenta.getTitular();
		
		if (existeUsuario.getCc() == numeroCc) {
			
		}else {
			System.out.println("Numero de cedula "+numeroCc+" no concuerda con la cuenta");
			return ;
		}
		
//		Llamado del método inscribir
		
		
		usuario.inscribir(numeroCc,numeroCuenta,tipoCuenta,nombreBanco);
		System.out.println(usuario);
		System.out.println(usuario.getListaIncritos());
//		hola mundo
		
	
	}
	
	
	
	
	
	
	

}
