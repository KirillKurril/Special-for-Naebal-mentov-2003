package interfaces;

import java.util.ArrayList;

public interface Medication {
    void addActiveIngredient(String ingredient);
    double calculateDosage(int age, int weight);
    void conductResearch();
    void changeStatus(boolean status);
    ArrayList<String> getActiveIngredients();
    boolean getFreelyAvailable();
}
