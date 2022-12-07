public final class WrapAroundDetection {
	public static boolean willCauseWrapAroundWhenAdded(int untrust_num1, int untrust_num2) {
		return ((untrust_num1 > 0) && (untrust_num2 > 0) 
				&& willCauseWrapAroundWhenAddingPositives(untrust_num1, untrust_num2))
			|| ((untrust_num1 < 0) && (untrust_num2 < 0)
				&& willCauseWrapAroundWhenAddingNegatives(untrust_num1, untrust_num2));
	}

	private static boolean willCauseWrapAroundWhenAddingPositives(final int untrust_positive1, final int untrust_positive2) {
            // max possible 2147483647
		//untrust_positive1 == 3
            // 0 < untrust_positive2 <= 2147483647 - untrust_positive1
		final int maxAllowedForPositive2 = Integer.MAX_VALUE - untrust_positive1;
		return (untrust_positive2 > maxAllowedForPositive2);
	}

	private static boolean willCauseWrapAroundWhenAddingNegatives(final int untrust_negative1, final int untrust_negative2) {
            // min possible -2147483648
		//untrust_negative1 == -1
            // -2147483648 - untrust_negative1 <= untrust_negative2 < 0
		final int minAllowedForNegative2 = Integer.MIN_VALUE - untrust_negative1;
		return (untrust_negative2 < minAllowedForNegative2);
	}
}
