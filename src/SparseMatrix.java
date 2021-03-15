public class SparseMatrix
{
    final int sparse[][];
    final int row;
    final int col;
    int[][] transpose;
    int element_count;

    public int[][] getSparse()
    {
        return sparse;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public int[][] getTranspose()
    {
        return transpose;
    }

    public int getElement_count()
    {
        return element_count;
    }


    //public SparseMatrix()
    //{
        //Under development
    //}
    public SparseMatrix(int matrix[][])
    {
        this.sparse=toSparseMatrix(matrix);
        this.row=matrix.length;
        this.col=matrix[0].length;
        transposeMatrix();
    }
    public void operate()
    {

    }
    public void getInput()
    {

    }
    public void displayOptions()
    {

    }

    public void printTransposeMatrix()
    {
        printMatrix(transpose,row,col);
    }

    public void printSparseMatrix()
    {
        printMatrix(sparse,row,col);
    }

    public void printMatrix(int[][] matrix)
    {
        printMatrix(matrix,matrix.length,matrix[0].length);
    }

    private void printMatrix(int[][] matrix,int row, int col)
    {
        int index=0;
        for (int a=0;a<row;a++)
        {
            for (int b=0;b<col;b++)
            {
                if(this.element_count>index)
                {
                    if (matrix[index][0] == a && matrix[index][1] == b)
                    {
                        System.out.print(matrix[index][2]);
                        index++;
                    }
                    else
                    {
                        System.out.print(0);
                    }
                }
                else
                {
                    System.out.print(0);
                }
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[][] toSparseMatrix(int[][] matrix)
    {
        int index=0;
        int result_matrix[][]=new int[(int) Math.pow(matrix.length,2)][3];
        for (int loop_var=0;loop_var<matrix.length;loop_var++)
        {
            for(int inner_loop_var=0;inner_loop_var<matrix[loop_var].length;inner_loop_var++)
            {
                if (matrix[loop_var][inner_loop_var]!=0)
                {
                    result_matrix[index][0]=loop_var;
                    result_matrix[index][1]=inner_loop_var;
                    result_matrix[index][2]=matrix[loop_var][inner_loop_var];
                    index++;
                }
            }
        }
        this.element_count=index;
        int result[][] = new int[index][3];
        for (int a=0;a<index;a++)
        {
            result[a]=result_matrix[a];
        }
        return result;
    }
    public int[][] toNormalMatrix(int sparse[][])
    {
        int result_matrix[][]=new int[this.row][this.col];
        for (int loop_var=0;loop_var<sparse.length;loop_var++)
        {
            result_matrix[sparse[loop_var][0]][sparse[loop_var][1]]=sparse[loop_var][2];
        }
        return result_matrix;
    }
    public void transposeMatrix()
    {
        transpose=new int[sparse.length][3];
        for (int loop_var=0;loop_var<sparse.length;loop_var++)
        {
            transpose[loop_var][0]=sparse[loop_var][1];
            transpose[loop_var][1]=sparse[loop_var][0];
            transpose[loop_var][2]=sparse[loop_var][2];
        }
        transpose=sortSparseMatrix(transpose);

    }
    public void isSymmetric()
    {
        for (int loop_var=0;loop_var<sparse.length;loop_var++)
        {
            if(sparse[loop_var][0]!=transpose[loop_var][0] || sparse[loop_var][1]!=transpose[loop_var][1] || sparse[loop_var][2]!=transpose[loop_var][2])
            {
                System.out.println("Not Symmetric");
            }
        }
    }
    public int[][] sortSparseMatrix(int[][] matrix)
    {
        int temp[];
        int min = 0;
        int min_loc=0;
        for (int loop_var=0;loop_var<matrix.length;loop_var++)
        {
            min=matrix[loop_var][0];
            min_loc=loop_var;
            for (int inner_loop_var = loop_var; inner_loop_var< matrix.length; inner_loop_var++)
            {
                if(min>=matrix[inner_loop_var][0])
                {
                    min= Math.min(min, matrix[inner_loop_var][0]);
                    min_loc=inner_loop_var;
                }
            }
            temp=matrix[loop_var];
            matrix[loop_var]=matrix[min_loc];
            matrix[min_loc]=temp;
        }

        for (int loop_var=0;loop_var<matrix.length-1;loop_var++)
        {
            min = matrix[loop_var][1];
            min_loc = loop_var;
            for (int inner_loop_var = loop_var; inner_loop_var < matrix.length; inner_loop_var++)
            {
                if (min >= matrix[inner_loop_var][1] && matrix[loop_var][0]==matrix[inner_loop_var][0])
                {
                    min = Math.min(min, matrix[inner_loop_var][1]);
                    min_loc = inner_loop_var;
                }
            }
            temp = matrix[loop_var];
            matrix[loop_var] = matrix[min_loc];
            matrix[min_loc] = temp;
        }
        return matrix;
    }

    public int[][] addMatrix(int[][] matrix_to_add) throws Exception
    {
        int[][] result;
        if(matrix_to_add.length==row && matrix_to_add[0].length==col)
        {
            SparseMatrix matrix=new SparseMatrix(matrix_to_add);
            matrix_to_add=matrix.getSparse();
            result=new int[matrix_to_add.length*2][3];
            
        }
        else
        {
            throw new Exception("Can not add two matrix with different dimensions");
        }
        int index=0;
        int x=0; // for sparse
        int y=0; // for to_add
        while(true)
        {
            if(matrix_to_add[y][0]==sparse[x][0])
            {
                result[index][0]= sparse[x][0];
                if(matrix_to_add[y][1]==sparse[x][1])
                {
                    result[index][1]= sparse[x][1];
                    result[index][2]= sparse[x][2]+matrix_to_add[y][2];
                    x++;
                    y++;
                }
                else if(matrix_to_add[y][1]>sparse[x][1])
                {
                    result[index][1]= sparse[x][1];
                    result[index][2]= sparse[x][2];
                    x++;
                }
                else
                {
                    result[index][1]= matrix_to_add[y][1];
                    result[index][2]= matrix_to_add[y][2];
                    y++;
                }
            }
            else if(matrix_to_add[y][0]>sparse[x][0])
            {
                result[index][0]= sparse[x][0];
                result[index][1]= sparse[x][1];
                result[index][2]= sparse[x][2];
                x++;
            }
            else
            {
                result[index][0]= matrix_to_add[y][0];
                result[index][1]= matrix_to_add[y][1];
                result[index][2]= matrix_to_add[y][2];
                y++;
            }
            index++;
            if(x== sparse.length && y==matrix_to_add.length)
            {
                break;
            }
            else if(x== sparse.length)
            {
                while(y< matrix_to_add.length)
                {
                    result[index][0]= matrix_to_add[y][0];
                    result[index][1]= matrix_to_add[y][1];
                    result[index][2]= matrix_to_add[y][2];
                    y++;
                }
                break;
            }
            else if(y== matrix_to_add.length)
            {
                while(y< sparse.length)
                {
                    result[index][0]= sparse[x][0];
                    result[index][1]= sparse[x][1];
                    result[index][2]= sparse[x][2];
                    y++;
                }
                break;
            }
        }
        return result;
    }
    public void multiplySparseMatrix(int matrix_to_multiply[][]) throws Exception
    {
        int result[][];
        if(matrix_to_multiply.length==col && matrix_to_multiply[0].length==row)
        {
            result=new int[row*col][3];
            matrix_to_multiply=toSparseMatrix(matrix_to_multiply);
        }
        else
        {
            throw new Exception("Can not multiply two matrix");
        }
    }
    public static void main(String[] args) throws Exception
    {
        /*
        int[][] matrix=new int[][]
                {
                        {0,2,0,3},
                        {0,2,0,0},
                        {0,0,2,0},
                        {0,0,0,0}
                };
         */

        int[][] matrix1=new int[][]
                {
                        {1,0,3,0},
                        {0,3,0,1},
                        {9,0,7,0},
                        {0,7,0,9}
                };


        int[][] matrix2=new int[][]
                {
                        {0,2,0,4},
                        {4,0,2,0},
                        {0,8,0,6},
                        {6,0,8,0}
                };
        SparseMatrix matrix=new SparseMatrix(matrix2);
        int arr[][]=matrix.addMatrix(matrix1);
        {
            // Snippet
            int x[][] = matrix.toNormalMatrix(arr);
            for (int a = 0; a < x.length; a++)
            {
                for (int b = 0; b < x[0].length; b++)
                {
                    System.out.print(x[a][b] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

/*
{
        // Snippet
        int x[][] = transpose;
        for (int a = 0; a < x.length; a++)
        {
        for (int b = 0; b < x[0].length; b++)
        {
        System.out.print(x[a][b]);
        }
        System.out.println();
        }
        System.out.println();
        }*/
