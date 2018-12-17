package io.karon.nandgame.memory;

import io.karon.nandgame.arithmetics.Word;
import io.karon.nandgame.plumbing.Multiplexer;
import io.karon.nandgame.plumbing.Switch;


public class ROM {

	private Register[] registers;

	public ROM(int nbRegisters, int sizeRegister) {
		nbRegisters = 2; // FOR NOW

		registers = new Register[nbRegisters];
		for (int i = 0; i < registers.length; ++i) {
			registers[i] = new Register(sizeRegister);
		}

		// load registers
	}

	public Word rom(Word ad) {
		return ad; // should return the word in rom memory (the registers) depending on the address
	}
}
