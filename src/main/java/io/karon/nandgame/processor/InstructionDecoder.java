package io.karon.nandgame.processor;

import static io.karon.nandgame.LogicGates.*;

import io.karon.nandgame.arithmetics.Word;
import io.karon.nandgame.plumbing.Multiplexer;
import io.karon.nandgame.plumbing.Splitter;


public class InstructionDecoder {

	public static Output instructionDecoder(Word word) {
		boolean bit15 = Splitter.splitter(word, 15);

		Word selectedWord = Multiplexer.select16(bit15, word, Word.getAllZero());

		return new Output(
				new Output.Flags(
						Splitter.splitter(selectedWord, 15),
						Splitter.splitter(selectedWord, 12),
						Splitter.splitter(selectedWord, 11),
						Splitter.splitter(selectedWord, 10),
						Splitter.splitter(selectedWord, 9),
						Splitter.splitter(selectedWord, 8),
						Splitter.splitter(selectedWord, 7),
						Splitter.splitter(selectedWord, 6),
						or(
								Splitter.splitter(selectedWord, 5),
								not(bit15)
						),
						Splitter.splitter(selectedWord, 4),
						Splitter.splitter(selectedWord, 3),
						Splitter.splitter(selectedWord, 2),
						Splitter.splitter(selectedWord, 1),
						Splitter.splitter(selectedWord, 0)
				),
				Multiplexer.select16(bit15, Word.getAllZero(), word)
		);
	}

	public static class Output {
		public Flags flags;
		public Word word;

		public Output(Flags flags, Word word) {
			this.flags = flags;
			this.word = word;
		}

		public static class Flags {
			public boolean ci;
			public boolean sm;
			public boolean zx;
			public boolean nx;
			public boolean zy;
			public boolean ny;
			public boolean f;
			public boolean no;
			public boolean a;
			public boolean d;
			public boolean aStar;
			public boolean gt;
			public boolean eq;
			public boolean lt;

			public Flags(
					boolean ci,
					boolean sm,
					boolean zx,
					boolean nx,
					boolean zy,
					boolean ny,
					boolean f,
					boolean no,
					boolean a,
					boolean d,
					boolean aStar,
					boolean gt,
					boolean eq,
					boolean lt) {
				this.ci = ci;
				this.sm = sm;
				this.zx = zx;
				this.nx = nx;
				this.zy = zy;
				this.ny = ny;
				this.f = f;
				this.no = no;
				this.a = a;
				this.d = d;
				this.aStar = aStar;
				this.gt = gt;
				this.eq = eq;
				this.lt = lt;
			}
		}
	}

}
