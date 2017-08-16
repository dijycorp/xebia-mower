package com.xebia.mowitnow.spaces;

/**
 * Indicate the position of the mower
 * 
 * @author Jeremie.Diacono
 * @version 0.1
 */
public class Position {

	private int horizontal;
	private int vertical;
	
	//CONSTRUCTORS
	
	public Position(int horizontal, int vertical){
		this.horizontal=horizontal;
		this.vertical=vertical;
	}
	
	// GETTER AND SETTER
	
	public int getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(int horizontal) {
		this.horizontal = horizontal;
	}

	public int getVertical() {
		return vertical;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
	}
}
