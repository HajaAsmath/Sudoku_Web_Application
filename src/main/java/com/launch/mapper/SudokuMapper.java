package com.launch.mapper;

import org.springframework.stereotype.Component;

import com.launch.model.Sudoku;
import com.launch.model.SudokuDTO;
import com.launch.util.Constants;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class SudokuMapper{
	
	public SudokuDTO mapEntityToDTO(Sudoku entity) {
		
		MapperFactory factory = new DefaultMapperFactory.Builder().build();
		factory.classMap(Sudoku.class, SudokuDTO.class)
				.customize(new CustomMapper<Sudoku,SudokuDTO>(){
					public void mapAtoB(Sudoku source, SudokuDTO dest, MappingContext context) {
						int[][] matrix = source.getMatrix();
						int[][] matrixCopy = new int[Constants.MATRIX_SIZE][Constants.MATRIX_SIZE];
						for(int i = 0;i<Constants.MATRIX_SIZE;i++) {
							for(int j =0;j<Constants.MATRIX_SIZE;j++) {
								matrixCopy[i][j] = matrix[i][j];
							}
						}
						dest.setMatrix(matrixCopy);
					}
				})
				.register();
		
		BoundMapperFacade<Sudoku, SudokuDTO> mapperFacade = 
				factory.getMapperFacade(Sudoku.class, SudokuDTO.class);
		
		return mapperFacade.map(entity);
	}
	
	public Sudoku mapDTOToEntity(SudokuDTO dto) {
		MapperFactory factory = new DefaultMapperFactory.Builder().build();
		
		factory.classMap(SudokuDTO.class, Sudoku.class)
			.customize(new CustomMapper<SudokuDTO, Sudoku>(){
				@Override
				public void mapAtoB(SudokuDTO source, Sudoku dest, MappingContext context) {
					int[][] matrix = source.getMatrix();
					int[][] matrixCopy = new int[Constants.MATRIX_SIZE][Constants.MATRIX_SIZE];
					for(int i = 0;i<Constants.MATRIX_SIZE;i++) {
						for(int j =0;j<Constants.MATRIX_SIZE;j++) {
							matrixCopy[i][j] = matrix[i][j];
						}
					}
					dest.setMatrix(matrixCopy);
				}
			})
			.register();
		
		BoundMapperFacade<SudokuDTO, Sudoku> mapperFacade = factory.getMapperFacade(SudokuDTO.class, Sudoku.class);
		
		return mapperFacade.map(dto);
	}
}
