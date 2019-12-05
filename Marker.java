package game;
public class Marker {

	final static int y = 0; //these variables are set to access index in a way so its readable to humans
	final static int x = 1;
	
	static int[] oldPos;
	static int[] newPos;
	
	public static String playerMarker = "X";
	
	static int[] getPosition(String marker, String[][] board) {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (board[y][x].startsWith(marker)) {
					int[] position = {y, x};
					return position;
				}
			}
		}
		
		System.out.println("ERROR: UNABLE TO FIND MARKER: " + marker);
		return null;
	}
		
	public void moveUp() {
		move(findNewPosition(/*Axis:*/ y, /*Increase:*/ false));
	}
	
	public void moveDown() {
		move(findNewPosition(/*Axis:*/ y, /*Increase:*/ true));
	}
	
	public void moveLeft() {
		move(findNewPosition(/*Axis:*/ x, /*Increase:*/ false));
	}

	
	public void moveRight() {
		move(findNewPosition(/*Axis:*/ x, /*Increase:*/ true));
	}
	
	
	private int[] findNewPosition(int axis, boolean increase) {
		oldPos = getPosition("+", Board.hlBoard);
		newPos = oldPos;
		
		if (increase) {
			newPos[axis] += 1;
		} else {
			newPos[axis] -= 1;
		}
		
		return newPos;
	}
	
	
	private void move(int[] newPosition) {
		
		if (validMove(Board.hlBoard, newPosition)) {
			Board.resetBoard(Board.hlBoard);
			Board.hlBoard[newPosition[y]][newPosition[x]] = "+";
		} else {
			MainFrame.gameStatus = "You cannot place the marker outside of the board!";
		}
		
		MainFrame.updateVisuals();
	}
	
	
	public void placeMarker() {
		
		oldPos = getPosition("+", Board.hlBoard);
		
		if (validMove(Board.gameBoard, getPosition("+", Board.hlBoard))) {
			updatePlayerMarker();
			Board.gameBoard[oldPos[y]][oldPos[x]] = playerMarker;
		}
			
		
		MainFrame.updateVisuals();
		
	}
	
	public static String getCurrentPlayerMarker() {
		
		updatePlayerMarker();
		return playerMarker;
	}
	
	
	public static boolean validMove(String[][] board, int[] newPosition) {
		if (board[newPosition[y]][newPosition[x]] == "-") {
			return true;
		} else {
			return false;
		}
		
	}
	
	private static void updatePlayerMarker() {
		
		if (MainFrame.isPlayerOneTurn) {
			playerMarker = "O";
			MainFrame.isPlayerOneTurn = false;
		}
		else {
			playerMarker = "X";
			MainFrame.isPlayerOneTurn = true;
		}
		
	}
	
}