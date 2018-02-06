package edu.iastate.cs228.hw1.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.iastate.cs228.hw1.Animal;
import edu.iastate.cs228.hw1.Jungle;
import edu.iastate.cs228.hw1.Puma;
import edu.iastate.cs228.hw1.State;

public class PumaTest {
	
	//who() should return the state PUMA
	@Test
	public void testwho() {
		Jungle j = new Jungle(3);
		Puma tom = new Puma(j,0,0,3);
		assertTrue(tom.who()==State.PUMA);
	}
	
	//Next should return Empty if the Puma is 4 years old
	@Test
	public void PumaAgeTest() throws FileNotFoundException {
		Jungle j = new Jungle("PumaAgeTest.txt");
		Jungle j2 = new Jungle(2);
		j2.grid[0][0] = j.grid[0][0].next(j2);
		assertTrue(j2.grid[0][0].who()==State.EMPTY);
	}
	
	//Next should return Jaguar if more Jaguars than Pumas
	@Test
	public void JaguarAttackTest() throws FileNotFoundException {
		Jungle j = new Jungle("Jaguarattack.txt");
		Jungle j2 = new Jungle(2);
		j2.grid[0][0] = j.grid[0][0].next(j2);
		assertTrue(j2.grid[0][0].who()==State.JAGUAR);
	}
	
	//Next should return Empty if less Deer than Jaguars and Pumas
	@Test
	public void NoCatFoodTest() throws FileNotFoundException {
		Jungle j = new Jungle("noCatFood.txt");
		Jungle j2 = new Jungle(2);
		j2.grid[1][1] = j.grid[1][1].next(j2);
		assertTrue(j2.grid[1][1].who()==State.EMPTY);
	}
	
	//Next should return a puma if no other conditions are met
	@Test
	public void Pumasurvivetest1() throws FileNotFoundException {
		Jungle j = new Jungle("PumaSurviveTest.txt");
		Jungle j2 = new Jungle(2);
		j2.grid[0][0] = j.grid[0][0].next(j2);
		assertTrue(j2.grid[0][0].who()==State.PUMA);
	}
	
	
	// Next Should return a puma one year older than initialization(1+1=2) if it survives
	@Test
	public void Pumasurvivetest2() throws FileNotFoundException {
		Jungle j = new Jungle("PumaSurviveTest.txt");
		Jungle j2 = new Jungle(2);
		j2.grid[0][0] = j.grid[0][0].next(j2);
		assertTrue(((Animal) j2.grid[0][0]).myAge()==2);
	}
}
