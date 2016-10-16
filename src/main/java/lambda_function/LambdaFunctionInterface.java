package lambda_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

/*
        1. () -> {}
        2. () -> "Raoul"
        3. () -> {return "Mario";}
        4. (Integer i) -> return "Alan" + i; //invalid
        5. (String s) -> {"Iron Man";}//invalid to make it valid removes brackets {}
        */
@FunctionalInterface
public interface LambdaFunctionInterface {

    void testLambda();

}


class Apple{

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private String color;
    private int weight;

    public Apple(){
        this.color="RED";
        this.weight=124;
    }
    public Apple(String color){
        this.color=color;
    }

    public Apple(int weight){
        this.weight=weight;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public void testColor(){
        LambdaFunctionInterface lambdaFunctionInterface = ()-> System.out.println("Apple.testColor:"+color);
        lambdaFunctionInterface.testLambda();
    }
    /*
     * The java.util.function.Consumer<T> interface defines an abstract method named accept that
      takes an object of generic type T and returns no result (void). You might use this interface when
        you need to access an object of type T and perform some operations on it. For example, you can
        use it to create a method forEach, which takes a list of Integers and applies an operation on each
        element of that list. In the following listing you use this forEach method combined with a
        lambda to print all the elements of the list.
    * */
    public void testConsumer(Apple apple){
        Callable<Apple> c = () -> new Apple("grey",34);
        try {
            System.out.println("Apple.testConsumer:" + c.call());
            Runnable r = () -> {System.out.println("Tricky example"); };
            r.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void testList(List<Apple> appleList){

      //  List<Apple> greenApple=filter(appleList,(Apple apple)->"green".equalsIgnoreCase(apple.getColor()));

    }

    public  void testLocal(){
        int portNumber=2343;
        Runnable runnable = ()-> System.out.println("Apple.testLocal:"+portNumber);
        runnable.run();
    }

    public void testMethodReferenceCreateObject(){
        Supplier<Apple> supplier = Apple::new;//()->new Apple()
        Apple apple = supplier.get();
        apple.testLocal();

        Function<String,Apple> integerAppleFunction = Apple::new;//(color)->new Apple(color)
        Apple appleFunction=integerAppleFunction.apply("green");
        System.out.println("Apple.testMethodReferenceCreateObject:" + appleFunction.getColor());

        BiFunction<String,Integer,Apple> multiConstructorArgs = Apple::new;//(color,weight)->new Apple("red",234)
        Apple appleMulti=multiConstructorArgs.apply("GreenRed",50);
        System.out.println("Apple.testMethodReferenceCreateObject Multi Param:"+appleMulti.getWeight());


    }

    public void testCompactorReference(List<Apple> appleList){

        appleList.sort(comparing(Apple::getWeight));
        System.out.println("Apple.testCompactorReference:"+appleList);
        appleList.sort(comparing(Apple::getWeight).reversed());
        System.out.println("Apple.testCompactorReference Reversed:"+appleList);
    }

    public void testCompositeFunctions() {
        BiFunction<String, Integer, Apple> addCompositeFunction = Apple::new;
        Apple apple = addCompositeFunction.apply("Red", 34);
     //   addCompositeFunction.andThen(Apple::getWeight).andThen(Apple::setColor);
    }

    public void testForEach(List<Apple> appleList){
        appleList.forEach((apple -> System.out.println("Apple.testForEach:"+apple.getColor())));

        ///
        Consumer<Apple> consumer=(apple) -> System.out.println("Apple.testForEach:"+apple.getWeight());
        appleList.forEach(consumer);

    }


    public static void main(String[] args)  {
        Apple apple = new Apple("Red",12);
        List<Apple> appleList= Arrays.asList(apple,new Apple("green",34));
        apple.testColor();
        apple.testConsumer(apple);
        apple.testLocal();
        apple.testMethodReferenceCreateObject();

        //
        List<Apple> inventoryList = new ArrayList<>();
        inventoryList.addAll(Arrays.asList(new Apple("green",680), new Apple("green",155), new Apple("red",344)));
        apple.testCompactorReference(inventoryList);
        apple.testForEach(inventoryList);
    }


    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
