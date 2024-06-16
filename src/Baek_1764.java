import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            String L_people = br.readLine();
            map.put(L_people,i);
        }

        for(int i=0; i<M; i++){
            String S_people = br.readLine();
            if(map.containsKey(S_people)){
                list.add(S_people);
            }
        }
        Collections.sort(list);
        int count = list.size();
        System.out.println(count);
        for(String s : list){
            System.out.println(s);
        }
    }
}
