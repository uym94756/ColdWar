package pequeno;

import java.util.Random;

import juego.Efecto.FactoriaEfectos;
import juego.Insecto;

public class ArañaEmboscadora extends Insecto {
    //La pasiva de la araña emboscadora es que tiene un 25% de probabilidad de paralizar al enemigo
    //y reduce su velocidad en 10 puntos
    public ArañaEmboscadora() {
        super(40,9,0,25,10);
        this.nombre = "Araña Emboscadora";
        // Constructor específico para ArañaEmboscadora
    }

    @Override
    public boolean atacar(Insecto enemigo){
        Random r = new Random();
        super.atacar(enemigo);

        if(r.nextInt(100) <=20){
            pasivaInsecto(enemigo);
        }
        return false;
    }

    private void pasivaInsecto(Insecto enemigo) {
        System.out.println(this.getNombre() + " utiliza su pasiva!");
        enemigo.aplicarEfecto(FactoriaEfectos.crearParalizado(1));
    }
}