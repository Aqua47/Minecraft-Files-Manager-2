package mfm.run;

import java.io.IOException;

import mfm.function.Backup;
import mfm.function.Delete;
import mfm.function.Indexes;
import mfm.function.Logs;
import mfm.function.Objects;

public class Cmd { //test
	
	private static final String version = "2.1";
	
	public static final boolean linux;
	
	public static final String slash;
	
	public static final String min;
	
	private static final String run = System.getProperty("user.dir");
	
	static {
		if (System.getProperty("os.name").toLowerCase().substring(0,3).equals("win")) {
			min = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\.minecraft";
			linux = false;
		} else {
			min = "/home/"+System.getProperty("user.name")+"/.minecraft";
			linux = true;
		}
		if (linux) {
			slash = "/";
		} else {
			slash = "\\";
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length == 0) {
			new Jf();
		} else {
			if (args[0] == "help") {
				
			} else if (args[0].equals("indexes")) {
				new Indexes(args[1]).start();
			} else if (args[0].equals("objects")) {
				Objects.main(args[1]);
			} else if (args[0].equals("old")) {
				
			} else if (args[0].equals("logs")) {
				Logs.main(min, false);
			} else if (args[0].equals("backup")) {
				Backup.main(min, "all", false);
			} else if (args[0].equals("delete")) {
				Delete.main("all", false);
			} else if (args[0].equals("folder")) {
				
			} else if (args[0].equals("servloc")) {
				
			} else if (args[0].equals("version")){
				System.out.println(version);
			}
		}
	}

}
