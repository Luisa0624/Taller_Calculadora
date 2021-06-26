import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Calculadora {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a+b;
        BiFunction<Integer, Integer, Integer> res = (a,b) -> a-b;


        BiFunction<Integer, Integer, Integer> multiply = (a,b) -> IntStream.range(0,b+1)
                .reduce((acumulador, numero)-> {

                    return add.apply(acumulador, a);
                }).getAsInt();

        BiFunction<Integer, Integer, Integer> divi = (a,b) -> IntStream.range(0,a)
                .reduce((acumulador, numero)->
                        multiply.apply(numero,b)<=a?add.apply(acumulador,1):acumulador).getAsInt();

        System.out.println(add.apply(45,5));
        System.out.println(res.apply(82,24));
        System.out.println(multiply.apply(85,15));
        System.out.println(divi.apply(425,12));

    }
}
