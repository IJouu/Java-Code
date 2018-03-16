public class Matrix {
    public static int[][] magicOdd(int n) {
        int[][] square = new int[n + 1][n + 1];

        int i = 0;
        int j = (n + 1) / 2;

        for(int key = 1; key <= n * n; key++) {
            if((key % n) == 1)
                i++;
            else {
                i--;
                j++;
            }

            if(i == 0)
                i = n;
            if(j > n)
                j = 1;

            square[i][j] = key;
        }

        int[][] matrix = new int[n][n];

        for(int k = 0; k < matrix.length; k++) {
            for(int l = 0; l < matrix[0].length; l++) {
                matrix[k][l] = square[k + 1][l + 1];
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int randNum = (int)(Math.random()*(30 - 20 + 1) + 20);
        while (randNum % 2 == 0) {
            randNum = (int)(Math.random()*(30 - 20 + 1) + 20);
        }
        int[][] magic = Matrix1.magicOdd(randNum);
        System.out.println(randNum + " x " + randNum);
        for (int k = 0; k < magic.length; k++) {
            for (int l = 0; l < magic[0].length; l++) {
                System.out.format("%3d ", magic[k][l]);
            }
            System.out.println();
        }
        int sum1 = 0;
        for (int i = 0; i < randNum; i++) {
            sum1 = sum1 + magic[(randNum - 1) / 2][i];
        }
        System.out.println(sum1);
        int sum2 = 0;
        for (int j = 0; j < randNum; j++) {
            sum2 = sum2 + magic[j][(randNum - 1) / 2];
        }
        System.out.println(sum2);
        int sum3 = 0;
        for (int m = 0; m < randNum; m++) {
            sum3 = sum3 + magic[m][m];
        }
        System.out.println(sum3);
    }
}
