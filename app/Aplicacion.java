package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelos.Proveedor;
import modelos.Cliente;
import modelos.Factura;
import modelos.Productos;


public class Aplicacion {
	 /*constates menu principal */
    private static final int SALIR = 0;
    private static final int GESTION_CLIENTES = 1;
    private static final int GESTION_PROVEEDORES = 2;
    private static final int GESTION_PRODUCTOS = 3;
    private static final int GESTION_FACTURACION = 4;
    /* constates sub menu */
    private static final int CREAR = 1;
    private static final int BUSCAR = 2;
    private static final int ACTUALIZAR = 3;
    private static final int ELIMINAR = 4;
    /*Variable del tipo Scanner */
    public static Scanner teclado;
    public static void main(String[] args){
        teclado = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Proveedor> proveedores = new ArrayList<>();
        List<Productos> productos = new ArrayList<>();
        List<Factura> facturas = new ArrayList<>();
        int opcion;
        int opcionSubMenu;
        do{
            do{
                mostrarMenu();
                opcion = capturarEntero("Cual es su opcion ? ");
                if(opcion < SALIR || opcion > GESTION_FACTURACION){
                    System.out.println("Error , se debe digitar un valor entre 0 y 4");
                }

            }while(opcion < SALIR || opcion > GESTION_FACTURACION);
            if(opcion == SALIR) {
            	break;
            }
            
            switch(opcion) {
            	case GESTION_CLIENTES:
            		do {
            			mostrarSubMenu("Clientes");
            			opcionSubMenu = capturarEntero("Que desea hacer? ");
            			if(opcionSubMenu < SALIR || opcionSubMenu > ELIMINAR) {
            				System.out.println("Error , el numero no esta en el rango");
            			}
            		}while(opcionSubMenu < SALIR || opcion > ELIMINAR);
            		
            		if(opcionSubMenu == SALIR) {
            			break;
            		}
            		/*Se lee la opcion del menu de Gestion Clientes*/
            		switch(opcionSubMenu) {
            			case CREAR:
            				crearCliente(clientes);
            				break;
            			
            			case BUSCAR:
            				break;
            			case ACTUALIZAR:
            				break;
            			case ELIMINAR:
            				break;
            				
            		}
            		break;/* gestion clientes cierre */
            	case GESTION_PROVEEDORES:
            		
            		break;
            		
            	case GESTION_PRODUCTOS:
            		
            		break;
            		
            	case GESTION_FACTURACION:
            		
            		break;
            }/*Case */
        }while(opcion != SALIR);/* cierre del do while */
    }/* main */

    private static void crearCliente(List<Cliente> clientes) {
		//Muestro el mensaje de informacion
    	System.out.println("-----Crear Cliente-----");
    	int numeroCedula;
    	int numeroTelefono;
    	String cedula;
    	String nombres;
    	String apellidos;
    	String direccion;
    	String correoElectronico;
    	do {
    		numeroCedula = capturarEntero("Cual es su numero de cedula? ");
    		if(numeroCedula<=0) {
    			System.out.println("Cedula incorrecta ");
    			numeroCedula=0;
    			continue;
    		}
    		cedula = String.valueOf(numeroCedula);
    		Cliente cliente = buscarClientePorCedula(clientes,cedula);
    		if(cliente != null) {
    			System.out.println("Ya existe esa numero de cedula");
    			numeroCedula=0;
    		}
    	}while(numeroCedula<=0);
    	/* solicito informacion al usuario */
    	nombres = capturarCaracteres("Cual es el nombre del cliente? ");
    	apellidos = capturarCaracteres("Cual es el apellido del cliente? ");
    	/*validacion del numero de telefono */
    	do {
    		numeroTelefono = capturarEntero("Cual es el numero de telefono? ");
    		if(numeroTelefono <= 0) {
    			System.out.println("Error, numero de telefono invalido");
    		}
    	}while(numeroTelefono <= 0);
    	/*direccion */
    	direccion = capturarCaracteres("Cual es su direccion? ");
    	/* validamos el correo electronico */
    	while(true){
    		correoElectronico = capturarCaracteres("Cual es el correo ? ");
    		if(!validarCorreo(correoElectronico)) {
    			System.out.println("Correo no valido, no mames wey");
    			continue;
    		}
    		break;
    	}
    	
	}
    /* Funcion para buscar un cliente por numero de cedula */
	private static Cliente buscarClientePorCedula(List<Cliente> clientes, String cedula) {
		for (Cliente cliente : clientes) {
			if(cliente.getCedula().equals(cedula)) {
				return cliente;
			}
		}
		return null;
	}

	/* Menu de principal de usuario */
    public static void mostrarMenu(){
        System.out.println("--- Menu Principal ---");
        System.out.println("1- Gestion Clientes");
        System.out.println("2- Gestion Proveedores");
        System.out.println("3- Gestion Productos");
        System.out.println("4- Gestion Facturación");
        System.out.println("0- Salir"); 
    }
    /*Sub Menu */
    public static void mostrarSubMenu(String tipoMenu) {
        System.out.printf("*** Menu Gestion %s ***\n",tipoMenu);
        System.out.println("1- Crear");
        System.out.println("2- Buscar");
        System.out.println("3- Actualizar");
        System.out.println("4- Eliminar");
        System.out.println("0- Salir"); 
    }
    /*Menu facturacion */
    public static void mostrarMenuFacturacion() {
        System.out.printf("*** Menu Gestion Facturacion ***");
        System.out.println("1- Crear");
        System.out.println("2- Buscar");
        System.out.println("0- Salir"); 
    }

    /*Validaciones de entrada de datos */
    public static String capturarCaracteres(String mensaje){
        String resultado;
        while(true){
            resultado = teclado.nextLine().strip();/*Strip remueve espacios en la cadena */
            /*Si la cadena no esta vacia */
            if(!resultado.isEmpty()){
                return resultado;
            }
            System.out.println("No hay informacion, esta vacio");
        }
    }

    public static int capturarEntero(String mensaje){
        while(true){
            try {
                System.out.printf("%s: ", mensaje);
                return Integer.parseInt(teclado.nextLine());//Para leer el dato por teclado 
            } catch (NumberFormatException e) {
                System.out.println("Por favor , digite un numero entero");
            }
        }
    }

    public static double capturarNumeroReal(String mensaje){
        while(true){
            try {
                System.out.printf("%s: ", mensaje);
                return Double.parseDouble(teclado.nextLine());//Para leer el dato por teclado 
            } catch (Exception e) {
                System.out.println("Por favor , digite un numero decimal");
            }
        }
    }
    
    /* Validacion de email */ 
    static boolean validarCorreo(String correo) {
        String regex = "^[\w-_\.+]*[\w-_\.]\@([\w]+\.)+[\w]+[\w]$";
        return correo.matches(regex);
     }
}

