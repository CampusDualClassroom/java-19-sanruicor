package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int[][] flatMatrix = new int[intArrayTri[0].length][intArrayTri[0][0].length];
        for (int i = 0; i < intArrayTri[0].length; i++) {
            for (int j = 0; j < intArrayTri[0][0].length; j++) {
                int sum = 0;
                for (int k = 0; k < intArrayTri.length; k++) {
                    sum += intArrayTri[k][i][j];
                }
                flatMatrix[i][j] = sum;
            }
        }
        return flatMatrix;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            sb.append(stringFlatMatrixRow(intArrayBi, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            if (i == uniArray.length - 1) {
                sb.append(uniArray[i]);
            } else {
                sb.append(uniArray[i] + " ");
            }

        }
        return sb.toString();
    }


    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] uniArray = new int[columns];
        for (int i = 0; i < columns; i++) {
            uniArray[i] = i + 1;
        }
        return uniArray;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] biArray = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                biArray[i][j] = value;
                value++;
            }
        }
        return biArray;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] triArray = new int[depth][rows][columns];
        int value = 1;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    triArray[i][j][k] = value;
                    value++;
                }
            }
        }
        return triArray;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
