package Pieces;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by Andrew on 6/8/2017.
 */
public class O extends PieceTemplate {

    public O(int x, int y) {
        super(x, y);
    }

    public void drawPiece(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(x, y, width, height);
    }
}
