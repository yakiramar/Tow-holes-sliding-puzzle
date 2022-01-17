import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex1 {
	
	
	// readFileText get String that contain path to txt file and return his content
	public static  String readFileTXT(String filePath) {

		String fileContent="";
		try {
		      File myObj = new File(filePath);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		       fileContent = fileContent + myReader.nextLine()+"\n";
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return fileContent;
		
		
	}

	public static void main(String[] args) {
		
		String fileContent = readFileTXT("C:\\Users\\yakira\\eclipse-workspace\\Tow-holes-sliding-puzzle\\src\\input.txt");
		//System.out.println(fileContent);
		Puzzle p = new Puzzle(fileContent);
		p.printPuzzle();
		Boolean movingBlock;
		
		System.out.println("\n");
	    movingBlock= p.towBlockLeft();
	    System.out.println("jgfhgf");
	    System.out.println("moving tow block sucsess2 ? "+movingBlock);
	    p.printBoard(p.board);
	    
		
		// TODO Auto-generated method stub

	}

}
