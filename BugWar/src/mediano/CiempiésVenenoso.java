package mediano;

import java.util.Random;

import juego.Efecto.FactoriaEfectos;
import juego.Insecto;

public class CiempiésVenenoso extends Insecto {
    
    // La pasiva aplica veneno al enemigo
    public CiempiésVenenoso() {
        super(65,12,5,15,10);
        this.nombre = "Ciempiés Venenoso";
    }
    @Override
    public boolean atacar(Insecto inObj){
        Random random = new Random();
        boolean pasiva = random.nextInt(100) < 10; // Probabilidad de activar la pasiva (10%)
             super.atacar(inObj);
        // Probabilidad de activar la pasiva (10%)
        if(pasiva){
        pasivaInsecto(inObj);
        }
        return false;
    }
    
    public void pasivaInsecto(Insecto inObj){
         // Aplicar la pasiva
            System.out.println(nombre + " ha activado su pasiva!");
            // Recuperar vida al atacar
            inObj.añadirEfecto(FactoriaEfectos.crearVeneno(4, 3));
            
    }
    // Additional methods and properties specific to CiempiésVeneno can be added here
}