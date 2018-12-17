package io.karon.nandgame.arithmetics;

import static io.karon.nandgame.LogicGates.*;

public class EqualToZero {

	public static boolean isZero(Word word) {
		boolean result;

		result = or(word.bits[0], word.bits[1]);
		result = or(result, word.bits[2]);
		result = or(result, word.bits[3]);
		result = or(result, word.bits[4]);
		result = or(result, word.bits[5]);
		result = or(result, word.bits[6]);
		result = or(result, word.bits[7]);
		result = or(result, word.bits[8]);
		result = or(result, word.bits[9]);
		result = or(result, word.bits[10]);
		result = or(result, word.bits[11]);
		result = or(result, word.bits[12]);
		result = or(result, word.bits[13]);
		result = or(result, word.bits[14]);
		result = or(result, word.bits[15]);

		return not(result);
	}

}
