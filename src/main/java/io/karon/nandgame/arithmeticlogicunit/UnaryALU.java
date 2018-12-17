package io.karon.nandgame.arithmeticlogicunit;

import io.karon.nandgame.arithmetics.Word;
import io.karon.nandgame.arithmetics.WordInvert;
import io.karon.nandgame.plumbing.Multiplexer;


public class UnaryALU {

	public static Word unaryAlu(boolean z, boolean n, Word x) {
		Word word = Multiplexer.select16(
				z,
				Word.getAllZero(),
				x
		);

		return Multiplexer.select16(
				n,
				WordInvert.inv16(word),
				word
		);
	}

}
