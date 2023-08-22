public class Order {
     private int ID;
     private String name;
     private int address;
     private int date;

     public Order(int ID, int date, String name, int address ){
         this.ID = ID;
         this.date = date;
         this.name = name;
         this.address = address;
     }

     public int getID(){
         return ID;
     }
     public int getAddress(){
        return address;
     }
     @Override
    public String toString(){
         return "Order ID:" + ID + ", Name: "+name + ", Date: " + date + ", Adderss ID: " + address;
     }


}
