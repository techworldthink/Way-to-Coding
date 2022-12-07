class strings {
    public static void main(String[] args) {
        String T = "Hello";
        System.out.println(T);
        System.out.println(T.length());
        System.out.println(T.toUpperCase());
        System.out.println(T.toLowerCase());
        System.out.println(T.indexOf("o"));
        System.out.println(T+" world!");
        System.out.println(T.concat(" ok"));

        // backslash escape character
        String T1 = "Hello \"hai\" ";
        String T2 = "Hello \'hai\' ";
        String T3 = "Hello \\ ";
        System.out.println(T1);
        System.out.println(T2);
        System.out.println(T3);

    }
}
