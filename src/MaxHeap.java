public class MaxHeap {

    /** Sort  a list of orders based on the  delivery deadline using Heap sort (Max-Heap)
     @param orders - A list of order
     @return -A list of  sorted order
     **/
    public void sort(Order[] orders){
        int l = orders.length;

        // Building heap
        for (int i = l / 2 - 1; i >= 0; i--)
            heapify(orders, l, i);

        // extract elements from heap
        for (int i=l-1; i>0; i--)
        {
            // Move current root to end
            Order temp = orders[0];
            orders[0] = orders[i];
            orders[i] = temp;
            heapify(orders, i, 0);
        }
    }

    void heapify(Order[] orders, int n, int i)
    {
        int parent = i; // root (i)
        int l = 2*i + 1; // left child
        int r = 2*i + 2; // right child

        // If left child > root
        if (l < n && orders[l].getDate() > orders[parent].getDate())
            parent = l;
        // If right child > largest so far
        if (r < n && orders[r].getDate() > orders[parent].getDate())
            parent = r;
        // If largest is not root
        if (parent != i)
        {
            Order swap = orders[i];
            orders[i] = orders[parent];
            orders[parent] = swap;

            // look into the affected subtree
            heapify(orders, n, parent);
        }
    }



}
