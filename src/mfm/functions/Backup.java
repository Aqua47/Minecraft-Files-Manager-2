package mfm.functions;

import java.io.IOException;

import mfm.run.Main;
import mfm.tools.Tools;

public class Backup extends Function {
	
	public Backup(String min, String world, boolean serv) {
		super(min, serv);
	}

	public static void main(String min, String world, boolean serv) throws IOException, InterruptedException {
		String txt = "";
		if (serv) {
			if (Main.linux) {
				txt = "color 2\n7z a MFM"+Main.s+"backup"+Main.s+"server"+Main.s+".7z "+min+"\nexit";
			} else {
				txt = "color 2\n7z a MFM"+Main.s+"backup"+Main.s+"server"+Main.s+".7z "+min+"\nexit"; //TODO linux
			}
		}
		else {
			if (Tools.nothing(world)) {
				Tools.available(min+Main.s+"saves");
				Tools.print("");
				Tools.print("Type the world or | all | to do all available");
				world = Tools.scan();
			}
			if (world.matches("all|a")) {
				world = "";
			}
			if (Main.linux) {
				txt = "color 2\n7z a MFM"+Main.s+"backup"+Main.s+"game"+Main.s+world+".7z "+min+Main.s+"saves"+Main.s+world+"\nexit";
			} else {
				txt = "color 2\n7z a MFM"+Main.s+"backup"+Main.s+"game"+Main.s+world+".7z "+min+Main.s+"saves"+Main.s+world+"\nexit"; //TODO linux
			}
		}
		if (world != "0") {
			if (Main.linux) {
				Tools.write7z("temp/7z_Backup.sh", txt);
				Tools.write7z("temp/7z_Backup.sh", txt);
				Tools.run7z("temp/7z_Backup.sh");
			} else {
				Tools.write7z("temp\\7z_Backup.bat", txt);
				Tools.run7z("temp\\7z_Backup.bat");
			}
		}
	}
}