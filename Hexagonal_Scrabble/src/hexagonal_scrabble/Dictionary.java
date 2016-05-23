/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

/**
 *
 * @author osimon8
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dictionary {
    Set<String> words = new HashSet<>();
    private Dictionary() {
        try {
            words = readFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Dictionary getInstance() {
        return DictionaryHolder.INSTANCE;
    }
    
    private static class DictionaryHolder {

        private static final Dictionary INSTANCE = new Dictionary();
    }
    private Set<String> readFile() throws FileNotFoundException{
        Set<String> dict = new HashSet<>();
        Scanner sc = new Scanner(new FileReader("words.txt"));
        while(sc.hasNext()){
            dict.add(sc.nextLine());
        }
        return dict;
    }
    public boolean contains(String s){
        return words.contains(s);
    }
    
    public boolean contains(Word w){
        return w!=null?words.contains(w.toString()):false;
    }
    
    public boolean allValid(List<Word> l){
        for(Word w : l){
            if (!contains(w))
                return false;
        }
        return true;
    }
}
