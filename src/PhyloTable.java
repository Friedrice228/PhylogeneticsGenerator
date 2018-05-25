import java.util.Scanner;

public class PhyloTable{
    
    //data structure to store the genetic data from the sequencer
    public int[][] geneticData;
    
    //takes in a square array (like the one that the sequencer makes) and will generate
    //a nice table from there
    public PhyloTable (int[][] data){
        
        geneticData = data;
        
    }
    
    //prints out the 2d array that is taken in from the main (which got it from the sequencer)
    public void print2dDataArray(){
        
        for (int i = 0; i < geneticData.length; i++){
            for (int j = 0; j < geneticData[0].length; j++){
                if (j == geneticData[0].length - 1){
                    System.out.println(geneticData[i][j]);
                } else{
                    System.out.print(geneticData[i][j] + " ");
                }
            }
        }
        
    }
    
}
