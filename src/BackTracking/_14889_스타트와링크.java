package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889_스타트와링크 {
    static int[][] map;
    static boolean[] visited;
    static int N;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0,0);
        System.out.println(Min);
    }

    public static void combi(int idx, int count){

        if(count == N / 2){
            diff();
            return;
        }

        for(int i=idx; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
    public static void diff(){
        int start = 0;
        int link = 0;

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(visited[i] && visited[j]) {
                    start += map[i][j];
                    start += map[j][i];
                }else if(!visited[i] && !visited[j]){
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int result = Math.abs(start-link);

        if(result == 0){
            System.out.println(result);
            System.exit(0);
        }
        Min = Math.min(result,Min);
    }

}
