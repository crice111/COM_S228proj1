package edu.iastate.cs228.hw1;

/**
 *  
 * @author Chris Rice
 *
 */

/**
 * A puma eats deers and competes against a jaguar. 
 */
public class Puma extends Animal 
{
	/**
	 * Constructor 
	 * @param j: jungle
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Puma (Jungle j, int r, int c, int a) 
	{
		this.jungle=j;
		this.row=r;
		this.column=c;
		this.age=a;
	}
		
	/**
	 * A puma occupies the square. 	 
	 */
	public State who()
	{ 
		return State.PUMA; 
	}
	
	/**
	 * A puma dies of old age or hunger, or from attack by a jaguar. 
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Jungle jNew)
	{
		int population[]= new int[5];
		this.census(population);
		if(age==4) {
			Living r = new Empty(jNew,row,column);
			return r;
			}
		if(population[3]>population[4]) {
			Living r = new Jaguar(jNew,row,column,0);
			return r;
		}
		if(population[3]+population[4]>population[0]) {
			Living r = new Empty(jNew,row,column);
			return r;
		}
		Living r = new Puma(jNew,row,column,age+1);
		return r;
		// See Living.java for an outline of the function. 
		// See Section 2.2 in the project description for the survival rules for a puma. 
	}
}
