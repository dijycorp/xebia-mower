package com.xebia.mowitnow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.xebia.mowitnow.converters.StringGridConverter;
import com.xebia.mowitnow.entities.Grid;
import com.xebia.mowitnow.entities.Mower;
import com.xebia.mowitnow.spaces.Direction;
import com.xebia.mowitnow.spaces.Position;
import com.xebia.mowitnow.validators.MowerInstructionValidator;
import com.xebia.mowitnow.validators.MowerPositionValidator;

/**
 * Launcher for the mower application
 * 
 * @author Jeremie.Diacono
 *
 */
public class MowerApplication {

	/**
	 * Main method for launch the app
	 * 
	 * @param args
	 *            the path of the file
	 */
	public static void main(String[] args) {

		// check validity of the arguments given
		if (args.length > 0) {
			// argument exists and will be convert into file
			File file = new File(args[0]);
			if (file.exists()) {
				// when the file exist, launch the app
				String result = MowerApplication.run(file);
				System.out.println(result);
			} else {
				System.out.println("File with path " + args[0] + "does not exists.");
			}
		} else {
			System.out.println("To execute, please add path of your files in parameters");
		}
	}

	public static String run(File file) {
		String currentLine = null;
		StringBuilder result = new StringBuilder();

		// initialize the validator
		MowerPositionValidator positionValidator = new MowerPositionValidator();
		MowerInstructionValidator instructionsValidator = new MowerInstructionValidator();
		
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			// collect the global grid at the first line and initialize him
			currentLine = bufferedReader.readLine();
			StringGridConverter converter = new StringGridConverter();
			Grid grid = converter.apply(currentLine);

			// initialize the collection of response
			List<Mower> mowers = new ArrayList<>();
			while ((currentLine = bufferedReader.readLine()) != null) {

				// read the data
				String initialPosition = currentLine;
				String instructions = bufferedReader.readLine();

				// validate the data given
				boolean isValidPosition = positionValidator.apply(currentLine);
				boolean isValidInstructions = instructionsValidator.apply(instructions);

				// make actions only when the line of values is correct
				if (isValidPosition && isValidInstructions) {
					mowers.add(processMower(initialPosition, instructions, grid));
				} else {
					StringBuilder log = new StringBuilder();
					log.append("no possible to launch instructions with ").append(instructions).append(" and position ")
							.append(initialPosition);
					System.out.println(log.toString());
				}

			}
			for (int i = 0; i < mowers.size(); i++) {
				result.append(mowers.get(i).toString()).append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println("An exception occured :" + e.getMessage());
		}
		return result.toString();
	}

	public static Mower processMower(String initialPosition, String instructions, Grid grid) {
		String[] c = initialPosition.split(" ");
		Position position = new Position(Integer.valueOf(c[0]), Integer.valueOf(c[1]));
		Direction direction = Direction.fromName(c[2]);

		Mower mower = new Mower(position, direction);
		for (char step : instructions.toCharArray()) {
			System.out.println(step + " instruction will be process");
			mower = processStep(step, mower, grid);
			System.out.println(mower);
		}
		return mower;
	}

	public static Mower processStep(char step, Mower mower, Grid grid) {
		if (step == 'A') {
			Direction currentOrientation = mower.getDirection();
			if (currentOrientation.equals(Direction.NORTH)) {
				if (mower.getPosition().getVertical() != grid.getHorizontalMax()) {
					mower.moveTo(mower.getPosition().getVertical(), mower.getPosition().getVertical() + 1);
				}
			}
			if (currentOrientation.equals(Direction.SOUTH)) {
				if (mower.getPosition().getVertical() != grid.getHorizontalMin()) {
					mower.moveTo(mower.getPosition().getHorizontal(), mower.getPosition().getVertical() - 1);
				}
			}
			if (currentOrientation.equals(Direction.WEST)) {
				if (mower.getPosition().getHorizontal() != grid.getVerticalMin()) {
					mower.moveTo(mower.getPosition().getHorizontal() - 1, mower.getPosition().getVertical());
				}
			}
			if (currentOrientation.equals(Direction.EAST)) {
				if (mower.getPosition().getHorizontal() != grid.getVerticalMax()) {
					mower.moveTo(mower.getPosition().getHorizontal() + 1, mower.getPosition().getVertical());
				}
			}
		} else {
			mower.setDirection(Direction.getOrientation(step, mower.getDirection()));
		}
		return mower;
	}

}
