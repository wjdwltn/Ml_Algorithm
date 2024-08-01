package Ml;

import java.util.*;
class Solution {
    public int solution(int k, int[] limits, int[][] sockets) {
        int answer = 0;
        int[] usage = new int[sockets.length+1];
        ArrayList<Integer>[] NodeCheck= new ArrayList[sockets.length];
        for(int i=0; i<sockets.length; i++){
            NodeCheck[i] = new ArrayList<Integer>();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<sockets.length; i++){
            map.put(i+1,0);
            for(int j=0; j<5; j++){
                if(sockets[i][j]==-1){
                    if(!map.containsKey(i+1)){
                        map.put(i+1,1);
                    }
                    else map.replace(i+1,map.get(i+1)+1);
                }
                if(sockets[i][j]>=2){
                    NodeCheck[i].add(sockets[i][j]);
                }
            }
        }
        for(int i=0; i<sockets.length; i++){
            for(int j=0; j<5; j++){
                if(sockets[i][j]>=2){
                    usage[i+1] += k * map.get(sockets[i][j]);
                    for(int find : NodeCheck[sockets[i][j]-1]){
                        usage[i+1] += k * map.get(find);
                    }

                }
                else if(sockets[i][j] == -1){
                    usage[i+1] += k;
                }
            }
        }

        for(int i=0; i<sockets.length; i++){
            System.out.println(NodeCheck[i]);

        }

        for(int i=1; i<6; i++){

            System.out.println(usage[i]);
        }

        for(int i=0; i< limits.length; i++){
            while(usage[i+1]<= limits[i]){
                if(usage[i+1]> limits[i]){
                    for(i=NodeCheck[i].size();i>=0;i--) {
                        answer++;
                        usage[i+1] -= k * map.get(i);
                    }
                }
            }

        }
        return answer;
    }
}