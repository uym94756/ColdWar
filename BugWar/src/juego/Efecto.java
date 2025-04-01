package juego;

public class Efecto {
	private String tipo; // Tipo de efecto: "veneno", "sangrado", "dormir, paralizado"
	private int duracion; // Duración en rondas
	private int dañoPorTurno; // Daño que se aplica por turno (si aplica)
	private int duracionActual; // Duración actual del efecto

	public Efecto(String tipo, int duracion, int dañoPorTurno) {
		this.tipo = tipo;
		this.duracion = duracion;
		this.dañoPorTurno = dañoPorTurno;
		this.duracionActual = duracion;
	}

	public String getTipo() {
		return tipo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void reducirDuracion() {
		if (duracionActual > 0) {
			duracionActual--; // Reducir la duración en 1
		}
	}

	public int getDañoPorTurno() {
		return dañoPorTurno;
	}

	public int getDuracionActual() {
		return duracionActual;
	}

	private void setDuracionActual(int duracionActual) {
		this.duracionActual = duracionActual;
	}

	public static class FactoriaEfectos {
		public static Efecto crearVeneno(int duracion, int dañoPorTurno) {
			return new Efecto("veneno", duracion, dañoPorTurno);
		}

		public static Efecto crearSangrado(int duracion, int dañoPorTurno) {
			return new Efecto("sangrado", duracion, dañoPorTurno);
		}

		public static Efecto crearDormir(int duracion) {
			return new Efecto("dormir", duracion, 0);
		}

		public static Efecto crearParalizado(int duracion) {
			return new Efecto("paralizado", duracion, 0);
		}

	}
}
