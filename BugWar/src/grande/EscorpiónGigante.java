package grande;


import juego.Insecto;

public class EscorpiónGigante extends Insecto {
    //Pasiva de sumar 5 de critico por cada ronda que ataque
    public EscorpiónGigante() {
        super(100,18,25,5,5);
        this.nombre = "Escorpión Gigante";
        // Initialize specific properties for EscorpiónGigante if needed
    }

   @Override
   public boolean atacar(Insecto objetivo){
        pasivaInsecto();
        return super.atacar(objetivo);
   }

   private void pasivaInsecto(){
        if(aumentarCritico(5)){
                System.out.println(nombre + " ha activado su pasiva y gana 5 de critico!");
            }else{
                System.out.println(nombre + " no puede ganar mas critico");
            }
   }
   }
