

public class Member {

	/** 
	 * @uml.property name="state"
	 * @uml.associationEnd aggregation="shared" inverse="member:State"
	 */
	private State state;

	/** 
	 * Getter of the property <tt>state</tt>
	 * @return  Returns the state.
	 * @uml.property  name="state"
	 */
	public State getState() {
		return state;
	}

	/** 
	 * Setter of the property <tt>state</tt>
	 * @param state  The state to set.
	 * @uml.property  name="state"
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @uml.property  name="name"
	 */
	private String name;

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @uml.property  name="address"
	 */
	private String address;

	/**
	 * Getter of the property <tt>address</tt>
	 * @return  Returns the address.
	 * @uml.property  name="address"
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter of the property <tt>address</tt>
	 * @param address  The address to set.
	 * @uml.property  name="address"
	 */
	public void setAddress(String address) {
		this.address = address;
	}

		
		/**
		 */
		public void setStatus(){
		}

		/**
		 * @uml.property  name="currentStatus"
		 */
		private State currentStatus;

		/**
		 * Getter of the property <tt>currentStatus</tt>
		 * @return  Returns the currentStatus.
		 * @uml.property  name="currentStatus"
		 */
		public State getCurrentStatus() {
			return currentStatus;
		}

		/**
		 * Setter of the property <tt>currentStatus</tt>
		 * @param currentStatus  The currentStatus to set.
		 * @uml.property  name="currentStatus"
		 */
		public void setCurrentStatus(State currentStatus) {
			this.currentStatus = currentStatus;
		}

		/**
		 * @uml.property  name="currentState"
		 */
		private State currentState;

		/**
		 * Getter of the property <tt>currentState</tt>
		 * @return  Returns the currentState.
		 * @uml.property  name="currentState"
		 */
		public State getCurrentState() {
			return currentState;
		}

		/**
		 * Setter of the property <tt>currentState</tt>
		 * @param currentState  The currentState to set.
		 * @uml.property  name="currentState"
		 */
		public void setCurrentState(State currentState) {
			this.currentState = currentState;
		}

		/**
		 * @uml.property  name="state1"
		 * @uml.associationEnd  aggregation="shared" inverse="member:State"
		 */
		private State state1;

		/**
		 * Getter of the property <tt>state1</tt>
		 * @return  Returns the state1.
		 * @uml.property  name="state1"
		 */
		public State getState1() {
			return state1;
		}

		/**
		 * Setter of the property <tt>state1</tt>
		 * @param state1  The state1 to set.
		 * @uml.property  name="state1"
		 */
		public void setState1(State state1) {
			this.state1 = state1;
		}

		/**
		 * @uml.property  name="staff"
		 * @uml.associationEnd  aggregation="shared" inverse="member:Staff"
		 */
		private Staff staff;

		/**
		 * Getter of the property <tt>staff</tt>
		 * @return  Returns the staff.
		 * @uml.property  name="staff"
		 */
		public Staff getStaff() {
			return staff;
		}

		/**
		 * Setter of the property <tt>staff</tt>
		 * @param staff  The staff to set.
		 * @uml.property  name="staff"
		 */
		public void setStaff(Staff staff) {
			this.staff = staff;
		}

		/**
		 * @uml.property  name="staffhead"
		 * @uml.associationEnd  aggregation="shared" inverse="member:Staffhead"
		 */
		private Staffhead staffhead;

		/**
		 * Getter of the property <tt>staffhead</tt>
		 * @return  Returns the staffhead.
		 * @uml.property  name="staffhead"
		 */
		public Staffhead getStaffhead() {
			return staffhead;
		}

		/**
		 * Setter of the property <tt>staffhead</tt>
		 * @param staffhead  The staffhead to set.
		 * @uml.property  name="staffhead"
		 */
		public void setStaffhead(Staffhead staffhead) {
			this.staffhead = staffhead;
		}

		/**
		 * @uml.property  name="test"
		 * @uml.associationEnd  aggregation="shared" inverse="member:test"
		 */

}
