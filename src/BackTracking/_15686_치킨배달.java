package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15686_치킨배달 {
    static int N,M;
    static int Min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> c_choice = new ArrayList<>();
//////////////////////////////////////////////////////////
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                //집 좌표
                if(map[i][j] == 1){
                    house.add(new int[]{i,j});
                }
                //치킨집 좌표
                if(map[i][j] == 2){
                    chicken.add(new int[]{i,j});
                }
            }
        }
        ////////////////////////////////////////////map에 값 저장

        visited = new boolean[chicken.size()];

        combi(0,0);
        System.out.println(Min);
    }
    public static void combi(int start, int count){
        if(count == M){
            int sum = 0;
            for(int[] h : house){
                int min = Integer.MAX_VALUE;
                for(int[] c : c_choice){
                    int result = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(min,result);
                }
                sum += min;
            }
            Min = Math.min(Min,sum);
            return;
        }

        for(int i=start; i<chicken.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                c_choice.add(chicken.get(i));
                combi(i+1,count+1);
                c_choice.remove(c_choice.size()-1);
                visited[i] = false;
            }
        }
    }
}
