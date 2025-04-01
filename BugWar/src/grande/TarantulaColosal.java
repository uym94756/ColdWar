package grande;

import java.util.Random;

import juego.Efecto.FactoriaEfectos;
import juego.Insecto;

public class TarantulaColosal extends Insecto{
    //Puede aplicar veneno
    public TarantulaColosal() {
        super(120,18,25,5,15);
        this.nombre = "Tarantula Colosal";
    }
    @Override
    public boolean atacar(Insecto enemigo) {
            Random r = new Random();
            super.atacar(enemigo);
            if(r.nextInt(100)<=15){
                pasivaInsecto(enemigo);
            }
            
        
        return false;
    }

    private void pasivaInsecto(Insecto enemigo){
            System.out.println(nombre + " ha activado su pasiva!");
            // Recuperar vida al atacar
            enemigo.añadirEfecto(FactoriaEfectos.crearVeneno(4, 3));
    }
}

