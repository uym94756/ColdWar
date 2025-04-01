package mediano;

import juego.Insecto;

public class MantisReligiosa extends Insecto {
    //La pasiva hara que se cure cuando mate a alguienn
    public MantisReligiosa() {
        super(70,13,10,20,15);
        this.nombre = "Mantis Religiosa";
    }
    @Override
    public boolean atacar(Insecto enemigo) {
        if(super.atacar(enemigo)){
            pasivaInsecto(enemigo);
        }
        return false;
    }

    private void pasivaInsecto(Insecto enemigo){
        aumentarVida(enemigo.getVidaMaxima());
    }
}