package mfm.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import mfm.run.Jf;
import mfm.tools.Tools;

public class Logs {
	public static void main(String location, boolean serv) throws IOException, InterruptedException {
		long startTime = System.nanoTime();
		String mfm;
		if (serv) {
			mfm = "MFM"+Jf.slash+"logs"+Jf.slash+"server"+Jf.slash;
		}
		else {
			mfm = "MFM"+Jf.slash+"logs"+Jf.slash+"game"+Jf.slash;
		}
		
		//delete logs files to replace it
		Delete.main("4", serv);
		//create 7z.bat
		//Tools.write7z("temp"+Jf.slash+"7z_Logs.bat", "7z e \""+location+Jf.slash+"logs"+Jf.slash+"*.gz\" -o \""+mfm+"\"\nexit");
		Tools.write7z("temp"+Jf.slash+"7z_Logs.bat", "7z e \""+location+Jf.slash+"logs"+Jf.slash+"*.gz\" -o\""+mfm+"\"\nexit");
		Tools.write7z("temp"+Jf.slash+"7z_Logs.bat", "7z e \""+location+Jf.slash+"logs"+Jf.slash+"*.gz\" -o\""+mfm+"\"\nexit");
		Tools.run7z("temp"+Jf.slash+"7z_Logs.bat");
		
		int timeLog = 0;
		int logNb = 0;
		String log = " ";
		new File(mfm).mkdirs();
		String[] logs = Tools.available(mfm);
		int repeatLog = logs.length;
		while (repeatLog != 0) {
			log = logs[logNb];
			BufferedReader br = new BufferedReader(new FileReader(mfm+""+log));
			String logLine = br.readLine();
			String firstTime = findTime(logLine);
			String lastTime = findTime(logLine);
			String lastLine = "";
			while (logLine != null) {
				if (findTime(logLine) != "") {
					lastLine = logLine;
				}
				logLine = br.readLine();
			}
			if (findTime(lastTime)!=null) {
				lastTime = findTime(lastLine);
				int time = calcTime(lastTime)-calcTime(firstTime);
				if (time < 0) {
					time = time+86400;
				}
				timeLog = timeLog+time;
				Tools.printLog(logs[logNb]+"  second: "+time);
			}
			logNb++;
			repeatLog--;
		}
		timePlay(timeLog);
		Tools.time(startTime);
	}
	
	private static String findTime (String line) {
		String out = "";
		int position = line.indexOf(":");
		if (position < 18 && position != -1 && line.startsWith("[")) {
			out = line.substring(position-2,position+6);
		}		
		return out;
	}
	
	private static int calcTime (String time) {
		int hours = Integer.valueOf(time.substring(0,2));
		int minutes = Integer.valueOf(time.substring(3,5));
		int seconds = Integer.valueOf(time.substring(6,8));
		seconds = seconds+(minutes*60)+(hours*3600);
		return seconds;
	}
	
	public static int[] timePlay(int timeLog) throws IOException {
		Tools.print("all seconds: "+timeLog);
		int minutes = timeLog/60;
		timeLog = timeLog-(minutes*60);
		int hours = minutes/60;
		minutes = minutes-(hours*60);
		int days = hours/24;
		hours = hours-(days*24);
		Tools.print("days:"+days+" hours:"+hours+" minutes:"+minutes+" seconds:"+timeLog);
		int[] a = {days,hours,minutes,timeLog};
		return a;
	}
}