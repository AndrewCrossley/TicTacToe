package Pieces;

import main.Board;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by Andrew on 6/8/2017.
 */
public class X extends PieceTemplate {

	private int endX = x + Board.cellSize - Board.cellBuffer * 2;
	private int endY = y + Board.cellSize - Board.cellBuffer * 2;

	private int secondLineStartX = endX;
	private int secondLineStartY = y;
	private int secondLineEndX = x;
	private int SecondLineEndY = endY;

    public X(int x, int y) {
        super(x, y);
	}

    public void drawPiece(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine(x, y, endX, endY);
		g.drawLine(secondLineStartX, secondLineStartY, secondLineEndX, SecondLineEndY);
	}
}
