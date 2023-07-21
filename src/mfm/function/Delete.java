package mfm.function;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import mfm.run.Jf;
import mfm.tools.*;

public class Delete {
	public static void main(String com, boolean serv) throws IOException {
		String scan = "all";
		//if it's for server; change the value
		
		String mfms = "MFM";
		if (serv) {
			mfms = "MFMS";
		}
		
		//if no command enter a command
		
		//if (Tools.nothing(com)) {
			//Print.menuDelete(serv);
			//com = Tools.scan().toLowerCase();
		//}
		
		if (com != "0") {
		
		//command execution
		
			if (com.matches("all|a")) {	
				deleteAll(mfms,null);
			}
			else if (com.matches("1|ind|indexe|indexes")) {	
				Tools.available(mfms+Jf.slash+"indexes");
				//String scan = Tools.scan();
				if (scan.matches("a|all")) {
					deleteAll(mfms+Jf.slash+"indexes",null);
				} else {
					deleteAll(mfms+Jf.slash+"indexes"+Jf.slash+scan,null);
				}
			}
			else if (com.matches("2|obj|object|objects")) {
				Tools.available(mfms+Jf.slash+"objects");
				//String scan = Tools.scan();
				if (scan.matches("a|all")) {
					deleteAll(mfms+Jf.slash+"objects",null);
				} else {
					deleteAll(mfms+Jf.slash+"objects"+Jf.slash+scan,null);
				}
			}
			else if (com.matches("4|logs")) {
				deleteAll(mfms+Jf.slash+"logs",null);
			}
			else if (com.matches("6|backup")) {
				Tools.available(mfms+Jf.slash+"backup");
				//String scan = Tools.scan();
				if (scan.matches("a|all")) {
					deleteAll(mfms+Jf.slash+"backup",null);
				} else {
					if (!scan.endsWith(".7z")) {
						scan = scan+".7z";
					}
					deleteFile(mfms+Jf.slash+"backup"+Jf.slash+scan);
				}
			}
			else {
				Tools.print("not a valid command! Type (mfm help) for help!");
			}
		}
	}
	
	public static void deleteAll(String loc, String notThisOne) throws IOException {
		Path dir = Paths.get(loc);
		if (dir.toFile().exists()) {
			Files.walk(dir)
					.sorted(Comparator.reverseOrder())
					.forEach(path -> {
						if (notThisOne != path.toString()) {	//check if path is complet so it works
							try {
								Tools.print("Deleting: " + path);
								Files.delete(path);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					});
		}
	}
	
	private static void deleteFile(String loc) throws IOException {
		new File(loc).delete();
	}
}