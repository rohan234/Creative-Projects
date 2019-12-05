package game;


public class Board extends MainFrame{

	/*Symbols
	 * X: Player One
	 * O: Player Two
	 * -: Blank
	 * +: Highlight
	 */
	
	static String[][] gameBoard = new String[3][3]; //Creates a 2d arrray for the game
	static String[][] hlBoard = new String[3][3]; //Creates a 2d arrray for the highlight
	
	public Board () {} //Constructor for class Board
	
	public static void init() {
		resetBoard(gameBoard);
		resetBoard(hlBoard);
		addMarker(hlBoard, 0, 0, "+");
		
		printBoard(gameBoard);
		printBoard(hlBoard);
		System.out.println("Game initialized.");
	}
	
	static void addMarker(String[][] board, int y, int x, String marker) {
		board[y][x] = marker;
	}
	
	static void resetBoard(String[][] board) {
		/*Generates an empty board*/
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				board[y][x] = "-";
			}
		}
	}

	static void printBoard(String[][] board) {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {

				System.out.print(board[y][x] + " ");
				
			} System.out.println();//stars a new line
		}
	}
	
}