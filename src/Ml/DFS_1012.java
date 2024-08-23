package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_1012 {
    static int T;
    static int M,N,K;
    static int count;
    static int arr[][];
    static boolean visited[][];
    static int[] dx={-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T= Integer.parseInt(br.readLine());

        for(int a=0; a<T; a++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            M= Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[M][N];
            visited = new boolean[M][N];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y]=1;
            }

            count =0;
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j]==1 && !visited[i][j]){
                        count++;
                        //dfs(i,j);
                        bfs(i,j);
                    }
                }
            }
            System.out.println(count);
        }

    }
    /*public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<M && ny >=0 && ny<N){
                if(arr[nx][ny]==1 && !visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }*/
    public static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx>=0 && nx<M && ny >=0 && ny<N){
                    if(arr[nx][ny]==1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
