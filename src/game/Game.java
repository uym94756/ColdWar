package game;
import java.util.ArrayList;
//import java.util.Scanner;

public class Game {
	public static final int EQUIPOS_ESTANDAR = 5;

    public static void jugar() {
    	ArrayList<Team>equipos = crearEquipos(EQUIPOS_ESTANDAR);
    	
    	System.out.println("Comienza el juego! Los equipos son los siguientes:");
    	mostrarEquipos(equipos); 
    	System.out.println("RONDA 1");
    	
    	for(Team equipo : equipos) {
    		equipo.decisionRonda();
    	}
    	
      }
    
    
    public static ArrayList<Team> crearEquipos(int n) {
    	String[] colores = ConsoleColors.getColors();
    	String reset = ConsoleColors.RESET;
    	//Scanner sc = new Scanner(System.in);
    	ArrayList<Team> equipos= new ArrayList<Team>();
    	for (int i = 0; i <n; i++) {
        	
            equipos.add(new Team());
            String color = colores[((i+1)-1)%colores.length];
            System.out.print(color+"Nombre del equipo " + (i + 1) + ": "+reset);
        	//String teamName = sc.nextLine();
            String teamName = ScannerSingleton.getInstance().nextLine();
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


