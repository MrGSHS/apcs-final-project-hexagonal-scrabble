/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owen
 */
public class Dictionary {
    private Set<String> words;
    public Dictionary(){
        try {
            words = readFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
}
