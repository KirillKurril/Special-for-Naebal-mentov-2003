import java.util.ArrayList;
import java.util.UUID;
import java.util.Calendar;

public class Car {

    private String id;
    private String brand;
    private String model;
    private int manufactureYear;
    private String color;
    private double cost;
    private String registryNumber;

    public Car(String id, String brand, String model,
    int manufactureYear, String color, double cost, String registryNumber)
    {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.color = color;
        this.cost = cost;
        this.registryNumber = registryNumber;
    }

    public Car(String id)
    {
        this.id = id;
    }

    public Car()
    {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }
    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }
    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }
    
    public static ArrayList<Car> getCarsByBrand(ArrayList<Car> cars, String brand) {
        
        ArrayList<Car> brandCars = new ArrayList<Car>();

        for (Car car : cars)
            if(car.getBrand().equals(brand))
                brandCars.add(car);

        return brandCars;
    }

    public static ArrayList<Car> getCarsByModelAndAge(ArrayList<Car> cars, String model, int operationalPeriod) {
        
        ArrayList<Car> sortedCars = new ArrayList<Car>();
        int curYear = Calendar.getInstance().get(Calendar.YEAR);

        for (Car car : cars)
            if(car.getModel() == model 
            &&  curYear - car.getManufactureYear() > operationalPeriod)
                sortedCars.add(car);

        return sortedCars;
    }

    public static ArrayList<Car> getCarsByYearAndPrice(ArrayList<Car> cars, int year, double price) {
        ArrayList<Car> sortedCars = new ArrayList<Car>();

        for (Car car : cars)
        if(car.getManufactureYear() == year && car.getCost() > price) 
            sortedCars.add(car);

        return sortedCars;
    }
}
