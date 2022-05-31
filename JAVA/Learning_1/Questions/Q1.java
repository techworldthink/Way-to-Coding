/* Create array objects of Book(bookid,price,pages) . find book at which highest price*/

import java.util.Scanner; 

class Main{
    public static void main(String []args){
        int arrSize;
        int max=0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Array size : ");
        arrSize = sc.nextInt();

        Book[] arrObj = new Book[arrSize];

        for(int i=0;i<arrSize;i++){
            arrObj[i] = new Book();
            arrObj[i].setValues();
            if(max < arrObj[i].getPrice()){
                max=arrObj[i].getPrice();
            }
        }
        System.out.println("---------HIGHEST ENTER DETAILS------------");
        for(int i=0;i<arrSize;i++){
            if(max == arrObj[i].getPrice()){
                arrObj[i].show();
            }
        }
    }
}

class Book{
    int bookId;
    int pages;
    int price;

    public void setValues(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------ENTER DETAILS------------");
        System.out.print("ID     : ");
        this.pages = sc.nextInt();
        System.out.print("Pages  : ");
        this.bookId = sc.nextInt();
        System.out.print("Price  : ");
        this.price = sc.nextInt();
    }

    public void show(){
        System.out.println("--------------------------------------------");
        System.out.println("ID     : "+this.pages);
        System.out.println("Pages  : "+this.bookId);
        System.out.println("Price  : "+this.price);
    }

    public int getPrice(){
        return this.price;
    } 
}