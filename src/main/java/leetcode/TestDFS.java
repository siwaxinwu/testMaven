//package leetcode;
//
//import java.util.Stack;
//
//public class TestDFS {
//    public boolean dfs(int[][] maze, int x, int y){
//        Stack<Integer[]> stack = new Stack<>();
//        stack.push(new Integer[]{x, y});
//        maze[x][y] = -1;
//        while (!stack.isEmpty()){
//            Integer[] pop = stack.pop();
//            x = pop[0];
//            y = pop[1];
//            if (x == B[0] && y == B[1]){
//                return true;
//            }
//            for (int d = 0; d < 4; d++) {
//                int i = x + dx[d];
//                int j = y + dy[d];
//                if (isSafe(maze, i, j)){
//                    stack.push(new Integer[]{i, j});
//                    maze[i][j] = -1;
//                }
//            }
//        }
//        return false;
//
//    }
//}
