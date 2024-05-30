package task3;

public class NaivePatternSearch {


	    public static void main(String[] args) {
	        String text = "AABAACAADAABAABA";
	        String pattern = "AABA";
	        searchPattern(text, pattern);
	    }

	    public static void searchPattern(String text, String pattern) {
	        int textLength = text.length();
	        int patternLength = pattern.length();
	        int comparisonCount = 0;

	        // Loop through the text
	        for (int i = 0; i <= textLength - patternLength; i++) {
	            int j;

	            // For current index i, check for pattern match
	            for (j = 0; j < patternLength; j++) {
	                comparisonCount++;
	                if (text.charAt(i + j) != pattern.charAt(j)) {
	                    break;
	                }
	            }

	            // If pattern is found
	            if (j == patternLength) {
	                System.out.println("Pattern found at index " + i);
	            }
	        }

	        System.out.println("Total comparisons made: " + comparisonCount);
	    }
	}


