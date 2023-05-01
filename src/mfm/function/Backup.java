package mfm.function;

import java.io.IOException;

import mfm.tools.Tools;

public class Backup {

	public static void main(String min, String world, boolean serv) throws IOException, InterruptedException {
		String txt = "";
		if (serv) {
			txt = "color 2\n7z a MFM\\backup\\server\\.7z "+min+"\nexit";
		}
		else {
			if (Tools.nothing(world)) {
				Tools.available(min+"\\saves");
				Tools.print("");
				Tools.print("Type the world or | all | to do all available");
				world = Tools.scan();
			}
			if (world.matches("all|a")) {
				world = "";
			}
			txt = "color 2\n7z a MFM\\backup\\game\\"+world+".7z "+min+"\\saves\\"+world+"\nexit";
		}
		if (world != "0") {
			Tools.write7z("temp\\7z_Backup.bat", txt);
			Tools.run7z("temp\\7z_Backup.bat");
		}
	}
}