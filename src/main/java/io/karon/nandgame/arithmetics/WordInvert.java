package io.karon.nandgame.arithmetics;

import static io.karon.nandgame.LogicGates.*;


public class WordInvert {

	public static Word inv16(Word word) {
		return new Word(
				not(word.bits[15]),
				not(word.bits[14]),
				not(word.bits[13]),
				not(word.bits[12]),
				not(word.bits[11]),
				not(word.bits[10]),
				not(word.bits[9]),
				not(word.bits[8]),
				not(word.bits[7]),
				not(word.bits[6]),
				not(word.bits[5]),
				not(word.bits[4]),
				not(word.bits[3]),
				not(word.bits[2]),
				not(word.bits[1]),
				not(word.bits[0])
		);
	}

}
