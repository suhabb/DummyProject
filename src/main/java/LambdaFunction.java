import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaFunction {

    List<Integer> listOfIntegers = Arrays.asList(10,20,34,65,67,564,43,76,86,467,476,570,23);

    public void testListOfIntegers(){
        listOfIntegers.forEach((valueOfEachItemInTheList)->System.out.println(valueOfEachItemInTheList));
        System.out.println("LambdaFunction.testListOfIntegers-=======================");
        listOfIntegers.forEach(System.out::println);
    }

    public void testListStreamAPI(){
        System.out.println("LambdaFunction.testListStreamAPI");
        listOfIntegers.stream().filter(integer -> integer >45).forEach(System.out::println);
        System.out.println("LambdaFunction.testListStreamAPI");
        listOfIntegers.forEach(item -> {
            if (45 > item) {
                System.out.println(item);
            }
        });

        System.out.println("LambdaFunction.testListStreamAPI:ANY MATCH");

        Boolean test= listOfIntegers.stream().anyMatch(integer -> integer > 45);
        System.out.println("LambdaFunction.testListStreamAPI:"+test);
        boolean anyMatchBoolean= listOfIntegers.stream().findAny().filter(integer -> integer > 45).isPresent();
        System.out.println("LambdaFunction.testListStreamAP Optional:"+anyMatchBoolean);

        System.out.println("LambdaFunction.testListStreamAPI: collect list of integers"+listOfIntegers.stream().filter(value -> value > 45).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        LambdaFunction lamdLambdaFunction = new LambdaFunction();
        lamdLambdaFunction.testListOfIntegers();
        lamdLambdaFunction.testListStreamAPI();

    }
}
