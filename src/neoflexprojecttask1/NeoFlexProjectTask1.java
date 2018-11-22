package neoflexprojecttask1;

import java.util.*;

public class NeoFlexProjectTask1 {
    static HashMap<String,Integer> countWords;// лучше Hashtable не использовать если нет использования многопоточности, заменить на HashMap

    public static void main(String[] args) {
        searchWord("Hello Dima, how are you? Hello, I'am Dima dima", "Dima Hello", true);
        while(itr.hasNext()) {
            String word = (String)itr.next(); //можно без итератора сделать вот так - for (String word : countWords.keySet()) {
            System.out.println("Слово: " + word + " встречается " +
                    (int) countWords.get(word) + " раз"); // здесь не нужен каст к int
        }
    }
    
    public static HashMap<String,Integer> searchWord(String text, String word, boolean ignorCase) { //метод желательно сделать private, т.к. больше нигде не предполагается его использовать
        countWords = new HashMap<String,Integer>(); //обычно инициализация неразрывна с объявлением ссылки + т.к. используется Java 8, то лучше сделать diamond annotations
        String[] wordsFromTheText = transformationInMassiv(text);
        String[] wordsFromTheWord = transformationInMassiv(word);
        int count;
        for (String d : wordsFromTheWord) { // плохие имена для переменных f и d, такие наименование можно делать только в цилках типа for, особенно плохо читается d.compareToIgnoreCase(f)
            count=0;
            for (String f : wordsFromTheText) {
                if (((d.compareToIgnoreCase(f))==0)&&(ignorCase==true)) // можно ignoreCase==true заменить просто на ignoreCase
                    count++;
                else { if((d.compareTo(f))==0) count++; }
            }
            countWords.put(d,count);
        }
        return countWords; //в данном примере метод надо делать void, т.к. countWords итак статический, нет смысла его возвращать
    }
    
    public static String[] transformationInMassiv(String text) {//метод желательно сделать private, т.к. больше нигде не предполагается его использовать
        text = text.replaceAll(" ", "_");
        text = text.replaceAll("\\W", "_");
        while (true) {
            if (text.indexOf("__")!=-1) { // лучше заменить на text.contains("__")
                text = text.replaceAll("__", "_");
                continue;
            } break;
        }
        return text.split("_"); // слишком много replaceAll в методе, все можно заменить на return text.replaceAll("[^A-Za-z]+", " ").split(" ");
    }
}
