

public abstract class State {

		
			
			
			public void rentBook(){
			}

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
			 * @uml.property  name="member"
			 * @uml.associationEnd  inverse="state1:Member"
			 */
			private Member member;

			/**
			 * Getter of the property <tt>member</tt>
			 * @return  Returns the member.
			 * @uml.property  name="member"
			 */
			public Member getMember() {
				return member;
			}

			/**
			 * Setter of the property <tt>member</tt>
			 * @param member  The member to set.
			 * @uml.property  name="member"
			 */
			public void setMember(Member member) {
				this.member = member;
			}

				
				/**
				 */
				public int deadline(){
					return 0;
				}

				/**
				 * @uml.property  name="deadline"
				 */
				private int deadline;

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
				 * @uml.property  name="fine"
				 */
				public int fine;

				/**
				 * Getter of the property <tt>fine</tt>
				 * @return  Returns the fine.
				 * @uml.property  name="fine"
				 */
				public int getFine() {
					return fine;
				}

				/**
				 * Setter of the property <tt>fine</tt>
				 * @param fine  The fine to set.
				 * @uml.property  name="fine"
				 */
				public void setFine(int fine) {
					this.fine = fine;
				}

}
