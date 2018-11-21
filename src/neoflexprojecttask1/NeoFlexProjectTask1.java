package neoflexprojecttask1;

import java.util.*;

public class NeoFlexProjectTask1 {
    static Hashtable<String,Integer> countWords;

    public static void main(String[] args) {
        searchWord("Hello Dima, how are you? Hello, I'am Dima dima", "Dima Hello", true);
        Iterator itr = countWords.keySet().iterator();
        while(itr.hasNext()) {
            String word = (String)itr.next();
            System.out.println("Слово: " + word + " встречается " + 
                    (int) countWords.get(word) + " раз");
        }
    }
    
    public static Hashtable<String,Integer> searchWord(String text, String word, boolean ignorCase) {
        countWords = new Hashtable<String,Integer>();
        String[] wordsFromTheText = transformationInMassiv(text);
        String[] wordsFromTheWord = transformationInMassiv(word);
        int count;
        for (String d : wordsFromTheWord) {
            count=0;
            for (String f : wordsFromTheText) {
                if (((d.compareToIgnoreCase(f))==0)&&(ignorCase==true))
                    count++;
                else { if((d.compareTo(f))==0) count++; }
            }
            countWords.put(d,count);
        }
        return countWords;
    }
    
    public static String[] transformationInMassiv(String text) {
        text = text.replaceAll(" ", "_");
        text = text.replaceAll("\\W", "_");
        while (true) {            
            if (text.indexOf("__")!=-1) {
                text = text.replaceAll("__", "_");
                continue;
            } break;
        }
        return text.split("_");
    }
}
