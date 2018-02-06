package edu.iastate.cs228.hw1;

/**
 *  
 * @author Chris Rice
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Jungle j, int r, int c) 
	{
		this.jungle=j;
		this.row=r;
		this.column=c;
	}
	
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Deer, Grass, Jaguar, or Puma, or 
	 * remain empty. 
	 * @param jNew     jungle in the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Jungle jNew)
	{
		int population[]= new int[5];
		this.census(population);
		if(population[0]>1) {
			Living r = new Deer(jNew,row,column,0);
			return r;
		}
		if(population[4]>1) {
			Living r = new Puma(jNew,row,column,0);
			return r;
		}
		if (population[3]>1) {
			Living r = new Jaguar(jNew,row,column,0);
			return r;
		}
		if (population[2]>=1) {
			Living r = new Grass(jNew,row,column);
			return r;
		}
		Living r = new Empty(jNew,row,column);
 		return r;
		

		// See Living.java for an outline of the function. 
		// See Section 2.5 in the project description for corresponding survival rules.  
	}
}
