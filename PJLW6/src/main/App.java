package main;

import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("==============================================");


        Solution solution = new Solution("Sterofundin");

        solution.addActiveIngredient("solution ingredient1");
        solution.addActiveIngredient("solution ingredient2");

        System.out.println("\nDose for human 70 years old and weight 50kg:");
        System.out.println(solution.calculateDosage(70, 50));
        System.out.println("\n" + solution.getName() + "is avalible: " + solution.getFreelyAvailable());
        System.out.println("Changing avalible");
        solution.changeStatus(true);
        System.out.println(solution.getName() + "is avalible: " + solution.getFreelyAvailable());
        System.out.println("\nActive ingridients in" + solution.getName() + " solution are:");
        for (String ingridient : solution.getActiveIngredients()) {
            System.out.println(ingridient);
        }
        solution.conductResearch();        
        System.out.println("\nSpecial solution function run:");
        solution.inject();


        System.out.println("==============================================");


        Ointment ointment = new Ointment("Miramistin");

        ointment.addActiveIngredient("ointment ingredient1");
        ointment.addActiveIngredient("ointment ingredient2");

        System.out.println("\nDose for human 40 years old and weight 70kg:");
        System.out.println(ointment.calculateDosage(40, 70));
        System.out.println("\n" + ointment.getName() + "is avalible: " + ointment.getFreelyAvailable());
        System.out.println("Changing avalible");
        ointment.changeStatus(false);
        System.out.println(ointment.getName() + "is avalible: " + ointment.getFreelyAvailable());
        System.out.println("\nActive ingridients in " + ointment.getName() + " ointment are:");
        for (String ingridient : ointment.getActiveIngredients()) {
            System.out.println(ingridient);
        }
        ointment.conductResearch();        
        System.out.println("\nSpecial ointment function run:");
        ointment.apply();


        System.out.println("==============================================");


        Pill pill = new Pill("Famotidine");

        pill.addActiveIngredient("pill ingredient1");
        pill.addActiveIngredient("pill ingredient2");

        System.out.println("\nDose for human 60 years old and weight 60kg:");
        System.out.println(pill.calculateDosage(60, 60));
        System.out.println("\n" + pill.getName() + "is avalible: " + pill.getFreelyAvailable());
        System.out.println("Changing avalible");
        pill.changeStatus(false);
        System.out.println(pill.getName() + "is avalible: " + pill.getFreelyAvailable());
        System.out.println("\nActive ingridients in " + pill.getName() + " pill are:");
        for (String ingridient : pill.getActiveIngredients()) {
            System.out.println(ingridient);
        }
        pill.conductResearch();        
        System.out.println("\nSpecial pill function run:");
        pill.apply();
    }
}
