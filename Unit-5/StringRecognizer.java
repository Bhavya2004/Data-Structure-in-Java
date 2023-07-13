import java.util.*;

public class StringRecognizer {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        if (!s.contains("c"))
            return false;

        int index = s.indexOf("c");

        for (int i = 0; i < index; i++) {
            st.push(s.charAt(i));
        }

        for (int i = index + 1; i < s.length(); i++) {
            if (st.empty()){
                return false;
            }
            
            if (st.pop() != s.charAt(i)){
                return false;
            }
            if (!st.empty())
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");

        String str = sc.next();
        if (isValid(str)) {
            System.out.println("given string is valid");
        } else {
            System.out.println("given string is not valid");

        }
    }
}
