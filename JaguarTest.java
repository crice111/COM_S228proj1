package edu.iastate.cs228.hw1.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import edu.iastate.cs228.hw1.*;
import org.junit.Test;


import edu.iastate.cs228.hw1.Jungle;

public class JaguarTest {
	
	//who() should return the state JAGUAR
	@Test
	public void testwho() {
		Jungle j = new Jungle(3);
		Jaguar tom = new Jaguar(j,0,0,5);
		assertTrue(tom.who()==State.JAGUAR);
	}

	//Next should return Empty if age is 5
	@Test
	public void nextagetest() throws FileNotFoundException {
		Jungle j = new Jungle("JagAgeTest.txt");
		Jungle j2 = new Jungle(2);
		j2.grid[0][0] = j.grid[0][0].next(j2);
		assertTrue(j2.grid[0][0].who()==State.EMPTY);
	}
	
	//Next should return Puma if at least twice as many Pumas as Jaguars
	@Test
	public void PumaAttacktest() throws FileNotFoundException {
		Jungle j = new Jungle("Pumaattack.txt");
		Jungle j2 = new Jungle(2);
		j2.grid[0][0] = j.grid[0][0].next(j2);
		assertTrue(j2.grid[0][0].who()==State.PUMA);
	}
	
	//Next should return Empty if more Pumas and Jaguars than Deer
	@Test
	public void noJagFoodtest() throws FileNotFoundException {
		Jungle j = new Jungle("noCatFood.txt");
		Jungle j2 = new Jungle(2);
		j2.grid[0][0] = j.grid[0][0].next(j2);
		assertTrue(j2.grid[0][0].who()==State.EMPTY);
	}
	
	
	//Next should return a jaguar if the jag survives(none of other conditions met)
	@Test
	public void Jagsurvivetest1() throws FileNotFoundException {
		Jungle j = new Jungle("JagSurviveTest.txt");
		Jungle j2 = new Jungle(2);
		j2.grid[0][0] = j.grid[0][0].next(j2);
		assertTrue(j2.grid[0][0].who()==State.JAGUAR);
	}
	
	// Next Should return a jaguar one year older than initialization(0+1=1) if it survives
	@Test
	public void Jagsurvivetest2() throws FileNotFoundException {
		Jungle j = new Jungle("JagSurviveTest.txt");
		Jungle j2 = new Jungle(2);
		j2.grid[0][0] = j.grid[0][0].next(j2);
		assertTrue(((Animal) j2.grid[0][0]).myAge()==1);
	}
}
