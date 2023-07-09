import java.util.*;

public class CheckAibString {
    public static boolean isValid(String s) {
        Stack<Character> st1 = new Stack<Character>();
        Stack<Character> st2 = new Stack<Character>();

        int index = s.indexOf("b");

        for (int i = 0; i < index; i++)
            st1.push(s.charAt(i));

        for (int i = index; i < s.length(); i++)
            st2.push(s.charAt(i));

        if (st1.size() != st2.size())
            return false;

        for (int i = 0; i < st2.size(); i++) {
            if (st1.get(i) != 'a' || st2.get(i) != 'b')
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.next();
        sc.close();
        if (isValid(str)) {
            System.out.println("given string is valid");
        } else {
            System.out.println("given string is not valid");

        }
    }
}
