package edu.iastate.cs228.hw1.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.iastate.cs228.hw1.Animal;
import edu.iastate.cs228.hw1.Deer;
import edu.iastate.cs228.hw1.Jungle;


public class AnimalTest {

	//Test whether myAge correctly returns age.
	@Test
	public void test() {
		Jungle j = new Jungle(5);
		Animal test= new Deer(j,2,2,3);
		assertEquals(3,test.myAge());
	}

}
