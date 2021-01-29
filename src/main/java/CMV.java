/**
 * This class implements the CMV (Conditions Met Vector).
 */
public class CMV {

	// The parameters.
	private Parameters parameters;
	// The conditions met vector.
	private boolean[] cmv = new boolean[15];

	/**
	 * Creates a CMV with input parameters.
	 * 
	 * @param param the parameter instance.
	 */
	public CMV(Parameters param) {
		this.parameters = param;
	}

	/**
	 * Populates the cmv vector, i.e. goes through all LICs.
	 * 
	 * This function needs to be called before get().
	 */
	public void populate() {
		// TODO: Implementation
	}

	/**
	 * Returns the populated cmv vector.
	 * 
	 * Note that vector is empty before you call populate().
	 * 
	 * @return the populated vector.
	 */
	public boolean[] get() {
		return this.cmv;
	}

	// -----------------------------------------
	// LIC condition functions below

	/**
	 * Computes the LIC 0 condition.
	 */
	private boolean LIC0() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 1 condition.
	 */
	private boolean LIC1() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 2 condition.
	 */
	private boolean LIC2() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 3 condition.
	 */
	private boolean LIC3() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 4 condition.
	 */
	private boolean LIC4() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 5 condition.
	 */
	private boolean LIC5() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 6 condition.
	 */
	private boolean LIC6() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 7 condition.
	 */
	private boolean LIC7() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 8 condition.
	 */
	private boolean LIC8() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 9 condition.
	 */
	private boolean LIC9() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 10 condition.
	 */
	private boolean LIC10() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 11 condition.
	 */
	private boolean LIC11() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 12 condition.
	 */
	private boolean LIC12() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 13 condition.
	 */
	private boolean LIC13() {
		// TODO: Implementation.
		return false;
	}

	/**
	 * Computes the LIC 14 condition.
	 */
	private boolean LIC14() {
		// TODO: Implementation.
		return false;
	}
}