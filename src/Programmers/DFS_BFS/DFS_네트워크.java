package Programmers.DFS_BFS;

public class DFS_네트워크 {
    class Solution {
        int answer = 0;
        boolean[] visited;
        public int solution(int n, int[][] computers) {
            visited = new boolean[computers.length];

            for(int i=0; i<computers.length; i++){
                if(!visited[i]){
                    dfs(i,computers);
                    answer++;
                }
            }
            return answer;
        }

        public void dfs(int x, int[][] computers){
            visited[x] = true;
            for(int i=0; i<computers.length; i++){
                if(computers[x][i] == 1 && !visited[i]){
                    dfs(i,computers);
                }
            }
        }
    }
}
