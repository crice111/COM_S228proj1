package edu.iastate.cs228.hw1;

/**
 *  
 * @author Chris Rice
 *
 */

/**
 * Grass may be eaten out or taken over by deers. 
 *
 */
public class Grass extends Living 
{
	public Grass (Jungle j, int r, int c) 
	{
		this.jungle=j;
		this.row=r;
		this.column=c;
	}
	
	public State who()
	{
		 
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many deers in the neighborhood. Deers may also 
	 * multiply fast enough to take over Grass. 
	 * 
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Jungle jNew)
	{
		int population[]= new int[5];
		this.census(population);
		if(population[2]*3<=population[0]) {
			Living r = new Empty(jNew,row,column);
			return r;
		}
		if(population[0]>=4) {
			Living r = new Deer(jNew,row,column,0);
			return r;
		}
		Living r= new Grass(jNew,row,column);
		return r;


		// See Living.java for an outline of the function. 
		// See Section 2.4 in the project description for the survival rules for grass. 
	}
}
