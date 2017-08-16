package com.xebia.mowitnow.entities;

/**
 * it's the grid of the garden to mow.
 * 
 * @author Jeremie.Diacono
 *
 */
public class Grid {

	private String name;

	private int horizontalMax;
	private int horizontalMin;
	private int verticalMax;
	private int verticalMin;

	/**
	 * Initialize the grid with the global dimension of the mow.
	 * 
	 * @param horizontalMax
	 *            the horizontal Max value of the grid
	 * @param verticalMax
	 *            the horizontal Max value of the grid
	 * @throws IllegalAccessException
	 *             when one or more parameters are less then 0
	 */
	public Grid(int horizontalMax, int verticalMax) {
		super();
		checkvalue(horizontalMax);
		checkvalue(verticalMax);
		this.horizontalMax = horizontalMax;
		this.verticalMax = verticalMax;
		this.verticalMin = 0;
		this.horizontalMin = 0;
	}

	/**
	 * Initialize a new grip for the mower
	 * 
	 * @param horizontalMax
	 *            the horizontal Max value of the grid
	 * @param verticalMax
	 *            the horizontal Max value of the grid
	 * @param upMax
	 *            the horizontal Max value of the grid
	 * @param downMax
	 *            the horizontal Max value of the grid
	 * @throws IllegalAccessException
	 *             when one or more parameters are less then 0
	 */
	public Grid(int horizontalMax, int verticalMax, int upMax, int downMax) {
		super();
		checkvalue(horizontalMax);
		checkvalue(verticalMax);
		checkvalue(upMax);
		checkvalue(downMax);
		this.horizontalMax = horizontalMax;
		this.verticalMax = verticalMax;
		this.verticalMin = upMax;
		this.horizontalMin = downMax;
	}

	// METHODS

	private void checkvalue(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("value can't be lower than 0");
		}
	}

	// GETTER AND SETTER

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHorizontalMax() {
		return horizontalMax;
	}

	public void setHorizontalMax(int horizontalMax) {
		this.horizontalMax = horizontalMax;
	}

	public int getHorizontalMin() {
		return horizontalMin;
	}

	public void setHorizontalMin(int horizontalMin) {
		this.horizontalMin = horizontalMin;
	}

	public int getVerticalMax() {
		return verticalMax;
	}

	public void setVerticalMax(int verticalMax) {
		this.verticalMax = verticalMax;
	}

	public int getVerticalMin() {
		return verticalMin;
	}

	public void setVerticalMin(int verticalMin) {
		this.verticalMin = verticalMin;
	}

}
