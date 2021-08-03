public class FizzBuzzTest {
    public static void main(String[] args) {
        // FizzBuzz tester = new FizzBuzz();
        FizzBuzz.fizzBuzz(9);
        FizzBuzz.fizzBuzz(10);
        FizzBuzz.fizzBuzz(15);
        FizzBuzz.fizzBuzz(16);
        FizzBuzz.fizzBuzz(2);
        for (int i = 1; i <= 50; i++) {
            FizzBuzz.fizzBuzz(i);
        }
    }
}
