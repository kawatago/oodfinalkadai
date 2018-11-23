import java.util.*;

public class Booklist {

		
		/**
		 */
		public void operateBookList(){
		}

		/**
		 * @uml.property  name="requestList"
		 */
		protected List<String> requestList = new ArrayList<String>();//館長が見る用isbnコードのみを持つ
//		protected List<Long> haveList = new ArrayList<Long>();//現在図書館が所持している本
	//↑のマップはタイトルリストで十分？

	protected Map<String, Long> addressList = new HashMap<String, Long>();
	protected Map<String, Integer> stockList = new HashMap<String, Integer>();
	protected Map<String, String> titleList = new HashMap<String, String>();//ISBNとタイトル
	protected Map<String, Calendar> deadlineList = new HashMap<String, Calendar>();//ISBNと返却期日

	public void setBookToList(String isbn, Long address, Integer stock, String title){//新しくリストに追加する
			addressList.put(isbn, address);
			stockList.put(isbn, stock);//前提：stockは常に1
			titleList.put(isbn, title);
		}

		/**
		 * @uml.property  name="StockList"
		 */

	public boolean containsKeydeadlineList(String isbn){//staffから使う
		return deadlineList.containsKey(isbn);
	}

	public boolean containsKeytitleList(String isbn){//searchのとき使う
		if (!titleList.containsKey(isbn)){
			return false;
		}
		return true;
	}


	public Calendar getdeadlineList(String isbn){
		return deadlineList.get(isbn);
	}

	public String getTitleList(String isbn){
		return titleList.get(isbn);
	}

	public String getAddressList(String isbn){
		return  String.valueOf(addressList.get(isbn));
	}

	public void removedeadlineList(String isbn){
		deadlineList.remove(isbn);
	}

	public int getStockList(String isbn){//Stocklistが1ならほんは未貸し出し
		return stockList.get(isbn);
	}

	public void operateStockList(String isbn, int i){
		int temp = stockList.get(isbn);
		stockList.put(isbn, temp + i);
		System.out.println("result:"+ stockList.get(isbn));
	}

	public void addDeadlineList(String isbn, int offset){
		Calendar rental_date = Calendar.getInstance();
		rental_date.add(Calendar.DATE,offset);
		//deadlineに追加
		deadlineList.put(isbn,rental_date);
		System.out.println("deadline is:" + deadlineList.get(isbn));
	}
	public void addrequestList(String isbn){
		requestList.add(isbn);
	}

}
