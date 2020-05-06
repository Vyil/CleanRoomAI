import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
//        JPanel centeredBoardUI = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        frame.add(centeredBoardUI);
//        centeredBoardUI.add(new testPane());
//        frame.pack();
//        frame.setSize(500,500);
//        frame.setLayout(null);
//        frame.setVisible(true);


        Grid grid = new Grid();
        grid.fillArray();
        grid.setUpRoom();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(grid);
        frame.pack();
        frame.setVisible(true);
//	grid.printTest();

//        DFSBacktrace backtrace = new DFSBacktrace();
//        backtrace.solve(grid);

        BFS bfs = new BFS();
        bfs.solve(grid);
    }

//    public static class testPane extends JPanel {
//
//        @Override
//        public Dimension getPreferredSize() {
//            return new Dimension(300, 300);
//        }
//
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            Graphics2D g2d = (Graphics2D) g.create();
//            for (int i = 0; i < getHeight(); i = i+15)
//            {
//                for (int j = 0; j <getWidth(); j = j+15)
//                {
//                    g2d.setColor(Color.BLACK);
//                    g2d.fillRect(j, i, 50, 50);
//                    g2d.setColor(Color.WHITE);
//                    g2d.drawRect(j,i,50,50);
//                }
//            }
//            g2d.dispose();
//        }
//
//        public void changeGridColor(int x, int y, Color color){
//
//        }
//    }
}
