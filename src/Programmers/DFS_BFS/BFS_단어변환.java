package Programmers.DFS_BFS;

import java.util.*;

public class BFS_단어변환 {
    class Word{
        String word;
        Integer depth;

        Word(String word, Integer depth){
            this.word = word;
            this.depth = depth;
        }
    }
    class Solution {
        private boolean[] visited;
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            visited = new boolean[words.length];

            List<String> list = new ArrayList<>(Arrays.asList(words));
            if(!list.contains(target)) return 0;
            else{
                answer = bfs(begin,target,words);
            }

            return answer;
        }

        public int bfs(String begin, String target, String[] words){
            String now = begin;
            int depth = 0;
            Queue<Word> queue = new LinkedList<>();
            queue.add(new Word(now,depth));

            while(!queue.isEmpty()){
                Word compare = queue.poll();
                for(int i=0; i<words.length; i++){
                    if(!visited[i] && equalWords(compare.word,words[i])){
                        if(words[i].equals(target)){
                            return compare.depth + 1;
                        }
                        visited[i] = true;
                        queue.add(new Word(words[i],compare.depth + 1));
                    }
                }
            }
            return 0;
        }

        public boolean equalWords(String compare, String word){
            int answer = 0;
            for(int i=0; i<compare.length(); i++){
                if(compare.charAt(i) != word.charAt(i)){
                    answer++;
                }
            }
            if(answer == 1)return true;
            else return false;
        }
    }
}
