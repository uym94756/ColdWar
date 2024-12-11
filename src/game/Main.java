package game;

public class Main {

	public static void main(String[] args) {
		int optn = Menu.menuRequest();
		Menu.menu(optn);
		if(optn == 1)
			jugar();
	}

}
