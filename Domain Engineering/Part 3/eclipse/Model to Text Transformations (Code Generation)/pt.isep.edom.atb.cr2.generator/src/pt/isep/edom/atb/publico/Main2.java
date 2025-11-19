package pt.isep.edom.atb.publico;

import pt.isep.edom.atb.publico.Main;
import pt.isep.edom.atb.publico.MainMenu;
import pt.isep.edom.atb.publico.SFactoryMain;

public class Main2 extends Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// SFactoryMain.setSFactoryImpl(new SFactoryAlternativeImpl());
		SFactoryMain.getSFactory();
		
		MainMenu.executeMenu();
	}

}