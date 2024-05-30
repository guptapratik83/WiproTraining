package com.patternsearching;

public class RabinKarpAlgorithm {
    final int d = 256; // Number of characters in the input alphabet
    final int q = 101; // A prime number
    
    void search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // Hash value for pattern
        int t = 0; // Hash value for txt
        int h = 1;
        
        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;
        
        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        
        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
            // Check the hash values of current window of text and pattern
            if (p == t) {
                // Check for characters one by one
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }
            
            // Calculate hash value for next window of text
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + 1)) % q;
                
                // We might get negative value of t, converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }
    
    public static void main(String[] args) {
        RabinKarpAlgorithm rka = new RabinKarpAlgorithm();
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        rka.search(pat, txt);
    }
}
