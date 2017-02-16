package com.fidelity.bowling;

public class Game {

	private static final int TOTAL_FRAMES = 10;

	private static final int PERFECT_10 = 10;

	private int[] rolls = new int[21];

	private int currentRoll = 0;

	private int score = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public Integer score() {
		int firstInFrame = 0;
		for (int frame = 0; frame < TOTAL_FRAMES; frame++) {
			if (isAStrike(firstInFrame)) {
				score += PERFECT_10 + nextTwoBallsInAStrike(firstInFrame);
				firstInFrame++;
			} else {
				if (isASpare(firstInFrame)) {
					score += PERFECT_10 + nextBallInASpare(firstInFrame);
				} else {
					score += twoBallsInAFrame(firstInFrame);
				}
				firstInFrame += 2;
			}
		}
		return score;
	}

	private int twoBallsInAFrame(int firstInFrame) {
		return rolls[firstInFrame] + rolls[firstInFrame + 1];
	}

	private int nextBallInASpare(int firstInFrame) {
		return rolls[firstInFrame + 2];
	}

	private int nextTwoBallsInAStrike(int firstInFrame) {
		int nextTwoBallsInAStrike = rolls[firstInFrame + 1] + nextBallInASpare(firstInFrame);
		return nextTwoBallsInAStrike;
	}

	private boolean isAStrike(int firstInFrame) {
		return rolls[firstInFrame] == PERFECT_10;
	}

	private boolean isASpare(int firstBallInFrame) {
		return twoBallsInAFrame(firstBallInFrame) == PERFECT_10;
	}

}
