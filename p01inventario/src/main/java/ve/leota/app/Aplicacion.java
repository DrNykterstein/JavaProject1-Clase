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
}

