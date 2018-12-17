package io.karon.nandgame.memory;

import static io.karon.nandgame.LogicGates.*;

import io.karon.nandgame.arithmetics.Word;
import io.karon.nandgame.arithmetics.WordIncrement;
import io.karon.nandgame.plumbing.Multiplexer;


public class Counter {

	private Register register;

	public Counter(int size) {
		register = new Register(size);
	}

	public Word counter(boolean st, Word word, boolean cl) {
		Word selectOutput = Multiplexer.select16(
				st,
				word,
				WordIncrement.inc16(register.lastOutput)
		);

		return register.register(
				not(),
				selectOutput,
				cl
		);
	}

}
