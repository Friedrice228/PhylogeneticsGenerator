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
    
    //print out the more relevant data compiled in the array. Leaves out the copied  difference numbers
    //Printing indeces really should not be this complex
    public void printTable(){
        
        int counterRow = 1;
        int counterCol = 0;
        
        for (int i = 0; i < geneticData.length; i++){
            for (int j = 0; j < geneticData[0].length; j++){
                //Prints the column indexes
                if (i == 0){
                    if (j == geneticData[0].length - 1){
                        System.out.println(counterCol);
                    } else{
                        if (counterCol == 0){
                            System.out.print(counterCol + " ");
                        } else{
                            System.out.print(counterCol + "   ");
                        }
                    }
                    counterCol++;
                    
                //prints the row indexes
                } else if (j == 0){
                    if (j == geneticData[0].length - 1){
                        System.out.println(counterRow);
                    } else{
                        System.out.print(counterRow + " ");
                    }
                    counterRow++;
                    
                } else{ //prints the actual fucking data
                    if (j >= i){
                        if (j == geneticData[0].length - 1){
                            System.out.println(geneticData[i][j]);
                        } else{
                            System.out.print(geneticData[i][j] + " ");
                        }
                    }
                    else{
                        System.out.print("    ");
                    }
                }
            }
        }
        
    }
    
}
