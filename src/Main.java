import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Grid grid = new Grid();
        grid.fillArray();
        grid.setUpRoom();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(grid);
        frame.pack();
        frame.setVisible(true);
//	grid.printTest();

        DFSBacktrace backtrace = new DFSBacktrace();
        backtrace.solve(grid);

//        BFS bfs = new BFS();
//        bfs.solve(grid);
    }

}
