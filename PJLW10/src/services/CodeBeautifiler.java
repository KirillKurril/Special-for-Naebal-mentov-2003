package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodeBeautifiler {
    public static void beautify(String filePath) throws IOException{
        String javaCode = readFileAsString(filePath);
        String processedCode = javaCode.replaceAll("(\\t| |\n)+\n", "\n")
        .replaceAll("[^\\S\n\t]+", " ") //[^\\S\n]+  [] -- набор символов из которых может быть выбран один символ, ^ - не, \s - не пробел
        .replaceAll("\\t+", "")
        .replaceAll("\\n ", "\n")
        .replaceAll("\\{ ", "{")
        .replaceAll(" \\}", "}")
        .replaceAll("\\[ ", "]")
        .replaceAll(" \\]", "]")
        .replaceAll("\\( ", "(")
        .replaceAll(" \\)", ")");
        
        
        writeToFile(processedCode, filePath);
        System.out.println(processedCode);
    }

    public static String readFileAsString(String filePath) throws IOException{
        
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String buffString;

        while ((buffString = bufferedReader.readLine()) != null) {
            stringBuilder.append(buffString + "\n");
        } 

        bufferedReader.close();
        String textToParse = stringBuilder.toString();
        return textToParse;
        }

        public static void writeToFile(String processedCode, String fileName) throws IOException
        {
            fileName = fileName.replaceAll("\\s+", "_");
            fileName = fileName.substring(0, fileName.length() - 5);
            fileName += "_formatted.java";
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(processedCode);
            fileWriter.close();
        }
    }
    


