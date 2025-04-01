package grande;

import java.util.Random;

import juego.Insecto;

public class AvispaCazaTarantulas extends Insecto {
    
    private static final double PARALYSIS_CHANCE = 0.5;
    //La pasiva de este insecto es que pega un picotazo gordo gordo.
    public AvispaCazaTarantulas() {
        super(100,20,15,10,20);
        this.nombre="Avispa Caza Tarantulas";
        // Initialize specific properties for AvispaCazaTarantulas if needed
    }
    
    @Override
    public boolean atacar(Insecto objetivo) {
        int daño = this.getPoderAtaque()+15;
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
   
}