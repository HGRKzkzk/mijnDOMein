package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AnalogDevice extends Device implements Serializable {

	public AnalogDevice(String name, int port) {
		super(name, port);
		
	}

}
