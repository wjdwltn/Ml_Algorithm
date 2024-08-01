package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BFS_2667 {
    static int n;
    static int count;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayList<Integer> house = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        count = 0;

        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]==1 && !visited[i][j]) {
                    count=1;
                    dfs(i,j);
                    house.add(count);
                }
            }
        }
        Collections.sort(house);
        System.out.println(house.size());
        for(int num : house) {
            System.out.println(num);
        }
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n) {
                if(arr[nx][ny]==1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                    count++;
                }
            }
        }
        return count;
    }
}
