package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro_튜플_2 {
    class Solution {
        public List<Integer> solution(String s) {
            s = s.substring(2, s.length()-2);
            String[] word = s.split("\\},\\{");

            Arrays.sort(word,(o1, o2)-> {
                return o1.length() - o2.length();
            });

            List<Integer> list = new ArrayList<>();

            for(int i=0; i<word.length; i++){
                String[] now = word[i].split(",");

                for(int j=0; j<now.length; j++){
                    int num = Integer.parseInt(now[j]);
                    if(!list.contains(num))
                        list.add(num);
                }
            }

            return list;
        }
    }
}
