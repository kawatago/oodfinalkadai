

public class Normal extends Person {
	private int rentlimit = 3;
	private int deadline = 14;

	//コンストラクタ（スーパークラスのコンストラクタを呼び出す）
	public Normal(String name, String address){
		super(name, address);
		System.out.println(name + "register as Normal");
	}

	//返却が完了したときにStaffから呼び出される
	//前提：本は一冊ずつ返す
	public void returnRentlimit(){
		this.rentlimit = (this.rentlimit > 4)? 5: this.rentlimit+1;
	}
	public void rentBook(String isbn, Booklist booklist) {
		if (booklist.getStockList(isbn) != 0){//Stocklistが1ならほんは未貸し出し
			booklist.operateStockList(isbn,-1);//Stocklistの対応するキーを１減らす
			booklist.addDeadlineList(isbn,this.deadline);//期限を追加
			System.out.println("isbn:"+isbn +"\nrentBook has done.");
		}
		else {
			System.out.println("error at premium.rentBook");//カウンターに本を持ってくるので、借りられているということはない
		}
	}
}
