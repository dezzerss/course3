
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\nДоступные фигуры: circle, rectangle, triangle");
            System.out.println("Введите 'exit' для выхода.");
            System.out.print("Введите тип фигуры: ");
            String shapeType = scanner.nextLine().trim().toLowerCase();

            if (shapeType.equals("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            try {
                Shape shape;
                switch (shapeType) {
                    case "circle":
                        System.out.print("Введите радиус круга: ");
                        double radius = scanner.nextDouble();
                        shape = ShapeFactory.createShape("circle", radius);
                        break;
                    case "rectangle":
                        System.out.print("Введите ширину прямоугольника: ");
                        double width = scanner.nextDouble();
                        System.out.print("Введите высоту прямоугольника: ");
                        double height = scanner.nextDouble();
                        shape = ShapeFactory.createShape("rectangle", width, height);
                        break;
                    case "triangle":
                        System.out.print("Введите длину стороны a: ");
                        double a = scanner.nextDouble();
                        System.out.print("Введите длину стороны b: ");
                        double b = scanner.nextDouble();
                        System.out.print("Введите длину стороны c: ");
                        double c = scanner.nextDouble();
                        shape = ShapeFactory.createShape("triangle", a, b, c);
                        break;
                    default:
                        System.out.println("Неизвестный тип фигуры!");
                        continue;
                }
                scanner.nextLine(); // Очистка ввода
                System.out.println(shape);
                System.out.printf("Площадь: %.2f, Периметр: %.2f%n", shape.area(), shape.perimeter());
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                scanner.nextLine(); // Очистка ввода
            }
        }
        scanner.close();
    }
}

abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
    public abstract String toString();
}


class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle(radius=" + radius + ")";
    }
}


class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle(width=" + width + ", height=" + height + ")";
    }
}

class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) throws IllegalArgumentException {
        if (!isValid(a, b, c)) {
            throw new IllegalArgumentException("Стороны треугольника не удовлетворяют неравенству треугольника");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean isValid(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle(a=" + a + ", b=" + b + ", c=" + c + ")";
    }
}

class ShapeFactory {
    public static Shape createShape(String shapeType, double... dimensions) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                if (dimensions.length != 1) throw new IllegalArgumentException("Круг требует 1 параметр: радиус.");
                return new Circle(dimensions[0]);
            case "rectangle":
                if (dimensions.length != 2) throw new IllegalArgumentException("Прямоугольник требует 2 параметра: ширина и высота.");
                return new Rectangle(dimensions[0], dimensions[1]);
            case "triangle":
                if (dimensions.length != 3) throw new IllegalArgumentException("Треугольник требует 3 параметра: длины сторон.");
                return new Triangle(dimensions[0], dimensions[1], dimensions[2]);
            default:
                throw new IllegalArgumentException("Неизвестный тип фигуры: " + shapeType);
        }
    }
}

