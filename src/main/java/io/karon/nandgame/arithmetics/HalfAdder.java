package io.karon.nandgame.arithmetics;

import static io.karon.nandgame.LogicGates.*;


class HalfAdder {

	static Output add(boolean a, boolean b) {
		return new Output(
				and(a, b),
				xor(a, b)
		);
	}

	static class Output {
		boolean h;
		boolean l;

		Output(boolean h, boolean l) {
			this.h = h;
			this.l = l;
		}
	}

	private HalfAdder() {
		super();
	}

}
