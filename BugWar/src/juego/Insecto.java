package juego;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class Insecto {
	protected int poderAtaque; // Daño que hará por ataque el insecto
	protected String nombre; // Nombre del insecto
	protected int armadura; // Reducción de daño (en porcentaje)
	protected int agilidad; // Probabilidad de esquivar (en porcentaje)
	protected int critico; // Probabilidad de ataque crítico (en porcentaje)
	protected int vidaMaxima; // Vida máxima del insecto
	protected int vida; // Vida actual del insecto
	protected int velocidad; // Velocidad del insecto
	private List<Efecto> efectosActivos = new ArrayList<>(); // Efectos que tiene el insecto

	public Insecto(int vida, int poderAtaque) {
		this.vida = vida;
		this.vidaMaxima = vida;
		this.poderAtaque = poderAtaque;
	}

	public Insecto(int vida, int poderAtaque, int armadura, int agilidad, int critico) {
		this.vida = vida;
		this.vidaMaxima = vida;
		this.poderAtaque = poderAtaque;
		this.armadura = armadura;
		this.agilidad = agilidad;
		this.critico = critico;
	}

	public boolean atacar(Insecto objetivo) {

		Random random = new Random();
		// Calcular si el ataque es crítico
		boolean esCritico = random.nextInt(100) < critico;
		int daño = poderAtaque;
		if (esCritico) {
			daño *= 2; // Multiplicador de daño crítico
			System.out.println(nombre + " ha realizado un ataque crítico!");
		}

		// Aplicar el ataque al objetivo
		return objetivo.recibirAtaque(daño);

	}

	public boolean recibirAtaque(int daño) {
		if (!esquivarAtaque()) {
			// Reducir el daño según la armadura
			int dañoReducido = reduccionDaño(daño);
			this.vida -= dañoReducido;

			if (this.vida <= 0) {
				this.vida = 0;
				System.out.println(nombre + " ha sido derrotado!");
				return true;
			}

			System.out.println(nombre + " ha recibido " + dañoReducido + " de daño. Vida restante: " + vida);
		} else {
			System.out.println(nombre + " ha esquivado el ataque!");
		}
		return false;
	}

	protected int getVida() {
		return this.vida;
	}

	protected int getPoderAtaque() {
		return this.poderAtaque;
	}

	protected int getArmadura() {
		return this.armadura;
	}

	protected int getCritico() {
		return this.critico;
	}

	private void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	private void setCritico(int critico) {
		this.critico = critico;
	}

	private void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}

	private void setVida(int vida) {
		this.vida = vida;
	}

	protected void aumentarVida(int vida) {
		if (getVida() + vida > getVidaMaxima()) {
			setVida(vidaMaxima);
		} else {
			this.vida += vida;
		}
	}

	protected void reducirVida(int vida) {
		if (getVida() - vida <= 0) {
			setVida(0);
		} else {
			this.vida -= vida;
		}
	}

	public int getAgilidad() {
		return this.agilidad;
	}

	protected Boolean aumentarAgilidad(int agilidad) {
		if (getAgilidad() + agilidad > 90) {
			return false;
		} else {
			setAgilidad(getAgilidad() + agilidad);
			return true;
		}
	}

	protected boolean aumentarCritico(int critico) {
		if (getCritico() + critico > 80) {
			return false;
		} else {
			setCritico(getCritico() + critico);
			return true;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public boolean esquivarAtaque() {
		Random random = new Random();
		return random.nextInt(100) < agilidad;
	}

	public void romperArmadura(int armadura) {
		if (getArmadura() - armadura <= 0) {
			setArmadura(0);
		} else {
			this.armadura -= armadura;
		}
	}

	protected int reduccionDaño(int daño) {
		return daño - (daño * armadura / 100); // Reducir el daño según el porcentaje de armadura
	}

	public void añadirEfecto(Efecto efecto) {
		// Si el efecto ya existe, no lo añadimos
		for (Efecto e : efectosActivos) {
			if (e.getTipo().equals(efecto.getTipo())) {
				System.out.println(nombre + " ya tiene el efecto: " + efecto.getTipo());
				return;
			}
		}
		efectosActivos.add(efecto);
		System.out.println(nombre + " ha recibido el efecto: " + efecto.getTipo());
	}

	public boolean procesarEfectos() {
		if (efectosActivos == null) {
			return false;
		}
		Iterator<Efecto> iterator = efectosActivos.iterator();
		boolean paralizado = false;
		while (iterator.hasNext()) {
			Efecto efecto = iterator.next();
			efecto.reducirDuracion();
			if (efecto.getTipo().equals("paralizado")) {
				paralizado = true;
			}

			aplicarEfecto(efecto);

			if (efecto.getDuracionActual() == 0) {
				iterator.remove();
				System.out.println(nombre + " ha eliminado el efecto: " + efecto.getTipo());
			}
		}
		return paralizado;
	}

	public void mostrarEfectos() {
		if (efectosActivos.isEmpty()) {
			System.out.println(nombre + " no tiene efectos activos.");
		} else {
			System.out.println(nombre + " tiene los siguientes efectos activos:");
			for (Efecto efecto : efectosActivos) {
				System.out.println("- " + efecto.getTipo() + " (duración: " + efecto.getDuracionActual() + ")");
			}
		}
	}

	public void aplicarEfecto(Efecto efecto) {
		this.reducirVida(efecto.getDañoPorTurno());
		System.out.println(this.getNombre() + " ha recibido " + efecto.getTipo() + " y le quedan "
				+ efecto.getDuracionActual() + " turnos");
	}

	public void eliminarEfectos(Efecto efecto) {
		efectosActivos.remove(efecto);
		System.out.println(nombre + " ha eliminado el efecto: " + efecto.getTipo());
	}
}