import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 2, 4},
                {1, 5, 8},
                {9, 6, 7}
        };
        int[][] sortedMatrix = sorting(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(sortedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] sorting(int[][] twoDArray) {
        int[] bebrochka = new int[twoDArray.length * twoDArray[0].length];
        int k = 0;
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                bebrochka[k] = twoDArray[i][j];
                k++;
            }
        }
        Arrays.sort(bebrochka);
        int[][] secondMatrix = new int[twoDArray.length][twoDArray[0].length];
        k = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[i].length; j++) {
                secondMatrix[i][j] = bebrochka[k];
                k++;
            }
        }
        return secondMatrix;
    }
}
