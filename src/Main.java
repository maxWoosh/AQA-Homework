public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        Cat cat1 = new Cat("Кот 1");
        Cat cat2 = new Cat("Кот 2");
        Dog dog1 = new Dog("Пес 1");

        cat1.run(150);
        cat2.swim(5);
        dog1.run(400);
        dog1.swim(8);

        Bowl bowl = new Bowl(20);
        System.out.println("В миске " + bowl.getFood() + " еды.");

        cat1.eatFromBowl(bowl);
        cat2.eatFromBowl(bowl);
        System.out.println("Осталось еды: " + bowl.getFood());

        bowl.addFood(15);
        System.out.println("Добавили еду. Теперь в миске " + bowl.getFood() + " еды.");

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("Собак: " + Dog.getDogCount());

        System.out.println();
        System.out.println("Задание 2");
        Circle circle = new Circle(5, "Красный", "Черный");
        Rectangle rectangle = new Rectangle(4, 7, "Зеленый", "Синий");
        Triangle triangle = new Triangle(3, 4, 5, "Желтый", "Коричневый");

        circle.display();
        rectangle.display();
        triangle.display();
    }

}


//Задание 1
abstract class Animal {
    protected String name;
    protected boolean isFull = false;
    protected static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Cat extends Animal {
    private static final int RUN_LIMIT = 200;
    private static final int SWIM_LIMIT = 0;
    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= RUN_LIMIT) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public static int getCatCount() {
        return catCount;
    }

    public void eatFromBowl(Bowl bowl) {
        if (bowl.getFood() > 0) {
            bowl.decreaseFood(10);
            this.isFull = true;
            System.out.println(name + " поел и теперь сыт.");
        } else {
            System.out.println("В миске недостаточно еды для " + name);
        }
    }
}

class Dog extends Animal {
    private static final int RUN_LIMIT = 500;
    private static final int SWIM_LIMIT = 10;
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= RUN_LIMIT) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= SWIM_LIMIT) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Bowl {
    private int food;

    public Bowl(int food) {
        if (food < 0) food = 0;
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        } else {
            food = 0;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
        }
    }
}

//Задание 2
interface Shape {
    double getPerimeter();

    double getArea();

    default void displayInfo(String fillColor, String borderColor) {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println();
    }
}

class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void display() {
        System.out.println("Фигура: Круг");
        displayInfo(fillColor, borderColor);
    }
}

class Rectangle implements Shape {
    private double width, height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    public void display() {
        System.out.println("Фигура: Прямоугольник");
        displayInfo(fillColor, borderColor);
    }
}

class Triangle implements Shape {
    private double a, b, c;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public void display() {
        System.out.println("Фигура: Треугольник");
        displayInfo(fillColor, borderColor);
    }
}