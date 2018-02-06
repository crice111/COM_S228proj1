package edu.iastate.cs228.hw1;


import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Chris Rice
 *
 */

/**
 * 
 * The CircleOfLife class performs simulation over a grid jungle 
 * with squares occupied by deers, jaguars, pumas, grass, or none. 
 *
 */
public class CircleOfLife 
{
	/**
	 * Update the new jungle from the old jungle in one cycle. 
	 * @param jOld  old jungle
	 * @param jNew  new jungle 
	 */
	public static void updateJungle(Jungle jOld, Jungle jNew)
	{
		
		for (int r=0;r<jOld.getWidth();r++) {
			for(int c=0;c<jOld.getWidth();c++) {
				jNew.grid[r][c]=jOld.grid[r][c].next(jNew);
			}
		}

		// For every life form (i.e., a Living object) in the grid jOld, generate  
		// a Living object in the grid jNew at the corresponding location such that 
		// the former life form changes into the latter life form. 
		// 
		// Employ the method next() of the Living class. 
	}
	
	/**
	 * Repeatedly generates jungles either randomly or from reading files. 
	 * Over each jungle, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		int cycles=0;
		int genchoice=0;
		int gridsize=0;
		int trialnum=1;
		System.out.println("Circle of Life in the Amazon Jungle");
		System.out.println("keys: 1 (random jungle)  2 (file input)  3(exit)"); 
		Scanner Scanny= new Scanner(System.in);
		while(genchoice!=3) {
			System.out.print("\nTrial "+trialnum +":");
			genchoice=Scanny.nextInt();
			trialnum++;
			if(genchoice==1) {
				System.out.print("Random jungle \nEnter the grid width:");
				gridsize=Scanny.nextInt();
				System.out.print("Enter the number of cycles:");
				cycles=Scanny.nextInt();
				System.out.println("\nInitial jungle:");
				Jungle odd= new Jungle(gridsize);
				Jungle even=new Jungle(gridsize);
				odd.randomInit();
				System.out.print(odd.toString());
				int track=0;
				for(int i=cycles;i>0;i--) {
					if(track%2==0) {
						updateJungle(odd,even);
					}
					else {
						updateJungle(even,odd);
					}
					track++;
				}
				System.out.println("\n\nFinal Jungle:");
				if(cycles%2==0) {
					System.out.println(odd.toString());
				}
				else {
					System.out.println(even.toString());
				}
			}
			if(genchoice==2) {
				System.out.print("Jungle input from a file\nFile name:");
				String filename=Scanny.next();
				System.out.print("Enter the number of cycles:");
				cycles=Scanny.nextInt();
				Jungle odd= new Jungle(filename);
				Jungle even=new Jungle(odd.getWidth());
				System.out.println("\nInitial jungle:");
				System.out.print(odd.toString());
				int track=0;
				for(int i=cycles;i>0;i--) {
					if(track%2==0) {
						updateJungle(odd,even);
					}
					else {
						updateJungle(even,odd);
					}
					track++;
				}
				System.out.println("\n\nFinal Jungle:");
				if(cycles%2==0) {
					System.out.println(odd.toString());
				}
				else {
					System.out.println(even.toString());
				}
			
			}

		}
		Scanny.close();
		// TODO 
		// 
		// Generate CircleOfLife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random jungle, 2 to read a jungle from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 
		// 2. Print out standard messages as given in the project description. 
		// 
		// 3. For convenience, you may define two jungles even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the jungle 
		//    odd from the jungle even; in an odd numbered cycle, generate even 
		//    from odd. 
		
		   				 // the jungle after an even number of cycles 
		                  // the jungle after an odd number of cycles
		
		// 4. Print out initial and final jungles only.  No intermediate jungles should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate jungles.)
		// 
		// 5. You may save some randomly generated jungles as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated. 
		}
}
