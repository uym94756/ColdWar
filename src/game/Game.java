package game;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public static final int EQUIPOS_ESTANDAR = 5;

    public static void jugar() {
    	ArrayList<Team>equipos = crearEquipos(EQUIPOS_ESTANDAR);
    	
    	System.out.println("Comienza el juego! Los equipos son los siguientes:");
    	mostrarEquipos(equipos);
    	
    	
    	
    	
    	
    	
    	
    	/*
    	final Scanner scc = new Scanner(System.in);
        
        
        ArrayList<Team> equipos= new ArrayList<Team>();
        
        System.out.println("Introduzca los nombres de los equipos:");
       
            for (int i = 0; i <EQUIPOS_ESTANDAR; i++) {
            	
                equipos.add(new Team());
                System.out.print("Nombre del equipo " + (i + 1) + ": ");
            	String teamName = scc.nextLine();
            	equipos.get(i).setNombre(teamName); // Leer línea con BufferedReader
                
            }
            int cont=1;
            System.out.println("Equipos registrados:");
            for (Team equipo : equipos) {
            	
                if (equipo != null && equipo.getNombre() != null) {
                    System.out.println("Equipo " + cont +": "+ equipo.getNombre());
                }
                cont++;
            }
         */
      }
    public static ArrayList<Team> crearEquipos(int n) {
    	Scanner sc = new Scanner(System.in);
    	ArrayList<Team> equipos= new ArrayList<Team>();
    	for (int i = 0; i <n; i++) {
        	
            equipos.add(new Team());
            System.out.print("Nombre del equipo " + (i + 1) + ": ");
        	String teamName = sc.nextLine();
        	equipos.get(i).setNombre(teamName); // Leer línea con BufferedReader
        }
    	return equipos;
    }   
    public static void mostrarEquipos(ArrayList<Team>equipos) {
    	String[] colores = ConsoleColors.getColors();
    	String reset = ConsoleColors.RESET;
    	int cont = 1;
    	System.out.println("Equipos registrados:");
        for (Team equipo : equipos) {
        	
            if (equipo != null && equipo.getNombre() != null) {
            	String color = colores[(cont-1)%colores.length];
                System.out.println(color+"Equipo " + cont +": "+ equipo.getNombre()+reset);
            }
            cont++;
        }
    }
}


