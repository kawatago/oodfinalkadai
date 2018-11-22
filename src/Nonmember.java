

public class Nonmember extends State {

	/**
	 * @uml.property  name="rentlimit"
	 */
	private int rentlimit;

	/**
	 * Getter of the property <tt>rentlimit</tt>
	 * @return  Returns the rentlimit.
	 * @uml.property  name="rentlimit"
	 */
	public int getRentlimit() {
		return rentlimit;
	}

	/**
	 * Setter of the property <tt>rentlimit</tt>
	 * @param rentlimit  The rentlimit to set.
	 * @uml.property  name="rentlimit"
	 */
	public void setRentlimit(int rentlimit) {
		this.rentlimit = rentlimit;
	}

	/**
	 * @uml.property  name="deadline"
	 */
	private int deadline = 0;

	/**
	 * Getter of the property <tt>deadline</tt>
	 * @return  Returns the deadline.
	 * @uml.property  name="deadline"
	 */
	public int getDeadline() {
		return deadline;
	}

	/**
	 * Setter of the property <tt>deadline</tt>
	 * @param deadline  The deadline to set.
	 * @uml.property  name="deadline"
	 */
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	/**
	 * @uml.property  name="fine" readOnly="true"
	 */
	private final int fine = 0;

	/**
	 * Getter of the property <tt>fine</tt>
	 * @return  Returns the fine.
	 * @uml.property  name="fine"
	 */
	public int getFine() {
		return fine;
	}

}
