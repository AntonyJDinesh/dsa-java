package com.ajd.prep.dsa.graph.bellmanfrod;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheapestFlightWithKStop {
    public static int cheapestFlightWithKStop(int n, int[][] flights, int src, int dst, int k) {
        int[] cheapest = new int[n];
        Arrays.fill(cheapest, Integer.MAX_VALUE);
        cheapest[src] = 0;

        for(int i = 0; i <= k; i++) {

            int[] tmp = cheapest.clone();
            for(int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if(cheapest[from] != Integer.MAX_VALUE) {
                    tmp[to] = Math.min(tmp[to], cheapest[from] + price);
                }
            }
            log.info("\n{}\n{}\n\n", cheapest, tmp);
            cheapest = tmp;
        }

        return cheapest[dst] == Integer.MAX_VALUE ? -1 : cheapest[dst];
    }
}
