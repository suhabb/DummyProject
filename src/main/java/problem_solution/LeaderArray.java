package problem_solution;


public class LeaderArray {
    //https://www.youtube.com/watch?v=M0ffPDQ3cgY&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG&index=22
    public static void main(String[] args) {
        int[] numberArray = {15, 16, 3, 19, 6, 1, 4};
        LeaderArray leaderArray = new LeaderArray();
        leaderArray.solution_regular(numberArray);
        leaderArray.optimized_solution(numberArray);
    }

    public void solution_regular(int[] numberArray) {

        //First Array -> 15,16,3,19,6,1,4==>
        //O  N^2
        for (int firstIndex = 0; firstIndex < numberArray.length; firstIndex++) {
            int secondIndex;
            for (secondIndex = firstIndex + 1; secondIndex < numberArray.length; secondIndex++) {
                if (numberArray[secondIndex] >= numberArray[firstIndex]) {
                    //break the inner lop
                    break;
                }
            }
            if (secondIndex == numberArray.length) {
                System.out.println("Leader elements = " + numberArray[firstIndex]);
            }
        }
    }

    public void optimized_solution(int[] numberArray) {
        //0-n
        int max_from_right = numberArray[numberArray.length - 1];
        for (int lastIndex = numberArray.length - 2; lastIndex >= 0; lastIndex--) {

            if (numberArray[lastIndex] > max_from_right) {
                max_from_right = numberArray[lastIndex];
            }
        }
        System.out.println("Leader:max_from_right = " + max_from_right);
    }
}


