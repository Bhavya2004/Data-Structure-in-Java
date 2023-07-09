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
            char c1 = s.charAt(i);
            if (st.empty())
                return false;
            char c2 = st.pop();

            if (c1 != c2)
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
