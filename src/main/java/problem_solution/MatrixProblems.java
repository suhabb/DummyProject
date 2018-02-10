package problem_solution;
//https://www.youtube.com/watch?v=dsPdwhRR_84&index=2&list=PLeIMaH7i8JDim_JbrI07PxNdWqrmrq5RK

public class MatrixProblems {
    public static void main(String[] args) {

        MatrixProblems matrixProblems = new MatrixProblems();

        int[] row1 = {10, 20, 30, 40, 50};
        int[] row2 = {60, 70, 80, 90};
        int[] row3 = {100, 110, 120, 130};
        int[] row4 = {140, 150, 160, 170};

        int[][] matrix = {
                row1,
                row2,
                row3,
                row4
        };

        int[][] mat = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        //sizeOfMatrix->4
        matrixProblems.optimizedSearchInSortedMatrix(matrix, 4, 140);
        matrixProblems.optimizedSearchInSortedMatrix(mat, 4, 15);
        matrixProblems.searchInMatrix(matrix, 4, 60);
    }

    public void optimizedSearchInSortedMatrix(int[][] matrix, int sizeOfMatrix, int findElement) {
        //O^N
        int rowIndex = 0;
        int columnIndex = sizeOfMatrix - 1;
        //columnindex must not go below zero and and rows Index shld be less then zero
        while (rowIndex < sizeOfMatrix && columnIndex >= 0) {
            if (matrix[rowIndex][columnIndex] == findElement) {
                System.out.println("Element found:" + findElement + "- Row Index:" + rowIndex + "- Column Index:" + columnIndex);
                return;
            }
            if (matrix[rowIndex][columnIndex] > findElement) {
                columnIndex--;
            } else {
                rowIndex++;
            }
        }
        System.out.println("Not Found:" + findElement);

    }

    public void searchInMatrix(int[][] matrix, int sizeOfMatrix, int findElement) {

        for (int row = 0; row < sizeOfMatrix; row++) {
            for (int column = 0; column < sizeOfMatrix; column++) {
                if (matrix[row][column] == findElement) {

                    System.out.println("findElement = " + findElement);
                    System.out.println("Row index:" + row + "-Column Index:" + column);
                    return;
                }
            }
        }
        System.out.println("Not Found:" + findElement);
    }
}
