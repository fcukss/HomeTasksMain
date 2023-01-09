package SubTask4;


import java.util.*;

public class Parking {
    static int numberOfCars=0;
    final static int parkingSize = 5;
    static List<Car> parking = new ArrayList<>(parkingSize);

    public void addCarToParking(Car car) {

        if (parkingSize != numberOfCars) {
            parking.add(car);
            numberOfCars++;
        } else {
            System.out.println("Parking is full");
        }
    }

    public void deleteCarFromParking(Car car) {
        parking.remove(car);
        numberOfCars--;
    }

    void getInfo() {
        System.out.println("NUmber of cars " + numberOfCars);
        System.out.println(parking);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car1 = new Car("Audi", "black");
        Car car2 = new Car("KIA", "grey");
        Car car3 = new Car("Mazda", "white");
        Car car4 = new Car("Opel", "red");
        Car car5 = new Car("Toyota", "blue");
        Car car6 = new Car("VW", "black");

        Parking parking = new Parking();

        parking.addCarToParking(car1);
        parking.addCarToParking(car2);

        parking.getInfo();

        parking.addCarToParking(car3);
        parking.addCarToParking(car4);

        parking.addCarToParking(car5);
        parking.addCarToParking(car6);
        parking.getInfo();
        parking.deleteCarFromParking(car4);
        parking.getInfo();

    }


}
