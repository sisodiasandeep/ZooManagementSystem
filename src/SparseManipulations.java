public class SparseManipulations {
    private final int matrix[][];

    /**
     * @param sparseMatrix is matrix whose reduced matrix is to be created
     */
    public SparseManipulations(int sparseMatrix[][])throws Exception{
        int count = 0, i, j;

        if (sparseMatrix == null) {
            throw new Exception(" NUll Value Array Passed");
        } else if (sparseMatrix.length == 0) {

        }
        for (i = 0; i < sparseMatrix.length; i++) {
            for (j = 0; j < sparseMatrix[0].length; j++) {
                if (sparseMatrix[i][j] != 0) {
                    count++;
                }
            }
        }


        matrix = new int[count][3];

        count = 0;

        for (i = 0; i < sparseMatrix.length; i++) {
            for (j = 0; j < sparseMatrix[0].length; j++) {
                if (sparseMatrix[i][j] != 0) {
                    matrix[count][0] = i;
                    matrix[count][1] = j;
                    matrix[count][2] = sparseMatrix[i][j];
                    count++;
                }
            }
        }

        printmatrix(matrix);

    }

    /**
     * @return the transpose of the original matrix
     */
    public int[][] matrixTranspose() {

        final int transposeMatrix[][] = new int[matrix[matrix.length - 1][1] + 1][matrix[matrix.length - 1][0] + 1];
        try {
            int i, j, k;
            for (i = 0, k = 0; i < transposeMatrix[0].length; i++) {
                for (j = 0; j < transposeMatrix.length; j++) {
                    if (matrix[k][0] == i && matrix[k][1] == j) {
                        transposeMatrix[j][i] = matrix[k][2];
                        k++;
                    } else
                        transposeMatrix[j][i] = 0;

                }
            }
        } catch (Exception e) {
        }
        return transposeMatrix;
    }

    /**
     * @param matrix is the matrix whose values are to bi printed
     */
    public void printmatrix(int matrix[][]) {
        try {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(" " + matrix[i][j] + "");
                }
                System.out.println();
            }
            System.out.println();
        } catch (Exception e) {
        }

    }

    /**
     * @return true if the original matrix is a symmetric matrix else return false
     */
    public boolean isSymmetric() {
        boolean isSymmetricMatrix = true;
        try {
            int transposedMatrix[][] = matrixTranspose(), i, j, k = -1;
            if (transposedMatrix.length != matrix[matrix.length - 1][0] + 1)
                isSymmetricMatrix = false;
            else
                for (i = 0; i < transposedMatrix.length; i++)
                    for (j = 0; j < (transposedMatrix[0].length); j++) {
                        k++;
                        if (i == matrix[k][0] && j == matrix[k][1] && transposedMatrix[i][j] != matrix[k][2])
                            isSymmetricMatrix = false;
                    }
        } catch (Exception e) {
        }
        return isSymmetricMatrix;

    }

    /**
     * @returns the array having elements the size of original matrix
     */
    public int[] size()throws Exception {
        return new int[] { (matrix[matrix.length - 1][0] + 1), (matrix[matrix.length - 1][1] + 1) };
    }

    /**
     * @param index is the position in original matrix whose value has to be found
     * @returns return the value at given position
     */
    public int getValue(int index[]) {
        try
        {
            for (int i = 0; i < matrix.length; i++)
                if ((matrix[i][0]) == index[0] && (matrix[i][1]) == index[1])
                    return matrix[i][2];
        }
        catch(Exception e) {}
        return 0;
    }

    /**
     * @param m1 and @param m2 are the two matrix whose addition has to be done
     * @return the addition of the two sparse matrix in 2-D array format The
     *         complexity of this function is O(n*m) , n =no. of rows in a matrix m=
     *         no. of column in a matrix
     */
    public int[][] addMatrix(SparseManipulations m1, SparseManipulations m2) {
        int add[][] = null;
        try {
            if (m1 == null || m2 == null)
                throw new Exception(" NUll Value Object Passed");
            int size1[] = m1.size(), size2[] = m2.size();
            if (size1[0] != size2[0] || size1[1] != size2[1]) {
                throw new Exception(" both matrix are of different size can't perform addition operation ");
            }
            add = new int[size1[0]][size1[1]];
            for (int i = 0; i < size1[0]; i++)
                for (int j = 0; j < size1[1]; j++) {
                    add[i][j] = m1.getValue(new int[] { i, j }) + m2.getValue(new int[] { i, j });
                }
        } catch (Exception e) {

        }
        return add;
    }

    /**
     * @param m1 and @param m2 are the two matrix whose multiplication has to be
     *           done
     *
     * @return the multiplication of the two sparse matrix in 2-D array format The
     *         complexity of this function is O(n*m*n) , n =no. of rows in a matrix
     *         m= no. of column in a matrix
     */
    public int[][] multiplyMatrix(SparseManipulations m1, SparseManipulations m2) {
        int multiply[][] = null;
        try {
            if (m1 == null || m2 == null)
                throw new Exception(" NUll Value Object Passed");
            int size1[] = m1.size(), size2[] = m2.size();
            if (size1[1] != size2[0]) {
                throw new Exception(" Multiplication Can't be performed ");
            }
            multiply = new int[size1[0]][size2[1]];
            for (int i = 0; i < size1[0]; i++)
                for (int j = 0; j < size2[1]; j++) {
                    multiply[i][j] = 0;
                    for (int k = 0; k < size1[1]; k++) {
                        multiply[i][j] += m1.getValue(new int[] { i, k }) * m2.getValue(new int[] { k, j });
                    }
                }
        } catch (Exception e) {

        }
        return multiply;
    }

    public static void main(String args[]) throws Exception {
        int[][] m = new int[][] { { 5, 6, 7 }, { 6, 3, 2 }, { 7, 2, 1 } };
        SparseManipulations ob = new SparseManipulations(m);
        int[][] firstMatrix = { { 3, -2, 5 }, { 3, 0, 4 } };
        int[][] secondMatrix = { { 2, 3 }, { -9, 0 }, { 0, 4 } };
        SparseManipulations ob1 = new SparseManipulations(firstMatrix);
        SparseManipulations ob2 = new SparseManipulations(secondMatrix);
        secondMatrix = ob.multiplyMatrix(ob1, ob2);
        // System.out.println(ob.isSymmetric());
        // m = ob.matrixTranspose();
        ob.printmatrix(secondMatrix);

    }
}