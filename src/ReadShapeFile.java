
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.
	public static Circle readCircle(Scanner line) {
		int posX = line.nextInt();
		int posY = line.nextInt();
		int volX = line.nextInt();
		int volY = line.nextInt();
		boolean filled = line.nextBoolean();
		int diameter = line.nextInt();
		int colourR = line.nextInt();
		int colourG = line.nextInt();
		int colourB = line.nextInt();
		int insertionTime = line.nextInt();
		boolean pulse = line.nextBoolean();
		
		Color colour =  Color.rgb(colourR, colourG, colourB);
		
		Circle newCircle = new Circle(insertionTime, posX, posY, volX, volY, diameter, colour , filled, pulse);
		
		System.out.println(newCircle.toString());
		return newCircle;
	}
	
	public static Oval readOval(Scanner line) {
		int posX = line.nextInt();
		int posY = line.nextInt();
		int volX = line.nextInt();
		int volY = line.nextInt();
		boolean filled = line.nextBoolean();
		int width = line.nextInt();
		int height = line.nextInt();
		int colourR = line.nextInt();
		int colourG = line.nextInt();
		int colourB = line.nextInt();
		int insertionTime = line.nextInt();
		boolean pulse = line.nextBoolean();
		
		Color colour =  Color.rgb(colourR, colourG, colourB);
		
		Oval newOval = new Oval(insertionTime, posX, posY, volX, volY, width, height, colour, filled, pulse);
	
		System.out.println(newOval.toString());
		return newOval;
	}
	
	public static Square readSquare(Scanner line) {
		int posX = line.nextInt();
		int posY = line.nextInt();
		int volX = line.nextInt();
		int volY = line.nextInt();
		boolean filled = line.nextBoolean();
		int side = line.nextInt();
		int colourR = line.nextInt();
		int colourG = line.nextInt();
		int colourB = line.nextInt();
		int insertionTime = line.nextInt();
		boolean pulse = line.nextBoolean();
		
		Color colour =  Color.rgb(colourR, colourG, colourB);
		
		Square newSquare = new Square(insertionTime, posX, posY, volX, volY, side, colour , filled, pulse);
		
		System.out.println(newSquare.toString());
		return newSquare;
	}
	
	public static Rectangle readRect(Scanner line) {
		int posX = line.nextInt();
		int posY = line.nextInt();
		int volX = line.nextInt();
		int volY = line.nextInt();
		boolean filled = line.nextBoolean();
		int width = line.nextInt();
		int height = line.nextInt();
		int colourR = line.nextInt();
		int colourG = line.nextInt();
		int colourB = line.nextInt();
		int insertionTime = line.nextInt();
		boolean pulse = line.nextBoolean();
		
		Color colour =  Color.rgb(colourR, colourG, colourB);
		
		Rectangle newRect = new Rectangle(insertionTime, posX, posY, volX, volY, width, height, colour, filled, pulse);
	
		System.out.println(newRect.toString());
		return newRect;
	}
	
	public static Triangle readTri(Scanner line) {
		int posX = line.nextInt();
		int posY = line.nextInt();
		int volX = line.nextInt();
		int volY = line.nextInt();
		boolean filled = line.nextBoolean();
		int width = line.nextInt();
		int height = line.nextInt();
		int colourR = line.nextInt();
		int colourG = line.nextInt();
		int colourB = line.nextInt();
		int insertionTime = line.nextInt();
		boolean pulse = line.nextBoolean();
		
		
		Color colour =  Color.rgb(colourR, colourG, colourB);
		
		Triangle newTri = new Triangle(insertionTime, posX, posY, volX, volY, width, height, colour, filled, pulse);
	
		System.out.println(newTri.toString());
		return newTri;
	}
	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
		
		while(in.hasNextLine()){
			String currentLine = in.nextLine();
			Scanner line = new Scanner(currentLine);
			String shapeName = line.next();
			
			
			if(shapeName.equals("circle")) {
				Circle newCircle = readCircle(line);
				shapeQueue.enqueue(newCircle);
			}
			else if(shapeName.equals("oval")) {
				Oval newOval = readOval(line);
				shapeQueue.enqueue(newOval);
			}
			else if(shapeName.equals("square")) {
				Square newSquare = readSquare(line);
				shapeQueue.enqueue(newSquare);
			}
			else if(shapeName.equals("rect")) {
				Rectangle newRect = readRect(line);
				shapeQueue.enqueue(newRect);
			}
			else if(shapeName.equals("triangle")) {
				Triangle newTri = readTri(line);
				shapeQueue.enqueue(newTri);
			}
			line.close();
		}
		//read in the shape files and place them on the Queue

		//Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}
	

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
		File inputFile = new File(filename);
		Scanner scan = null;
		
		try {
			scan = new Scanner(inputFile);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error on file: " + filename);
			System.exit(0);
		}
		return ReadShapeFile.readDataFile(scan);
	}
}
