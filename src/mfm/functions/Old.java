package mfm.functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import mfm.run.Main;
import mfm.tools.*;

public class Old {
	public static void main(String min, String keep) throws IOException, InterruptedException {
		if (Tools.nothing(keep)) {
			Tools.available(min+Main.s+"versions");
			Tools.print("Type the version you want to keep!");
			keep = Tools.scan();
		}	
		if (keep != "0") { //do nothing if = 0
			long startTime = System.nanoTime();
			Runtime.getRuntime().exec("explorer.exe /select,"+min+Main.s+"versions"+Main.s+keep);
			
			//all
			if (keep == "all") {
				Delete.deleteAll(min+"assets",null);
				Delete.deleteAll(min+"libraries",null);
				//versions
			}
			else {	
				if (keep.lastIndexOf(".") >= 3) {
					keep = Tools.removeLast(keep,2);
				}
				Path indexe = Paths.get("MFM"+Main.s+"indexes"+Main.s+keep+".json");
				if (!Files.exists(indexe)) {
					new Indexes(keep).createIndexe();
				}
				//Print.bar();
				
				//del indexes
				Delete.deleteAll(min+Main.s+"assets"+Main.s+"indexes", keep);
				//keep indexes folder
				
				BufferedReader br = new BufferedReader(new FileReader("MFM"+Main.s+"indexes"+Main.s+keep+".json"));
				String line = "0";
				ArrayList<String> lines = new ArrayList<String>();
				ArrayList<String> folders = new ArrayList<String>();
				ArrayList<String> sizeS = new ArrayList<String>();
				boolean line1 = true;
				int start = 0;
				while ((line = br.readLine()) != null) {
					if (line1 == false) {
						start = line.indexOf("{")+10;
					}
					if (line1 == true) {
						start = line.indexOf("{")+47;
						line1 = false;
					}
					lines.add(line.substring(start,start+40));
					folders.add(line.substring(start,start+2));
					String sizeSt = line.substring(start+50,line.length()-2);
					if (sizeSt.endsWith("}")) {
						sizeSt = Tools.removeLast(sizeSt,1);
					}
					sizeS.add(sizeSt);
				}
				br.close();	
				String[] pathnames = {"0"};
				File file = new File(min+Main.s+"assets"+Main.s+"objects");
				pathnames = file.list();
				long bytes = 0;
				for (String pathname : pathnames) {		
					String[] pathnames2 = {"0"};
					File file2 = new File(min+Main.s+"assets"+Main.s+"objects"+Main.s+pathname);
					pathnames2 = file2.list();
					for (String pathname2 : pathnames2) {
						File path2 = new File(file2+Main.s+pathname2);
						int a1 = lines.indexOf(pathname2);
						if (a1 == -1) {
							Path path = Paths.get(file2+Main.s+pathname2);
							try {
								bytes += Files.size(path);
							} catch (IOException e) {
								e.printStackTrace();
							}
							path2.delete();
							Tools.print(path2+"  deleted"); 
						}
					}
				}
				size(bytes);
			}
			Tools.time(startTime);
		}
	}
	
	private static void size(long bytes) throws IOException {
		Tools.print(bytes/1024+" ko");
	}
}

