package co.edu.unbosque.sistemamestmejorado;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SystemController Controlador = new SystemController();
		
		System.out.println("Bienvenido al sistema de gestión estudiantil");
		System.out.println("Versión: 2.0");
		System.out.println("Desarrollado por: Johann!");
		System.out.println();
		
		while(true) {
			Controlador.responseSelection(Controlador.startApp());
		}
		
	}

}
