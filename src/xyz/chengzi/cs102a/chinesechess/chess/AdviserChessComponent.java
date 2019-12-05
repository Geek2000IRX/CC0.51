package xyz.chengzi.cs102a.chinesechess.chess;

import xyz.chengzi.cs102a.chinesechess.chessboard.ChessboardPoint;

import java.awt.*;

public class AdviserChessComponent extends ChessComponent {
    public AdviserChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color) {
        super(chessboardPoint, location, color);
    }
    @Override
    public boolean canMoveTo(ChessComponent[][] chessboard, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        boolean a = false;
        if (destination.getX()!=3&&destination.getX()!=5&&destination.getY()!=2&&destination.getY()!=6) {
            if (source.getX() + 1 == destination.getX() && source.getY() + 1 == destination.getY()) {
                a= true;
            } else if (source.getX() - 1 == destination.getX() && source.getY() + 1 == destination.getY()) {
                a= true;
            } else if (source.getX() + 1 == destination.getX() && source.getY() - 1 == destination.getY()) {
                a= true;
            } else if (source.getX() - 1 == destination.getX() && source.getY() - 1 == destination.getY()) {
                a= true;
            }
        }else {
            a= false;
        }
        return a;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(CHESS_COLOR);
        g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        g.setColor(getChessColor().getColor());
        g.drawOval(2, 2, getWidth() - 5, getHeight() - 5);
        g.setColor(Color.BLACK);
        g.drawString("士", 15, 25); // FIXME: Use library to find the correct offset.
        if (isSelected()) { // Highlights the chess if selected.
            g.setColor(Color.RED);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }
}
