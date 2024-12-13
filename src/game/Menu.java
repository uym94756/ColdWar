package game;

//import java.util.Scanner;

public class Menu {

    // Códigos ANSI para colores
    public static final String RESET = "\u001B[0m";       // Resetea colores
    public static final String RED = "\u001B[31m";       // Rojo
    public static final String GREEN = "\u001B[32m";     // Verde
    public static final String YELLOW = "\u001B[33m";    // Amarillo
    public static final String BLUE = "\u001B[34m";      // Azul
    public static final String PURPLE = "\u001B[35m";    // Morado
    public static final String CYAN = "\u001B[36m";      // Cian

    // Método para mostrar y capturar la selección del menú
    public static int menuRequest() {
        int optn;
  //      Scanner sc = new Scanner(System.in);
        System.out.println(BLUE + "Bienvenido al juego " + YELLOW + "COLDWAR" + RESET);
        System.out.println(CYAN + "Para empezar seleccione una opción:" + RESET);
        System.out.println("-----------------------");
        System.out.println(GREEN + "[1] JUGAR" + RESET);
        System.out.println(YELLOW + "[2] Reglas del juego" + RESET);
        System.out.println(PURPLE + "[3] Información" + RESET);
        System.out.println(CYAN + "[4] Apartado abierto" + RESET);
        System.out.println(RED + "[0] Salir" + RESET);
        System.out.println("-----------------------");
        System.out.print("Opción: ");
        optn = ScannerSingleton.getInstance().nextInt();
        ScannerSingleton.getInstance().nextLine();
        //optn = sc.nextInt();
        //sc.close();
       return optn;
    }

    // Método para gestionar la opción seleccionada
    public static void menu(int optn) {

        if (optn == 1) {
            System.out.println(GREEN + "Empieza el juego" + RESET);
        } else if (optn == 2) {
        	System.out.println(YELLOW + 
        		    "---------------------------------------------------------------------------------------------\n" +
        		    "El juego " + CYAN + "COLDWAR" + YELLOW + " consta de 5 equipos, donde cada uno tendrá 200 vidas y\n" +
        		    "50 misiles por ronda que podrán usar de manera tanto defensiva como ofensiva. Es importante\n" +
        		    "destacar que no se conservan entre rondas los misiles. Los misiles usados de manera defensiva,\n" +
        		    "es decir, para repeler los ataques enemigos, costarán el doble; para neutralizar un misil\n" +
        		    "enemigo se gastarán dos misiles propios.\n" +
        		    "---------------------------------------------------------------------------------------------" + RESET);

        } else if (optn == 3) {
            System.out.println(PURPLE + "Versión beta 1.0 del juego " + CYAN + "COLDWAR!" + RESET);
            System.out.println("\tContacto: uym94756@educastur.es");
            System.out.println("\tAutor: Jorge Santillán");
        } else if (optn == 4) {
            System.out.println(CYAN + "Próximamente" + RESET);
        } else if (optn == 0) {
            System.out.println(RED + "Hasta la próxima!" + RESET);
        } else {
            System.out.println(RED + "No has seleccionado una opción válida" + RESET);
        }
    }
}

