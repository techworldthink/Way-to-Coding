import java.util.Arrays;

class AnagramProblem {

        public static boolean isAnagram(char[] word_1, char[] word_2) {
                if (word_1.length != word_2.length)
                        return false;

                Arrays.sort(word_1);
                Arrays.sort(word_2);

                for (int i = 0; i < word_1.length; i++)
                        if (word_1[i] != word_2[i])
                                return false;

                return true;

        }

        public static void main(String[] args) {
                System.out.println(isAnagram("test".toCharArray(), "eat".toCharArray()));
                System.out.println(isAnagram("restful".toCharArray(), "fluster".toCharArray()));
        }
}