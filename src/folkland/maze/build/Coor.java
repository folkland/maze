package folkland.maze.build;


public class Coor {
    int x;
    int y;
    boolean isVisited;
    boolean isWall;
    char exit = ' ';

    public Coor (int x, int y, boolean isWall) {
        this.x = x;
        this.y = y;
        this.isWall = isWall;
        isVisited = false;
    }
    public String toString() {
        return x+" "+y;
    }

    public boolean eq(Coor c) {
        return c.x==x && c.y == y;
    }
    public boolean isVisited() {
        return isVisited;
    }
    public void setVisited(boolean visited) {
        isVisited = visited;
    }
    public char getExit() {
        return exit;
    }
    public void setExit(char exit) {
        this.exit = exit;
    }
    public boolean isWall() {
        return isWall;
    }
}
