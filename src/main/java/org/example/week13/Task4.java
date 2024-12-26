package org.example.week13;

public class Task4 {
    public static void main(String[] args) {
        NewDevice newDevice = new NewDeviceImpl();
        newDevice.novo();

        // Using OldDevice through the adapter
        OldDevice oldDevice = new OldDeviceImpl();
        NewDevice adaptedDevice = new DeviceAdapter(oldDevice);
        adaptedDevice.novo();

    }
}

interface NewDevice{
    void novo();
}

interface OldDevice{
    void staro();
}

class OldDeviceImpl implements OldDevice{
    @Override
    public void staro(){
        System.out.println("This is old device");
    }
}

class NewDeviceImpl implements NewDevice{
    @Override
    public void novo(){
        System.out.println("This is new device");
    }
}

class DeviceAdapter implements NewDevice{
    private OldDevice oldDevice;

    public DeviceAdapter(OldDevice oldDevice) {
        this.oldDevice = oldDevice;
    }

    @Override
    public void novo(){
        System.out.println("givin old devices to new devices");
        oldDevice.staro();
    }
}
