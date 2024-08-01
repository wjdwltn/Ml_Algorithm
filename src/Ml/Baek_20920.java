package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Baek_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String word = br.readLine();
            /*if(word.length()>=M){
                if(!map.containsKey(word)){
                    map.put(word,1);
                }
                else{
                    map.replace(word,map.get(word)+1);
                }
            }*/
            //-> word를 가져와서 map.getOrDefault란-> word가 map에 있으면 word의 value를 가져오는 것/ 없으면 0을 가져오는 것 / 그래서 가져온 후 1을 더해준다.
            if(word.length()<M)continue;
            map.put(word, map.getOrDefault(word,0)+1);
        }
       /* List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                if(map.get(o1).equals(map.get(o2))){
                    if(o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }
                    else{
                        return o2.length() - o1.length();
                    }
                }
                else{
                    return map.get(o2).compareTo(map.get(o1));
                }
            }
        });*/
        List<String> keySet = map.keySet().stream().collect(Collectors.toList());
        keySet.sort((o1,o2)->{
            int c1 = map.get(o1);
            int c2 = map.get(o2);

            if(c1 == c2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return c2-c1;
        });

        StringBuilder sb = new StringBuilder();
        for(String s : keySet){
            sb.append(s).append("\n");
        }
        System.out.print(sb);

    }
}
