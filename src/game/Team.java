package game;

import java.util.List;
//import java.util.Scanner;

public class Team {
	private String nombre;
    private int vidas = 200;
    private boolean defendido = false;
    private List<Team> equiposDisponibles; // Lista de equipos para elegir el objetivo

    // Métodos getter y setter para nombre, vidas y misiles
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getDefendido() {
    	return defendido;
    }
    
    public void setDefendido(boolean defendido) {
    	this.defendido = defendido;
    }
    
    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    // Método para configurar la lista de equipos disponibles para atacar
    public void setEquiposDisponibles(List<Team> equiposDisponibles) {
        this.equiposDisponibles = equiposDisponibles;
    }

    // Método que decide si atacar o defender
    public void decisionRonda() {
    	
        System.out.println(nombre + ", ¿quieres atacar o defender? (escribe \"atacar\" o \"defender\"):");
        String decision = ScannerSingleton.getInstance().nextLine().toLowerCase();
        //ScannerSingleton.getInstance().nextLine();
        
        if ("atacar".equals(decision)) {
            System.out.println("¿A qué equipo deseas atacar? (Escribe el nombre del equipo):");
            String objetivoNombre = ScannerSingleton.getInstance().nextLine();
            //ScannerSingleton.getInstance().nextLine();
            Team equipoObjetivo = obtenerEquipoPorNombre(objetivoNombre);

            if (equipoObjetivo != null && equipoObjetivo.getVidas() > 0 && !this.nombre.equals(equipoObjetivo.getNombre())) {
                System.out.println(equipoObjetivo.getNombre() + ", ¿quieres defenderte? (escribe S/N):");
                String defensa = ScannerSingleton.getInstance().nextLine().toLowerCase();
                if(defensa.equals("s")) {
                	equipoObjetivo .setDefendido(true);
                }
                atacar(equipoObjetivo);
            } else {
                System.out.println("El equipo objetivo no es válido o ya está fuera de juego.");
            }
        } else if ("defender".equals(decision)) {
            defender();
        } else {
            System.out.println("Decisión no válida o sin misiles disponibles para atacar.");
        }
    }

    // Método para atacar a un equipo objetivo
    private void atacar(Team enemigo) {
       if(enemigo.getDefendido()==false) {
            enemigo.vidas -= 50; // Ejemplo de ataque, resta 50 vidas al enemigo
            System.out.println(nombre + " ha atacado a " + enemigo.getNombre() + ", sus vidas restantes son " + enemigo.getVidas());
       }else {
    	   enemigo.vidas -=25;
    	   System.out.println(nombre+"ha atacado a"+ enemigo.getNombre()+ " mientras se estaba defendiendo, sus vidas restantes son"+ enemigo.getVidas());
       }
    }

    // Método para defender
    private void defender() {
    	setDefendido(defendido);
        System.out.println(nombre + " ha decidido defenderse en esta ronda.");
    }

    // Buscar un equipo por nombre dentro de la lista de equipos disponibles
    private Team obtenerEquipoPorNombre(String nombre) {
        for (Team equipo : equiposDisponibles) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }
}
