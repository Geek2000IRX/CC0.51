package xyz.chengzi.cs102a.chinesechess.chess;

import xyz.chengzi.cs102a.chinesechess.chessboard.ChessboardPoint;

import java.awt.*;

public class HorseChessComponent extends ChessComponent {
    public HorseChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color) {
        super(chessboardPoint, location, color);
    }
    @Override
    public boolean canMoveTo(ChessComponent[][] chessboard, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if (source.getX()+2 == destination.getX()&&source.getY()+1 == destination.getY()) {
            int row = source.getX()+1;
            int col = source.getY();
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                    return false;
            }
        } else if (source.getX()+2 == destination.getX()&&source.getY()-1 == destination.getY()) {
            int row = source.getX()+1;
            int col = source.getY();
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                return false;
            }
        }else if (source.getX()-2 == destination.getX()&&source.getY()+1 == destination.getY()) {
            int row = source.getX()-1;
            int col = source.getY();
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                return false;
            }
        }else if (source.getX()-2 == destination.getX()&&source.getY()-1 == destination.getY()) {
            int row = source.getX()-1;
            int col = source.getY();
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                return false;
            }
        }
        else if (source.getX()+1 == destination.getX()&&source.getY()+2 == destination.getY()) {
            int row = source.getX();
            int col = source.getY()+1;
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                return false;
            }
        }else if (source.getX()+1 == destination.getX()&&source.getY()-2 == destination.getY()) {
            int row = source.getX();
            int col = source.getY()-1;
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                return false;
            }
        }else if (source.getX()-1 == destination.getX()&&source.getY()+2 == destination.getY()) {
            int row = source.getX();
            int col = source.getY()+1;
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                return false;
            }
        }else if (source.getX()-1 == destination.getX()&&source.getY()-2 == destination.getY()) {
            int row = source.getX();
            int col = source.getY()-1;
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                return false;
            }
        }
        else { // Not on the same row or the same column.
            return false;
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(CHESS_COLOR);
        g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        g.setColor(getChessColor().getColor());
        g.drawOval(2, 2, getWidth() - 5, getHeight() - 5);
        g.setColor(Color.BLACK);
        g.drawString("马", 15, 25); // FIXME: Use library to find the correct offset.
        if (isSelected()) { // Highlights the chess if selected.
            g.setColor(Color.RED);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }
}
