
public class Main {

    public static void main(String[] args) {
        /**This section is the inputs**/
        //example inputs:
        Order[] listOfOrders = {
                new Order(1, 20201020, "Jessica", 1),
                new Order(5, 20201123, "Cassandra", 6),
                new Order(2, 20201021, "Alex", 2),
                new Order(4, 20201013, "John", 8),
                new Order(3, 20191117, "Chloe", 5)};
        int[][] map=new int[][]{
                {0,5,6},
                {5,0,3},
                {6,3,0}};

        int destinationID = 1;
        int findCustomerByID = 2;
        /**End of inputs**/

        MaxHeap MH = new MaxHeap();
        Dijkstra D = new Dijkstra();
        RBTree rbtree = new RBTree();

        /**return the order information with soonest deadline**/

        int n = listOfOrders.length;
        MH.sort(listOfOrders);
        System.out.println("\n-- The order with soonest delivery deadline is:");
        int i =0;
        while(listOfOrders[i].getDate()==listOfOrders[0].getDate()&& i < n){
            System.out.println(listOfOrders[i]);
            i++;
        }

        /**find the order information with by ID (Red Black Tree)**/
        // form RBTree
        for (int c = 0; c < listOfOrders.length; c++){
            rbtree.insert(listOfOrders[c]);
        }

        System.out.println("\n-- Customer with order ID: "+findCustomerByID +": ");
        System.out.println(rbtree.findByID(findCustomerByID));

        

        /**return the shortest path to the destination**/
        System.out.print("\n-- The shortest distance from source to address: "+destinationID+" is ");
        D.dijkstra(map, 0, destinationID);
        System.out.print(" kilometers");

    }
}

