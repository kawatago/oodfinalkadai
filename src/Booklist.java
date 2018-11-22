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
		protected List<Long> stockList = new ArrayList<Long>();//現在図書館が所持している本
		public Booklist(){
			
		}

		/**
		 * @uml.property  name="StockList"
		 */


		protected Map<Long, String> titleList = new HashMap<Long, String>();//ISBNとタイトル
		protected Map<Long, Long> deadlineList = new HashMap<Long, Long>();//ISBNと返却期日

}
