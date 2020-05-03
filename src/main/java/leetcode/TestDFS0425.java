//package leetcode;
//
//import java.util.concurrent.ForkJoinPool;
//
//public class TestDFS0425 {
//    public void solve(int[][] maze){
//        for (int i = 0; i < maze.length; i++) {
//            for (int j = 0; j < maze[i].length; j++) {
//                if (maze[i][j] ==0 && !(i == A[0] && j == A[1])) {
//                    maze[i][j] = Integer.MAX_VALUE;
//                }
//            }
//        }
//        dfs(maze, A[0], A[1]);
//        if (maze[B[0]][B[1]] < Integer.MAX_VALUE) {
//            print("shortest path count is :" + maze[B[0]][B[1]]);
//        } else {
//            print("Cannot find B!");
//        }
//    }
//    void dfs(int[][] maze, int x, int y){
//        if (x == B[0] && y == B[1]) {
//            return;
//        }
//        for (int d = 0; d < 4; d++) {
//            int i = x + dx[d];
//            int j = y + dy[d];
//            if (isSafe(maze, i, j) && maze[i][j] > maze[x][y] + 1){
//                maze[i][j] = maze[x][y] + 1;
//                dfs(maze, i, j);
//            }
//        }
//    }
//}
