package juego;
import java.util.*;

public class Combate {
	private List<Insecto> insectos;
	private Scanner scanner;

	public Combate(List<Insecto> insectos) {
		this.insectos = new ArrayList<>(insectos);
		this.scanner = new Scanner(System.in);
	}

	public void iniciarCombate() {
		System.out.println("¡Comienza la batalla entre los insectos!");
		int ronda = 1;

		while (!combateTerminado()) {
			System.out.println("Ronda: " + ronda++);
			mostrarEstadoInsectos();

			// Procesar efectos en todos los insectos antes de atacar
			List<Insecto> paralizados = new ArrayList<>();
			List<Insecto> insectosVivos = obtenerEnemigosVivos();
			for (Insecto insecto : insectosVivos) {
				insecto.mostrarEfectos();
				if (insecto.procesarEfectos()) {
					paralizados.add(insecto); // Se guarda si está paralizado
				}
			}

			// Cada insecto juega su turno si no está paralizado
			for (Insecto atacante : new ArrayList<>(insectos)) {
				if (atacante.getVida() > 0 && !paralizados.contains(atacante)) {
					turnoJugador(atacante);
				} else if (paralizados.contains(atacante)) {
					System.out.println(atacante.getNombre() + " está paralizado y pierde su turno.");
				}
			}
		}
		anunciarGanador();
	}

	private void turnoJugador(Insecto atacante) {
		List<Insecto> enemigosVivos = obtenerEnemigosVivos(atacante);
		if (enemigosVivos.isEmpty())
			return; // No hay enemigos vivos, no se puede atacar

		System.out.println("Turno de " + atacante.getNombre() + ". ¿A quién quieres atacar?");
		for (int i = 0; i < enemigosVivos.size(); i++) {
			System.out.println((i + 1) + ". " + enemigosVivos.get(i).getNombre() + " (Vida: "
					+ enemigosVivos.get(i).getVida() + ")");
		}

		int eleccion = -1;
		while (eleccion < 1 || eleccion > enemigosVivos.size()) {
			System.out.print("Elige un número: ");
			if (scanner.hasNextInt()) {
				eleccion = scanner.nextInt();
			}
			scanner.nextLine(); // Limpiar buffer
		}

		Insecto objetivo = enemigosVivos.get(eleccion - 1);
		System.out.println(atacante.getNombre() + " ataca a " + objetivo.getNombre() + "!");
		atacante.atacar(objetivo);
	}

	private List<Insecto> obtenerEnemigosVivos(Insecto atacante) {
		List<Insecto> vivos = new ArrayList<>();
		for (Insecto i : insectos) {
			if (i != atacante && i.getVida() > 0) {
				vivos.add(i);
			}
		}
		return vivos;
	}

	private List<Insecto> obtenerEnemigosVivos() {
		List<Insecto> vivos = new ArrayList<>();
		for (Insecto i : insectos) {
			if (i.getVida() > 0) {
				vivos.add(i);
			}
		}
		return vivos;
	}

	private boolean combateTerminado() {
		int vivos = 0;
		for (Insecto insecto : insectos) {
			if (insecto.getVida() > 0) {
				vivos++;
			}
		}
		return vivos <= 1;
	}

	private void anunciarGanador() {
		for (Insecto insecto : insectos) {
			if (insecto.getVida() > 0) {
				System.out.println("¡" + insecto.getNombre() + " ha ganado el combate!");
				return;
			}
		}
		System.out.println("¡Todos los insectos han sido derrotados! No hay ganador.");
	}

	private void mostrarEstadoInsectos() {
		List<Insecto> insectosVivos = obtenerEnemigosVivos();
		for (Insecto insecto : insectosVivos) {
			System.out.println(insecto.getNombre() + " - Vida: " + insecto.getVida());
		}
		System.out.println("-------------------------");
	}
}
