public abstract class Person extends State {//こいつも抽象クラス
    private int rentlimit;
    private int deadline;
    private int fine = 0;
    public abstract void returnRentlimit();
    public abstract void rentBook(String isbn, Booklist booklist);



    public int getRentlimit() {
        return rentlimit;
    }
    public void setFine(int fine) {
        this.fine += fine;
    }//一応積算される
    public void resetFine(){this.fine = 0;	}//全部払った
    public Person(String name, String address){
        super(name, address);
    }

    //    public void setRentlimit(int rentlimit) {
//        this.rentlimit = rentlimit;
//    }
//    public int getDeadline() {
//        return deadline;
//    }
//public void setDeadline(int deadline) {
//        this.deadline = deadline;
//    }
//public int getFine() {
//        return fine;
//    }

}
