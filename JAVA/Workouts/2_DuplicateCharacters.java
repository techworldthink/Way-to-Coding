class DuplicateCharacters {

    String data;

    DuplicateCharacters(String data) {
        this.data = data;
    }

    void printDuplicates() {
        int count;
        char string[] = data.toCharArray();

        System.out.println("Duplicate characters in a given string: ");

        for (int i = 0; i < string.length; i++) {
            count = 1;
            for (int j = i + 1; j < string.length; j++) {
                if (string[i] == string[j] && string[i] != ' ') {
                    count++;

                    string[j] = '0';
                }
            }
            if (count > 1 && string[i] != '0')
                System.out.println(string[i]);
        }
    }

    public static void main(String[] args) {
        DuplicateCharacters obj = new DuplicateCharacters("ABCDABEA");
        obj.printDuplicates();
    }
}