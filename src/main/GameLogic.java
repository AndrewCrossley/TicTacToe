package main;

import Pieces.Piece;

import static main.Board.cell;

/**
 * Created by Andrew on 6/7/2017.
 */
public class GameLogic {

	public static void checkForWinner(int x, int y, Piece piece){

		int row = 0, column = 0, diagnal = 0, antiDiagnal = 0;
		for(int a = 0; a < Board.rows; a++) {
			if(cell[x][a] == piece) row++;
			if(cell[a][y] == piece) column++;
			if(cell[a][a] == piece) diagnal++;
			if(cell[a][Board.rows - a - 1] == piece) antiDiagnal++;
		}
		if(row == 3 || column == 3 || diagnal == 3 || antiDiagnal == 3) {
			System.out.print(piece + " wins!");
		}
	}

}
