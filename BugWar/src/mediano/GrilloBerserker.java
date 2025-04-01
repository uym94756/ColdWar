package mediano;

import java.util.Random;

import juego.Insecto;

public class GrilloBerserker extends Insecto {
    //La pasiva de este insecto es que mientras menos vida tenga, mas daño hace.
    public GrilloBerserker() {
        super(70,13,10,20,15);
        this.nombre = "Grillo Berserker";
    }

    @Override
    public boolean atacar(Insecto objetivo) {
        int daño = pasivaInsecto();
        Random random = new Random();
        // Calcular si el ataque es crítico
        boolean esCritico = random.nextInt(100) < critico;
        if (esCritico) {
            daño *= 2; // Multiplicador de daño crítico
            System.out.println(nombre + " ha realizado un ataque crítico!");
        }
        
        // Aplicar el ataque al objetivo
        return objetivo.recibirAtaque(daño);
    }

    private int pasivaInsecto() {
        double baseDamage = getPoderAtaque();
        double damageMultiplier = 1 + (porcentajeVidaPerdido() / 25) * 0.1;
        return (int)(baseDamage * damageMultiplier);
    }

   

    private int porcentajeVidaPerdido() {
        double vidaActual = this.getVida();
        double vidaMax = this.getVidaMaxima();
        return (int) (((vidaMax - vidaActual) / vidaMax) * 100);
    }
}