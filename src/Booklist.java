import java.util.*;

public class Booklist {

		
		/**
		 */
		public void operateBookList(){
		}

		/**
		 * @uml.property  name="requestList"
		 */
		protected List<Long> requestList = new ArrayList<Long>();//館長が見る用
		protected List<Long> haveList = new ArrayList<Long>();//現在図書館が所持している本
	//↑のマップはタイトルリストで十分？
		public Booklist(){
			
		}

		/**
		 * @uml.property  name="StockList"
		 */
		protected Map<Long, Long> addressList = new HashMap<Long, Long>();
		protected Map<Long, Integer> stockList = new HashMap<Long, Integer>();
		protected Map<Long, String> titleList = new HashMap<Long, String>();//ISBNとタイトル
		protected Map<Long, Calendar> deadlineList = new HashMap<Long, Calendar>();//ISBNと返却期日

	public boolean containsKeydeadlineList(Long isbn){//staffから使う
		if (!deadlineList.containsKey(isbn)){
			return false;
		}
		return true;
	}

	public boolean containsKeytitleList(Long isbn){//searchのとき使う
		if (!titleList.containsKey(isbn)){
			return false;
		}
		return true;
	}


	public Calendar getdeadlineList(Long isbn){
		return deadlineList.get(isbn);
	}

	public String getTitleList(Long isbn){
		return titleList.get(isbn);
	}

	public String getAddressList(Long isbn){
		return  String.valueOf(addressList.get(isbn));
	}

	public void removedeadlineList(Long isbn){
		deadlineList.remove(isbn);
	}

	public int getStockList(Long isbn){//Stocklistが1ならほんは未貸し出し
		return stockList.get(isbn);
	}

	public void operateStockList(Long isbn, int i){
		int temp = stockList.get(isbn);
		stockList.put(isbn, temp + i);
	}

	public void addDeadlineList(Long isbn, int offset){
		Calendar rental_date = Calendar.getInstance();
		rental_date.add(Calendar.DATE,offset);
		//deadlineに追加
		deadlineList.put(isbn,rental_date);
	}

}
