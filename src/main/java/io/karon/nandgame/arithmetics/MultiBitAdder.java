package io.karon.nandgame.arithmetics;

public class MultiBitAdder {

	public static Output add(boolean a1, boolean a0, boolean b1, boolean b0, boolean c) {
		FullAdder.Output add1 = FullAdder.add(a0, b0, c);
		FullAdder.Output add2 = FullAdder.add(a1, b1, add1.h);
		return new Output(
			add2.h,
			add2.l,
			add1.l
		);
	}

	public static class Output {
		boolean c;
		boolean s1;
		boolean s0;

		Output(boolean c, boolean s1, boolean s0) {
			this.c = c;
			this.s1 = s1;
			this.s0 = s0;
		}
	}

	private MultiBitAdder() {
		super();
	}

}
