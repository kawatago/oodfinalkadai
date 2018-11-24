import java.util.ArrayList;
import java.util.List;

public class Member {

	private List<State> status_list = new ArrayList<State>();
	private Booklist booklist;
//staffもリストに（館長も紛れている）
	private List<Staff> stafflist = new ArrayList<Staff>();


	/**
	 * @uml.property  name="name"
	 */
	private String temp_name;//これをStateに渡す

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return temp_name;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.temp_name = name;
	}

	/**
	 * @uml.property  name="address"
	 */
	private String temp_address;

	/**
	 * Getter of the property <tt>address</tt>
	 * @return  Returns the address.
	 * @uml.property  name="address"
	 */
	public String getAddress() {
		return temp_address;
	}

	/**
	 * Setter of the property <tt>address</tt>
	 * @param address  The address to set.
	 * @uml.property  name="address"
	 */
	public void setAddress(String address) {
		this.temp_address = address;
	}

		
	/**
	 */

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

	public void setCurrentState(String name, String address) {
		if((address).indexOf("大岡山")<0){
			this.currentState = new Normal(name, address);//コンストラクタにname, addressを設定させる
			System.out.println("register as Normal");
		}else if(address.equals("")){
			this.currentState = new Nonmember(name, address);
			System.out.println("register as Nonmember");
		}else{
			this.currentState = new Premium(name, address);
			System.out.println("register as Premium");
		}
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
	 * @uml.property  name="test"
	 * @uml.associationEnd  aggregation="shared" inverse="member:test"
	 */
	public Member(){//コンストラクタ

//		staffhead = new Staffhead();//職員と館長は一人ずつ
//		staff = new Staff();
		booklist = new Booklist();

		/*
		* 初期状態としていくつか本を登録しておく
		 */
		booklist.setBookToList("1", 1l, 1, "one");
		booklist.setBookToList("2", 2l, 1, "two");
		booklist.setBookToList("3", 3l, 1, "thr");
		System.out.println("initial booklist state \n1:"+ booklist.getTitleList("1")+
				"\n2:" + booklist.getTitleList("2")+
				"\n3:" + booklist.getTitleList("3"));
	}
	/*
	* staff.returnbook()には、本を借りていた人を表すクラスのインスタンスを渡さなければいけない
	* そこで、statuslistの順番をidとみなし、idから対応するクラスを返すメソッドを定義する
	 */
	private State IDtoPerson(int id){
		return status_list.get(id);
	}
	private Staff IDtoStaff(int id){
		return stafflist.get(id);
	}
	private void rent(String isbn, int id){
		State state = IDtoPerson(id);
		System.out.println("user:"+state.getName());
		state.rentBook(isbn,booklist);
	}
	private int return_process(String isbn, int id){
		return staff.returnbook(isbn, IDtoPerson(id), booklist);
	}
	private void request(String isbn, String title, int id){
		State state = IDtoPerson(id);
		System.out.println("user:"+ state.getName());
		state.requestBook(isbn, title, booklist);
		booklist.showRequestList();
	}
	public void purchase(int numOfPurchase, int id){
		Staff staff = IDtoStaff(id);
		staff.purchasebook(booklist, id);
	}

	//addMemberでリストに新しいメンバーを追加し、ステータスを設定
	public void addMember(String Name, String Address){//新しい会員を登録する
		temp_name = Name;
		temp_address = Address;
		setCurrentState(temp_name, temp_address);
		//currentStateをStateリストに追加する
		status_list.add(this.currentState);
	}

	//addMemberでリストに新しいメンバーを追加し、ステータスを設定
	public void addStaff(String Name, boolean headflag){//新しい会員を登録する
		temp_name = Name;
		//staffかstaffheadのインスタンスをStafflistに追加する
		if(headflag) {
			stafflist.add(new Staffhead());
			System.out.println(Name+"is registered as staffhead");
		}else{
			stafflist.add(new Staff());
			System.out.println(Name+"is registered as staff");
		}
	}

	public static void main(String[] args){
			Member m1 = new Member();
			m1.addMember("sample1", "tokyo");//会員1を追加
			m1.addMember("sample2", "tokyo");//会員2を追加
			m1.addMember("nonmember1","");//会員登録していないアクター
			m1.addMember("premium1", "大岡山1");//大岡山会員を追加
			m1.addStaff("staff1", false);//スタッフ1を追加
			m1.addStaff("head", true);//館長を追加
			//同じ本は借りれない
//			m1.rent("1", 0);//id:0の人がisbn:1の本を借りる
//			m1.rent("1", 1);//id:1の人がisbn:1の本を借り(ようとす)る
//			m1.return_process("1", 0);//返却時に当人が会員証を持ってカウンターにいる
//			m1.rent("1", 1);//id:1の人がisbn:1の本を借りる
			//リクエストはだれでもできる
			m1.request("111", "req_one",0);//会員1が111をリクエスト
			m1.request("222","req_two", 2);//非会員1が222をリクエスト
			m1.request("333","req_thr",  3);//大岡山会員が333をリクエスト
			//館長による購入処理
			m1.purchase(2, 1);//館長が二つ購入


		}
}
