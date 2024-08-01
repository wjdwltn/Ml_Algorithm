package Ml;

class Greedy_11399 {
    public int[] solution(int[][] arr) {
        int[] answer = new int[arr[0].length];
        int[] preanswer = new int[arr[0].length];
        int count = 0;
        int sum = 0;


        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(i==0){
                    preanswer[arr[i][j]] = j;
                    System.out.println( "0pre : pre"+arr[i][j]+": "+ preanswer[arr[i][j]]);
                }
                else{
                    if(preanswer[arr[i][j]]-j<0){
                        answer[arr[i][j]] += (preanswer[arr[i][j]]-j)*-1;
                    }
                    else{
                        answer[arr[i][j]] += (preanswer[arr[i][j]]-j);
                    }
                    preanswer[arr[i][j]] = j;
                    System.out.println( "pre : pre"+arr[i][j]+": "+ preanswer[arr[i][j]]);
                    System.out.println( "answer : answer "+arr[i][j]+": "+ answer[arr[i][j]]);

                }
            }
        }

        return answer;
    }
}