package Ml;

import java.util.Scanner;

public class _1978_소수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;
        for(int i=0; i<N; i++){
            int val = sc.nextInt();

            if(val == 1){
                continue;
            }

            for(int j=2; j<=val; j++){
                if(j == val){
                    count++;
                }
                if(val % j == 0){
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
