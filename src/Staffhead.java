

public class Staffhead extends Staff {

	/**
	 * @uml.property  name="member"
	 * @uml.associationEnd  inverse="staffhead:Member"
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
	public void purchasebook(Booklist booklist, int numOfPurchase){
		booklist.purchasefromList(numOfPurchase);//booklist 内のメソッドで購入を済ませる
	}
	public void deletebook(Booklist booklist, String isbn){
		booklist.deletefromList(isbn);
	}

}
