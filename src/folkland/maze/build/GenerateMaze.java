package folkland.maze.build;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateMaze extends AbstractMaze {

    public GenerateMaze(int width, int height) {
        if (height%2 == 0) height++;
        if (width%2 == 0) width++;
        this.height = height;
        this.width = width;
        createFields();
        generateField(maze[1][1]);
    }

    private void createFields() {
        maze = new Coor[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if((i % 2 != 0  && j % 2 != 0) && (i < height-1 && j < width-1))
                    maze[i][j] = new Coor(i,j,false);
                else maze[i][j] = new Coor(i,j,true);
            }
        }
    }
    private void generateField(Coor c) {
        boolean b = true;
        c.isVisited = true;
        do {
            Coor ls[] = searchNeighbours(c);
            int k=0;
            for (Coor t: ls) {
                if (t!=null) k++;
            }
            if (k > 0) {
                int j = ThreadLocalRandom.current().nextInt(k);
                Coor t = ls[j];
                removeWall(c, t);
                generateField(t);
            } else b = false;
        } while (b);
    }
    private void removeWall (Coor c, Coor t) {
        Coor a = fieldBetween(c, t);
        a.isWall = false;
    }
}
