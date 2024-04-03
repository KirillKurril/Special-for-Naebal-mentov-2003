package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.Gson;

public class Train extends Transport {
    
    private ArrayList<Wagon> wagons;

    public Train(ArrayList<Wagon> wagons) {
        this.wagons = wagons;
    }

    public Train(Train train)
    {
        this. wagons = train.wagons;
    }

    public Train(){
        this.wagons = new ArrayList<Wagon>();
    }
    @Override
    public int getPassengerCount() {

        int totalPassengerCount = 0;
        for (Wagon wagon : wagons) 
            totalPassengerCount += wagon.getPassengerCount();
        
        return totalPassengerCount;
    }

    @Override
    public int getBaggageCount() {

        int totalBaggageCount = 0;
        for (Wagon wagon : wagons) 
            totalBaggageCount += wagon.getBaggageCount();
        
        return totalBaggageCount;
    }

    @Override
    public String toString() {
        String output = "Train:\n";
        for (Wagon wagon : wagons) 
            output += "\n" + wagon;
        
        return output;
    }

    public void sortByComfortClass()
    {
        Collections.sort(wagons);
    }

    public void addWagon(Wagon wagon)
    {
        wagons.add(wagon);
    }

    public void removeWagon(Wagon wagon)
    {
        wagons.remove(wagon);
    }

    public void writeToFile(String fileName)
    {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(json);
            fileWriter.close();
        } 
        catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

    public void bootFromFile(String fileName)
    {
         try {
            Gson gson = new Gson();
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String buffString;

            while ((buffString = bufferedReader.readLine()) != null) {
                stringBuilder.append(buffString);
            }                
            bufferedReader.close();
            String json = stringBuilder.toString();

            Train train = gson.fromJson(json, Train.class);
            this.wagons = train.wagons;

        } catch (IOException e) {
            System.out.println("File read or deserialization error: " + e.getMessage());
        }
    }
}