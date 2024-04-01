package main;

import entities.ComfortClass;
import entities.Train;
import entities.Wagon;

public class App {
    public static void main(String[] args) throws Exception {
        loadDefaultBootData();
        Train train = new Train();
        train.bootFromFile("bootData.json");
        System.out.println(train);
        train.sortByComfortClass();
        System.out.println(train);
    }

    public static void loadDefaultBootData()
    {
        Train train = new Train();
        for (int i = 0; i < 10; i++) {
            int passengerCount = (i + 1) * 10;
            int baggageCount = (i + 1) * 5;
            ComfortClass comfortClass = ComfortClass.values()[i % ComfortClass.values().length];

            Wagon wagon = new Wagon(passengerCount, baggageCount, comfortClass);
            train.addWagon(wagon);
        }
        train.writeToFile("data.json");

    }
}


