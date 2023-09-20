package mfm.main;

import java.io.IOException;

public class Laucher extends Function {
	
	public Laucher(String ver, boolean serv) {
		super(ver, serv);
	}
	
	public void Lauch() {
		
	}
	
	//mod
	
	public void createModPack(String name) {
		new ModPack(name).saveModPack();
	}
	
	public void useModPack(String name) throws IOException {
		ModPack.unloadModPack();
		new ModPack(name).loadModPack();
	}
	
	
	
}
