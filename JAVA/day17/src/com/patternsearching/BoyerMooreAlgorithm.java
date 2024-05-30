package com.patternsearching;

public class BoyerMooreAlgorithm {
    static int NO_OF_CHARS = 256;

    // The preprocessing function for Boyer-Moore's bad character heuristic
    void badCharHeuristic(char[] str, int size, int badchar[]) {
        for (int i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        for (int i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }

    int search(String txt, String pat) {
        char[] text = txt.toCharArray();
        char[] pattern = pat.toCharArray();
        int m = pattern.length;
        int n = text.length;

        int badchar[] = new int[NO_OF_CHARS];
        badCharHeuristic(pattern, m, badchar);

        int s = 0;  // s is shift of the pattern with respect to text
        int lastOccurrence = -1;  // To store the last occurrence index
        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pattern[j] == text[s + j])
                j--;

            if (j < 0) {
                lastOccurrence = s;
                s += (s + m < n) ? m - badchar[text[s + m]] : 1;
            } else {
                s += Math.max(1, j - badchar[text[s + j]]);
            }
        }
        return lastOccurrence;
    }

    public static void main(String[] args) {
        BoyerMooreAlgorithm bma = new BoyerMooreAlgorithm();
        String txt = "ABAAABCD";
        String pat = "ABC";
        int lastIndex = bma.search(txt, pat);
        if (lastIndex != -1)
            System.out.println("Last occurrence of pattern is at index " + lastIndex);
        else
            System.out.println("Pattern not found");
    }
}
