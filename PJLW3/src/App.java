import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("1", "Toyota", "Camry", 2018, "Blue", 25000.0, "AB1234CD"));
        cars.add(new Car("2", "Honda", "Civic", 2018, "Red", 21000.0, "EF5678GH"));
        cars.add(new Car("3", "Toyota", "Corolla", 2019, "Silver", 22000.0, "IJ9012KL"));
        cars.add(new Car("4", "Ford", "Focus", 2018, "Black", 15000.0, "MN3456OP"));
        cars.add(new Car("5", "Honda", "Accord", 2017, "White", 20000.0, "QR7890ST"));
        cars.add(new Car("2", "Honda", "Civic", 2000, "Red", 1800.0, "EF5678GH"));
        cars.add(new Car("2", "Honda", "Civic", 2001, "Red", 1700.0, "EF5678GH"));

        ArrayList<Car> brandCars = Car.getCarsByBrand(cars, "Toyota");
        System.out.println("\nList of Toyota autos:");
        for (Car car : brandCars) 
            System.out.println(car.getBrand() + " " + car.getModel());

        ArrayList<Car> byModelAndAgeCars = Car.getCarsByModelAndAge(cars, "Civic", 15);
        System.out.println("\nList of Civic model vehicles that have been in operation for more than 15 years: ");
        for (Car car : byModelAndAgeCars)
            System.out.println(car.getBrand() + " " + car.getModel() + " " + car.getManufactureYear());

        ArrayList<Car> yearAndCostCars = Car.getCarsByYearAndPrice(cars, 2018, 20000);
        System.out.println("\nList of 2018 model year cars priced over 20,000: ");
            for (Car car : yearAndCostCars)
                System.out.println(car.getBrand() + " " + car.getModel() + " " 
                + car.getManufactureYear() + " " + car.getCost());
    }
}
