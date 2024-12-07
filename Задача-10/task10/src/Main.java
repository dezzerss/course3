public class Main {
    public static void main(String[] args) {
        HomeAutomationFacade homeFacade = new HomeAutomationFacade();

        homeFacade.startEveningMode();

        System.out.println();

        homeFacade.stopAllDevices();
    }
}

class Light {
    public void turnOn() {
        System.out.println("Свет включен.");
    }

    public void turnOff() {
        System.out.println("Свет выключен.");
    }
}

class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("Температура установлена на " + temperature + " градусов.");
    }
}

class AudioSystem {
    public void playMusic(String track) {
        System.out.println("Играет музыка: " + track);
    }

    public void stopMusic() {
        System.out.println("Музыка остановлена.");
    }
}

class HomeAutomationFacade {
    private Light light;
    private Thermostat thermostat;
    private AudioSystem audioSystem;

    public HomeAutomationFacade() {
        this.light = new Light();
        this.thermostat = new Thermostat();
        this.audioSystem = new AudioSystem();
    }

    public void startEveningMode() {
        System.out.println("Включение вечернего режима...");
        light.turnOn();
        thermostat.setTemperature(22);
        audioSystem.playMusic("Relaxing Jazz");
    }

    public void stopAllDevices() {
        System.out.println("Выключение всех устройств...");
        light.turnOff();
        audioSystem.stopMusic();
        System.out.println("Температура в доме остается установленной.");
    }
}