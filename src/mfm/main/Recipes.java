package mfm.main;

public class Recipes {
	
	String _ver;
	
	String _path;
	
	//.minecraft\versions\1.18.2\1.18.2.jar\data\minecraft\recipes\
	
	public Recipes(String ver) {
		_ver = ver;
		_path = Main.min+Main.s+"versions"+Main.s+ver+Main.s+ver+".jar"+Main.s+"data"+Main.s+"minecraft"+Main.s+"recipes";
	}
	
	
	public void read() {
		
	}
	
	
	public void create() {
		
	}
	
	
	
}
