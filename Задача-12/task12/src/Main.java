import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Красный");
        Square square = new Square("Синий");
        Triangle triangle = new Triangle("Зеленый");

        CompositeGraphic composite1 = new CompositeGraphic();
        composite1.add(circle);
        composite1.add(square);

        CompositeGraphic composite2 = new CompositeGraphic();
        composite2.add(triangle);
        composite2.add(composite1);

        System.out.println("Отображение первого составного объекта:");
        composite1.draw();

        System.out.println("\nОтображение второго составного объекта:");
        composite2.draw();
    }
}

interface Graphic {
    void draw();
}

class Circle implements Graphic {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Рисуется круг с цветом " + color);
    }
}

class Square implements Graphic {
    private String color;

    public Square(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Рисуется квадрат с цветом " + color);
    }
}

class Triangle implements Graphic {
    private String color;

    public Triangle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Рисуется треугольник с цветом " + color);
    }
}

class CompositeGraphic implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void add(Graphic graphic) {
        children.add(graphic);
    }

    public void remove(Graphic graphic) {
        children.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : children) {
            graphic.draw();
        }
    }
}