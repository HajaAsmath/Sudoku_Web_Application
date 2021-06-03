package com.launch.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.launch.mapper.SudokuMapper;
import com.launch.service.DiggingInterface;
import com.launch.service.HardStrategy;
import com.launch.service.NormalStrategy;

@Configuration
public class SudokuConfiguration {
	
	@Bean
	public SudokuMapper sudokuMapper() {
		return new SudokuMapper();
	}
	
	@Bean
	public DiggingInterface hardStrategy() {
		return new HardStrategy();
	}
	
	@Bean
	public DiggingInterface normalStrategy() {
		return new NormalStrategy();
	}
	
}
