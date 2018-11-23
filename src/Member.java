import java.util.ArrayList;
import java.util.List;

public class Member {

	private List<State> status_list;
	private Booklist booklist;

	public void setState() {//会員を扱うリストのインスタンスをつくる
		this.status_list = new ArrayList<State>();
	}

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
			setState();//stateリストのインスタンスを作るだけ
			staffhead = new Staffhead();//職員と館長は一人ずつ
			staff = new Staff();
			booklist = new Booklist();

			/*
			* 初期状態としていくつか本を登録しておく
			 */
			booklist.setBookToList("1", 111l, 1, "one");
			booklist.setBookToList("2", 112l, 1, "two");
			booklist.setBookToList("3", 113l, 1, "thr");
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
		private void rent(String isbn, int id){
			State state = IDtoPerson(id);
			System.out.println("user:"+state.getName());
			state.rentBook(isbn,booklist);
		}
		private int return_process(String isbn, int id){
			return staff.returnbook(isbn, IDtoPerson(id), booklist);
		}

		//addMemberでリストに新しいメンバーを追加し、ステータスを設定
		public void addMember(String Name, String Address){//新しい会員を登録する
			temp_name = Name;
			temp_address = Address;
			setCurrentState(temp_name, temp_address);
			//currentStateをStateリストに追加する
			status_list.add(this.currentState);
		}

		public static void main(String[] args){
			Member m1 = new Member();
			m1.addMember("sample1", "tokyo");//会員1を追加
			m1.addMember("sample2", "tokyo");//会員2を追加
			m1.rent("1", 0);//id:0の人がisbn:1の本を借りる
			m1.rent("1", 1);//id:1の人がisbn:1の本を借り(ようとす)る
			m1.return_process("1", 0);//返却時に当人が会員証を持ってカウンターにいる
			m1.rent("1", 1);//id:1の人がisbn:1の本を借りる
		}
}
