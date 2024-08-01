package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Stack_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list1 = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for(int i=0; i<N; i++){
            list1.add(i+1);
        }

        int index = 0;
        while( list1.size()>1){
            index = (index+(K-1))%list1.size();

            sb.append(list1.remove(index)).append(", ");

        }
        sb.append(list1.remove()).append(">");

        System.out.println(sb);
    }
}
