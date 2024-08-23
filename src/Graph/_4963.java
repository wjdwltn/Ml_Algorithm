package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4963 {
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int w;
    static int h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int count = 0;

            if (w == 0 && h == 0)
                break;

            map = new int[h][w];
            check = new boolean[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j]==1 && !check[i][j]){
                        //dfs(i,j);
                        bfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    /*public static void dfs(int i, int j) {
        check[i][j] = true;

        for (int n = 0; n < 8; n++) {
            int di = i + dx[n];
            int dj = j + dy[n];

            if(di>=0 && di<h && dj >=0 && dj<w){
                if (map[di][dj]==1 && !check[di][dj]){
                    dfs(di,dj);
                }
            }
        }
    }*/
    public static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        check[i][j] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for (int n = 0; n < 8; n++) {
                int di = now[0] + dx[n];
                int dj = now[1] + dy[n];

                if(di>=0 && di<h && dj >=0 && dj<w){
                    if (map[di][dj]==1 && !check[di][dj]){
                        check[di][dj] = true;
                        q.add(new int[]{di,dj});
                    }
                }
            }
        }

    }
}
