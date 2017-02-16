package com.fidelity.game;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

	private Game game;

	@Before
	public void setUp() {
		game = new Game();
	}

	public void rollMany(int numberOfRolls, int pins) {
		for (int i = 0; i < numberOfRolls; i++) {
			game.roll(pins);
		}
	}

	private void rollASpare() {
		game.roll(5);
		game.roll(5);
	}
	
	private void rollAStrike() {
		game.roll(10);
	}

	@Test
	public void shouldHandleARoll() throws Exception {
		game.roll(0);
	}

	@Test
	public void shouldScoreAGutterGame() throws Exception {
		rollMany(20, 0);
		assertThat(game.score(), equalTo(0));
	}

	@Test
	public void shouldHandleAllOnes() throws Exception {
		rollMany(20, 1);
		assertThat(game.score(), equalTo(20));
	}

	@Test
	public void shouldHandleASpare() throws Exception {
		rollASpare();
		game.roll(3);
		rollMany(17, 0);
		assertThat(game.score(), equalTo(16));
	}

	@Test
	public void shouldHandleAStrike() throws Exception {
		rollAStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		assertThat(game.score(), equalTo(24));
	}
	
	@Test
	public void shouldHandleTwoStrikes() throws Exception {
		rollAStrike();
		game.roll(3);
		game.roll(4);
		rollAStrike();
		game.roll(1);
		rollMany(13, 0);
		assertThat(game.score(), equalTo(36));
	}

	@Test
	public void shouldHandleAllStrikes() throws Exception {
		rollMany(12, 10);
		assertThat(game.score(), equalTo(300));
	}

}
