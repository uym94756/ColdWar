package juego;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import grande.EscorpiónGigante;
import mediano.CiempiésVenenoso;
import mediano.EscarabajoRinoceronte;

public class Main {
	public static void main(String[] args) {
		List<Insecto> insectos = new ArrayList<>();
		// insectos.add(new TijeretaNocturna());
		// insectos.add(new PulgaSaltarina());
		// insectos.add(new MantisReligiosa());
		// insectos.add(new TarantulaColosal());
		// insectos.add(new MosquitoVampiro());
		// insectos.add(new AvispaCazaTarantulas());
		// insectos.add(new GrilloBerserker());
		insectos.add(new CiempiésVenenoso());
		insectos.add(new EscorpiónGigante());
		insectos.add(new EscarabajoRinoceronte());

		if (validarInsectosUnicos(insectos)) {
			Combate combate = new Combate(insectos);
			combate.iniciarCombate();
		} else {
			System.out.println("Error: No puede haber insectos repetidos en la partida.");
		}
	}

	private static boolean validarInsectosUnicos(List<Insecto> insectos) {
		Set<Class<? extends Insecto>> tiposInsectos = new HashSet<>();

		// Verifica que cada insecto sea único
		for (Insecto i : insectos) {
			if (!tiposInsectos.add(i.getClass())) {
				return false;
			}
		}
		return true;
	}
}
