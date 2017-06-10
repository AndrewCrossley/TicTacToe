package main;

import Pieces.O;
import Pieces.Piece;
import Pieces.PieceTemplate;
import Pieces.X;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Andrew on 6/7/2017.
 *
 * To Do: Add side panel showing winner and allowing for restarting the game. Add multiplayer
 *
 */
public class Board extends JPanel implements MouseListener {

    public static final int rows = 3, columns = 3;
    public static final int cellSize = 100; //Pixel size of cells.
    public static final int cellBuffer = (int) (cellSize * 0.05); //Distance between piece edge and neighboring cell.
    private static final int boardLength = cellSize * columns;
    private static final int boardHeight = cellSize * rows;

    private static Piece piece = Piece.X; //Default piece is X
    public static Piece[][] cell = new Piece[rows][columns];
    private static int cellX, cellY;

    PieceTemplate pt;

    public Board() {
        setLayout(null);
        addMouseListener(this);

        setPreferredSize(new Dimension(boardLength, boardHeight));
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Vertical lines
        for(int x = cellSize; x < boardLength; x+=cellSize) {
            g.drawLine(x,0,x,boardLength);
        }
        //Horizontal lines
        for(int x = cellSize; x < boardHeight; x+=cellSize) {
            g.drawLine(0,x,boardHeight,x);
        }

        for(int x = 0; x < rows; x++) {
        	for(int y = 0; y < columns; y++) {
        		if(cell[x][y] == Piece.X) {
					pt = new X(x, y);
        			pt.drawPiece(g);
				}
				if(cell[x][y] == Piece.O) {
					pt = new O(x, y);
        			pt.drawPiece(g);
				}
			}
		}

	}

    public void mouseClicked(MouseEvent e) {
		getMousePosition(e);
    }

    private void getMousePosition(MouseEvent e) {
        cellX = e.getX();
        cellY = e.getY();
        cellX/= cellSize;
        cellY/= cellSize;

        setCell(cellX, cellY, piece);
	}

	public void setCell(int x, int y, Piece piece) {
		if(cell[x][y] == null) {
			cell[x][y] = piece;
			GameLogic.checkForWinner(x, y, piece);
			repaint();
			if(piece == Piece.X) {
				this.piece = Piece.O;
			}
			else if (piece == Piece.O) {
				this.piece = Piece.X;
			}
		}
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
