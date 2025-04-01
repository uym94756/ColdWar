package pequeno;
import java.util.Random;

import juego.Efecto.FactoriaEfectos;
import juego.Insecto;




public class TijeretaNocturna extends Insecto {
    //La pasiva es que cada vez que ataca, el enemigo recibe daño por sangrado
    public TijeretaNocturna() {
        super(45, 11,5,25,10); // Vida fija: 80, Poder de ataque fijo: 15
        this.nombre= "Tijereta Nocturna";
    }
    @Override
    public boolean atacar(Insecto insObj){
        Random r = new Random();
        super.atacar(insObj);
         if(r.nextInt(100) <= 20){
            pasivaInsecto(insObj);
        }
        return false;

    }
    // Cuando se activa la pasiva metera sangrado al enemigo y ademas
    // le hara ataque en funcion de su vida actual
    private void pasivaInsecto(Insecto insObj) {
                 // Aplicar la pasiva
            System.out.println(nombre + " ha activado su pasiva!");
            // Recuperar vida al atacar
            
            insObj.añadirEfecto(FactoriaEfectos.crearSangrado(3, 3));
    }

}