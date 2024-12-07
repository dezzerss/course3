
public class Main {
    public static void main(String[] args) {

        SmartDevice smartSocket = new SmartSocket();
        DeviceController smartController = new DeviceController(smartSocket);
        System.out.println("Управляем умной розеткой:");
        smartController.activate();
        smartController.deactivate();

        OldDevice oldSocket = new OldSocket();
        SmartDevice adaptedOldSocket = new OldDeviceAdapter(oldSocket);
        DeviceController oldController = new DeviceController(adaptedOldSocket);
        System.out.println("\nУправляем старой розеткой через адаптер:");
        oldController.activate();
        oldController.deactivate();
    }
}

interface SmartDevice {
    void turnOn();
    void turnOff();
}

class SmartSocket implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Умная розетка включена.");
    }

    @Override
    public void turnOff() {
        System.out.println("Умная розетка выключена.");
    }
}

interface OldDevice {
    void powerOn();
    void powerOff();
}

class OldSocket implements OldDevice {
    @Override
    public void powerOn() {
        System.out.println("Старая розетка включена.");
    }

    @Override
    public void powerOff() {
        System.out.println("Старая розетка выключена.");
    }
}

class OldDeviceAdapter implements SmartDevice {
    private final OldDevice oldDevice;

    public OldDeviceAdapter(OldDevice oldDevice) {
        this.oldDevice = oldDevice;
    }

    @Override
    public void turnOn() {
        oldDevice.powerOn();
    }

    @Override
    public void turnOff() {
        oldDevice.powerOff();
    }
}

class DeviceController {
    private final SmartDevice device;

    public DeviceController(SmartDevice device) {
        this.device = device;
    }

    public void activate() {
        device.turnOn();
    }

    public void deactivate() {
        device.turnOff();
    }
}
