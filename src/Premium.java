

public class Premium extends Person {
//	/**
//	 * @uml.property  name="rentlimit"
//	 */
	private int rentlimit = 5;
//
//	/**
//	 * Getter of the property <tt>rentlimit</tt>
//	 * @return  Returns the rentlimit.
//	 * @uml.property  name="rentlimit"
//	 */
//	public int getRentlimit() {
//		return rentlimit;
//	}
//
//	/**
//	 * Setter of the property <tt>rentlimit</tt>
//	 * @param rentlimit  The rentlimit to set.
//	 * @uml.property  name="rentlimit"
//	 */
//	public void setRentlimit(int rentlimit) {
//		this.rentlimit = rentlimit;
//	}
//
//
//	//返却が完了したときにStaffから呼び出される
//	//前提：本は一冊ずつ返す
//	public void returnRentlimit(){
//		this.rentlimit = (this.rentlimit > 4)? 5: this.rentlimit+1;
//	}
//	/**
//	 * @uml.property  name="deadline"
//	 */
	private int deadline = 21;
//
//	/**
//	 * Getter of the property <tt>deadline</tt>
//	 * @return  Returns the deadline.
//	 * @uml.property  name="deadline"
//	 */
//	public int getDeadline() {
//		return deadline;
//	}
//
//	/**
//	 * Setter of the property <tt>deadline</tt>
//	 * @param deadline  The deadline to set.
//	 * @uml.property  name="deadline"
//	 */
//	public void setDeadline(int deadline) {
//		this.deadline = deadline;
//	}
//
//	/**
//	 * @uml.property  name="fine"
//	 */
//	private int fine = 0;
//
//	/**
//	 * Getter of the property <tt>fine</tt>
//	 * @return  Returns the fine.
//	 * @uml.property  name="fine"
//	 */
//	public int getFine() {
//		return fine;
//	}
//
//	/**
//	 * Setter of the property <tt>fine</tt>
//	 * @param fine  The fine to set.
//	 * @uml.property  name="fine"
//	 */
//	public void setFine(int fine) {
//		this.fine += fine;
//	}//一応積算される
//	public void resetFine(){this.fine = 0;	}//全部払った
//
//	@Override
//	public void rentBook(String isbn, Booklist booklist) {
//		if (booklist.getStockList(isbn) != 0){//Stocklistが1ならほんは未貸し出し
//			booklist.operateStockList(isbn,-1);//Stocklistの対応するキーを１減らす
//			booklist.addDeadlineList(isbn,this.deadline);//期限を追加
//		}
//		else {
//			System.out.println("error at premium.rentBook");//カウンターに本を持ってくるので、借りられているということはない
//		}
//	}
//
//	public void request(String isbn, Booklist booklist){
//		booklist.addrequestList(isbn);
//	}
//
	//コンストラクタ（スーパークラスのコンストラクタを呼び出す）
	public Premium(String name, String address){
		super(name, address);
	}

}
