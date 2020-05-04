import java.util.Arrays;
import java.util.Random;

public class RandomRobot {

    private Random rnd = new Random();
    Vaccuum vaccuum = new Vaccuum(0, 0);

    public void RandomRun(String[][] grid) {

        Boolean[][] visited = new Boolean[20][20];
        for(Boolean[]bool: visited){
            Arrays.fill(bool,false);
        }
        visited[0][0] = true;
        int counter = 0;


        while (uncleanedCells(visited)) {
            System.out.println(vaccuum.getX());
            System.out.println(vaccuum.getY());
            int a = rnd.nextInt(3);
            switch (a) {
                case 0:
                    if (vaccuum.getY() != 19) {
                        if (grid[vaccuum.getY() + 1][vaccuum.getX()].equals("O")) {
                            vaccuum.setY(vaccuum.getY() + 1); // Move Down
                            visited[vaccuum.getY()][vaccuum.getX()] = true;
                            grid[vaccuum.getY()][vaccuum.getX()] = "Clean";
                            counter++;
                        }
                    }

                case 1:
                    if (vaccuum.getY() != 0) {
                        if (grid[vaccuum.getY() - 1][vaccuum.getX()].equals("O")) {
                            vaccuum.setY(vaccuum.getY() - 1); // Move Up
                            visited[vaccuum.getY()][vaccuum.getX()] = true;
                            grid[vaccuum.getY()][vaccuum.getX()] = "Clean";
                            counter++;
                        }
                    }
                case 2:
                    if (vaccuum.getX() != 19) {
                        if (grid[vaccuum.getX()][vaccuum.getX() + 1].equals("O")) {
                            vaccuum.setX(vaccuum.getX() + 1); // Move Right
                            visited[vaccuum.getY()][vaccuum.getX()] = true;
                            grid[vaccuum.getY()][vaccuum.getX()] = "Clean";
                            counter++;
                        }
                    }

                case 3:
                    if (vaccuum.getX() != 0) {
                        if (grid[vaccuum.getX()][vaccuum.getX() - 1].equals("O")) {
                            vaccuum.setX(vaccuum.getX() - 1); // Move Left
                            visited[vaccuum.getY()][vaccuum.getX()] = true;
                            grid[vaccuum.getY()][vaccuum.getX()] = "Clean";
                            counter++;
                        }
                    }

                default:
//                    System.out.println("Blocked wall");
                    counter++;
            }
        }
        System.out.println("Finished the grid in: " + counter + " turns");
    }

    private Boolean uncleanedCells(Boolean[][] grid) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (grid[i][j] == false) {
//                    System.out.println(grid[i][j]);
                    return true;
                }
            }
        }
        return false;
    }
}
