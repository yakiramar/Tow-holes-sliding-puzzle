
public class Puzzle {
	int columns; // How much Colums
	int rows; // How much rows
	String [][] board; // board game
	String algorithmName; // the algorithm's name that we want tu use
	Boolean withTime; // if to print the time running
	String [][] boardSolution; // the board s
	
	
	public Puzzle(String input) {
		String [] inputArray= input.split("\n");
		this.algorithmName = inputArray[0];
		this.withTime = inputArray[1] == "with time"  ? true : false;
		this.rows = Integer.parseInt(inputArray[2].split("x")[0]);
		this.columns = Integer.parseInt(inputArray[2].split("x")[1]);
		board = new String [rows][columns];
		boardSolution = new String [rows][columns];
		int r = 0;
		String [] numbersArray = inputArray[3].split(",");
		
		//Filling the board game
		for(int i = 0; i< rows; i++) {	
			for(int j = 0; j < columns; j++) {
				board[i][j] = numbersArray[r];
				r++;
			}
		}
		
		//Filling the board Solution
		r=1;
		for(int i = 0; i< rows; i++) {	
			for(int j = 0; j < columns; j++) {
				boardSolution[i][j] = i == (rows -1) &&(j == columns -1 || j == columns -2) ? "_" : String.valueOf(r);
				r++;
			}
		}
		
		
		
		
	}
	
	//print the input details
	public  void printPuzzle() {
		System.out.println("Alogorithm name : "+this.algorithmName);
		System.out.println("Need cuculate running time : "+this.withTime);
		System.out.println("Size board, rows : "+this.rows+" columns : "+this.columns);
		System.out.println("\n" + "The game board :");
		printBoard(this.board);
		System.out.println("\n" + "The board Solution : ");
		printBoard(boardSolution);
		
	}
	
	
	/*Action that we can do on the board and they cost
	 * cost 5: one block down/up/right/left
	 * cost 6: tow block right/left
	 * cost 7: tow block up/down
	 */
	
	
	//move one block down: 1- the first "_", 2- the second "_"
	public Boolean oneBlockDown(int firstOrSecondBlock) {
		for(int i = 0; i< rows -1; i++) {
			for(int j = 0; j< columns; j++) {
				if((firstOrSecondBlock == 1) && (board[i][j].equals("_")) && (!board [i+1][j].equals("_")) ){
					board[i][j] = board [i+1][j];
					board [i+1][j] = "_";
					return true;
				}
				if(board[i][j].equals("_")) {firstOrSecondBlock = 1;}
			}
		}
		
		return false;
	}
	
	//move one block up
	public Boolean oneBlockUp(int firstOrSecondBlock) {
		for(int i = 1; i< rows; i++) {
			for(int j = 0; j< columns; j++) {
				if((firstOrSecondBlock == 1) && (board[i][j].equals("_")) && (!board [i-1][j].equals("_")) ){
					board[i][j] = board [i-1][j];
					board [i-1][j] = "_";
					return true;
				}
				if(board[i][j].equals("_")) {firstOrSecondBlock = 1;}
			}
		}
		
		return false;
		
	}
	
   //move one Block right
   public Boolean oneBlockRight(int firstOrSecondBlock) {
	   for(int i = 0; i< rows; i++) {
			for(int j = 0; j< columns-1; j++) {
				if((firstOrSecondBlock == 1) && (board[i][j].equals("_")) && (!board [i][j+1].equals("_")) ){
					board[i][j] = board [i][j+1];
					board [i][j+1] = "_";
					return true;
				}
				if(board[i][j].equals("_")) {firstOrSecondBlock = 1;}
			}
		}
		
		return false;
   }
   
   //move one Block Left
   public  Boolean oneBlockLeft(int firstOrSecondBlock) {
	   for(int i = 0; i< rows; i++) {
			for(int j = 1; j< columns; j++) {
				if((firstOrSecondBlock == 1) && (board[i][j].equals("_")) && (!board [i][j-1].equals("_")) ){
					board[i][j] = board [i][j-1];
					board [i][j-1] = "_";
					return true;
				}
				if(board[i][j].equals("_")) {firstOrSecondBlock = 1;}
			}
		}
		
		return false;
	   
   }
   
   //move tow Block up
   public Boolean towBlockUp() {
	   for(int i = 1; i< rows; i++) {
				for(int j = 0; j< columns-1; j++) {
					if((board[i][j].equals("_")) && (board[i][j+1].equals("_"))){
						board[i][j] = board [i-1][j];
						board[i][j+1] = board [i-1][j+1];
						board [i-1][j] = "_";
						board[i-1][j+1] = "_";
						return true;
					}
				}
			}
			
			return false;
		   
	   }
   
   
   //move tow Block Down
   public Boolean towBlockDown() {
	   for(int i = 0; i< rows-1; i++) {
				for(int j = 0; j< columns-1; j++) {
					if((board[i][j].equals("_")) && (board[i][j+1].equals("_"))){
						board[i][j] = board [i+1][j];
						board[i][j+1] = board [i+1][j+1];
						board [i+1][j] = "_";
						board[i+1][j+1] = "_";
						return true;
					}
				}
			}
			
			return false;
		   
	   }
  
   
   //move tow Block Right
   public Boolean towBlockRight() {
	   for(int i = 0; i< rows-1; i++) {
				for(int j = 0; j< columns-1; j++) {
					if((board[i][j].equals("_")) && (board[i+1][j].equals("_"))){
						board[i][j] = board [i][j+1];
						board[i+1][j] = board [i+1][j+1];
						board [i][j+1] = "_";
						board[i+1][j+1] = "_";
						return true;
					}
				}
			}
			
			return false;
		   
	   }
   
   //move tow Block Left
   public Boolean towBlockLeft() {
	   for(int i = 0; i< rows-1; i++) {
				for(int j = 1; j< columns; j++) {
					if((board[i][j].equals("_")) && (board[i+1][j].equals("_"))){
						board[i][j] = board [i][j-1];
						board[i+1][j] = board [i+1][j-1];
						board [i][j-1] = "_";
						board[i+1][j-1] = "_";
						return true;
					}
				}
			}
			
			return false;
		   
	   }
   
   
   //print the board
   public void printBoard(String [][] b) {
	   for(int i = 0; i< rows; i++) {	
			for(int j = 0; j < columns; j++) {
				System.out.print(b[i][j]);
				System.out.print(j < columns ? ",": "");
				
				
			}
			System.out.println();
		}
   }
   
   
   //Checking if the current board is the solution
   public  Boolean checkSolution() { 
	   for(int i = 0; i< rows; i++) {	
			for(int j = 0; j < columns; j++) {
				if(!board[i][j].equals(boardSolution[i][j])) {return false;} //if the cells not match
				
			}
		}
	   
	   return true;
   }
}
