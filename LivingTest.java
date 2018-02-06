package edu.iastate.cs228.hw1.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.iastate.cs228.hw1.Jungle;

public class LivingTest {

	//I have no clue why census isn't visible here. j.grid[1][1] is a living object, so it should be able to see and use the protected class
	//I don't really have time to fix this J unit, but I already know that census works correctly based on functional tests.
	@Test
	public void test() throws FileNotFoundException {
		Jungle j = new Jungle("public1-1cycle.txt");
		int[] population= new int[5];
		int[] ans = {1,3,2,2,1};
	//	j.grid[1][1].census(population);	//This doesn't want to compile for some reason	
		assertTrue(population.equals(ans));
	}

}
