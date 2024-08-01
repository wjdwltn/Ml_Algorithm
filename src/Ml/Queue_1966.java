package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_1966 {
    static int T;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // N,M 입력

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            StringTokenizer str = new StringTokenizer(br.readLine());// 중요도 입력

            LinkedList<int[]> q = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                q.offer(new int[] {j, Integer.parseInt(str.nextToken())});
            }

            int count = 0;

            while (!q.isEmpty()) {
                int[] temp = q.poll();
                boolean check = true;

                for (int j = 0; j < q.size(); j++) {
                    if (temp[1] < q.get(j)[1]) {
                        q.offer(temp);

                        for (int k = 0; k < j; k++)
                            q.offer(q.poll());

                        check = false;
                        break;
                    }
                }

                if (check == false)
                    continue;

                count++;

                if (temp[0] == M)
                    break;

            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
