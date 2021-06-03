package com.launch.repo;

import org.springframework.data.repository.CrudRepository;

import com.launch.model.Sudoku;

public interface SudokuRepository extends CrudRepository<Sudoku, String>{

}
