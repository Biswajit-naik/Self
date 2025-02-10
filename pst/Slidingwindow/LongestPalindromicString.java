public class LongestPalindromicString {
    /*
     * Find longest substring
     */
        public static String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
    
            int start = 0;  // Starting index of the longest palindrome
            int maxLen = 1; // Length of the longest palindrome found
    
            // Iterate through each character in the string
            for (int i = 0; i < s.length(); i++) {
                // Check for the longest odd-length palindrome (center is a single character)
                int len1 = expandAroundCenter(s, i, i);
                // Check for the longest even-length palindrome (center is between two characters)
                int len2 = expandAroundCenter(s, i, i + 1);
    
                // The maximum length between the two cases
                int len = Math.max(len1, len2);
    
                // If the found palindrome is longer than the previous one, update the start and maxLen
                if (len > maxLen) {
                    maxLen = len;
                    start = i - (len - 1) / 2; // Calculate the start index of the palindrome
                }
            }
    
            // Return the longest palindrome substring
            return s.substring(start, start + maxLen);
        }

        private static int expandAroundCenter(String s, int left, int right) {
            // Expand while the characters match and stay within bounds of the string
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // Return the length of the palindrome found
            return right - left - 1;
        }
    public static void main(String[] args) {
        String s = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy" ; 
        // String longeststring = "";
        long startTime = System.nanoTime();
        /* 
        // Bruteforce Approch
        for (int i=0 ; i< s.length();i++){
            String temp ="";
            for (int j=i;j<s.length();j++){
                temp = temp + s.charAt(j);
                if (isPalindrome(temp)){
                    if (temp.length() > longeststring.length()){
                        longeststring=temp;
                    }
                }
                System.out.print(temp + " ");

            }
            System.out.println(" ");
        }
        */
        longestPalindrome(s);
        long endTime = System.nanoTime();
        double milliseconds = (endTime - startTime)/1_000_000.0;
        // System.out.println("Longest subs tring is  :"+ longeststring);
        System.out.println("Execution time: " + milliseconds + " ms");
    }
   
}