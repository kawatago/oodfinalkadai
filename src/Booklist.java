import java.util.*;

public class Booklist {
//前提：何も指定しなければ新しい本はadresstail+1のアドレスに収納される
		private long address_tail;//アドレスの最後尾
		private List<String> delete_list = new ArrayList<String>();
		/**
		 */
		public void operateBookList(){
		}

		/**
		 * @uml.property  name="requestList"
		 */
//		protected List<String> requestList = new ArrayList<String>();//館長が見る用isbnコードのみを持つ
//		protected List<Long> haveList = new ArrayList<Long>();//現在図書館が所持している本
	//↑のマップはタイトルリストで十分？

	protected Map<String, Long> addressList = new HashMap<String, Long>();
	protected Map<String, Integer> stockList = new HashMap<String, Integer>();
	protected Map<String, String> titleList = new HashMap<String, String>();//ISBNとタイトル
	protected Map<String, Calendar> deadlineList = new HashMap<String, Calendar>();//ISBNと返却期日
	protected Map<String, String> requestList = new HashMap<String, String>();//館長が見る用isbnとタイトルを持つ

	public void setBookToList(String isbn, Long address, Integer stock, String title){//新しくリストに追加する
			addressList.put(isbn, address);
			stockList.put(isbn, stock);//前提：stockは常に1
			titleList.put(isbn, title);
			address_tail++;//次に追加すべきアドレス（館長の購入などではこのアドレスで収納される）
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
		System.out.println("before"+isbn+":"+ stockList.get(isbn));
		stockList.put(isbn, temp + i);
		System.out.println("after"+isbn+":"+ stockList.get(isbn));
	}

	public void addDeadlineList(String isbn, int offset){
		Calendar rental_date = Calendar.getInstance();
		System.out.println("today is " + rental_date.get(Calendar.DATE));
		rental_date.add(Calendar.DATE,offset);//ステータスに応じた返却期日を加算する
		//deadlineに追加
		deadlineList.put(isbn,rental_date);
		System.out.println("deadline is:" + rental_date.get(Calendar.DATE));
	}
	public void addrequestList(String isbn, String title){//タイトルまで入力してもらう
		System.out.println("bef add:");
		showRequestList();
		requestList.put(isbn, title);
		System.out.println("aft add:");
		showRequestList();
	}
	public void showTitleList(){
		System.out.println("titleList state:");
		for (Iterator<Map.Entry<String, String>> iterator = titleList.entrySet().iterator(); iterator.hasNext();){
			Map.Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	public void showRequestList(){
		System.out.println("requestList state:");
		for (Iterator<Map.Entry<String, String>> iterator = requestList.entrySet().iterator(); iterator.hasNext();){
			Map.Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}

	}

	public void deletefromList(String isbn){
		System.out.println("bef delete:");
		showTitleList();
		if(titleList.containsKey(isbn)){
			System.out.println(titleList.get(isbn)+"is deleted.");
			titleList.remove(isbn);
			stockList.remove(isbn);
			addressList.remove(isbn);
		}else{
			System.out.println("Not Exist");
		}
		showTitleList();
	}

	public void purchasefromList(int numOfPurchase){//numOfPurchase分だけリクエストリストから購入する
		//処理前のrequestlistを表示する
		System.out.println("bef purchase:");
		showRequestList();
		showTitleList();

		for (Iterator<Map.Entry<String, String>> iterator = requestList.entrySet().iterator(); iterator.hasNext();){
			if(numOfPurchase<0){break;}
			Map.Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey()+":"+entry.getValue()+ "is purchased");
			setBookToList(entry.getKey(), address_tail, 1, entry.getValue());//新しい本を各種リストに追加
			//リクエストリストから消去するため、新しいリストにキーを追加しておく
			delete_list.add(entry.getKey());//delete_listにあるキーのまっプを消去するメソッドdelete_entryをつくる
			numOfPurchase--;
		}
		deleteEntry("request");
		//処理後のrequestlistを表示する
		System.out.println("aft purchase");
		showRequestList();
		showTitleList();
	}
	//指定したリストのエントリをすべて削除するメソッド
	public void deleteEntry(String select_list){
		if(select_list.equals("request")){
			for (int i = 0 ; i < delete_list.size();i++){
				requestList.remove(delete_list.get(i));//delete_listに入っているキーを削除
			}
		}else if(select_list.equals("stock")){
			for (int i = 0 ; i < delete_list.size();i++){
				stockList.remove(delete_list.get(i));//delete_listに入っているキーを削除
			}
		}
	}
}
