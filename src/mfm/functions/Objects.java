package mfm.functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import mfm.run.Main;
import mfm.tools.Tools;

public class Objects extends Function {
	
	public Objects(String ver) {
		super(ver);
	}

	public void createObject() throws IOException, InterruptedException {		
		boolean all = false;
		String fileOut = "";
		String[] indexes = Tools.available(Main.min+Main.s+"assets"+Main.s+"indexes");
		if (Tools.nothing(_ver)) {
			_ver = Tools.scan();
		}
		if (_ver != "0") {
			long startTime = System.nanoTime();
			String verjson = _ver;
			byte a = -1;
			int nbIndexes = 0;
			if (_ver.matches("all|a")) {
				a = 0;
				all = true;
				nbIndexes = indexes.length;
			}
			if (a != -1) {
				verjson = (indexes[a]);
				_ver = Tools.removeLast(verjson,5);
			}
			while(nbIndexes != a) {
				byte pl = 0;
				if (a != -1) {
					verjson = (indexes[a]);
					_ver = Tools.removeLast(verjson,5);
				}
				a++;
				new File("MFM"+Main.s+"objects").mkdirs();
				Path indexe = Paths.get("MFM"+Main.s+"indexes"+Main.s+verjson);
				Tools.print(_ver);
				if (!Files.exists(indexe)) {
					Indexes Indexes1;
					if (all) {
						Indexes1 = new Indexes(_ver+".json");
					} else {
						Indexes1 = new Indexes(_ver);
					}
					Indexes1.createIndexe();
					//wait
					Thread.sleep(1000);
					System.gc();
				}
				//Print.bar();
				FileInputStream lec = new FileInputStream("MFM"+Main.s+"indexes"+Main.s+verjson); //TODO bug
				List<Character> ca = new ArrayList<Character> ();
				for (short ca80 = 0; ca80 != 80; ca80++) {
					ca.add(' ');
				}
				String cc="";
				String cc2 = "";
				byte get = -2;
				if (verjson.equals("pre-1.6.json")) {
					get = -4;
				}
				byte getadd = -1;
				byte h = 0;
				//%
				BufferedReader br = new BufferedReader(new FileReader("MFM"+Main.s+"indexes"+Main.s+verjson));
				int allLine = 0;			
				while (br.readLine() != null) {
					allLine++;
				}		
				float line = 0;
				for (int r = 0; r!=-1;) {
					r = lec.read();
					char c = (char)r;
					if (get==2) {
						get = -2;
						h++;
						byte ccadd = 16;
						byte lim = 0;
						while (ccadd != 80) {
							if (lim != 1 || ca.get(ccadd).equals(' ')) {
								String cct = "";
								for (byte cadd = 0; cadd != ccadd; cadd++) {
										cct += ca.get(cadd);
								}
								cc = cct.trim();
								lim++;
							}
							lim = 0;
							ccadd++;							
						}
						if (h==1) {
							cc2 = cc;
							File nfp = new File("MFM"+Main.s+"objects"+Main.s+_ver+Main.s+cc2);
							fileOut = "MFM/objects/"+_ver+"/"+cc2.substring(0, cc2.length() - nfp.getName().length())+nfp.getName();
							File nf = new File(fileOut);
							nf.mkdirs();
						}
						if (h==2) {
							h = 0;
							Path source = Paths.get(Main.min+Main.s+"assets"+Main.s+"objects"+Main.s+cc.substring(0,2)+Main.s+cc);
							Path dest = Paths.get(fileOut);
							Files.deleteIfExists(dest);
							Files.copy(source, dest);
							
							
							line++;
							if (line/allLine >= 0.25 && pl == 0) {
								System.out.print("25%   ");
								pl++;
							}
							if (line/allLine >= 0.5 && pl == 1) {
								System.out.print("50%   ");
								pl++;
							}
							if (line/allLine >= 0.75 && pl == 2) {
								System.out.print("75%   ");
								pl++;
							}
							if (line/allLine >= 1 && pl == 3) {
								Tools.print("100%");
								pl++;
							}
							
						}
						for (byte ca80 = 0; ca80 != 80; ca80++) {
							ca.set(ca80,' ');
						}
					}
					if (r==34) {
						get++;
						getadd = -1;
					}		
					if (get==1) {
						getadd++;
						for (byte caplus = 0; caplus != 80; caplus++) {
							ca.set(caplus,ccc(getadd, c, ca.get(caplus), caplus));
						}
					}
				}
				br.close();
				lec.close();
				Tools.print(verjson);
				Tools.time(startTime);
			}
		}
	}
	private static char ccc (byte getadd, char c, char r, byte cx) {
		if (getadd==cx+1) {
			if (c=='/') {
				r = '\\';
			}
			else {
				r = c;
			}
		}
		return r;		
	}
}