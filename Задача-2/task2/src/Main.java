
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Выберите марку автомобиля для производства: Toyota, BMW, Tesla");
        String choice = scanner.nextLine().trim().toLowerCase();

        CarFactory factory;
        switch (choice) {
            case "toyota":
                factory = new ToyotaFactory();
                break;
            case "bmw":
                factory = new BMWFactory();
                break;
            case "tesla":
                factory = new TeslaFactory();
                break;
            default:
                System.out.println("Неизвестная марка автомобиля!");
                scanner.close();
                return;
        }


        Car car = new Car(factory);
        car.showSpecifications();

        scanner.close();
    }
}

interface Engine {
    String getEngineType();
}

interface Wheel {
    String getWheelType();
}

interface Body {
    String getBodyType();
}

class ToyotaEngine implements Engine {
    @Override
    public String getEngineType() {
        return "Toyota Engine";
    }
}

class ToyotaWheel implements Wheel {
    @Override
    public String getWheelType() {
        return "Toyota Wheel";
    }
}

class ToyotaBody implements Body {
    @Override
    public String getBodyType() {
        return "Toyota Body";
    }
}

class BMWEngine implements Engine {
    @Override
    public String getEngineType() {
        return "BMW Engine";
    }
}

class BMWWheel implements Wheel {
    @Override
    public String getWheelType() {
        return "BMW Wheel";
    }
}

class BMWBody implements Body {
    @Override
    public String getBodyType() {
        return "BMW Body";
    }
}

class TeslaEngine implements Engine {
    @Override
    public String getEngineType() {
        return "Tesla Electric Engine";
    }
}

class TeslaWheel implements Wheel {
    @Override
    public String getWheelType() {
        return "Tesla Wheel";
    }
}

class TeslaBody implements Body {
    @Override
    public String getBodyType() {
        return "Tesla Body";
    }
}

interface CarFactory {
    Engine createEngine();
    Wheel createWheel();
    Body createBody();
}

class ToyotaFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new ToyotaEngine();
    }

    @Override
    public Wheel createWheel() {
        return new ToyotaWheel();
    }

    @Override
    public Body createBody() {
        return new ToyotaBody();
    }
}

class BMWFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new BMWEngine();
    }

    @Override
    public Wheel createWheel() {
        return new BMWWheel();
    }

    @Override
    public Body createBody() {
        return new BMWBody();
    }
}

class TeslaFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new TeslaEngine();
    }

    @Override
    public Wheel createWheel() {
        return new TeslaWheel();
    }

    @Override
    public Body createBody() {
        return new TeslaBody();
    }
}

class Car {
    private Engine engine;
    private Wheel wheel;
    private Body body;

    public Car(CarFactory factory) {
        this.engine = factory.createEngine();
        this.wheel = factory.createWheel();
        this.body = factory.createBody();
    }

    public void showSpecifications() {
        System.out.println("Car Specifications:");
        System.out.println("- Engine: " + engine.getEngineType());
        System.out.println("- Wheel: " + wheel.getWheelType());
        System.out.println("- Body: " + body.getBodyType());
    }
}

