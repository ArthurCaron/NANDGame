package io.karon.nandgame.arithmetics;

public class WordIncrement {

	public static Word inc16(Word word) {
		return WordSubstraction.sub16(
				word,
				WordInvert.inv16(
						Word.getAllZero()
				)
		);
	}

}
