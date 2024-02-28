package Week_02.TransposeArray;

public class Main {
    public static void main(String[] args) {
        int[][] matris = {
                {2, 3, 4},
                {5, 6, 4}
        };

        int[][] transpozeMatris = findTranspose(matris);

        System.out.println("Matris : ");
        printMatrix(matris);

        System.out.println("Transpoze : ");
        printMatrix(transpozeMatris);
    }
    public static int[][] findTranspose(int[][] matris) {
        int rowNumber = matris.length;
        int columnNumber = matris[0].length;

        int[][] transpozeMatris = new int[columnNumber][rowNumber];

        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                transpozeMatris[j][i] = matris[i][j];
            }
        }

        return transpozeMatris;
    }

    public static void printMatrix(int[][] matris) {
        for (int[] row : matris) {
            for (int eleman : row) {
                System.out.print(eleman + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
