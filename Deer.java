package edu.iastate.cs228.hw1;

/**
 *  
 * @author Chris Rice
 *
 */

/*
 * A deer eats grass and lives no more than six years.
 */
public class Deer extends Animal 
{	
	/**
	 * Creates a Deer object.
	 * @param j: jungle  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Deer (Jungle j, int r, int c, int a) 
	{
		this.jungle=j;
		this.row=r;
		this.column=c;
		this.age=a;
	}
		
	// Deer occupies the square.
	public State who()
	{ 
		return State.DEER;
	}
	
	/**
	 * @param jNew     jungle in the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Jungle jNew)
	{
		int population[]= new int[5];
		this.census(population);
		if(age==6|population[2]==0) {
			Living r = new Empty(jNew,row,column);
			return r;
		}
		if(population[3]+population[4]>population[0]&&population[3]*2<=population[4]) {
			Living r = new Puma(jNew,row,column,0);
			return r;
		}
		if(population[3]+population[4]>population[0]&&population[3]>= population[4]) {
			Living r = new Jaguar(jNew,row,column,0);
			return r;
		}
		Living r = new Deer(jNew,row,column,age+1);
		return r;

		// See Living.java for an outline of the function. 
		// See Section 2.3 in the project description for the survival rules for a deer. 

	}
}
