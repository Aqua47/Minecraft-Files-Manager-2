package mfm.function;

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

import mfm.tools.*;

public class Objects {
	public static void main(String min, String ver) throws IOException {
		boolean all = false;
		String fileOut = "";
		String[] pathnamesP;
		if (Tools.nothing(ver)) {
			pathnamesP = Tools.available(min+"\\assets\\indexes");
			ver = Tools.scan();
		} else {
			pathnamesP = Tools.available(min+"\\assets\\indexes");
		}
		if (ver != "0") {
			long startTime = System.nanoTime();
			//String verjson = ver+".json";
			String verjson = ver;
			byte a = -1;
			int p = pathnamesP.length;
			if (ver.matches("all|a")) {
				a = 0;
				all = true;
			}
			else {
				p = 0;
			}
			if (a != -1) {
				verjson = (pathnamesP[a]);
				ver = Tools.removeLast(verjson,5);
			}
			while(p != a) {
				byte pl = 0;
				if (a != -1) {
					verjson = (pathnamesP[a]);
					ver = Tools.removeLast(verjson,5);
				}
				a++;
				new File("MFM\\objects").mkdirs();
				FileInputStream lec = null;
				Path indexe = Paths.get("MFM\\indexes\\"+verjson);
				Tools.print(ver);
				if (!Files.exists(indexe)) {
					System.out.println("kkk");
					if (all) {
						Indexes.main(min, ver+".json");
					} else {
						Indexes.main(min, ver);
					}
					System.gc();
				}
				//Print.bar();
				lec = new FileInputStream("MFM\\indexes\\"+verjson); //TODO bug
				List<Character> ca = new ArrayList<Character> ();
				for (short ca80 = 0; ca80 !=80; ca80++) {
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
				BufferedReader br = new BufferedReader(new FileReader("MFM\\indexes\\"+verjson));
				int allLine = 0;
				
				Tools.print(allLine+"");
				
				while (br.readLine() != null) {
					allLine++;
				}
				
				Tools.print(allLine+"");
				
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
							File nfp = new File("MFM\\objects\\"+ver+"\\"+cc2);
							fileOut = "MFM\\objects\\"+ver+"\\"+cc2.substring(0, cc2.length() - nfp.getName().length())+nfp.getName();
							File nf = new File(fileOut);
							nf.mkdirs();
						}
						if (h==2) {
							h = 0;
							Path source = Paths.get(min+"\\assets\\objects\\"+cc.substring(0,2)+"\\"+cc);
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