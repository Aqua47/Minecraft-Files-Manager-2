package mfm.main;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
	static final String version = "2.1";
	
	public static final boolean linux;
	
	public static final String s; //slash
	
	public static final String min;
	
	static final String run = System.getProperty("user.dir");
	
	public static final String date;
	
	static String servLoc;
	
	static {
		if (System.getProperty("os.name").toLowerCase().substring(0,3).equals("win")) {
			min = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\.minecraft";
			linux = false;
		} else {
			min = "/home/"+System.getProperty("user.name")+"/.minecraft";
			linux = true;
		}
		if (linux) {
			s = "/";
		} else {
			s = "\\";
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");  
		LocalDateTime now = LocalDateTime.now();  
		date = dtf.format(now);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length == 0) {
			new MFM();
		} else {
			if (args[0] == "help") {
				
			} else if (args[0].equals("indexes")) {
				new Indexes(args[1]).createIndexe();
			} else if (args[0].equals("objects")) {
				new Objects(args[1]).createObject();
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
			} else {
				//help
			}
		}
	}

}