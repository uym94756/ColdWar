package game;

public class ConsoleColors {
	public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String RESET = "\u001B[0m";

    // Método para obtener un array de colores
    public static String[] getColors() {
        return new String[]{RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE};
    }
}
