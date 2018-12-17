package io.karon.nandgame.plumbing;

import static io.karon.nandgame.LogicGates.*;

import io.karon.nandgame.arithmetics.Word;


public class Multiplexer {

	public static boolean select(boolean s, boolean d1, boolean d0) {
		return or(
				and(s, d1),
				and(not(s), d0)
		);
	}

	public static Word select16(boolean s, Word d1, Word d0) {
		Word word = new Word(d1.bits.length);

		for (int i = 0; i < d1.bits.length; ++i) {
			word.bits[i] = select(s, d1.bits[i], d0.bits[i]);
		}

		return word;
	}

}
