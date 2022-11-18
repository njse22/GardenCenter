package model;

import java.util.Random;

public class MatrixUtil{
	
	public static int[][] randomMatrix(int f, int c){
        int[][] matrix = new int[f][c];
        Random rand = new Random();

        for(int i=0; i <matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                matrix[i][j]= rand.nextInt(9);
            }
        }
        return matrix;
    }

    public static String matrixToString(int[][]matrix){
    	String msg= "";
        for(int i=0; i <matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
               msg += "["+matrix[i][j]+"]";
            }
            msg += "\n";
        }
        return msg;
    }
}