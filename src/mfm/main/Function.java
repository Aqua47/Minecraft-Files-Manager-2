package mfm.main;

public abstract class Function {
	
	String _ver;
	
	String _min;
	Boolean _serv;
	
	Function(String ver) {
		_ver = ver;
	}
	
	Function(String min, Boolean serv) {
		_min = min;
		_serv = serv;
	}
}
