
import java.lang.*;
public class Dijkstra {


    int minDistance(int dist[], Boolean lock[],int V)
    {
        int min = Integer.MAX_VALUE, idx_min = -1;
        for (int i = 0; i < V; i++)
            if (lock[i] == false && dist[i] <= min) {
                min = dist[i];
                idx_min = i;
            }

        return idx_min;
    }

    void dijkstra(int map[][], int src, int destination)
    {
        int l= map.length;   //range of the map
        int dist[] = new int[l]; // The output array.
        // dist[i] = the shortest distance from src to i

        // lock[i] =true if vertex i is included in shortest
        // path tree or min distance from src to i is found
        Boolean lock[] = new Boolean[l];

        for (int i = 0; i < l; i++) {
            dist[i] = Integer.MAX_VALUE;
            lock[i] = false;
        }
        //src to src = 0
        dist[src] = 0;

        // Find shortest path
        for (int c = 0; c < l - 1; c++) {

            int u = minDistance(dist, lock, l);

            // Mark the picked vertex as processed
            lock[u] = true;

            // Update dist of adjacent vertex
            for (int v = 0; v < l; v++)
                // Update dist[v] when not locked, edge between u v exist, dist is smaller than current
                if (!lock[v] && map[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + map[u][v] < dist[v])
                    dist[v] = dist[u] + map[u][v];
        }

        // print the distance to destination
        System.out.print(dist[destination]);

    }
}
