package week4.automobiles2;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(mode, car.mode)
                && Objects.equals(color, car.color);
        //Добавить специальные условия если не указан год или цвет
    }

    @Override
    public int hashCode() {
        return Objects.hash(mode, year, color);
        //Добавить специальные условия если не указан год или цвет
    }
}
