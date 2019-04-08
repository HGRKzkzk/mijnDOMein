package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SwitchableDevice extends DigitalDevice implements Serializable {

	public SwitchableDevice(String name, int port) {
		super(name, port);
		
	}
	
	

}
