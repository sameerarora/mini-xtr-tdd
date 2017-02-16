package com.xke.bowling;

public class Game {

	private static final int PERFECT_TEN = 10;

	int[] rolls = new int[21];

	private int currentIndex = 0;

	public void roll(int pins) {
		rolls[currentIndex++] = pins;
	}

	public int score() {
		int score = 0;
		int i = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isSpare(i)) {
				score += PERFECT_TEN + firstBallInTheNextFrame(i);
				i += 2;
			} else if (isStrike(i)) {
				score += PERFECT_TEN + nextTwoBallsInFrame(i);
				i++;
			} else {
				score += bothBallsInAFrame(i);
				i += 2;
			}

		}
		return score;
	}

	private int bothBallsInAFrame(int i) {
		return rolls[i] + rolls[i + 1];
	}

	private int nextTwoBallsInFrame(int i) {
		return rolls[i + 1] + rolls[i + 2];
	}

	private int firstBallInTheNextFrame(int i) {
		return rolls[i + 2];
	}

	private boolean isStrike(int i) {
		return rolls[i] == PERFECT_TEN;
	}

	private boolean isSpare(int i) {
		return bothBallsInAFrame(i) == 10;
	}

}
