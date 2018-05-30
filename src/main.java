import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//main class for the sequencer code that will generate the phylogenetic trees or table (I'm not sure yet)
public class main {
	
	public static String identifier = ">";
    public static String fileName = "Sequences.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
        
        Sequencer sequencer = new Sequencer(identifier, fileName);
        int[][] arr = sequencer.compareGenes(sequencer.getSequences());
        
        PhyloTable table = new PhyloTable(arr);
        table.print2dDataArray();
        
        System.out.println("");
        
        table.printTable();
        
        
	}
}
    
