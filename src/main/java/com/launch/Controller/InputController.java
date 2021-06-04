package com.launch.Controller;

import com.launch.service.ResultValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.launch.model.SudokuDTO;
import com.launch.service.GeneratorService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class InputController {
	
	@Autowired
	GeneratorService generatorService;

	@Autowired
	ResultValidatorService validatorService;
	
	@RequestMapping("/generate")
	public SudokuDTO generate(@RequestParam("difficulty") int difficulty) {
		return generatorService.generateProblem(difficulty);
	}
	
	@RequestMapping(path = "/submit",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public boolean submit(@RequestBody SudokuDTO sudoku) {
		return validatorService.checkResult(sudoku.getMatrix());
	}
}
