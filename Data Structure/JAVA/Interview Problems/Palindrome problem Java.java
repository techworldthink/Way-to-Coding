
class PalindromeProblem {

        public static boolean isPalindrome(String word) {

                int forward = 0;
                int backward = word.length() - 1;

                while (forward < backward) {
                        if (word.charAt(forward) != word.charAt(backward))
                                return false;

                        forward++;
                        backward--;
                }
                return true;

        }

        public static void main(String[] args) {
                System.out.println(isPalindrome("malayalam"));
                System.out.println(isPalindrome("english"));
        }
}