package problem_solution;

import java.util.*;

/*      Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/
public class ArrayProblems {

    public int[] twoSum(int[] numberArray, int target) {

        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int indexOfArray = 0; indexOfArray < numberArray.length; indexOfArray++) {
            int complement = target - numberArray[indexOfArray];
            if (map.containsKey(complement)) {
                result[1] = indexOfArray;
                result[0] = map.get(complement);
                return result;
            }
            map.put(numberArray[indexOfArray], indexOfArray);
        }
        return result;
    }

/*-------------------------------Sum OF Array-------------------------------------------------------------------------*/


    public int[] sumOfArrayToZero(int[] numberArray) {

        // Creates an empty hashMap mapOfSumToIndex
        HashMap<Integer, Integer> mapOfSumToIndex = new HashMap<>();

        // Initialize sum of elements
        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i <= numberArray.length; i++) {
            // Add current element to sum
            sum += numberArray[i];

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            //https://www.youtube.com/watch?v=hLcYp67wCcM
            if (numberArray[i] == 0 || sum == 0 || mapOfSumToIndex.get(sum) != null) {
                System.out.println("Index:" + i + "--Sum: " + sum + "-- Map:" + mapOfSumToIndex.get(sum));
                return Arrays.copyOfRange(numberArray, mapOfSumToIndex.get(sum) + 1, i + 1);

            }

            // Add sum to hash map
            mapOfSumToIndex.put(sum, i);
            System.out.println("Sum-Key: " + sum + " Value-Index: " + mapOfSumToIndex.get(sum));
        }

        // We reach here only when there is no subarray with 0 sum

        return numberArray;

    }
/*-------------------Reverse a String---------------------------------------------------------------------------------*/

    public String reverseString(String input) {

        String reverse = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reverse = reverse + input.charAt(i);
        }
        return reverse;
    }


    /*-------------------Reverse without extra space ---------------------------------------------------------------------------------*/
    //[4,3,2,7,8,2,3,1]
    //https://www.youtube.com/watch?v=W-090WziKAs
    public int[] reverse(int[] input) {

        int startIndex = 0;
        int lastIndex = input.length - 1;
        while (startIndex < lastIndex) {
            //use XOR implementation to swap without temp variable
            int temp = input[lastIndex];
            input[lastIndex] = input[startIndex];
            input[startIndex] = temp;
            startIndex++;
            lastIndex--;

        }
        return input;

    }


    /*---------------------------------Find Duplicate Arrays-----------------------------------------------------------------------*/
    public List<Integer> duplicate(int[] input) {

        int nextIndex;
        List<Integer> duplicate = new ArrayList<>();
        for (int index = 0; index < input.length - 1; index++) {

            for (nextIndex = index + 1; nextIndex < input.length - 1; nextIndex++) {

                if (input[index] == input[nextIndex]) {
                    duplicate.add(input[index]);
                }
            }
        }
        return duplicate;

    }


    //https://www.youtube.com/watch?v=GeHOlt_QYz8

    public List<Integer> findAllDuplicates(int[] numberArray) {

        List<Integer> resultSet = new ArrayList<>();
        for (int i = 0; i < numberArray.length; i++) {
            int index = Math.abs(numberArray[i]) - 1;
            if (numberArray[index] < 0) {
                resultSet.add(Math.abs(numberArray[index]));
            } else {
                numberArray[index] = -numberArray[index];
            }
        }
        return resultSet;
    }


    /*---------------------------------------move Zeros to End Array--------------------------------------------------*/

    public int[] pushZeroToEnd(int arr[], int sizeOfArray) {
        int count = 0;
        //int[] numberArrayOfZero = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int index = 0; index < sizeOfArray; index++) {
            if (arr[index] != 0) {
                arr[count++] = arr[index];
            }

        }

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < sizeOfArray) {
            arr[count++] = 0;
        }
        return arr;
    }

    /*-------------------------------Main-----------------------------------------------------------------------------*/
    public static void main(String[] args) {


        ArrayProblems arrayProblems = new ArrayProblems();

        int[] numberArray = new int[]{4, 7, 11, 8};
        int target = 12;
        int[] result = arrayProblems.twoSum(numberArray, target);
        System.out.println("result = [" + result + "]" + result);
        Arrays.stream(result).forEach(number ->
                System.out.println(number)
        );

        /*---------------------Sum of array--------------------------------------------------------------------------*/
        int[] sumZeroArray = {1, 4, -2, -2, 5, -4, 3};
        int[] sumOfArrayToZero = arrayProblems.sumOfArrayToZero(sumZeroArray);
        System.out.println("Sum of total zero array:");
        Arrays.stream(sumOfArrayToZero).forEach(item -> System.out.println(item));

        /*------------------------Reverse String----------------------------------------------------------------------*/

        System.out.println("Reverse String:" + arrayProblems.reverseString("Hello"));

        /*---------------------------Reverse Constant space array ----------------------------------------------------*/
        int[] numberArrayReverse = {4, 3, 2, 7, 8, 2, 3, 7};
        int[] reverseInt = arrayProblems.reverse(numberArrayReverse);
        Arrays.stream(reverseInt).forEach(value -> System.out.println(value));

        /*--------------------------------------------Find duplicates--------------------------------------------------*/
        int[] numberArrayDuplicates = {4, 3, 2, 7, 8, 2, 3, 7, 7};
        List<Integer> duplicateArray = arrayProblems.duplicate(numberArrayDuplicates);
        System.out.println("duplicate array");
        duplicateArray.forEach(value -> System.out.println(value));

        /*--------------------------------------------Zero Array--------------------------------------------------*/
        int[] numberArrayOfZero = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int[] intArrayZeroAtEnd = arrayProblems.pushZeroToEnd(numberArrayOfZero, numberArrayOfZero.length);
        System.out.println("Zero end array");
        for (int i = 0; i < intArrayZeroAtEnd.length; i++) {
            System.out.println(intArrayZeroAtEnd[i]);
        }


        /*--------------------------------------------Find constant duplicates---------------------------------------*/

        List<Integer> duplicateArrayFind = arrayProblems.findAllDuplicates(numberArrayDuplicates);
        System.out.println("duplicate array constant");
        duplicateArrayFind.forEach(value -> System.out.println(value));
    }


}
