package io.karon.nandgame.arithmetics;


public class WordSubstraction {

	public static Word sub16(Word word1, Word word2) {
		return WordInvert.inv16(
				WordAdder.add16(
						WordInvert.inv16(word1),
						word2
				)
		);
	}

}
