package edu.train.chapter2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8_001_StreamBuilder {
	
	public static void main(String[] args) {
		
		List<Object> list = Stream.of("1" , "2").collect(Collectors.toList());
		
		Stream.concat(Stream.of(1 , 2 ),Stream.of(3 , 4));
	}
	
	
}
