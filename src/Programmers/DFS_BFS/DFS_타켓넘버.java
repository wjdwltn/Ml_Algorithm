package Programmers.DFS_BFS;

public class DFS_타켓넘버 {
    class Solution {
        int answer = 0;
        public int solution(int[] numbers, int target) {

            dfs(numbers, 0, 0, target);

            return answer;
        }

        public void dfs(int[] numbers, int depth, int cal, int target){
            if(depth == numbers.length){
                if(cal == target){
                    answer++;
                }
                return;
            }
            else{
                dfs(numbers, depth + 1, cal + numbers[depth], target);
                dfs(numbers, depth + 1, cal - numbers[depth], target);
            }
        }
    }
}
