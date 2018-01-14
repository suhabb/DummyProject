package problem_solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*      Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/
public class TwoSum{
    public int[] twoSum(int[] numberArray, int target) {

        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<> ();
        for (int indexOfArray = 0; indexOfArray < numberArray.length; indexOfArray++) {
            int complement = target - numberArray[indexOfArray];
            if (map.containsKey(complement)) {
                result[1] = indexOfArray ;
                result[0] = map.get(complement);
                return result;
            }
            map.put(numberArray[indexOfArray], indexOfArray);
        }
        return result;
    }


    public static void main(String[] args) {


        TwoSum twoSum = new TwoSum();

        int[] numberArray = new int[]{4, 7, 11, 8};
        int target = 12;
        int[] result = twoSum.twoSum(numberArray, target);
        System.out.println("result = [" + result + "]" + result);
        Arrays.stream(result).forEach(number -> {
                    System.out.println(number);
                }
        );
    }


}
