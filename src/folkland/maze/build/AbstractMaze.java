package folkland.maze.build;

public abstract class AbstractMaze {
    protected int width;
    protected int height;
    protected Coor maze[][];
    protected Coor[] searchNeighbours(Coor c) {
        Coor[] array = new Coor[4];
        int k=0;
        int x = c.x;
        int y = c.y;
        if (x+2 < height && !maze[x+2][y].isVisited){
            array[k] = maze[x+2][y];
            k++;
        }
        if (x-2 > 0 && !maze[x-2][y].isVisited) {
            array[k] = maze[x-2][y];
            k++;
        }
        if (y+2 < width && !maze[x][y+2].isVisited) {
            array[k] = maze[x][y+2];
            k++;
        }
        if (y-2 > 0 && !maze[x][y-2].isVisited) {
            array[k] = maze[x][y-2];
            k++;
        }
        return array;
    }
    public Coor[][] getMaze() {
        return maze;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

    public void showMaze() {
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (!maze[i][j].isWall()) System.out.print(maze[i][j].getExit());
                else if (i==0 || i%2==0) System.out.print('-');
                else System.out.print('|');
            }
            System.out.print("\n");
        }
    }
    protected Coor fieldBetween(Coor c, Coor t) {
        int x, y;
        if(c.x == t.x) {
            x = c.x;
            if (c.y > t.y) {
                y = c.y - 1;
            } else y = c.y + 1;
        } else {
            y = c.y;
            if (c.x > t.x) {
                x = c.x - 1;
            } else x = c.x + 1;
        }
        return maze[x][y];
    }
}
