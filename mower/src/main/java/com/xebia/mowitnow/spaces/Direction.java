package com.xebia.mowitnow.spaces;

public enum Direction {

	NORTH("N", 0),
	EAST("E", 1),
	SOUTH("S", 2),
	WEST("W", 3);

	private String name;
	private Integer value;

	Direction(String name, Integer value) {
		this.name = name;
		this.value = value;

	}

	public static Direction fromName(String c) {
		for (Direction o : Direction.values()) {
			if (o.name.equals(c)) {
				return o;
			}
		}
		return null;
	}

	public static Direction fromValue(int value) {
		return Direction.values()[(value + 4) % 4];
	}

	public static Direction getOrientation(char direction, Direction original) {
		Direction toReturn = null;
		if (direction == 'G') {
			toReturn = fromValue(original.value - 1);
		}
		if (direction == 'D') {
			toReturn = fromValue(original.value + 1);
		}
		return toReturn;
	}

	public String toString() {
		return name;
	}
}
