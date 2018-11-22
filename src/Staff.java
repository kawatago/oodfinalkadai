import javafx.scene.chart.CategoryAxis;

import java.util.*;
public class Staff  {
	int fine_val = 100;
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
	public int returnbook(long isbn, State rt_person, Booklist booklist){
		//ここで返却手続き
		//Booklistのdeadline＜Long, Long＞を扱う
		//Booklist<Long, Date>
		//返却ならエントリを消去、貸し出しならエントリを作成
		if (booklist.containsKeydeadlineList(isbn)){//Booklistのインスタンスにisbnキーを持つエントリがあればtrue
			//日付を取得し,deadline.get(isbn)と比較する
			Calendar now_date = Calendar.getInstance();
			if(now_date.after(booklist.getdeadlineList(isbn))){
				rt_person.setFine(fine_val);//期限オーバーしているとき、超過料金をユーザのインスタンスに付与（加算）
			}
			booklist.removedeadlineList(isbn);
			rt_person.returnRentlimit();
		}
		return 0;
	}

}
