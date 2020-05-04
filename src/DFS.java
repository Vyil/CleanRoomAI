import java.security.AllPermission;
import java.util.Stack;

public class DFS {
    Vaccuum vaccuum = new Vaccuum(0,0);
    Boolean[][] visited = new Boolean[20][20];
    private int direction = 0;
    private int counter = 0;
    // 0 = up, 90 = right, 180=down, 270 = left

    public String results(){
        return "Finished the algorithm in: "+counter + " iterations";
    }

    public void DFSRun(String[][] grid, int direction) {
        System.out.println("Looped");

        if(AlLCleaned(grid)){
            System.out.println("Finished the algorithm in: "+counter + " iterations");
            return;
        }
        String cleaned = "C";//Clean
        grid[vaccuum.getY()][vaccuum.getX()] = cleaned;
        if(canMove(vaccuum.getY(),vaccuum.getX(),direction)){
            switch(direction){
                case 0 : vaccuum.setY(vaccuum.getY() -1);
                case 90: vaccuum.setX(vaccuum.getX() +1);
                case 180: vaccuum.setY(vaccuum.getY() +1);
                case 270: vaccuum.setX(vaccuum.getX() -1);
            }
            counter++;
            DFSRun(grid,direction);
        } else {
            vaccuum.turnLeft(direction);
            vaccuum.turnLeft(direction);
            switch(direction){
                case 0 : vaccuum.setY(vaccuum.getY() -1);
                case 90: vaccuum.setX(vaccuum.getX() +1);
                case 180: vaccuum.setY(vaccuum.getY() +1);
                case 270: vaccuum.setX(vaccuum.getX() -1);
            }
            counter++;
            int newDir = vaccuum.turnLeft(direction);
            DFSRun(grid,newDir);
        }


    }

    private int move(int curDir,int y, int x){
        switch(curDir){
            case 0 : return -1;
            case 90: return +1;
            case 180: return +1;
            case 270: return -1;
            default: return 0;
        }
    }

    private boolean canMove(int y, int x, int curDir){
        if(y==0 && curDir == 0){
            return false;
        }
        if(y==19 && curDir ==180){
            return false;
        }
        if(x==0 && curDir == 270){
            return false;
        }
        if(x==19 && curDir == 90){
            return false;
        }
        return true;
    }


    private Boolean AlLCleaned(String[][] visited){
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (visited[i][j] == "O") {
                    return false;
                }
            }
        }
        return true;
    }

}
