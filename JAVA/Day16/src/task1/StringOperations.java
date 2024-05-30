package task1;

public class StringOperations {
	

	    public static void main(String[] args) {
	        // Test cases
	        System.out.println(middleSubstring("hello", "world", 5));  // Output: "dlorw"
	        System.out.println(middleSubstring("", "test", 2));        // Output: "et"
	        System.out.println(middleSubstring("abc", "", 4));         // Output: "cba"
	        System.out.println(middleSubstring("abc", "def", 10));     // Output: "fedcba"
	        System.out.println(middleSubstring("", "", 3));            // Output: ""
	    }

	    public static String middleSubstring(String str1, String str2, int length) {
	        // Step 1: Concatenate the two strings
	        String concatenatedStr = str1 + str2;

	        // Step 2: Reverse the concatenated string
	        String reversedStr = new StringBuilder(concatenatedStr).reverse().toString();

	        // Step 3: Determine the starting index for the middle substring
	        int n = reversedStr.length();
	        if (length >= n) {
	            return reversedStr;  // If the requested length is larger than the string, return the whole string
	        }

	        int startIndex = (n - length) / 2;

	        // Step 4: Extract and return the middle substring
	        return reversedStr.substring(startIndex, startIndex + length);
	    }
	}


