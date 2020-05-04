import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSBacktrace {

    private static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int counter =0;


    private Coordinate getNextCoordinate(int row, int col, int i, int j) {
        return new Coordinate(row + i, col + j);
    }

    public void printPath(List<Coordinate> list){
        for(Coordinate a: list){
            System.out.println(a.toString());
        }
    }

    public void printGrid(Grid grid){
        grid.printTest();
    }


    public List<Coordinate> solve(Grid grid) {
        System.out.println("Called solve");
        List<Coordinate> path = new ArrayList<>();
        if (explore(grid, 0, 0, path)) {
            System.out.println("Returning path: ");
            System.out.println("Counter = "+counter);
            printPath(path);
            printGrid(grid);
            return path;
        }
        return Collections.emptyList();
    }

    private boolean explore(Grid grid, int y, int x, List<Coordinate> path) {
        counter++;
        if (!grid.isValidMove(y, x) || grid.isBlocked(y, x) || grid.isCleaned(y, x)) {
            return false;
        }

        path.add(new Coordinate(y, x));
        grid.setCleaned(y, x);

        if (grid.roomIsCleaned()) {
            System.out.println("Room is cleaned");
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            Coordinate coordinate = getNextCoordinate(
                    y, x, direction[0], direction[1]);
            if (explore(grid, coordinate.getX(), coordinate.getY(), path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}
