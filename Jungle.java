package edu.iastate.cs228.hw1;

/**
 *  
 * @author Chris Rice
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random; 
/**
 * 
 * The jungle is represented as a square grid of size width X width. 
 *
 */
public class Jungle 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Jungle(String inputFileName) throws FileNotFoundException
	{	
		width=0;
		File scan1= new File(inputFileName);
		Scanner sc= new Scanner(scan1);
		String line=sc.nextLine();
		Scanner linescan= new Scanner(line);
		while(linescan.hasNext()) {
			linescan.next();
			width++;
		}
		linescan.close();
		sc.close();
		grid= new Living[width][width];

		
		File file2= new File (inputFileName);
		Scanner sc2 = new Scanner(file2);
		String s;
		for(int r=0;r<width;r++) {
			for(int c=0;c<width;c++) {			//This code isn't pretty but it works... 
				s = sc2.next();			//If there were more options I would probably do a .charat(), but with this few (<20) it doesn't matter that much
				if(s.equals("E")) {
					Living j = new Empty(this,r,c);
					grid[r][c]=j;
				}
				if(s.equals("G")) {
					Living j = new Grass(this,r,c);
					grid[r][c]=j;
				}
				if(s.equals("J0")) {
					Living j = new Jaguar(this,r,c,0);
					grid[r][c]=j;
				}
				if(s.equals("J1")) {
					Living j = new Jaguar(this,r,c,1);
					grid[r][c]=j;
				}
				if(s.equals("J2")) {
					Living j = new Jaguar(this,r,c,2);
					grid[r][c]=j;
				}
				if(s.equals("J3")) {
					Living j = new Jaguar(this,r,c,3);
					grid[r][c]=j;
				}
				if(s.equals("J4")) {
					Living j = new Jaguar(this,r,c,4);
					grid[r][c]=j;
				}
				if(s.equals("J5")) {
					Living j = new Jaguar(this,r,c,5);
					grid[r][c]=j;
				}
				if(s.equals("P0")) {
					Living j = new Puma(this,r,c,0);
					grid[r][c]=j;
				}
				if(s.equals("P1")) {
					Living j = new Puma(this,r,c,1);
					grid[r][c]=j;
				}
				if(s.equals("P2")) {
					Living j = new Puma(this,r,c,2);
					grid[r][c]=j;
				}
				if(s.equals("P3")) {
					Living j = new Puma(this,r,c,3);
					grid[r][c]=j;
				}
				if(s.equals("P4")) {
					Living j = new Puma(this,r,c,4);
					grid[r][c]=j;
				}
				if(s.equals("D0")) {
					Living j = new Deer(this,r,c,0);
					grid[r][c]=j;
				}
				if(s.equals("D1")) {
					Living j = new Deer(this,r,c,1);
					grid[r][c]=j;
				}
				if(s.equals("D2")) {
					Living j = new Deer(this,r,c,2);
					grid[r][c]=j;
				}
				if(s.equals("D3")) {
					Living j = new Deer(this,r,c,3);
					grid[r][c]=j;
				}
				if(s.equals("D4")) {
					Living j = new Deer(this,r,c,4);
					grid[r][c]=j;
				}
				if(s.equals("D5")) {
					Living j = new Deer(this,r,c,5);
					grid[r][c]=j;
				}
				if(s.equals("D6")) {
					Living j = new Deer(this,r,c,6);
					grid[r][c]=j;
				}
			}
		}
		sc2.close();
		// 
		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid jungle in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done. 
		
	}
	
	/**
	 * Constructor that builds a w X w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Jungle(int w)
	{
		grid=new Living[w][w];
		width=w;
	}
	
	
	public int getWidth()
	{
		return width;  // to be modified 
	}
	
	/**
	 * Initialize the jungle by randomly assigning to every square of the grid  
	 * one of Deer, Empty, Grass, Jaguar, or Puma.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random(); 
		for(int r=0;r<width;r++) {
			for(int c=0;c<width;c++) {
				int rand = generator.nextInt(5);
				if(rand==0) {
					Living j=new Deer(this,r,c,0);
					grid[r][c]=j;
				}
				if(rand==1) {
					Living j=new Empty(this,r,c);
					grid[r][c]=j;
				}
				if(rand==2) {
					Living j=new Grass(this,r,c);
					grid[r][c]=j;
				}
				if(rand==3) {
					Living j=new Jaguar(this,r,c,0);
					grid[r][c]=j;
				}
				if(rand==4) {
					Living j=new Puma(this,r,c,0);
					grid[r][c]=j;
				}
			}
		}
	}
	
	
	/**
	 * Output the jungle grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String result="";
		for(int r=0;r<width;r++) {
			result=result+"\n";
			for(int c=0;c<width;c++) {
				if(grid[r][c].who().equals(State.DEER)) {
					int age= ((Animal)grid[r][c]).myAge();
					result = (result+"D"+age+" ");
				}
				if(grid[r][c].who().equals(State.PUMA)) {
					int age= ((Animal)grid[r][c]).myAge();
					result = (result+"P"+age+" ");
				}
				if(grid[r][c].who().equals(State.JAGUAR)) {
					int age= ((Animal)grid[r][c]).myAge();
					result = (result+"J"+age+" ");
				}
				if(grid[r][c].who().equals(State.EMPTY)) {;
					result = (result+"E  ");
				}
				if(grid[r][c].who().equals(State.GRASS)) {
					result = (result+"G  ");
				}
			}
		}
		return result; 
	}
	

	/**
	 * Write the jungle grid to an output file.  Also useful for saving a randomly 
	 * generated jungle for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		
		File file= new File(outputFileName);
		PrintWriter output= new PrintWriter(file);
		for(int r=0;r<width;r++) {
			for (int c=0;c<width;c++) {
				if(grid[r][c].who()==State.EMPTY) {
					output.print("E  ");
				}
				if(grid[r][c].who()==State.GRASS) {
					output.print("G  ");
				}
				if(grid[r][c].who()==State.DEER) {
					Deer d=(Deer)grid[r][c];
					int age=d.myAge();
					output.print("D"+age+" ");
				}
				if(grid[r][c].who()==State.JAGUAR) {
					Jaguar j=(Jaguar)grid[r][c];
					int age=j.myAge();
					output.print("J"+age+" ");
				}
				if(grid[r][c].who()==State.PUMA) {
					Puma p=(Puma)grid[r][c];
					int age=p.myAge();
					output.print("P"+age+" ");
				}
			}
			output.println("");
		}
		output.close();
		// 
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    D, E, G, J, P. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 
	}			
}
