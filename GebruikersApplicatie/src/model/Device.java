package model;

import java.io.Serializable;

import interfaces.Nameable;
import interfaces.PortHandler;

@SuppressWarnings("serial")
public abstract class Device implements Nameable, PortHandler, Serializable {

	protected DeviceCommunicator dCom;
	private String name;
	private int port;
	private boolean switchedOn;
	private boolean activated;

	public Device(String name, int port) {
		
		dCom = new DeviceCommunicator();
		changePort(port);
		changeName(name);
		switchedOn = true;
		activated = true;

	}

	public void switchOn() {

		this.switchedOn = true;
		dCom.Switch(this);

	}

	public void switchOff() {

		this.switchedOn = false;
		dCom.Switch(this);

	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean changePort(int port) {

		if (validatePort(port)) {
			this.port = port;
			return true;
		}
		return false;

	}

	public boolean validatePort(int port) {
		if (port < maxPort && port > minPort)
			return true;
		return true;

	}

	public void changeName(String name) {

		if (validateName(name)) {
			this.name = name;

		} else

		if (name == "" || name.isEmpty()) {
			this.name = standardName;
		}

		return;

	}

	public boolean validateName(String name) {

		if (name.length() <= maxNamelength && name.length() > 0)
			return true;
		return false;
	}

	public String getName() {

		return this.name;

	}

	public int getPort() {

		return this.port;

	}

	public boolean getSwitchedOn() {

		return this.switchedOn;

	}
	
	

}
