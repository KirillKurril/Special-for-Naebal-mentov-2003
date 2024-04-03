package services;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TextParser {

    static public HashMap<String, Integer> getWordStatistic(ArrayList<String> wordsToFind, String textToParse) throws Exception
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        
        try{
            ArrayList<String> words = new ArrayList<>(Arrays.asList(textToParse.split("\\s+")));

            Predicate<String> isTargetWord = w -> wordsToFind.contains(w);
            Consumer<String> refreshStatistic = w -> 
            result.put(w, result.containsKey(w) ? result.get(w) + 1 : 1);
            
            for (String word : words) 
                if (isTargetWord.test(word)) 
                    refreshStatistic.accept(word); 
            
            return result;
        }
        finally{}
    }

    static public HashMap<String, Integer> getWordStatisticFromFile(ArrayList<String> wordsToFind, String filePath) throws Exception
    {
        try
        {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String buffString;

            while ((buffString = bufferedReader.readLine()) != null) {
                stringBuilder.append(buffString);
            } 

            bufferedReader.close();
            String textToParse = stringBuilder.toString();
            return getWordStatistic(wordsToFind, textToParse);
        }
        catch(IOException e)
        {
            System.out.println("Error while reading " + filePath + " file: " + e.getMessage());
            return new HashMap<String, Integer>();
        }
    }
}
