package com.fidelity.bowling;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

	private Game game;

	@Before
	public void setUp() {
		game = new Game();
	}

	private void rollMany(int numberOfRolls, int pins) {
		for (int i = 0; i < numberOfRolls; i++) {
			game.roll(pins);
		}
	}

	@Test
	public void shouldScoreAGutterGame() throws Exception {
		rollMany(20, 0);
		assertThat(game.score(), equalTo(0));
	}

	@Test
	public void shouldScoreAllOnes() throws Exception {
		rollMany(20, 1);
		assertThat(game.score(), equalTo(20));
	}

	@Test
	public void shouldBeAbleToHandleASpare() throws Exception {
		rollASpare();
		game.roll(3);
		rollMany(17, 0);
		assertThat(game.score(), equalTo(16));
	}
	
	@Test
	public void shouldBeAbleToHandleOneStrike() throws Exception {
		rollAStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		assertThat(game.score(), equalTo(24));
	}
	
	@Test
	public void shouldHandleAllStrikes() throws Exception {
		rollMany(12, 10);
		assertThat(game.score(), equalTo(300));
	}

	private void rollAStrike() {
		game.roll(10);
	}

	private void rollASpare() {
		rollMany(2, 5);
	}

}
