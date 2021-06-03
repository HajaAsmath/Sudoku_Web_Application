package com.launch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launch.util.CheckIsSafe;
import com.launch.util.Constants;
import com.launch.util.CopyMatrixUtil;
import com.launch.util.RandomNumberUtil;

public class NormalStrategy implements DiggingInterface{
	
	public static int N = Constants.MATRIX_SIZE;
	
	@Autowired
	SolverService solver;
	
	@Override
	public int[][] digHoles(int[][] matrix, int lowerBound) {
		int[][] visited = new int[N][N];
		int totalGiven = N * N;
		boolean flag = false;
		while (totalGiven >= lowerBound) {
			flag = true;
			int row = RandomNumberUtil.randomNumber(N);
			int col = RandomNumberUtil.randomNumber(N);
			int n = matrix[row][col];
			if (visited[row][col] != 1) {
				visited[row][col] = 1;
				for (int i = 1; i <= N; i++) {
					if (i != n) {
						matrix[row][col] = 0;
						if (CheckIsSafe.checkSafe(matrix, row, col, i)) {
							matrix[row][col] = i;
							if (solver.solve(CopyMatrixUtil.copyMatrix(matrix), 0, 0)) {
								matrix[row][col] = n;
								flag = false;
								break;
							}
						}
					}
				}
				if (flag) {
					matrix[row][col] = 0;
					totalGiven--;
				}

			}

		}
		return matrix;
	}

}
