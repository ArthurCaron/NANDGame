package io.karon.nandgame.memory;

import static io.karon.nandgame.LogicGates.*;

public class DataFlipFlop {

	private Latch latch0 = new Latch();
	private Latch latch1 = new Latch();

	public boolean dff(boolean st, boolean d, boolean cl) {
		return latch1.latch(
				cl,
				latch0.latch(
						and(
								st,
								not(cl)
						),
						d
				)
		);
	}

}
