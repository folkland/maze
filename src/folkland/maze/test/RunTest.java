package folkland.maze.test;

import folkland.maze.build.Coor;
import folkland.maze.build.GenerateMaze;
import folkland.maze.build.SearchExit;

public class RunTest {

    public static void main(String[] args) {
        GenerateMaze maze = new GenerateMaze(43,43);
        maze.showMaze();
        System.out.println("Now we search exit");
        Coor start = new Coor(1,1,false);
        Coor finish = new Coor(maze.getHeight()-2,maze.getWidth()-2,false);
        SearchExit search = new SearchExit(maze.getMaze(),maze.getHeight(),maze.getWidth(), start, finish);
        search.showMaze();
    }
}
