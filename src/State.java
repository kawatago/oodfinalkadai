

public abstract class State {
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){//名前の変更,setting(name, address)から呼び出す
		this.name = name;
	}
	public void setAdress(String address){//名前の変更,setting(name, address)から呼び出す
		this.address = address;
	}
	public String getAddress(){
		return this.address;
	}
	private String address;
	private int rentlimit = 0;
	public abstract void returnRentlimit();

	public abstract void rentBook(String isbn, Booklist booklist);

	public String h_searchBook(String isbn, Booklist booklist){//IDで検索
		if(booklist.containsKeytitleList(isbn)){
			return "match >>> "+ booklist.getTitleList(isbn) + " at " + booklist.getAddressList(isbn)+"\n";
		}
		else{
			return "isbn : " + isbn +" >>> no matches... please request";
		}
	}



			/**
			 * Getter of the property <tt>rentlimit</tt>
			 * @return  Returns the rentlimit.
			 * @uml.property  name="rentlimit"
			 */
			public int getRentlimit() {
				return rentlimit;
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
			public abstract void setFine(int fine);

	public State(String name, String address){
		this.name = name;
		this.address = address;
	}
	public void requestBook(String isbn, String title, Booklist booklist){
		if(booklist.containsKeytitleList(isbn)){
			System.out.println(title+"is exist in this library.");
			System.out.println("In "+ booklist.getAddressList(isbn));
		}
		booklist.addrequestList(isbn,title);
	}


}
