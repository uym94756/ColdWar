package game;

import java.util.Scanner;

public class ScannerSingleton {

    // Variable estática que almacena la única instancia de Scanner
    private static Scanner scanner;

    // Constructor privado para evitar la instanciación externa
    private ScannerSingleton() {
        // No se necesita inicialización
    }

    // Método público para obtener la única instancia de Scanner
    public static synchronized Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    // Método para cerrar el Scanner cuando ya no se necesite
    public static synchronized void closeScanner() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
   	}
  }
