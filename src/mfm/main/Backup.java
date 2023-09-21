package mfm.main;

import java.io.IOException;

import tools.Tools;

public class Backup extends Function {
	
	public Backup(String min, String world, boolean serv) {
		super(min, serv);
	}

	public static void main(String min, String world, boolean serv) throws IOException, InterruptedException {
		String txt = "";
		if (serv) {
			if (MFM.linux) {
				txt = "color 2\n7z a MFM"+MFM.s+"backup"+MFM.s+"server"+MFM.s+".7z "+min+"\nexit";
			} else {
				txt = "color 2\n7z a MFM"+MFM.s+"backup"+MFM.s+"server"+MFM.s+".7z "+min+"\nexit"; //TODO linux
			}
		}
		else {
			if (Tools.nothing(world)) {
				Tools.available(min+MFM.s+"saves");
				Tools.print("");
				Tools.print("Type the world or | all | to do all available");
				world = Tools.scan();
			}
			if (world.matches("all|a")) {
				world = "";
			}
			if (MFM.linux) {
				txt = "color 2\n7z a MFM"+MFM.s+"backup"+MFM.s+"game"+MFM.s+world+".7z "+min+MFM.s+"saves"+MFM.s+world+"\nexit";
			} else {
				txt = "color 2\n7z a MFM"+MFM.s+"backup"+MFM.s+"game"+MFM.s+world+".7z "+min+MFM.s+"saves"+MFM.s+world+"\nexit"; //TODO linux
			}
		}
		if (world != "0") {
			if (MFM.linux) {
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