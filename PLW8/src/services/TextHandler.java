package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TextHandler {
    public static String cleanUp(String text) throws Exception {

	    String processedText = "";

        for (char ch : text.toCharArray()) 
            if (Character.isAlphabetic(ch) || Character.isWhitespace(ch))
                processedText += ch; 
            else
                processedText += ' ';           

        processedText = processedText.replaceAll("\\s+", " ");

        return processedText;
	}

    public static String processText(String text)
    {
        HashMap<Integer, String> splitedText = new HashMap<>();
        ArrayList<Pair<Integer, String>> onVowels = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();

        String[] words = text.split("\\s+");

        for (int i = 0; i < words.length; i++) 
        {
            splitedText.put(i, words[i]);
            
            if (isVowel(words[i].charAt(0)))
            {
                onVowels.add(new Pair<Integer, String>(i, words[i]));
                temp.add(words[i]);
            }
        }

        System.out.println(temp);
        Collections.sort(temp);
        System.out.println(temp);

        int i = 0;
        for (Pair<Integer, String> pair : onVowels) {
            pair.setValue(temp.get(i++));
        }

        for (Pair<Integer, String> pair : onVowels) {
            splitedText.put(pair.getKey(), pair.getValue());
        }

        temp.clear();
        for ( Integer key : splitedText.keySet()) 
            temp.add(splitedText.get(key));

        String processedText = String.join(" ", temp);
        return processedText;
    }

    public static boolean isVowel(char letter) {
        char lowercaseLetter = Character.toLowerCase(letter);
        
        return lowercaseLetter == 'a' || lowercaseLetter == 'e' ||
               lowercaseLetter == 'i' || lowercaseLetter == 'o' ||
               lowercaseLetter == 'u' || lowercaseLetter == 'y';
    }
}

    