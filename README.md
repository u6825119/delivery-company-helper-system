# delivery-company-helper-system


##Background
A delivery company which processes orders in the order of the soonest deadline 
using a max-heap, then finds customer information using Red-Black Tree, and finally 
finds the shortest path to the delivery destination using Dijkstra's algorithm.
This program will use Java as the programming language.

##Functionalities:
(I/O: Read in the provided input and save the information in data structure.)
1. Identify the order with soonest delivery deadline among all the orders.
2. Find the order information including name, address, delivery deadline, and order 
ID with a given order ID.
3. Find the closest path to the desired destination (Address ID).
   
## Programming Language used: Java   
## Java classes:
1.  Order: This class is the most important class defining the structure and behavior of all “Order” instances that will be used
    throughout the program, an order instance contains an order ID, a date of delivery deadline, a name of the customer, and an address represented by an address ID (Integer).
    The users will need to input the customer order information in the form of this class, which is Order(int ID, int date, String name, int address ). 
2.	Dijkstra: Where the Dijkstra algorithm is implemented.
3.	RBTree: Where the Red Black tree related functions are implemented, methods include find the order information by ID and tree formation.
4.	MaxHeap: Where heap sort is implemented in the order of soonest deadlines.
5.	Main: All inputs can be modified in this section and all functionalities will be executed here.

## Functionalities:
1.	Find the order information with soonest delivery date
2.	Find the order information by order ID
3.	Find the closest path to the desired destination (Address ID)

### User guidelines:
Users will need to give the input in the main method of Main class, input information and format are shown below:
### listOfOrders:
| Description: A list of Orders needs to be provided in this section, an Order refers to an instance of the Order class.
| Example: Order[] listOfOrders = { new Order(1, 20201020, "Jessica", 1),
                                    new Order(4, 20201123, "Cassandra", 6),
                                    new Order(3, 20201021, "Alex", 2),
                                    new Order(2, 20201013, "John", 8) };
| Assumptions: The date are expected to be in the form as shown in the example above.

### map: 
| Description: A 2D array providing the connections and their distances between address IDs. map [0][5] = 6 denotes the connection     
  between address ID 0 and 5 is 6 km apart, map [2][3] = 0 denotes there is no connection between address ID 2 and 3, full map with    
  all possible connections between all IDs needs to be provided.
| Example:  int[][] map=new int[][]{
                { 0, 4, 0, 0, 0, 0, 0, 8 },
                { 4, 0, 8, 0, 0, 0, 0, 11},
                { 0, 8, 0, 7, 0, 4, 0, 0},
                { 0, 0, 7, 0, 9, 14, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0},
                { 0, 0, 0, 0, 0, 2, 0, 1},
                { 8, 11, 0, 0, 0, 0, 1, 0 } };
| Assumptions: map[x][y]==0 should be satisfied when x == y. map is a square 2D array.

### destinationID: 
| Description: A desired address ID (int) that will help returning the shortest path to this point from where the delivery company is located.
| Assumptions: The address ID should be valid from the map above.

### findCustomerByID: 
| Description: This ID will return its corresponding order information.
| Assumptions: The order ID should be valid from the input orders above.

## Compile:
The program can be run directly after these input variables are assigned, click on Run ‘Main’ will compile this program.

## Output: 
Result of all functionalities are output as strings in the console. 
