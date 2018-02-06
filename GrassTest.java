package edu.iastate.cs228.hw1.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.iastate.cs228.hw1.Jungle;
import edu.iastate.cs228.hw1.State;

public class GrassTest {

	// Next Should return Empty if there are at least 3x as many deer as Grasses
	@Test
	public void GrasstoEmptytest() throws FileNotFoundException {
		Jungle j = new Jungle("GrasstoEmpty.txt");
		Jungle j2 = new Jungle(3);
		j2.grid[1][1] = j.grid[1][1].next(j2);
		assertTrue(j2.grid[1][1].who()==State.EMPTY);
	}
	
	// Next Should return Deer if there are at least 4 deer in the neighborhood and less than 3*totalGrass Deers in the neighborhood
	@Test
	public void GrasstoDeertest() throws FileNotFoundException {
		Jungle j = new Jungle("GrasstoDeer.txt");
		Jungle j2 = new Jungle(3);
		j2.grid[1][1] = j.grid[1][1].next(j2);
		assertTrue(j2.grid[1][1].who()==State.DEER);
	}

	// Next Should return Grass if the other criteria isn't met
	@Test
	public void GrasstoGrass() throws FileNotFoundException {
		Jungle j = new Jungle("GrasstoGrass.txt");
		Jungle j2 = new Jungle(3);
		j2.grid[1][1] = j.grid[1][1].next(j2);
		assertTrue(j2.grid[1][1].who()==State.GRASS);
	}
}
