package week4.automobiles2;

public class Car {
    String mode;
    int year;
    String color;

    public Car(String mode, int year, String color) {
        this.mode = mode;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mode='" + mode + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}
