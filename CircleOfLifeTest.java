package edu.iastate.cs228.hw1.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.iastate.cs228.hw1.*;

public class CircleOfLifeTest {
	
	//updateJungle should update the first jungle j into the second j2. This should then be the same as the answer txt
	@Test
	public void updateJungletest() throws FileNotFoundException {
		Jungle j = new Jungle("public1-1cycle.txt");
		Jungle j2 = new Jungle(3);
		Jungle ans = new Jungle("public1-1cycleans.txt");
		CircleOfLife.updateJungle(j, j2);
		String s = j2.toString();
		String s2 = ans.toString();
		assertTrue(s.equals(s2));
	}

}
