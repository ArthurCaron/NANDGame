package io.karon.nandgame.arithmetics;

import static io.karon.nandgame.arithmetics.FullAdder.*;

public class WordAdder {

	public static Word add16(Word word1, Word word2) {
		Output output0 = add(word1.bits[0], word2.bits[0], false);
		Output output1 = add(word1.bits[1], word2.bits[1], output0.h);
		Output output2 = add(word1.bits[2], word2.bits[2], output1.h);
		Output output3 = add(word1.bits[3], word2.bits[3], output2.h);
		Output output4 = add(word1.bits[4], word2.bits[4], output3.h);
		Output output5 = add(word1.bits[5], word2.bits[5], output4.h);
		Output output6 = add(word1.bits[6], word2.bits[6], output5.h);
		Output output7 = add(word1.bits[7], word2.bits[7], output6.h);
		Output output8 = add(word1.bits[8], word2.bits[8], output7.h);
		Output output9 = add(word1.bits[9], word2.bits[9], output8.h);
		Output output10 = add(word1.bits[10], word2.bits[10], output9.h);
		Output output11 = add(word1.bits[11], word2.bits[11], output10.h);
		Output output12 = add(word1.bits[12], word2.bits[12], output11.h);
		Output output13 = add(word1.bits[13], word2.bits[13], output12.h);
		Output output14 = add(word1.bits[14], word2.bits[14], output13.h);
		Output output15 = add(word1.bits[15], word2.bits[15], output14.h);

		// rest (output15.h) is ignored
		return new Word(
				output15.l,
				output14.l,
				output13.l,
				output12.l,
				output11.l,
				output10.l,
				output9.l,
				output8.l,
				output7.l,
				output6.l,
				output5.l,
				output4.l,
				output3.l,
				output2.l,
				output1.l,
				output0.l
		);
	}

}
