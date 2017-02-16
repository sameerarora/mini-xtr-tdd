package com.xke.bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GameTest {

	private Game game;

	@Before
	public void setUp() {
		game = new Game();
	}
	
	@Test
	public void shouldBeAbleToScoreAComplicatedGame() throws Exception {
		rollMany(18, 0);
		game.roll(5);
		game.roll(5);
		game.roll(10);
		assertEquals(20, game.score());
	}
	
	@Test
	public void shouldScoreAPerfectGame() throws Exception {
		rollMany(12, 10);
		assertEquals(300, game.score());
	}
	
	
	@Test
	public void shouldBeAbleToScoreAStrike() throws Exception {
		game.roll(10);
		game.roll(4);
		game.roll(3);
		rollMany(16, 0);
		assertEquals(24, game.score());
	}

	@Test
	public void shouldBeAbleToScoreASpare() throws Exception {
		game.roll(5);
		game.roll(5);
		game.roll(3);
		rollMany(17, 0);
		assertEquals(16, game.score());
	}

	@Test
	public void shouldScoreAllOnes() throws Exception {
		rollMany(20, 1);
		assertEquals(20, game.score());
	}

	@Test
	public void shouldScoreAGutterGame() throws Exception {
		rollMany(20, 0);
		assertEquals(0, game.score());
	}

	@Test
	public void shouldBeAbleToRoll() throws Exception {
		game.roll(-1);
	}

	@Test
	public void shouldBeScoredAtZeroInitially() throws Exception {
		assertEquals(0, game.score());
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
			game.roll(pins);
		}
	}

}
