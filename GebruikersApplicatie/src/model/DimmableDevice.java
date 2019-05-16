package model;

import java.io.Serializable;

import interfaces.Dimmable;

@SuppressWarnings("serial")
public class DimmableDevice extends AnalogDevice implements Dimmable, Serializable {

	private int dimvalue = 100;

	public DimmableDevice(String name, int port) {
		super(name, port);

	}

	public DimmableDevice(String naam, int pin, boolean switchedon, boolean active) {
		super(naam, pin, switchedon, active);
	 
	}

	@Override
	public void setDimValue(int newvalue) {
		this.dimvalue = newvalue;

		dCom.altervalue(this);

	}

	@Override
	public boolean validateDimvalue() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getDimvalue() {
		return dimvalue;
	}

	@Override
	public int getDimValue() {
		return this.dimvalue;

	}

	@Override
	public boolean giveCurrentValue() {
		// TODO Auto-generated method stub
		return false;
	}
	

	public void switchOn() {

		this.switchedOn = true;
		dCom.flipswitch(this);

	}

	public void switchOff() {

		this.switchedOn = false;
		dCom.flipswitch(this);

	}

	public void setSwitchedOn(boolean b) {
		this.switchedOn = b;
		dCom.flipswitch(this);
		
	}

	@Override
	public boolean getSwitchedOn() {
		
		return this.switchedOn;
	}
 

}
