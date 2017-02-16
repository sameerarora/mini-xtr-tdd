package com.fidelity.game;

public class Game {

	private static final int TOTAL_FRAMES = 10;

	private static final int TEN = 10;

	private int score = 0;

	private int[] rolls = new int[21];

	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public Integer score() {
		int firstRoll = 0;
		for (int frame = 0; frame < TOTAL_FRAMES; frame++) {
			if (isStrike(firstRoll)) {
				score += TEN + nextTwoBalls(firstRoll);
				firstRoll++;
			} else {
				if (isSpare(firstRoll)) {
					score += TEN + nextBall(firstRoll);
				} else {
					score += bothBallsInAFrame(firstRoll);
				}
				firstRoll += 2;
			}
		}
		return score;
	}

	private boolean isStrike(int i) {
		return rolls[i] == TEN;
	}

	private int bothBallsInAFrame(int i) {
		return rolls[i] + rolls[i + 1];
	}

	private int nextTwoBalls(int i) {
		return rolls[i + 1] + rolls[i + 2];
	}

	private int nextBall(int i) {
		return rolls[i + 2];
	}

	private boolean isSpare(int i) {
		return bothBallsInAFrame(i) == 10;
	}

}
