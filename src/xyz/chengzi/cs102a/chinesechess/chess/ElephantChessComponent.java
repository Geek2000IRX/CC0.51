package xyz.chengzi.cs102a.chinesechess.chess;

import xyz.chengzi.cs102a.chinesechess.chessboard.ChessboardPoint;

import java.awt.*;

public class ElephantChessComponent extends ChessComponent {
    public ElephantChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color) {
        super(chessboardPoint, location, color);
    }
    @Override
    public boolean canMoveTo(ChessComponent[][] chessboard, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if(destination.getX()==6||destination.getX()==3){
            return false;
        } //开始绊象腿
        else if (source.getX()+2 == destination.getX()&&source.getY()+2 == destination.getY()) {
            int row = source.getX()+1;
            int col = source.getY() + 1;
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                    return false;
            }
        } else if (source.getX()+2 == destination.getX()&&source.getY()-2 == destination.getY()) {
            int row = source.getX()+1;
            int col = source.getY()-1;
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                return false;
            }
        }else if (source.getX()-2 == destination.getX()&&source.getY()+2 == destination.getY()) {
            int row = source.getX()-1;
            int col = source.getY()+1;
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                return false;
            }
        }else if (source.getX()-2 == destination.getX()&&source.getY()-2 == destination.getY()) {
            int row = source.getX()-1;
            int col = source.getY()-1;
            if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                return false;
            }
        } else { // 不走田字格.
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
        g.drawString("象", 15, 25); // FIXME: Use library to find the correct offset.
        if (isSelected()) { // Highlights the chess if selected.
            g.setColor(Color.RED);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }
}
