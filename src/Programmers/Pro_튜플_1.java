package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pro_튜플_1 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = {};
            HashMap<String,Integer> map = new HashMap<>();

            s = s.substring(2, s.length()-2);
            String[] arr = s.split("\\},\\{");

            for(int i=0; i<arr.length; i++){
                String[] nowArr = arr[i].split(",");
                for(String now : nowArr){
                    map.put(now,map.getOrDefault(now,0)+1);
                }
            }

            List<String> list = new ArrayList<>(map.keySet());
            list.sort((o1,o2)-> map.get(o2) - map.get(o1));

            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = Integer.parseInt(list.get(i));
            }

            return answer;
        }
    }
}
