package model;

import java.io.Serializable;

import interfaces.Dimmable;

@SuppressWarnings("serial")
public class DimmableDevice extends Device implements Dimmable, Serializable {

	private int dimvalue = 100;

	public DimmableDevice(String name, int port) {
		super(name, port);

	}

	@Override
	public void setDimValue(int newvalue) {
		this.dimvalue = newvalue;

	}

	@Override
	public boolean validateDimvalue() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getDimvalue() {
		return dimvalue;
	}

	public void setDimvalue(int dimvalue) {
		this.dimvalue = dimvalue;
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

}
