package mfm.functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import mfm.run.Main;
import mfm.tools.Tools;

public class Indexes extends Function {
	
	public Indexes(String ver) {
		super(ver);
	}
	
	public void createIndexe() throws IOException, InterruptedException {
		new File("MFM"+Main.s+"indexes"+Main.s).mkdirs();
		String[] indexes = Tools.available(Main.min+Main.s+"assets"+Main.s+"indexes");
		if (Tools.nothing(_ver)) {
			_ver = Tools.scan();
		}
		byte indexe = -1;
		int nbIndexes = 0;
		if (_ver.matches("all|a")) {
			indexe = 0;
			_ver = (indexes[indexe]);
			nbIndexes = indexes.length;
		}
		while(nbIndexes != indexe) {
			long startTime = System.nanoTime();
			if (indexe != -1) {
				_ver = (indexes[indexe]);
			}
			indexe++;
			if (new File(Main.min+Main.s+"assets"+Main.s+"indexes"+Main.s+_ver).exists()) {
				FileInputStream fin;
				File out = new File("MFM"+Main.s+"indexes"+Main.s+_ver);
				FileWriter fw;
				try {
					fin = new FileInputStream(Main.min+Main.s+"assets"+Main.s+"indexes"+Main.s+_ver);
					fw = new FileWriter(out);
					PrintWriter pw = new PrintWriter(fw);
					byte comma = 0;
					if (_ver.equals("pre-1.6.json")) {
						comma = -1;
					}
				
					//indexes decoder loop
					char cd;
					for (cd = (char) fin.read(); cd != 65535; cd = (char) fin.read()) {
						pw.print(cd);
						if (cd == ',') {
							comma++;
							if (comma==2) {
								comma = 0;
								pw.println();
							}
						}
					}
					fw.close();
					pw.close();
					fin.close();
				} catch (IOException e) { e.printStackTrace(); }
				Tools.print("indexes "+_ver+" created");
			}
			Tools.time(startTime);
			System.gc();
		}
	}
}