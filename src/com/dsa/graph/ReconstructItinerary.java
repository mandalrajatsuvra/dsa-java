package com.dsa.graph;

import java.util.*;

public class ReconstructItinerary {


    public Map<String, PriorityQueue<String>> createGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            String source = ticket.get(0);
            String destination = ticket.get(1);
            PriorityQueue<String> adjacentNodes = graph.getOrDefault(source, new PriorityQueue<>());
            adjacentNodes.offer(destination);
            graph.put(source, adjacentNodes);
        }
        return graph;
    }

    public void dfs(String u, Map<String, PriorityQueue<String>> graph, HashSet<String> ticketUsed, LinkedList<String> itinerary ){
        PriorityQueue<String> adList = graph.getOrDefault(u, new PriorityQueue<>());

        while(!adList.isEmpty()){
            String v = adList.poll();
            dfs(v, graph, ticketUsed, itinerary);
        }
        itinerary.addFirst(u);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = createGraph(tickets);
        HashSet<String> visited = new HashSet<>();
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, visited, itinerary);
        return itinerary;
    }

    public static void main(String[] args) {
        ReconstructItinerary  ir = new ReconstructItinerary();
        List<List<String>> tickets1 = new ArrayList<>();
        List<String> ticket1 = Arrays.asList("MUC","LHR");
        List<String> ticket2 = Arrays.asList("JFK","MUC");
        List<String> ticket3 = Arrays.asList("SFO","SJC");
        List<String> ticket4 = Arrays.asList("LHR","SFO");
        tickets1.add(ticket1);
        tickets1.add(ticket2);
        tickets1.add(ticket3);
        tickets1.add(ticket4);
        System.out.println(ir.findItinerary(tickets1));


        List<List<String>> tickets2 = new ArrayList<>();
        List<String> ticket5 = Arrays.asList("JFK","SFO");
        List<String> ticket6 = Arrays.asList("JFK","ATL");
        List<String> ticket7 = Arrays.asList("SFO","ATL");
        List<String> ticket8 = Arrays.asList("ATL","JFK");
        List<String> ticket9 = Arrays.asList("ATL","SFO");
        tickets2.add(ticket5);
        tickets2.add(ticket6);
        tickets2.add(ticket7);
        tickets2.add(ticket8);
        tickets2.add(ticket9);

        System.out.println(ir.findItinerary(tickets2));



    }
}
