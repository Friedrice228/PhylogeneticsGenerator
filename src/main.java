import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//main class for the sequencer code that will generate the phylogenetic trees or table (I'm not sure yet)
public class main {
	
	public static String identifier = ">";
    public static String fileName = "Sequences.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
        
        //sequencer object to parse through the text data in the .txt file
        Sequencer sequencer = new Sequencer(identifier, fileName);
        int[][] arr = sequencer.compareGenes(sequencer.getSequences());
        
        //table is the object that presents the data aprsed from the sequencer object... they should really
        //in the same file... later maybe *shrugs*
        PhyloTable table = new PhyloTable(arr);
        table.print2dDataArray(); //test method to see if the data was being processed correctly
        
        System.out.println("");
        
        //this is the real method that you should use
        //clean this up if you have any self respect left
        table.printTable();
        
        
	}
}
    
