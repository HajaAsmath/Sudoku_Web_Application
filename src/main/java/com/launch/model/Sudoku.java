package com.launch.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.launch.util.Constants;

@Entity(name = "SUDOKU")
public class Sudoku {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid",strategy = "uuid2")
	private String id;
	
	@Transient
	private int[][] matrix;
	
	@Column(name = "matrix")
	private String matrixString;
	
	@Column(name = "create_ts")
	private LocalDateTime create_timestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int[][] getMatrix() {
		return this.matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrixString = convertToString(matrix);
		this.matrix = matrix;
	}

	public LocalDateTime getCreate_timestamp() {
		return create_timestamp;
	}

	public void setCreate_timestamp(LocalDateTime create_timestamp) {
		this.create_timestamp = create_timestamp;
	}

	public String getMatrixString() {
		return matrixString;
	}
	
	public String convertToString(int[][] matrix) {
		String mat = "";
		for(int i = 0;i<Constants.MATRIX_SIZE;i++) {
			for(int j = 0;j<Constants.MATRIX_SIZE;j++) {
				mat += matrix[i][j];
			}
		}
		return mat;
	}
}
