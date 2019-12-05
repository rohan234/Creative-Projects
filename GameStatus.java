package game;

public class GameStatus {
	
	boolean playerOneVictory;
	boolean playerTwoVictory;
	
	
	//Maybe make another board called victory board OwO
	//Depending on how the methods below turn out, put on different markers that become lines?
	
	public static boolean checkVictory (String board[][]) {
		//
		if(checkRowVictory(board)[2] == 1)// return[0] y coord and return [1] is the x coord of vic pos, return[2] is whether there was victory or not 
			return true;
		else if (checkColVictory(board)[2] == 1)
			return true;
		else if (checkDiagVictory(board)[2] == 1)
			return true;
		else
			return false;
		
		
		
	}
	
	public static int[] checkRowVictory(String board[][]) {
		int[] victoryCoordinate = {0, 0, 0}; //y, x, trueCoordinate
		
		
		for (int y = 0; y < 3; y++) {
			if (board[y][0] == board[y][1] 
					&& board[y][1] == board[y][2] 
							&& board[y][0] != "-") {
				victoryCoordinate[2] = 1; //sets it as true
				victoryCoordinate[0] = y;
				return victoryCoordinate;
			}
		} 
		return victoryCoordinate;
	}
	
	public static int[] checkColVictory(String board[][]) {
		int[] victoryCoordinate = {0, 0, 0}; //y, x, trueCoordinate
		for (int x = 0; x < 3; x++) {
			if (board[0][x] == board[1][x] 
					&& board[1][x] == board[2][x]
							&& board[0][x] != "-") {
				victoryCoordinate[1] = x;
				victoryCoordinate[2] = 1; //sets the coordinate as true
				return victoryCoordinate;
			}
		} 
		return victoryCoordinate;
	}
	
	public static int[] checkDiagVictory(String board[][]) {
		int[] victoryCoordinate = {0, 0, 0, 0}; //y, x, trueCoordinate, isTopLeft
		
		if(board[1][1] != "-") {
			if (board[0][0] == board[1][1] 
					&& board[1][1] == board[2][2]) {
				victoryCoordinate[2] = 1; //sets coordinate as true
				victoryCoordinate[3] = 1; //sets top left as true
				return victoryCoordinate;
		}
			else if (board[0][2] == board[1][1] 
					&& board[1][1] == board[2][0]) {
				victoryCoordinate[2] = 1; //sets coordinate as true
				victoryCoordinate[1] = 2;
				return victoryCoordinate;
			}
		}
		return victoryCoordinate;	 
		
	}
	
}
