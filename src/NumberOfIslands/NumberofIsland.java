package NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

/*
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
 */
public class NumberofIsland {

    public static void main(String[] args) {

        char[][] grid ={{'1','1','0','0','0'},{'1','1','0','0','0'},
                {'0','0','1','0','0'},{'0','0','0','1','1'}};



        int m=grid.length;
        int n=grid[0].length;

        int[][] visited= new int[m][n];
        int cnt=0;

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(visited[row][col]==0&&grid[row][col]=='1'){

                    bfs(row,col,grid,visited);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }


    public static void bfs(int row,int col,char[][] grid,int[][] visited){
        int m=grid.length;
        int n=grid[0].length;

        Queue<Pair> q= new LinkedList<>();
        visited[row][col]=1;
        q.add(new Pair(row,col));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){

            int r=q.peek().first;
            int c=q.peek().second;

            q.remove();

            for(int k = 0; k < 4; k++){
                int nrow = r + dr[k];
                int ncol = c + dc[k];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]==0 &&
                        grid[nrow][ncol]=='1'){
                    visited[nrow][ncol]=1;
                    q.offer(new Pair(nrow,ncol));
                }




            }


    }

}

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


}