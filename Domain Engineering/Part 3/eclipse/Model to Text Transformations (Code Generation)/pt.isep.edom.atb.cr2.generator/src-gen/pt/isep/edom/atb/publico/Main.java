package pt.isep.edom.atb.publico;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// SFactoryMain.setSFactoryImpl(new SFactoryAlternativeImpl());
		SFactoryMain.getSFactory();
		
		MainMenu.executeMenu();
	}
}