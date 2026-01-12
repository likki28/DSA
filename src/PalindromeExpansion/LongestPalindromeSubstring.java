package PalindromeExpansion;

import java.util.Scanner;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String odd = expand(s, i, i);
            if (odd.length() > longest.length()) longest = odd;

            String even = expand(s, i, i + 1);
            if (even.length() > longest.length()) longest = even;
        }

        System.out.println(longest);
        sc.close();
    }

    private static String expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
