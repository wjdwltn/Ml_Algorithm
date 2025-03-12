package Programmers.DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;

public class DFS_여행경로 {
    class Solution {
        private ArrayList<String> answer;
        private boolean[] visited;

        public String[] solution(String[][] tickets) {
            answer = new ArrayList<>();
            visited = new boolean[tickets.length];

            dfs(0,"ICN","ICN",tickets);

            Collections.sort(answer);

            String[] result = answer.get(0).split(" ");

            return result;
        }

        public void dfs(int depth, String word, String route, String[][] tickets){

            if(depth == tickets.length){
                answer.add(route);
                return;
            }

            for(int i=0; i<tickets.length; i++){
                if(word.equals(tickets[i][0]) && !visited[i]){
                    visited[i] = true;
                    dfs(depth+1,tickets[i][1],route+" "+tickets[i][1],tickets);
                    visited[i] = false;
                }
            }
        }
    }
}
