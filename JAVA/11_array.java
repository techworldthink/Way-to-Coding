class array {
    public static void main(String[] args) {
        String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
        cars[0] = "Opel";
        System.out.println(cars[0]);
        System.out.println(cars.length);
        for (String i : cars) {
            System.out.println(i);
        }

        int[][] myNumbers = { { 1, 2, 3, 4 }, { 5, 6, 7 } };
        for (int[] i : myNumbers) {
            for (int j : i) {
                System.out.println(j);
            }
        }
    }
}
