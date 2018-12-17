package io.karon.nandgame.arithmetics;

public class Word {

	// Make sure every part of the code can adapt to the number of bits we decide upon instead of letting them all set any number of bit word

	public boolean[] bits;

	public Word() {
		this(16);
	}

	public Word(int size) {
		this.bits = new boolean[size];
	}

	public Word(boolean... bits) {
		this.bits = bits;
	}

	public static Word getAllZero() {
		return new Word();
	}

	public static Word getAllOne() {
		return new Word(
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true
		);
	}
}
