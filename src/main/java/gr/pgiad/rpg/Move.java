package main.java.gr.pgiad.rpg;

public class Move {
    //    Method to restore the kind of square the player was and move X to the desired square
    private static String[][] swap(String[][] gridMap, int x_posA, int y_posA, int x_posB, int y_posB
            , String lastPosition) {
        String temp = gridMap[y_posA][x_posA];
        gridMap[y_posA][x_posA] = lastPosition;
        gridMap[y_posB][x_posB] = temp;
        return gridMap;
    }

    public static boolean moveUp(Grid grid) {
//        Check if the move user wants to do is valid
        if (grid.getY_pos() == 0 || grid.getMap()[grid.getY_pos() - 1][grid.getX_pos()].equals("N")) {
            return false;
        }
//        Store last position's value
        String tempPosition = grid.getLastPosition();
//        Update last position's value with the value of the next position
        grid.setLastPosition(grid.getMap()[grid.getY_pos() - 1][grid.getX_pos()]);
//        Update grid map calling swap method with the tempPosition
        grid.setMap(swap(grid.getMap(), grid.getX_pos(), grid.getY_pos(), grid.getX_pos(), grid.getY_pos() - 1
                , tempPosition));
//        Update y position
        grid.setY_pos(grid.getY_pos() - 1);
//        Print grid map
        grid.print();
        return true;
    }

    public static boolean moveDown(Grid grid) {
//        Check if the move user wants to do is valid
        if (grid.getY_pos() == grid.getY_max() || grid.getMap()[grid.getY_pos() + 1][grid.getX_pos()].equals("N")) {
            return false;
        }
//        Store last position's value
        String tempPosition = grid.getLastPosition();
//        Update last position's value with the value of the next position
        grid.setLastPosition(grid.getMap()[grid.getY_pos() + 1][grid.getX_pos()]);
//        Update grid map calling swap method with the tempPosition
        grid.setMap(swap(grid.getMap(), grid.getX_pos(), grid.getY_pos(), grid.getX_pos(), grid.getY_pos() + 1
                , tempPosition));
//        Update y position
        grid.setY_pos(grid.getY_pos() + 1);
//        Print grid map
        grid.print();
        return true;
    }

    public static boolean moveLeft(Grid grid) {
//        Check if the move user wants to do is valid
        if (grid.getX_pos() == 0 || grid.getMap()[grid.getY_pos()][grid.getX_pos() - 1].equals("N")) {
            return false;
        }
//        Store last position's value
        String tempPosition = grid.getLastPosition();
//        Update last position's value with the value of the next position
        grid.setLastPosition(grid.getMap()[grid.getY_pos()][grid.getX_pos() - 1]);
//        Update grid map calling swap method with the tempPosition
        grid.setMap(swap(grid.getMap(), grid.getX_pos(), grid.getY_pos(), grid.getX_pos() - 1, grid.getY_pos()
                , tempPosition));
//        Update x position
        grid.setX_pos(grid.getX_pos() - 1);
//        Print grid map
        grid.print();
        return true;
    }

    public static boolean moveRight(Grid grid) {
//        Check if the move user wants to do is valid
        if (grid.getX_pos() == grid.getX_max() || grid.getMap()[grid.getY_pos()][grid.getX_pos() + 1].equals("N")) {
            return false;
        }
//        Store last position's value
        String tempPosition = grid.getLastPosition();
//        Update last position's value with the value of the next position
        grid.setLastPosition(grid.getMap()[grid.getY_pos()][grid.getX_pos() + 1]);
//        Update grid map calling swap method with the tempPosition
        grid.setMap(swap(grid.getMap(), grid.getX_pos(), grid.getY_pos(), grid.getX_pos() + 1, grid.getY_pos()
                , tempPosition));
//        Update x position
        grid.setX_pos(grid.getX_pos() + 1);
//        Print grid map
        grid.print();
        return true;
    }
}
