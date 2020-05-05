import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class BFS {

    private static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int counter = 0;


    private Coordinate getNextCoordinate(int row, int col, int i, int j) {
        return new Coordinate(row + i, col + j);
    }

    private List<Coordinate> backtrackPath(Coordinate cur) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate iter = cur;

        while (iter != null) {
            path.add(iter);
            iter = iter.parent;
        }

        return path;
    }

    public List<Coordinate> solve(Grid grid) {
        LinkedList<Coordinate> nextToVisit = new LinkedList<>();
        Coordinate start = new Coordinate(0,0);
        nextToVisit.add(start);

        while (!nextToVisit.isEmpty()) {
            counter++;
            Coordinate cur = nextToVisit.remove();

            if (!grid.isValidMove(cur.getX(), cur.getY()) || grid.isCleaned(cur.getX(), cur.getY())) {
                continue;
            }

            if (grid.isBlocked(cur.getX(), cur.getY())) {
                continue;
            }

//            if (grid.isExit(cur.getX(), cur.getY())) {
//                return backtrackPath(cur);
//            }

            for (int[] direction : DIRECTIONS) {
                Coordinate coordinate = new Coordinate(cur.getX() + direction[0],cur.getY() + direction[1], cur);
                nextToVisit.add(coordinate);
                grid.setCleaned(cur.getX(), cur.getY());
            }
        }
        grid.printTest();
        System.out.println("Iterated : "+counter+" times");
        return Collections.emptyList();
    }
}
