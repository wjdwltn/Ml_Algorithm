import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<N; i++){
            String st = br.readLine();

            for(int j=0; j<st.length(); j++){
                if(st.charAt(j)=='('){
                    stack.push(st.charAt(j));
                }
                else{
                    if(stack.isEmpty()) {
                        stack.push(st.charAt(j));
                        break;
                    }else {
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }
}
