package com.launch.util;

public class Validator {
	
	public static final int N = 9;
	
	public boolean validate(int[][] sudoku) {
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(sudoku[i][j]!=0) {
					int num = sudoku[i][j];
					sudoku[i][j] = 0;
					if(!CheckIsSafe.checkSafe(sudoku, i, j, num)) {
						sudoku[i][j] = num;
						return false;
					}
					sudoku[i][j] = num;
				}
			}
		}
		return true;
	}
}
