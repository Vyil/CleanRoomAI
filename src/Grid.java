import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Grid extends JPanel {

    String[][] grid = new String[20][20];
    private static final int SIZE = 20;

    public Grid(){
    }

    public boolean roomIsCleaned(){
        for(String[] row:grid){
            for(String a: row){
                if(a== "O"){
                    return false;
                }
            }
        }
        return true;
    }


    public void printTest(){
        for(int i=0;i<20;i++){
            System.out.println(Arrays.deepToString(grid[i]));
        }
    }

    public void fillArray(){
        for(String[] row:grid){
            Arrays.fill(row,"O");
        }
    }

    public boolean isBlocked(int y, int x){
        return grid[y][x].equals("X");
    }

    public boolean isValidMove(int y, int x){
        if(y<0 || y>19 || x< 0 || x>19){
            return false;
        }
        return true;
    }

    public boolean isCleaned(int y, int x){
        return grid[y][x].equals("C");
    }

    public void setCleaned(int y, int x){
        grid[y][x] = "C";
    }

    public void setUpRoom(){
        setPlant();
        setBed();
        setKitchen();
    }

    private void setPlant(){
        for(int i=0;i<4;i++){
            for(int j=4;j<8;j++){
                grid[i][j]="X";
            }
        }
    }

    private void setBed(){
        for(int i=19;i>13;i--){
            for(int j=8;j<13;j++){
                grid[i][j]="X";
            }
        }
    }

    private void setKitchen(){
        for(int i=19;i>9;i--){
            for(int j=16;j<20;j++){
                grid[i][j]="X";
            }
        }
    }

    public String[][] getGrid(){
        return grid;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

    @Override
    public void paintComponent(Graphics g) //override paintComponent not paint
    {
        super.paintComponent(g);
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[0].length; col++)
            {
                g.drawRect(SIZE*col, SIZE * row , SIZE, SIZE);
                if(grid[row][col].equals("X"))
                {
                    g.setColor(Color.BLACK);
                    g.fillRect(SIZE*col, SIZE * row , SIZE, SIZE);
                }
                if(grid[row][col].equals("C")){
                    g.setColor(Color.RED);
                    g.fillRect(SIZE*col, SIZE * row , SIZE, SIZE);
                }
            }
        }
    }

    public void repaintRythm(){
        repaint();
    }
}
