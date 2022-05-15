public class Main {

    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);

        int c;
        try {
            c = calc.devide.apply(a, b);
        } catch (ArithmeticException e) {
            System.out.println("В методе minus возвращается 0, который должен быть использован в методе devide как делитель. Делить на 0 нельзя");
            c = -1;
        }
        calc.println.accept(c);
    }
}
