package game;

import java.util.ArrayList;
import java.util.Scanner;
public class Game2 {
	

		
		static Scanner scc;
	    public static void jugar() {
	    	scc= new Scanner(System.in);
	        
	        //Team[] equipos = new Team[5];
	        ArrayList<Team> equipos= new ArrayList<Team>();
	        
	        System.out.println("Introduzca los nombres de los equipos:");
	       // try {
	            for (int i = 0; i <6; i++) {
	            	
	                equipos.add(new Team());
	                System.out.print("Nombre del equipo " + (i + 1) + ": ");
	                String teamName = scc.next();
	                equipos.get(i).setNombre(teamName); // Leer línea con BufferedReader
	            }

	            System.out.println("Equipos registrados:");
	            for (Team equipo : equipos) {
	                if (equipo != null && equipo.getNombre() != null) {
	                    System.out.println("Equipo: " + equipo.getNombre());
	                }
	            }
	    }
	}

