package model;

public class DeviceFactory {

	public Device getDevice(String devicetype, String name, int port, boolean analoog) {

		if (devicetype == DeviceTypes.READONLY.getDescription()) {
			return new ReadableDevice(name, port);
			
		} else if (devicetype == DeviceTypes.SWITCHABLE.getDescription()) {
			return new SwitchableDevice(name, port);

		} else if (devicetype == DeviceTypes.DIMMABLE.getDescription()) {
			return new DimmableDevice(name, port);

		}

		return new ReadableDevice(name, port);

	}

}
