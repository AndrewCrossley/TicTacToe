package Pieces;

import main.Board;

import java.awt.Graphics;

/**
 * Created by Andrew on 6/8/2017.
 */
public abstract class PieceTemplate {

    protected int x, y, width, height;

    public PieceTemplate(int x, int y) {
		this.x = x * Board.cellSize + Board.cellBuffer;
		this.y = y * Board.cellSize + Board.cellBuffer;
		width = Board.cellSize - Board.cellBuffer * 2;
		height = Board.cellSize - Board.cellBuffer * 2;
	}

    public abstract void drawPiece(Graphics g);

}
