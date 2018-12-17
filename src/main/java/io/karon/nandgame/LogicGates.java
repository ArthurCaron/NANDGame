package io.karon.nandgame;

import io.karon.nandgame.arithmetics.Word;


public class LogicGates {

	public static boolean nand(boolean a, boolean b) {
		return !(a && b);
	}

	public static boolean not(boolean input) {
		return nand(input, input);
	}

	public static boolean not() {
		return not(false);
	}

	public static boolean and(boolean a, boolean b) {
		return not(nand(a, b));
	}

	public static boolean or(boolean a, boolean b) {
		return nand(not(a), not(b));
	}

	public static boolean nor(boolean a, boolean b) {
		return not(or(a, b));
	}

	public static boolean xor(boolean a, boolean b) {
		return and(or(a, b), nand(a, b));
	}

	public static boolean xnor(boolean a, boolean b) {
		return not(xor(a, b));
	}

	// Multiplexer
	public static boolean mux(boolean selector, boolean a, boolean b) {
		return or(
				and(not(selector), a), // selects a if selector is 0
				and(selector, b) // selects b if selector is 1
		);
	}

	// Demultiplexer
//	public static Word.w2 dMux(boolean input, boolean selector) {
//		return new Word.w2(
//				and(not(selector), input),
//				and(selector, input)
//		);
//	}

}
