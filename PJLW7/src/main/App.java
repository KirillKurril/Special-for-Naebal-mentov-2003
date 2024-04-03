package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import services.TextParser;

public class App {
    public static void main(String[] args) {
        String filePath = "resources/data.txt";
        ArrayList<String> monitoredWords = new ArrayList<>(Arrays.asList("God", "And"));
    try
    {
        HashMap<String, Integer> parseResult = TextParser.getWordStatisticFromFile(monitoredWords, filePath);
        for ( String key : parseResult.keySet()) 
            System.out.println(key + " : " + parseResult.get(key));
    }
    catch(Exception e)
    {
        System.out.println("Was caused by an exception: " + e.getMessage());
    }
    }

}