

public class Nonmember extends State {
	private int rentlimit = 0;
	private int deadline = 0;
	private int fine = 0;

	public void returnRentlimit(){
		System.out.println("error");
	}
	public void setFine(int fine) {
		this.fine += fine;
	}
	public void resetFine(){this.fine = 0;	}//全部払った

	@Override
	public void rentBook(String isbn, Booklist booklist) {
		System.out.println("error at Nonmember.rentBook");//会員でないので借りることはできない（そもそも呼び出されない？）
	}

	//コンストラクタ（スーパークラスのコンストラクタを呼び出す）
	public Nonmember(String name, String address){
		super("", "");//登録はしていない
		System.out.println("register as Nonmember");
	}

}
