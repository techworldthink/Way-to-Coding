class test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 8) {
                break;
            }
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }
    }
}
