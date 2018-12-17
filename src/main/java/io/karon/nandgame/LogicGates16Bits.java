package io.karon.nandgame;

import java.util.function.BiFunction;
import java.util.function.Function;

import io.karon.nandgame.arithmetics.Word;


public class LogicGates16Bits {

	public static Word nand16(Word a, Word b) {
		return apply(a, b, LogicGates::nand);
	}

	public static Word not16(Word a) {
		return apply(a, LogicGates::not);
	}

	public static Word and16(Word a, Word b) {
		return apply(a, b, LogicGates::and);
	}

	public static Word or16(Word a, Word b) {
		return apply(a, b, LogicGates::or);
	}

	public static Word nor16(Word a, Word b) {
		return apply(a, b, LogicGates::nor);
	}

	public static Word xor16(Word a, Word b) {
		return apply(a, b, LogicGates::xor);
	}

	public static Word xnor16(Word a, Word b) {
		return apply(a, b, LogicGates::xnor);
	}

	public static Word mux16(boolean selector, Word a, Word b) {
		Word word = new Word();

		for (int i = 0; i < word.bits.length; ++i) {
			word.bits[i] = LogicGates.mux(selector, a.bits[i], b.bits[i]);
		}

		return word;
	}

	private static Word apply(Word a, Function<Boolean, Boolean> function) {
		Word word = new Word();

		for (int i = 0; i < word.bits.length; ++i) {
			word.bits[i] = function.apply(a.bits[i]);
		}

		return word;
	}

	private static Word apply(Word a, Word b, BiFunction<Boolean, Boolean, Boolean> function) {
		Word word = new Word();

		for (int i = 0; i < word.bits.length; ++i) {
			word.bits[i] = function.apply(a.bits[i], b.bits[i]);
		}

		return word;
	}

}
