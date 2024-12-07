
public class Main {
    public static void main(String[] args) {
        Renderer monitorRenderer = new MonitorRenderer();
        Renderer printerRenderer = new PrinterRenderer();
        Renderer plotterRenderer = new PlotterRenderer();

        Shape circle = new Circle(monitorRenderer, 5.0);
        Shape square = new Square(printerRenderer, 4.0);
        Shape triangle = new Triangle(plotterRenderer, 6.0, 3.0);

        circle.draw();
        square.draw();
        triangle.draw();
    }
}

interface Renderer {
    void renderCircle(double radius);
    void renderSquare(double side);
    void renderTriangle(double base, double height);
}


class MonitorRenderer implements Renderer {
    @Override
    public void renderCircle(double radius) {
        System.out.println("Отображение круга на мониторе с радиусом: " + radius);
    }

    @Override
    public void renderSquare(double side) {
        System.out.println("Отображение квадрата на мониторе со стороной: " + side);
    }

    @Override
    public void renderTriangle(double base, double height) {
        System.out.println("Отображение треугольника на мониторе с основанием: " + base + " и высотой: " + height);
    }
}

class PrinterRenderer implements Renderer {
    @Override
    public void renderCircle(double radius) {
        System.out.println("Печать круга на принтере с радиусом: " + radius);
    }

    @Override
    public void renderSquare(double side) {
        System.out.println("Печать квадрата на принтере со стороной: " + side);
    }

    @Override
    public void renderTriangle(double base, double height) {
        System.out.println("Печать треугольника на принтере с основанием: " + base + " и высотой: " + height);
    }
}

class PlotterRenderer implements Renderer {
    @Override
    public void renderCircle(double radius) {
        System.out.println("Рисование круга на плоттере с радиусом: " + radius);
    }

    @Override
    public void renderSquare(double side) {
        System.out.println("Рисование квадрата на плоттере со стороной: " + side);
    }

    @Override
    public void renderTriangle(double base, double height) {
        System.out.println("Рисование треугольника на плоттере с основанием: " + base + " и высотой: " + height);
    }
}


abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
}


class Circle extends Shape {
    private double radius;

    public Circle(Renderer renderer, double radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }
}

class Square extends Shape {
    private double side;

    public Square(Renderer renderer, double side) {
        super(renderer);
        this.side = side;
    }

    @Override
    public void draw() {
        renderer.renderSquare(side);
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(Renderer renderer, double base, double height) {
        super(renderer);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        renderer.renderTriangle(base, height);
    }
}

