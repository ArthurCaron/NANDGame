package io.karon.nandgame.memory;

import io.karon.nandgame.arithmetics.Word;
import io.karon.nandgame.plumbing.Multiplexer;
import io.karon.nandgame.plumbing.Switch;


public class RAM {

	private Register[] registers;

	public RAM(int nbRegisters, int sizeRegister) {
		nbRegisters = 2; // FOR NOW

		registers = new Register[nbRegisters];
		for (int i = 0; i < registers.length; ++i) {
			registers[i] = new Register(sizeRegister);
		}
	}

	public Word ram(boolean ad, boolean st, Word x, boolean cl) {
		Switch.Output switchOutput = Switch.switchChan(ad, st);

		Word register1Word = registers[1].register(switchOutput.c1, x, cl);
		Word register0Word = registers[0].register(switchOutput.c0, x, cl);

		return Multiplexer.select16(
				ad,
				register1Word,
				register0Word
		);
	}

}
