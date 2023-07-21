package mfm.function;

import java.io.IOException;

import mfm.run.Jf;
import mfm.tools.Tools;

public class Backup {

	public static void main(String min, String world, boolean serv) throws IOException, InterruptedException {
		String txt = "";
		if (serv) {
			if (Jf.linux) {
				txt = "color 2\n7z a MFM"+Jf.slash+"backup"+Jf.slash+"server"+Jf.slash+".7z "+min+"\nexit";
			} else {
				txt = "color 2\n7z a MFM"+Jf.slash+"backup"+Jf.slash+"server"+Jf.slash+".7z "+min+"\nexit"; //TODO linux
			}
		}
		else {
			if (Tools.nothing(world)) {
				Tools.available(min+Jf.slash+"saves");
				Tools.print("");
				Tools.print("Type the world or | all | to do all available");
				world = Tools.scan();
			}
			if (world.matches("all|a")) {
				world = "";
			}
			if (Jf.linux) {
				txt = "color 2\n7z a MFM"+Jf.slash+"backup"+Jf.slash+"game"+Jf.slash+world+".7z "+min+Jf.slash+"saves"+Jf.slash+world+"\nexit";
			} else {
				txt = "color 2\n7z a MFM"+Jf.slash+"backup"+Jf.slash+"game"+Jf.slash+world+".7z "+min+Jf.slash+"saves"+Jf.slash+world+"\nexit"; //TODO linux
			}
		}
		if (world != "0") {
			if (Jf.linux) {
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