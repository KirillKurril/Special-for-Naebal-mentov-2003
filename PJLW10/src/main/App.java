package main;

import java.io.IOException;

import services.CodeBeautifiler;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            CodeBeautifiler.beautify("resources/TextParser.java");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
