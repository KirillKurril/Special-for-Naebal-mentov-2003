package main;

import services.TextHandler;

public class App {
    public static void main(String[] args) throws Exception {
        String stringToProcces = 
        "Of the collective farm youth, I was the only one who was a punk:\n" +
        "I wore leather pants and was dirty as a pig,\n" +
        "My daddy did three loads a day on the combine harvester,\n" +
        "And my mama, there on the farm, twiddling her tits all day  long.\n\n" +
        
        "I'm as fierce as a boar,\n" +
        "got my own accordion,\n" +
        "I play punk rock on it\n" +
        "I'm the first guy in the land\n" +
        "I'm the first guy on the block\n" +
        "I'm the first guy in the world\n" +
        "What a nyahay!\n\n" +
        
        "My father beats me with a ladle and my mother beats me with a broom\n" +
        "Because I'm pissing punk rock all over the house,\n" +
        "I'm despised by the girls because of my pluck,\n" +
        "Everyone in the village barks at me and says: \"Punk rock is out!\"";

        System.out.println(stringToProcces);
        String cleanedString = TextHandler.cleanUp(stringToProcces);
        System.out.println(cleanedString);
        String proccesedString = TextHandler.processText(cleanedString);
        System.out.println(proccesedString);
    }
}
