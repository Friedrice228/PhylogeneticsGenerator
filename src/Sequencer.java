import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sequencer{
    
    public String identifier = "";
    public String fileName = "";
    public String textData = "";
    public String[] sequences = {""};
    public int minI = 0;

    
    //constructor
    public Sequencer(String ident, String file) throws FileNotFoundException{
        
        identifier = ident;
        
        fileName = file;
        
        textData = new Scanner(new File(fileName)).useDelimiter("\\A").next();
        
        int countDiv = 0; // counts the number of points entered
        //What I will probably wnat to do is check for the longest string (DNA) and fill all the shorter strands with "O"s
        //to represent void values that do not match. This will allow me to split the DNA into even sections that can be compared together
        //in a more comparative way
        
        //counts the amount of different DNA strands
        for (int i = 0; i < textData.length() - 1; i++){
            
            if (textData.substring(i, i+1).equals(identifier)){
                countDiv++;
            }
            
        }
        
          sequences = separate(countDiv);
        
          minI = checkLengths(sequences);
        
    }
    
    
    
    //returns the seprated sequences of genes
    public String[] getSequences(){
        
        return sequences;
        
    }
    
    //seperates the textData into the different strands of DNA
    public String[] separate(int numPoint){
        
        int startIndex = 0;
        int sequenceIndex = 0;
        
        String sequences1[] = new String[numPoint];
        
        for (int i = 0; i < textData.length(); i++){
            if (textData.substring(i, i+1).equals(identifier) && (i != 0)){
                sequences1[sequenceIndex] = textData.substring(startIndex, i);
                sequenceIndex++;
                startIndex = i;
            }
        }
        return sequences1;
        
    }
    
    //actual comparitor between two gene sequences
    public int checkRelation(String dna1, String dna2){
        
        int totalDiff = 0;
        for (int i = 0; i < minI; i++){
            if (!dna1.substring(i, i+1).equals(dna2.substring(i, i+1))){
                totalDiff++;
            }
        }
        
        return totalDiff;
        
    }
    
    //takes in the genetic data and returns the table of all the differnces
    public int[][] compareGenes(String[] data){
        
        int comparisons[][] = new int[data.length][data.length];
        
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data.length; j++){
                if (i != j){
                    comparisons[i][j] = checkRelation(data[i], data[j]);
                }
            }
        }
        
        return comparisons;
        
    }
    
    //finds the shortest strand of DNA
    public int checkLengths(String[] data){
        
        int min = data[0].length();
        
        for (int i = 0; i < data.length; i++){
            if (data[i].length() < min){
                min = data[i].length();
            }
        }
        
        return min;
        
    }

    
    
    
}
