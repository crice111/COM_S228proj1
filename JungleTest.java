package edu.iastate.cs228.hw1.Tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import edu.iastate.cs228.hw1.Jungle;

public class JungleTest {

	@Test
	public void JunglegetWidth() {
		Jungle j = new Jungle(3);
		assertTrue(j.getWidth()==3);
	}

	@Test 
	public void JunglegetWidth2() throws FileNotFoundException {
		Jungle j = new Jungle("public1-1cycle.txt");
		assertTrue(j.getWidth()==3);
	}
	
	@Test
	public void toStringtest() throws FileNotFoundException {
		Jungle j = new Jungle("public1-1cycle.txt");
		String s = j.toString();
		assertTrue(s.equals("\nG  E  G  \nE  J0 P1 \nJ1 E  D0 "));
	}
	
	@Test
	public void writetest() throws FileNotFoundException {
		Jungle j = new Jungle("public1-1cycle.txt");
		j.write("writejunit.txt");
		File file = new File("writejunit.txt");
		assertTrue(file.exists());
	}
	
}
