package pequeno;



import java.util.Random;

import juego.Insecto;

public class HormigaSoldado extends Insecto {
    //La pasiva ataca dos veces
    public HormigaSoldado() {
        super(50,10,5,20,10);
        this.nombre = "Hormiga Soldado";
        // Initialize specific properties for HormigaSoldado if needed
    }

    @Override
    public boolean atacar(Insecto obInsecto) {
        Random random = new Random();
        
        if(random.nextInt(100) < 30){//Ataca 2 veces
            super.atacar(obInsecto);
            System.out.println("Parece que la Hormiga Soldado utiliza su pasiva!! \n Golpea 2 veces a su enemigo");
             super.atacar(obInsecto);
        }else{//Ataca 1 vez
             super.atacar(obInsecto);
        }

        return false;
         
    }

    
}