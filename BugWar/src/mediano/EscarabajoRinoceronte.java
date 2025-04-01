package mediano;

import java.util.Random;

import juego.Efecto.FactoriaEfectos;
import juego.Insecto;

public class EscarabajoRinoceronte extends Insecto {
    private static final double ARMOR_REDUCTION = 0.20;
    //La pasiva de este insecto es que haya posibilidad de que aplique un sangrado y rompa la armura del enemigo
    public EscarabajoRinoceronte() {
        super(80,15,20,10,10);
        this.nombre = "Escarabajo Rinoceronte";
    }

     public boolean atacar(Insecto enemigo) {
            Random r = new Random();
            super.atacar(enemigo);
            if(r.nextInt(100)<=20){
                pasivaInsecto(enemigo);
            }
            
        
        return false;
    }

    private void pasivaInsecto(Insecto enemigo){

            System.out.println(nombre + " ha activado su pasiva!");
            
            enemigo.añadirEfecto(FactoriaEfectos.crearSangrado(3, 3));

            Random r = new Random();

            if(r.nextInt(100)<=50){
                enemigo.romperArmadura(10);
            }
    }
    

    
    // Otros métodos específicos del Escarabajo Rinoceronte pueden ser añadidos aquí
}