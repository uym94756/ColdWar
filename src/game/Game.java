package game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void jugar() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Team[] equipos = new Team[5];

        System.out.println("Introduzca los nombres de los equipos:");
        try {
            for (int i = 0; i < equipos.length; i++) {
                equipos[i] = new Team();
                System.out.print("Nombre del equipo " + (i + 1) + ": ");
                equipos[i].setNombre(br.readLine()); // Leer línea con BufferedReader
            }

            System.out.println("Equipos registrados:");
            for (Team equipo : equipos) {
                if (equipo != null && equipo.getNombre() != null) {
                    System.out.println("Equipo: " + equipo.getNombre());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer la entrada: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.jugar(); // Llamar al método jugar()
    }
}


