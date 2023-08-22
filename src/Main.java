public class Main {

    public static void main(String[] args) {
        /**This section is the inputs**/
        //example inputs:
        Order[] listOfOrders = {
                new Order(1, 20201020, "Jessica", 1),
                new Order(7, 20201123, "Cassandra", 6),
                new Order(3, 20201021, "Alex", 2),
                new Order(5, 20201013, "John", 8),
                new Order(4, 20201117, "Chloe", 5),
                new Order(6, 20210103, "Michael", 4),
                new Order(2, 20201205, "Ellen", 1)};
        int[][] map=new int[][]{
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        int destinationID = 4;
        int findCustomerByID = 5;
        /**End of inputs**/

        MaxHeap MH = new MaxHeap();
        Dijkstra D = new Dijkstra();
        RBTree rbtree = new RBTree();
        /**return the order information with soonest deadline**/
        Order soonestOrder = MH.SoonestOrder(listOfOrders);
        System.out.println("Customer with soonest delivery deadline: "+soonestOrder.toString());

        /**find the order information with by ID (Red Black Tree)**/
        // form RBTree
        Order find = rbtree.findByID(findCustomerByID);
        System.out.println("Customer with order ID "+findCustomerByID +": "+find);

        /**return the shortest path to the destination**/
        int[] shortestPath = D.dijkstra(map,destinationID);
        for(int i = 0; i<shortestPath.length; i++){
            System.out.print(shortestPath[i]+ ", ");
        }

    }
}

