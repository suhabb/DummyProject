package lambda_function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaList {

    List<Integer> listOfIntegers = Arrays.asList(10, 20, 34, 65, 67, 564, 43, 76, 86, 467, 476, 570, 23);

    public void testListOfIntegers() {
        listOfIntegers.forEach((valueOfEachItemInTheList) -> System.out.println(valueOfEachItemInTheList));
        System.out.println("lambda_function.LambdaList.testListOfIntegers-=======================");
        listOfIntegers.forEach(System.out::println);
    }

    public void testListStreamAPI() {
        System.out.println("lambda_function.LambdaList.testListStreamAPI");
        listOfIntegers.stream().filter(integer -> integer > 45).forEach(System.out::println);
        System.out.println("lambda_function.LambdaList.testListStreamAPI");
        listOfIntegers.forEach(item -> {
            if (45 > item) {
                System.out.println(item);
            }
        });

        System.out.println("lambda_function.LambdaList.testListStreamAPI:ANY MATCH");

        Boolean test = listOfIntegers.stream().anyMatch(integer -> integer > 45);
        System.out.println("lambda_function.LambdaList.testListStreamAPI:" + test);
        boolean anyMatchBoolean = listOfIntegers.stream().findAny().filter(integer -> integer > 45).isPresent();
        System.out.println("lambda_function.LambdaList.testListStreamAP Optional:" + anyMatchBoolean);

        System.out.println("lambda_function.LambdaList.testListStreamAPI: collect list of integers" + listOfIntegers.stream().filter(value -> value > 45).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        LambdaList lamdLambdaList = new LambdaList();
        lamdLambdaList.testListOfIntegers();
        lamdLambdaList.testListStreamAPI();

    }
}
