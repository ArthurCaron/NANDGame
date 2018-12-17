package io.karon.nandgame.processor;

import io.karon.nandgame.arithmetics.Word;
import io.karon.nandgame.memory.RAM;
import io.karon.nandgame.memory.Register;


public class CombinedMemory {

	private RAM ram;
	private Register registerA;
	private Register registerD;
	public Output previousOutput;

	public CombinedMemory() {
		ram = new RAM(4);
		registerA = new Register(16);
		registerD = new Register(16);
	}

	public Output combinedMemory(Flags flags, Word x, boolean cl) {
		previousOutput = new Output(
				registerA.register(flags.a, x, cl),
				registerD.register(flags.d, x, cl),
				ram.ram(registerA.lastOutput, flags.aStar, x, cl)
		);
		return previousOutput;
	}

	public static class Flags {
		public boolean a;
		public boolean d;
		public boolean aStar;

		public Flags(boolean a, boolean d, boolean aStar) {
			this.a = a;
			this.d = d;
			this.aStar = aStar;
		}
	}

	public static class Output {
		public Word a;
		public Word d;
		public Word aStar;

		public Output(Word a, Word d, Word aStar) {
			this.a = a;
			this.d = d;
			this.aStar = aStar;
		}
	}

}
