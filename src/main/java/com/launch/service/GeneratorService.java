package com.launch.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launch.configuration.SudokuConfiguration;
import com.launch.mapper.SudokuMapper;
import com.launch.model.Sudoku;
import com.launch.model.SudokuDTO;
import com.launch.repo.SudokuRepository;
import com.launch.util.Constants;

@Service
public class GeneratorService {
	
	@Autowired
	SudokuRepository repository;
	
	@Autowired
	SudokuConfiguration configuration;
	
	@Autowired
	CreateTerminalMatrixService createTerminalMatrixService;
	
	@Autowired
	HoleDiggingService diggingService;
	
	@Autowired
	SudokuMapper sudokuMapper;
	
	public SudokuDTO generateProblem(int difficulty) {
		Sudoku sudoku = new Sudoku();
		sudoku.setCreate_timestamp(LocalDateTime.now());
		int[][] matrix = createTerminalMatrixService.createTerminalMatrix();
		diggingService.digHoles(difficulty, matrix);
		sudoku.setMatrix(matrix);
		repository.save(sudoku);
		return sudokuMapper.mapEntityToDTO(sudoku);
	}
}
