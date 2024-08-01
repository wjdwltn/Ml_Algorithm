package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_12845 {
    static  int nowchange;
    static int health_1;
    static int[] bandage = {1,10,20};
    static int health = 100;
    static int[][] attacks = {{2,30},{4,50}};
    public static void main(String[] args) throws IOException {

        System.out.println(solution(bandage, health, attacks));
    }
    public static int solution(int[] bandage, int health, int[][] attacks) {
        nowchange = health;
        health_1 = health;
        int success = 0;
        int nowindex= 0;

        for(int i=1; i<=attacks[attacks.length-1][0]; i++){
            if(i!=attacks[nowindex][0])
            {
                nowchange +=  bandage[1];
                success++;
                if(success == bandage[0]){
                    nowchange +=  bandage[2];
                    success=0;
                }
                if(nowchange > health) nowchange = health;
            }
            else{
                success=0;
                nowchange-=attacks[nowindex][1];
                nowindex++;
                if(nowchange<=0){
                    return -1;
                }
            }
        }
        if(nowchange<=0){
            return -1;
        }
        else return nowchange;
    }

}
