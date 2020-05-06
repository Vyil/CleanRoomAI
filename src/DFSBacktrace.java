import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSBacktrace {

    private static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int counter = 0;


    private Coordinate getNextCoordinate(int row, int col, int i, int j) {
        return new Coordinate(row + i, col + j);
    }

    public void printPath(List<Coordinate> list) {
        for (Coordinate a : list) {
            System.out.println(a.toString());
        }
    }

    public void printGrid(Grid grid) {
        grid.printTest();
    }


    public List<Coordinate> solve(Grid grid) {
        long startStopwatch = System.currentTimeMillis();

        List<Coordinate> path = new ArrayList<>();
        if (explore(grid, 0, 0, path)) {
//            printPath(path);
            System.out.println(path.size());
            printGrid(grid);
            long stopStopwatch = System.currentTimeMillis();
            long finish = stopStopwatch - startStopwatch;
            System.out.println("Iterated : "+counter+" times and took: "+finish /1000+" seconds");
            return path;
        }
        return Collections.emptyList();
    }

    private boolean explore(Grid grid, int y, int x, List<Coordinate> path) {
        try{
            Thread.sleep(10);
        } catch (InterruptedException e){
            System.out.println(e);
        }

        grid.repaint();

        if (grid.roomIsCleaned()) {
            System.out.println("Room is cleaned");
            return true;
        }

        counter++;
        if (!grid.isValidMove(y, x) || grid.isBlocked(y, x) || grid.isCleaned(y, x)) {
            return false;
        }

        path.add(new Coordinate(y, x));
        grid.setCleaned(y, x);

        for (int[] direction : DIRECTIONS) {
            Coordinate coordinate = getNextCoordinate(
                    y, x, direction[0], direction[1]);
            if (explore(grid, coordinate.getX(), coordinate.getY(), path)) {
                return true;
            }
        }

        return false;
    }

}
