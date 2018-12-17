package io.karon.nandgame.arithmeticlogicunit;

import io.karon.nandgame.LogicGates;
import io.karon.nandgame.arithmetics.Word;
import io.karon.nandgame.arithmetics.WordAdder;
import io.karon.nandgame.arithmetics.WordInvert;
import io.karon.nandgame.plumbing.Multiplexer;


public class ALU {

	public static Word alu(Flags flags, Word x, Word y) {
		Word wordX = UnaryALU.unaryAlu(flags.zx, flags.nx, x);
		Word wordY = UnaryALU.unaryAlu(flags.zy, flags.ny, y);

		Word selectedWord = Multiplexer.select16(
				flags.f,
				WordAdder.add16(wordX, wordY),
				LogicGates.and16(wordX, wordY)
		);

		return Multiplexer.select16(
				flags.no,
				WordInvert.inv16(selectedWord),
				selectedWord
		);
	}

	public static class Flags {
		public boolean zx;
		public boolean nx;
		public boolean zy;
		public boolean ny;
		public boolean f;
		public boolean no;

		public Flags(boolean zx, boolean nx, boolean zy, boolean ny, boolean f, boolean no) {
			this.zx = zx;
			this.nx = nx;
			this.zy = zy;
			this.ny = ny;
			this.f = f;
			this.no = no;
		}
	}

}
