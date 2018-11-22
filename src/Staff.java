import java.util.*;
public class Staff extends Booklist {

	/**
	 * @uml.property  name="member"
	 * @uml.associationEnd  inverse="staff:Member"
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
		public int returnbook(long isbn, State rt_person){
			//ここで返却手続き
		    //Booklistのdeadline＜Long, Long＞を扱う
			//返却ならエントリを消去、貸し出しならエントリを作成
			if (deadlineList.get(isbn) != null){
				deadlineList.remove(isbn);
			}
			return 0;
		}

}
