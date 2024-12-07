import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("Красный", 10));
        shapes.add(new Rectangle("Синий", 20, 30));
        shapes.add(new Triangle("Зеленый", 15, 25));

        List<Shape> clonedShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            clonedShapes.add(shape.clone());
        }

        clonedShapes.get(0).setColor("Желтый");
        clonedShapes.get(1).setColor("Фиолетовый");

        System.out.println("Оригинальные фигуры:");
        for (Shape shape : shapes) {
            shape.draw();
        }

        System.out.println("\nКлонированные фигуры:");
        for (Shape shape : clonedShapes) {
            shape.draw();
        }
    }
}


abstract class Shape implements Cloneable {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public Shape(Shape source) {
        if (source != null) {
            this.color = source.color;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public abstract Shape clone();

    public abstract void draw();
}

class Circle extends Shape {
    private int radius;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    public Circle(Circle source) {
        super(source);
        if (source != null) {
            this.radius = source.radius;
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }

    @Override
    public void draw() {
        System.out.println("Рисуется круг с радиусом " + radius + " и цветом " + getColor());
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(String color, int width, int height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle source) {
        super(source);
        if (source != null) {
            this.width = source.width;
            this.height = source.height;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(this);
    }

    @Override
    public void draw() {
        System.out.println("Рисуется прямоугольник с шириной " + width + ", высотой " + height + " и цветом " + getColor());
    }
}

class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle(String color, int base, int height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public Triangle(Triangle source) {
        super(source);
        if (source != null) {
            this.base = source.base;
            this.height = source.height;
        }
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public Triangle clone() {
        return new Triangle(this);
    }

    @Override
    public void draw() {
        System.out.println("Рисуется треугольник с основанием " + base + ", высотой " + height + " и цветом " + getColor());
    }
}