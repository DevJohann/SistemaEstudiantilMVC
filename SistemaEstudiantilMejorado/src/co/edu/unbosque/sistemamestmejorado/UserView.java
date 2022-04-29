package co.edu.unbosque.sistemamestmejorado;
import java.util.Scanner;
import java.util.ArrayList;

public class UserView {
	
	Scanner scan = new Scanner(System.in);

	public int mainMenu() {
		
		System.out.println("Que desea hacer?");
		
		int resMainMenu;
		
		while(true) {
			System.out.println("1. Agregar estudiante");
			System.out.println("2. Consultar estudiante");
			System.out.println("3. Eliminar estudiante");
			System.out.println("4. Modificar estudiante");
			System.out.println("5. Ver lista completa de estudiantes");
			System.out.print("Elija: ");
			resMainMenu = scan.nextInt();
			
			if(resMainMenu == 1 || resMainMenu == 2 || resMainMenu == 3 || resMainMenu == 4 || resMainMenu == 5) {
				return resMainMenu;
			}
			else {
				System.out.println("Error, opción inválida");
				continue;

			}
		}
	}
	
	public ArrayList<String> addStudentGathering() {
		ArrayList<String> returnableData = new ArrayList<String>();
		
		System.out.println("Ingrese el nombre del estudiante:");
		returnableData.add(scan.next());
		System.out.println("Ingrese la edad del estudiante: ");
		returnableData.add(scan.next());
		System.out.println("Ingrese el grado que cursa: ");
		returnableData.add(scan.next());
		
		return returnableData;
	}
	
	public String getStudentDataGathering(){
		//ArrayList<String> returnableData = new ArrayList<String>();
		System.out.println("Ingrese el nombre para la operación: ");
		String nameGathered = scan.next();
		return nameGathered;
		//return returnableData;
	}
	
	public void showStudentDetails(String name, String age, String year) {
		System.out.println("Nombre: " + name);
		System.out.println("Edad: " + age);
		System.out.println("Grado: " + year + "°");
		System.out.println();
	}
	public void showAllStudents(ArrayList<SystemModel> data) {
		int id = 1;
		for(SystemModel model : data) {
			System.out.println("ID: " + id);
			System.out.println("Nombre: " + model.getName());
			System.out.println();
			id++;
		}
	}
	public int showModifyMenu() {
		System.out.println("Que desea modificar: ");
		System.out.println("1. Nombre");
		System.out.println("2. Edad");
		System.out.println("3. Grado");
		System.out.println("0. Volver");
		int responseModifyMenu = scan.nextInt();
		return responseModifyMenu;
	}
	public String compareResponseModify(int value) {
		String returnableData = "";
		int response = value;
		switch(response) {
		case 1:
			System.out.println("Ingrese el nuevo nombre: ");
			returnableData = scan.next();
			break;
		case 2:
			System.out.println("Ingrese la nueva edad: ");
			returnableData = scan.next();
			break;
		case 3:
			System.out.println("Ingrese el nuevo grado: ");
			returnableData = scan.next();
			break;
		case 4:
			returnableData = "false";
			ok();
			break;
		default:
			System.out.println("Opción inválida");
			showModifyMenu();
		}
		return returnableData;
	}
	
	public void ok() {
		System.out.println("OK");
		System.out.println();
	}
	public void failure() {
		System.out.println("NOT OK");
		System.out.println();
	}
	public void notFound() {
		System.out.println("404 DATA NOT FOUND");
		System.out.println();
	}
}
