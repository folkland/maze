package folkland.maze.build;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SearchExit extends AbstractMaze {

    Coor start;
    Coor finish;
    boolean stop = false;
    public SearchExit(Coor maze[][], int height, int width, Coor start, Coor finish) {
        this.maze = maze;
        this.height = height;
        this.width = width;
        this.start = start;
        this.finish = finish;
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                maze[i][j].setVisited(false);
            }
        }
        searchExitFromMaze(start);
        maze[start.x][start.y].setExit('s');
        maze[finish.x][finish.y].setExit('s');
    }
    private boolean neighbourWall(Coor c, Coor t) {
        Coor a = fieldBetween(c,t);
        return a.isWall();
    }
    private void searchExitFromMaze(Coor c) {
        if (!stop && finish.eq(c)) stop = true;
        boolean b = true;
        c.isVisited = true;
        c.setExit('r');
        do {
            Coor ls[] = searchNeighbours(c);
            List<Coor> list = new ArrayList<>();
            for (Coor t: ls) {
                if (t!=null && !neighbourWall(c,t)) list.add(t);
            }
            if (list.size() > 0) {
                int j = ThreadLocalRandom.current().nextInt(list.size());
                Coor t = list.get(j);
                searchExitFromMaze(t);
            } else {
                c.setExit(' ');
                b = false;
            }
        } while (!stop && b);
    }
}
