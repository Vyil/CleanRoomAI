public class Vaccuum {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Vaccuum(int y, int x){
        this.y =y;
        this.x =x;
    }


    public int turnLeft(int curDir){
        switch(curDir){
            case 0: return 270;
            case 270: return 180;
            case 180: return 90;
            case 90: return 0;
            default: return 0;
        }
    }

    public int turnRight(int curDir){
        switch(curDir){
            case 0: return 90;
            case 90: return 180;
            case 180: return 270;
            case 270: return 0;
            default: return 0;
        }
    }
}
