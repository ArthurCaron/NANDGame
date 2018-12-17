package io.karon.nandgame.arithmetics;

import static io.karon.nandgame.LogicGates.*;


class FullAdder {

	static Output add(boolean a, boolean b, boolean c) {
		HalfAdder.Output add1 = HalfAdder.add(a, b);
		HalfAdder.Output add2 = HalfAdder.add(add1.l, c);
		return new Output(
				or(add1.h, add2.h),
				add2.l
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

	private FullAdder() {
		super();
	}

}
