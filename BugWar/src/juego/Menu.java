package juego;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Menu extends JFrame {
	public Menu() {
		// Configuración de la ventana
		setTitle("Menú Principal");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5, 1)); // Diseño de botones en una columna

		// Crear botones para las opciones del menú
		JButton button1 = new JButton("Opción 1: Iniciar Juego");
		JButton button2 = new JButton("Opción 2: Configuración");
		JButton button3 = new JButton("Opción 3: Créditos");
		JButton button4 = new JButton("Opción 4: Salir");

		// Agregar listeners a los botones
		button1.addActionListener(e -> option1());
		button2.addActionListener(e -> option2());
		button3.addActionListener(e -> option3());
		button4.addActionListener(e -> System.exit(0)); // Salir del programa

		// Agregar botones a la ventana
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}

	// Métodos para manejar las opciones
	private void option1() {
		JOptionPane.showMessageDialog(this, "Iniciando el juego...");
		// Aquí puedes agregar la lógica para iniciar el juego
	}

	private void option2() {
		JOptionPane.showMessageDialog(this, "Abriendo configuración...");
		// Aquí puedes agregar la lógica para la configuración
	}

	private void option3() {
		JOptionPane.showMessageDialog(this, "Créditos: Desarrollado por BugWar Team.");
		// Aquí puedes mostrar información sobre los créditos
	}

	// Método principal para ejecutar el menú
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Menu menu = new Menu();
			menu.setVisible(true);
		});
	}
}
