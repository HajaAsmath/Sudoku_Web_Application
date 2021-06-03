package com.launch.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launch.util.Constants;

@Service
public class HoleDiggingService {

	public static Map<Integer, Integer> difficultyMap = new HashMap<>();

	SolverService solver = new SolverService();

	public static int N = Constants.MATRIX_SIZE;

	@Autowired
	DiggingInterface hardStrategy;
	
	@Autowired
	DiggingInterface normalStrategy;

	HoleDiggingService() {
		difficultyMap.put(1, 60);
		difficultyMap.put(2, 49);
		difficultyMap.put(3, 35);
		difficultyMap.put(4, 31);
		difficultyMap.put(5, 27);
	}

	public int[][] digHoles(int difficulty, int matrix[][]) {
		int lowerBound = difficultyMap.get(difficulty);
		if (difficulty < 4) {
			return normalStrategy.digHoles(matrix, lowerBound);
		} else {
			return hardStrategy.digHoles(matrix, lowerBound);
		}
	}
}
