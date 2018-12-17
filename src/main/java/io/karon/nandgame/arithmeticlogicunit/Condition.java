package io.karon.nandgame.arithmeticlogicunit;

import static io.karon.nandgame.LogicGates.*;

import io.karon.nandgame.arithmetics.EqualToZero;
import io.karon.nandgame.arithmetics.LessThanZero;
import io.karon.nandgame.arithmetics.Word;


public class Condition {

	public static boolean condition(Flags flags, Word x) {
		boolean isNeg = LessThanZero.isNeg(x);
		boolean isZero = EqualToZero.isZero(x);

		boolean isNotNeg = not(isNeg);
		boolean isNotZero = not(isZero);

		return or (
				or(
						and(flags.lt, and(isNeg, isNotZero)),
						and(flags.eq, isZero)
				),
				or(
						and(flags.eq, isZero),
						and(flags.gt, and(isNotNeg, isNotZero))
				)
		);
	}

	public static class Flags {
		boolean lt;
		boolean eq;
		boolean gt;

		public Flags(boolean lt, boolean eq, boolean gt) {
			this.lt = lt;
			this.eq = eq;
			this.gt = gt;
		}
	}

}
