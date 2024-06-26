package com.patternsearching;

public class KMPAlgorithm {
    void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        
        // Create lps[] that will hold the longest prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]
        
        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, M, lps);
        
        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            }
            // Mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters, they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }
    
    void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
        
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        KMPAlgorithm kmp = new KMPAlgorithm();
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        kmp.KMPSearch(pat, txt);
    }
}
