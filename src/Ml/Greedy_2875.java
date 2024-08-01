package Ml;

import java.io.*;
import java.util.*;
class Greedy_2875 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int testCase = Integer.parseInt(input);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(); // 순서를 보장하기 위한 링크드해시맵 (값이 같다면 회사 번호가 빠른것)

        for (int i = 0; i < testCase; i++) {
            String[] temp = br.readLine().split(" ");
            map.put(i, (int) (Double.parseDouble(temp[0]) * Double.parseDouble(temp[1]) * 10)); // 소수랑 계산할 때 double끼리 계산 (double * int 불가)
            System.out.println((int) (Double.parseDouble(temp[0]) * Double.parseDouble(temp[1]) * 10));
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : list) {
            int temp = entry.getKey() + 1;
            sb.append(temp);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}