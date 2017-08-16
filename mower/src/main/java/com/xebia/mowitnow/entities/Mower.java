package com.xebia.mowitnow.entities;

import com.xebia.mowitnow.spaces.Direction;
import com.xebia.mowitnow.spaces.Position;

/**
 * The mower to move into the grid
 * 
 * @author Jeremie.Diacono
 *
 */
public class Mower {

	private int id;

	private Position position;
	
	private Direction direction;

	// CONSTRUCTORS

	public Mower(int id, Position position, Direction direction) {
		super();
		this.id = id;
		this.position = position;
		this.direction=direction;
	}
	
	public Mower(Position position, Direction direction) {
		super();
		this.position = position;
		this.direction=direction;
	}

	// GETTER AND SETTER

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	//METHODS
	
	public void moveTo(int x, int y){
		Position newPosition = new Position(x, y);
		this.setPosition(newPosition);
	}
	
	//HASH CODE AND EQUALS
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mower other = (Mower) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return position.getHorizontal() + " " + position.getVertical() + " " + direction.toString();
	}

}
