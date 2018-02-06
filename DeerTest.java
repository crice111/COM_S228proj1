package edu.iastate.cs228.hw1.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.iastate.cs228.hw1.Animal;
import edu.iastate.cs228.hw1.Deer;
import edu.iastate.cs228.hw1.Jungle;
import edu.iastate.cs228.hw1.State;

public class DeerTest {

	//who() should return the state DEER
		@Test
		public void testwho() {
			Jungle j = new Jungle(3);
			Deer tom = new Deer(j,0,0,5);
			assertTrue(tom.who()==State.DEER);
		}

		//Next should return Empty if age is 6
		@Test
		public void nextagetest() throws FileNotFoundException {
			Jungle j = new Jungle("DeerAgeTest.txt");
			Jungle j2 = new Jungle(2);
			j2.grid[0][0] = j.grid[0][0].next(j2);
			assertTrue(j2.grid[0][0].who()==State.EMPTY);
		}
		
		//Next should return Puma if 2x more pumas than jags and deer outnumbered by PUMAs+JAGUARS
		@Test
		public void DeertoPumatest() throws FileNotFoundException {
			Jungle j = new Jungle("DeertoPuma.txt");
			Jungle j2 = new Jungle(3);
			j2.grid[1][1] = j.grid[1][1].next(j2);
			assertTrue(j2.grid[1][1].who()==State.PUMA);
		}
		
		//Next should return Jaguar if deer outnumbered by Pumas+ Jaguars and # Jaguars >= # Pumas
		@Test
		public void DeertoJaguar() throws FileNotFoundException {
			Jungle j = new Jungle("DeertoJaguar.txt");
			Jungle j2 = new Jungle(2);
			j2.grid[0][0] = j.grid[0][0].next(j2);
			assertTrue(j2.grid[0][0].who()==State.JAGUAR);
		}
		
		
		//Next should return a Deer if the deer survives(none of other conditions met)
		@Test
		public void Deersurvivetest1() throws FileNotFoundException {
			Jungle j = new Jungle("DeerSurviveTest.txt");
			Jungle j2 = new Jungle(2);
			j2.grid[0][0] = j.grid[0][0].next(j2);
			assertTrue(j2.grid[0][0].who()==State.DEER);
		}
		
		// Next Should return a Deer one year older than initialization(0+1=1) if it survives
		@Test
		public void Deersurvivetest2() throws FileNotFoundException {
			Jungle j = new Jungle("DeerSurviveTest.txt");
			Jungle j2 = new Jungle(2);
			j2.grid[0][0] = j.grid[0][0].next(j2);
			assertTrue(((Animal) j2.grid[0][0]).myAge()==4);
		}
	
}
