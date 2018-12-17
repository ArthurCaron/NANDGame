package io.karon.nandgame.processor;

import io.karon.nandgame.arithmetics.Word;


public class Computer {

	private ProgramEngine programEngine;
	private ControlUnit controlUnit;
	private Word instruction;
	private ControlUnit.Output result;

	public Computer() {
		programEngine = new ProgramEngine();
		controlUnit = new ControlUnit();

		instruction = programEngine.programEngine(true, Word.getAllZero(), false);
	}

	public void run(boolean clock) {
		result = controlUnit.controlUnit(instruction, clock);
		instruction = programEngine.programEngine(result.j, result.a, clock);
	}

}
