package pequeno;

import juego.Insecto;

public class PulgaSaltarina extends Insecto {
    // La pasiva hara que gane mas agilidad y se puede curar cada x rondas un porcentaje
    private int rondas;
    public PulgaSaltarina() {
        super(35,9,0,40,5);
        this.nombre="Pulga Saltarina";
        setRondas(1);
        
    }
    @Override
    public boolean atacar(Insecto inObjetivo){
        this.rondas++;
        pasivaInsecto(100);
        super.atacar(inObjetivo);
        return false;
    }

    public void pasivaInsecto(int probabilidad){
        if(0 <= probabilidad){ // Si la probabilidad es menor o igual a la probabilidad de la pasiva
           if(getRondas() % 4 ==0){ // Cadad 4 rondas se cura un porcentaje de vida
            aumentarVida(((this.getVida()/this.getVidaMaxima())*20));
            System.out.println("Pulga Saltarina aplica su pasiva y se cura de vida, tiene "+this.getVida());
        }
        if(getVida()< 15){ // Si la vida es menor de 15 gana 5 de agilidad
            if(aumentarAgilidad(5)){
                System.out.println("Pulga Saltarina aplica su pasiva y gana agilidad");
            }
        }
        
    }
    }

    

    public int getRondas(){
        return this.rondas;
    }

    private void setRondas(int rondas){
        this.rondas=rondas;
    }
    // Otros métodos específicos de PulgaSaltarina pueden ser añadidos aquí
}