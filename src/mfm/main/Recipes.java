package mfm.main;

public class Recipes {
	
	String _ver;
	
	String _path;
	
	//.minecraft\versions\1.18.2\1.18.2.jar\data\minecraft\recipes\
	
	public Recipes(String ver) {
		_ver = ver;
		_path = MFM.min+MFM.s+"versions"+MFM.s+ver+MFM.s+ver+".jar"+MFM.s+"data"+MFM.s+"minecraft"+MFM.s+"recipes";
	}
	
	
	public void read() {
		
	}
	
	
	public void create() {
		
	}
	
	
	
}
