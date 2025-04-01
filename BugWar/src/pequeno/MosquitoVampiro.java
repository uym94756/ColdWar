package pequeno;

import java.util.Random;

import juego.Efecto.FactoriaEfectos;
import juego.Insecto;

public class MosquitoVampiro extends Insecto {
    //La pasiva sera ganar los puntos de vida que le quite al enemigo cuando aplique el ataque ademas de dejar un sangrado
    public MosquitoVampiro() {
        super(40,8,0,30,5);
       this.nombre = "Mosquito Vampiro";
        // Constructor específico para MosquitoVampiro
    }
    @Override
    public boolean atacar(Insecto inObj){
        Random random = new Random();
        // Calcular si el ataque es crítico
        boolean esCritico = random.nextInt(100) < critico;
        boolean pasiva = random.nextInt(100) < 100; // Probabilidad de activar la pasiva (10%)
        int daño = poderAtaque;
        if (esCritico) {
            daño *= 2; // Multiplicador de daño crítico
            System.out.println(nombre + " ha realizado un ataque crítico!");
        }
        if(pasiva){
        pasivaInsecto(inObj, daño);
        }
        // Aplicar el ataque al objetivo
        inObj.recibirAtaque(daño);
        return false;
    }

    public void pasivaInsecto(Insecto inObj, int daño){
         // Aplicar la pasiva
            System.out.println(nombre + " ha activado su pasiva y se ha curado "+ daño);
            // Recuperar vida al atacar
            this.aumentarVida(daño);
            
            inObj.añadirEfecto(FactoriaEfectos.crearSangrado(3, 3));
            
    }
}