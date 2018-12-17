package io.karon.nandgame.processor;

import io.karon.nandgame.arithmetics.Word;
import io.karon.nandgame.memory.Counter;
import io.karon.nandgame.memory.ROM;


public class ProgramEngine {

	private ROM rom;
	private Counter counter;

	public ProgramEngine() {
		this.rom = new ROM(7, 16);
		// Maybe load rom data here
		this.counter = new Counter(16);
	}

	public Word programEngine(boolean j, Word ad, boolean cl) {
		return rom.rom(
				counter.counter(j, ad, cl)
		);
	}

}
