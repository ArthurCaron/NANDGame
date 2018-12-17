package io.karon.nandgame.memory;

import io.karon.nandgame.plumbing.Multiplexer;


public class Latch {

	private boolean out = false;

	public boolean latch(boolean st, boolean d) {
		out = Multiplexer.select(st, d, out);
		return out;
	}

}
