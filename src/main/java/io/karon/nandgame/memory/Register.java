package io.karon.nandgame.memory;

import io.karon.nandgame.arithmetics.Word;


public class Register {

	private DataFlipFlop[] dataFlipFlops;
	public Word lastOutput;

	public Register(int size) {
		dataFlipFlops = new DataFlipFlop[size];
		lastOutput = Word.getAllZero();
	}

	public Word register(boolean st, Word word, boolean cl) {
		Word output = new Word(word.bits.length);

		for (int i = 0; i < dataFlipFlops.length && i < word.bits.length; ++i) {
			output.bits[i] = dataFlipFlops[i].dff(st, word.bits[i], cl);
		}

		lastOutput = output;
		return output;
	}

}
