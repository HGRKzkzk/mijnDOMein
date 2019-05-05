package model;

import java.io.Serializable;

import interfaces.Dimmable;
import jserial.ArduinoRequests;
import jserial.jSerialcomm;
import proxy.ProxyOnsDomein;
import view.Main;

@SuppressWarnings("serial")
public class DeviceCommunicator implements Serializable {

	transient ProxyOnsDomein proxy;

	DeviceCommunicator() {

		proxy = new ProxyOnsDomein();

	}

	public void Switch(Device device) {

		int[] message = new int[3];
		int whichValue = device.getSwitchedOn() ? 1 : 0; // van boolean naar int tbv protocol
		int whichPin = device.getPort();
		int whichAction = ArduinoRequests.switchPin.num;

		message[0] = whichPin;
		message[1] = whichAction;
		message[2] = whichValue;

		sendMessage("SET", message);

	}

	public void Alter(Device device) {

		int pinValue = ((Dimmable) device).getDimValue();
		int[] message = new int[3];
		int whichValue = pinValue;
		int whichPin = device.getPort();
		int whichAction = ArduinoRequests.setValue.num;;

		

		message[0] = whichPin;
		message[1] = whichAction;
		message[2] = whichValue;

		sendMessage("SET", message);

	}

	public void RequestStatus(Device device) {

		int[] message = new int[3];
		int whichValue = device.getSwitchedOn() ? 1 : 0; // van boolean naar int tbv protocol
		int whichPin = device.getPort();
		int whichAction = ArduinoRequests.getStatus.num;

		message[0] = whichPin;
		message[1] = whichAction;
		message[2] = whichValue;

		sendMessage("GET", message);

	}

	public void sendMessage(String action, int[] message) {

		String msg = message.toString();
		int whichPin = message[0];
		int whichAction = message[1];
		int whichValue = message[2];

		if (Main.getGa().isDirectToArduino()) {

			jSerialcomm.sendProtocolData(whichPin, whichAction, whichValue);
			return;

		}

		String response;
		if (proxy == null) {
			proxy = new ProxyOnsDomein();
		}

		if (proxy.connectClientToServer()) {
			proxy.sendRequest(msg);

		}

		proxy.closeConnection();
		return;

	}

}
