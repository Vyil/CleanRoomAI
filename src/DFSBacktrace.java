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

        List<Coordinate> path = new ArrayList<>();
        if (explore(grid, 0, 0, path)) {
            System.out.println("Returning path: ");
            System.out.println("Iterations done: " + counter);
//            printPath(path);
            System.out.println(path.size());
//            System.out.println(countAvailableSpots(grid));
            printGrid(grid);
            return path;
        }
        return Collections.emptyList();
    }

    private boolean explore(Grid grid, int y, int x, List<Coordinate> path) {
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

    private int countAvailableSpots(Grid grid) {
        int randomCounter = 0;
        for (String[] a : grid.grid) {
            for (String b : a) {
                if (b.equals("O") || b.equals("C")) {
                    randomCounter++;
                }
            }
        }
        return randomCounter;
    }

}
