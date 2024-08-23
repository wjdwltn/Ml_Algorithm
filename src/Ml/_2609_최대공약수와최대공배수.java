package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2609_최대공약수와최대공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int gcd = GCD(N, M);

        //최대공약수
        System.out.println(gcd);
        //최소공배수
        System.out.println(((N*M)/gcd));

    }

    private static int GCD(int n, int m) {

        // 나머지가 0이면 return
        if (n%m == 0) return m;

        // 아닐 경우 다시 나눔
        return GCD(m, n%m);
    }

}
