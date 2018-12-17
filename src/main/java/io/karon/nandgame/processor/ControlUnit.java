package io.karon.nandgame.processor;

import io.karon.nandgame.arithmeticlogicunit.ALU;
import io.karon.nandgame.arithmeticlogicunit.Condition;
import io.karon.nandgame.arithmetics.Word;
import io.karon.nandgame.plumbing.Multiplexer;


public class ControlUnit {

	public CombinedMemory combinedMemory;

	public ControlUnit() {
		this.combinedMemory = new CombinedMemory();
	}

	public Output controlUnit(Word I, boolean cl) {
		InstructionDecoder.Output instruction = InstructionDecoder.instructionDecoder(I);

		Word select0 = Multiplexer.select16(
				instruction.flags.sm,
				combinedMemory.previousOutput.aStar,
				combinedMemory.previousOutput.a
		);

		Word alu = ALU.alu(
				new ALU.Flags(
						instruction.flags.zx,
						instruction.flags.nx,
						instruction.flags.zy,
						instruction.flags.ny,
						instruction.flags.f,
						instruction.flags.no
				),
				combinedMemory.previousOutput.d,
				select0
		);

		Word select1 = Multiplexer.select16(
				instruction.flags.ci,
				alu,
				instruction.word
		);

		combinedMemory.combinedMemory(
				new CombinedMemory.Flags(
						instruction.flags.a,
						instruction.flags.d,
						instruction.flags.aStar
				),
				select1,
				cl
		);

		boolean conditionJ = Condition.condition(
				new Condition.Flags(
						instruction.flags.lt,
						instruction.flags.eq,
						instruction.flags.gt
				),
				alu
		);

		return new Output(
				conditionJ,
				combinedMemory.previousOutput.a
		);
	}

	public class Output {
		public boolean j;
		public Word a;

		public Output(boolean j, Word a) {
			this.j = j;
			this.a = a;
		}
	}

}
