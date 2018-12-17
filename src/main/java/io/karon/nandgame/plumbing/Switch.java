package io.karon.nandgame.plumbing;

import static io.karon.nandgame.LogicGates.*;

public class Switch {

	public static Output switchChan(boolean s, boolean d) {
		return new Output(
				and(s, d),
				and(not(s), d)
		);
	}

	public static class Output {
		public boolean c1;
		public boolean c0;

		Output(boolean c1, boolean c0) {
			this.c1 = c1;
			this.c0 = c0;
		}
	}

}
