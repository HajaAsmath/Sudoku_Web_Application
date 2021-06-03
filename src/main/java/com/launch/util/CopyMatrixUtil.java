package com.launch.util;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class CopyMatrixUtil {
	public static int[][] copyMatrix(int[][] matrix){
		return Arrays.stream(matrix).map(i -> i.clone()).toArray($ -> matrix.clone());
	}
}
