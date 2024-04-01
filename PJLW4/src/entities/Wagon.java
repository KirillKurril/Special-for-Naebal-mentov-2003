package entities;
public class Wagon extends Transport implements Comparable<Wagon>{
    // Поля и методы для вагона

    private int passengerCount;
    private int baggageCount;
    private ComfortClass comfortClass;

    public ComfortClass getComfortClass() {
        return comfortClass;
    }

    public void setComfortClass(ComfortClass comfortClass) {
        this.comfortClass = comfortClass;
    }

    public Wagon(int passengerCount, int baggageCount, ComfortClass comfortClass) {
        this.passengerCount = passengerCount;
        this.baggageCount = baggageCount;
        this.comfortClass = comfortClass;
    }

    @Override
    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public int getBaggageCount() {
        return baggageCount;
    }

    @Override
    public String toString() {
        return "PassengerCount: " + passengerCount + "\nBaggage count: " + baggageCount +
        "\nComfort class: " + comfortClass;
    }

    @Override
   public int compareTo(Wagon wagon) {
        if(this.comfortClass.getCode() < wagon.getComfortClass().getCode())
            return -1;
        else if(this.comfortClass.getCode() > wagon.getComfortClass().getCode())
            return 1;
        else 
            return 0;
   }        
}