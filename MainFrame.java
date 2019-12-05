package game;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import ddf.minim.spi.*;
import ddf.minim.signals.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.ugens.*;
import ddf.minim.effects.*;
 


public class MainFrame extends JFrame implements KeyListener, MouseListener{
    
	public static MainDraw draw;
    
    final static int FRAME_PADDING = 20;
    final static int TEXT_WIDTH = 400;
    
    public static boolean isPlayerOneTurn = true;
    
    public static String gameStatus;
    
    Marker highlight = new Marker();
    
    static void updateVisuals() {
    	Board.printBoard(Board.gameBoard);
    	Board.printBoard(Board.hlBoard);
    	MainFrame.draw.repaint();
    }
    
    public void keyPressed(KeyEvent e) {
    	System.out.println("keyPressed");
    }
   
   void sounds() {
	   
	  
    }
    public void keyReleased(KeyEvent e) {
    	
    	if (e.getKeyCode() == KeyEvent.VK_UP) {
        	highlight.moveUp();
        	
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
        	highlight.moveDown();
        	
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
        	highlight.moveLeft();
        	
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	highlight.moveRight();
        	
        } else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
        	highlight.placeMarker();
        	
        	if (GameStatus.checkVictory(Board.gameBoard)) {
        		System.out.println("Victory!");
        	}
        } 
        	
    }
    
    public void mouseClicked(MouseEvent e) { 
  
        // getClickCount gives the number of quick, 
        // consecutive clicks made by the user 
        // show the point where the mouse is i.e 
        // the x and y coordinates 
        System.out.println("mouse clicked at point: " + + e.getX() + " " + e.getY() + "mouse clicked: " + e.getClickCount());
        
        int[] clickCoordinates = {checkMouseRow(e), checkMouseColumn(e)};
        
        Board.resetBoard(Board.hlBoard);
        if (e.getClickCount() == 1) 
        	Board.addMarker(Board.hlBoard, clickCoordinates[0], clickCoordinates[1], "+");
        else if (e.getClickCount() == 2 && Marker.validMove(Board.gameBoard, clickCoordinates)) {
        	Board.addMarker(Board.gameBoard, clickCoordinates[0], clickCoordinates[1], Marker.getCurrentPlayerMarker());
        	if (GameStatus.checkVictory(Board.gameBoard)) {
        		System.out.println("Victory!");
        	}
        		
        }
        updateVisuals();
    } 
    
    private int checkMouseRow(MouseEvent e) {
    	if (e.getY() < 200 + 25) {
        	return 0;
        } else if (e.getY() < 400 + 25) {
        	return 1;
        } else {
        	return 2;
        } 
    }
    
    private int checkMouseColumn(MouseEvent e) {
    	if (e.getX() < 200) {
        	return 0;
        } else if (e.getX() < 400) {
        	return 1;
        } else {
        	return 2;
        } 
    }
    
    
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }

    public MainFrame(){
        this.draw = new MainDraw();
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
    	
    	Board.init();
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            
        	public void run() {
                
            	MainFrame frame = new MainFrame();
                frame.setTitle("TicTacToe Game");
                frame.setResizable(false);
                frame.setSize(200 * 3 + TEXT_WIDTH, 200 * 3 + FRAME_PADDING);
                frame.setMinimumSize(new Dimension(200 * 3 + TEXT_WIDTH, 200 * 3 + FRAME_PADDING));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.draw);
                frame.pack();
                frame.setVisible(true);
                
            }
        });
        
        
        
    }
    
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

    
 
}