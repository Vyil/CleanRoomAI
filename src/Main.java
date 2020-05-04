import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	Grid grid = new Grid();
	grid.fillArray();
	grid.setUpRoom();
//	grid.printTest();
//        DFS dfs = new DFS();
//        dfs.DFSRun(grid.getGrid(),0);
//        RandomRobot robot = new RandomRobot();
//        robot.RandomRun(grid.getGrid());
//        dfs.results();
        DFSBacktrace backtrace = new DFSBacktrace();
        backtrace.solve(grid);
    }
}
