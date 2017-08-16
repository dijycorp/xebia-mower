package com.xebia.mowitnow.converters;

import java.util.Objects;
import java.util.function.Function;

import com.xebia.mowitnow.entities.Grid;

public class StringGridConverter implements Function<String, Grid> {

	@Override
	public Grid apply(String gridArguements) {
		// check if the value is not null
		Objects.requireNonNull(gridArguements, "the grid arguements can't be null");
		
		// split the values
		String[] gridSplited = gridArguements.split(" ");
		
		// convert to string
		int horizontalMax = Integer.valueOf(gridSplited[0]);
		int verticalMax = Integer.valueOf(gridSplited[1]);
		
		return new Grid(horizontalMax, verticalMax);
	}

}
