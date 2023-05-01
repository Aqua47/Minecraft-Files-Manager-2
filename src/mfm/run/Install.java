package mfm.run;

import java.util.HashMap;
import java.util.Map;

public class Install {
	
	private static final String run = System.getProperty("user.dir");
	
	public static void main(String args[]) {
		env(run);
	}

	public static void env(String run) {
		System.out.println(run);
		System.out.println();
		Map<String, String> env = new HashMap<>(System.getenv());
		System.out.println(env);
		System.out.println();
		System.out.println();
		env.put("Path", env.get("Path") + ";" + run);
		Map<String, String> env2 = System.getenv();
		System.out.println(env2);
	}
	
}
