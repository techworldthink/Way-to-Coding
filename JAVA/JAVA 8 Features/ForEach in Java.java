import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

class IterationDemo {

        public static void main(String[] args) {

                List<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < 10; i++)
                        numbers.add(i);

                // Iterator
                Iterator<Integer> iterator = numbers.iterator();
                while (iterator.hasNext()) {
                        System.out.print(iterator.next() + "\t");
                }

                // JAVA 8 - foreach method - traversing with Consumer interface implementation
                System.out.print("\n.......foreach.....\n");
                ConsumerImpl action = new ConsumerImpl();
                numbers.forEach(action);

                // JAVA 8 - traversing through forEach method of Iterable with anonymous class
                System.out.print("\n.......foreach.....\n");
                numbers.forEach(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer value) {
                                System.out.print(value + "\t");

                        }
                });

        }
}

class ConsumerImpl implements Consumer<Integer> {

        @Override
        public void accept(Integer value) {
                System.out.print(value + "\t");

        }

}