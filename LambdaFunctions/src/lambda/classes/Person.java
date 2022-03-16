package lambda.classes;

public class Person {
    private final double height;

    public Person( double aHeight) {
        this.height = aHeight;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                '}';
    }
}
