package mfm.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import mfm.run.Cmd;
import mfm.run.Jf;

public class Tools {
	
	public static boolean nothing (String in) {
		return (in == null || in.length() == 0);
	}

	public static String scan() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	//substring
	
	public static String removeLast(String var, int remove) {
		var = var.substring(0,var.length()-remove);
		return var;
	}
	
	//available
	
	public static String[] available (String in) {
		String[] pathnamesP1;
		File fav = new File(in);
		pathnamesP1 = fav.list();
		for (@SuppressWarnings("unused") String pathnameP1 : pathnamesP1) {
			if (pathnameP1.equals("mfmLogs")) {
				
			}
		}
		return pathnamesP1;
	}
	
	//7z
	
	public static void write7z(String name, String txt) throws IOException{
		new File("temp").mkdirs();
		new File(name).setExecutable(true);
		FileWriter write7z = new FileWriter(name);
		write7z.write(txt);
		write7z.close();
	}
	
	public static void run7z(String in) throws InterruptedException, IOException {
		try {
			Process gz;
			if (Jf.linux) {
				gz = Runtime.getRuntime().exec(in);
			} else {
				gz = Runtime.getRuntime().exec("cmd /C start /wait "+in);
			}
			gz.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		}
		new File(in).delete();
		new File("temp").delete();
	}
	
	//print
	
	public static void print(String s) {
		System.out.println(s);
		Jf.print.append(s+"\n");
	}
	
	public static void time(float startTime) {
		float elapsedTime = ((System.nanoTime() - startTime));
		float m = (Math.round(elapsedTime/100000));
		Tools.print((m/10000)+" second");
	}
	
	
	//MFMlogs
	public static void printLog(String s) throws IOException {
		new File("MFMLogs\\").mkdirs();
		FileWriter fw = new FileWriter("MFMLogs\\"+Cmd.date+".txt",true);
		fw.append(s+"\n");
		fw.close();
	}

}
