package entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import interfaces.Medication;

public class Pill implements Medication {

    private String name;
    private ArrayList<String> ingredients;
    private boolean freelyAvailable;
    private int dosageCoefficient; 

    public Pill(String name)
    {
        this.name = name;
        ingredients = new ArrayList<String>();
        this.freelyAvailable = true;

        Random random = new Random();
        this.dosageCoefficient = random.nextInt(10) + 1;
    }

    @Override
    public void addActiveIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public double calculateDosage(int age, int weight) {
        return weight * dosageCoefficient / age;
    }

    @Override
    public void conductResearch() {
        try {
            File file = new File(name + "_pill_research.txt");
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(toString());
            fileWriter.close();
            System.out.println("\nThe results of " + name + " research are printed in file " + name + "_pill_research.txt");
        } 
        catch (IOException e) {
            System.out.println("Error while writing research to file: " + e.getMessage());
        }
    }

    @Override
    public void changeStatus(boolean status) {
        this.freelyAvailable = status;
    }

    @Override
    public ArrayList<String> getActiveIngredients() {
        return ingredients;       
    }

    @Override
    public boolean getFreelyAvailable(){
        return freelyAvailable;
    }

    @Override
    public String toString() {
        String output = name + "pill: \n\tIngredients:\n";
        
        for (String ingredient : ingredients) {
            output += "\t\t" + ingredient + "\n";
        }

        output += "\tIs freely available:\n\t\t" + freelyAvailable;
        return output;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void apply() {
        System.out.println(name + " pill is taken");
    }
}
