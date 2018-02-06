package edu.iastate.cs228.hw1.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.iastate.cs228.hw1.Empty;
import edu.iastate.cs228.hw1.Jungle;
import edu.iastate.cs228.hw1.State;

public class EmptyTest {

	//who() should return the state EMPTY
		@Test
		public void testwho() {
			Jungle j = new Jungle(3);
			Empty inside = new Empty(j,0,0);
			assertTrue(inside.who()==State.EMPTY);
		}

		//Next should return Deer if more than one neighboring Deer
		@Test
		public void EmptytoDeertest() throws FileNotFoundException {
			Jungle j = new Jungle("EmptytoDeer.txt");
			Jungle j2 = new Jungle(2);
			j2.grid[0][0] = j.grid[0][0].next(j2);
			assertTrue(j2.grid[0][0].who()==State.DEER);
		}
		
		//Next should return Puma if more than one neighboring Puma
		@Test
		public void EmptytoPuma() throws FileNotFoundException {
			Jungle j = new Jungle("EmptytoPuma.txt");
			Jungle j2 = new Jungle(2);
			j2.grid[0][0] = j.grid[0][0].next(j2);
			assertTrue(j2.grid[0][0].who()==State.PUMA);
		}
		
		//Next should return Jaguar if more than one neighboring Jaguar
		@Test
		public void EmptytoJagtest() throws FileNotFoundException {
			Jungle j = new Jungle("EmptytoJaguar.txt");
			Jungle j2 = new Jungle(2);
			j2.grid[0][0] = j.grid[0][0].next(j2);
			assertTrue(j2.grid[0][0].who()==State.JAGUAR);
		}
		
		
		//Next should return Grass if at least one neighboring Grass
		@Test
		public void EmptytoGrassTest() throws FileNotFoundException {
			Jungle j = new Jungle("EmptytoGrass.txt");
			Jungle j2 = new Jungle(2);
			j2.grid[0][0] = j.grid[0][0].next(j2);
			assertTrue(j2.grid[0][0].who()==State.GRASS);
		}
		
		// Next Should return Empty if none of the other conditions are met
		@Test
		public void StayEmpty() throws FileNotFoundException {
			Jungle j = new Jungle("StayEmpty.txt");
			Jungle j2 = new Jungle(2);
			j2.grid[0][0] = j.grid[0][0].next(j2);
			assertTrue(j2.grid[0][0].who()==State.EMPTY);
		}
}
