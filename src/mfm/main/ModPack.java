package mfm.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ModPack {
	
	String _name;
	ArrayList<String> _mods;
	
	public ModPack(String name) {
		_name = name;
		_mods = new ArrayList<String>();
	}
	
	public void addMod(String mod) {
		_mods.add(mod);
	}
	
	public void rmMod(String mod) {
		_mods.remove(mod);
	}
	
	public void saveModPack() {
		new File("MFMLaucher"+Main.s+"ModPack"+Main.s+_name).mkdirs();
		//Files.move();
	}
	
	public void loadModPack() throws IOException {
		Files.move(Paths.get("MFMLaucher"+Main.s+"ModPack"+Main.s+_name), Paths.get(Main.min+Main.s+"mods")); //each files in folder
	}
	
	public static void unloadModPack() throws IOException {
		Delete.deleteAll(Main.min+Main.s+"mods", null);
	}
	
}
