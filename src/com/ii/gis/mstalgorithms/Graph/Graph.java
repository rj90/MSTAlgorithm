package com.ii.gis.mstalgorithms.Graph;

import java.util.LinkedList;

public class Graph {
	protected LinkedList<Edge> edges = new LinkedList<Edge>();
	protected LinkedList<String> nodes = new LinkedList<String>();
	
	public class Edge implements Comparable<Edge>{
		private String first, second;
		private double weight;
		public Edge(String first, String second, double weight){
			this.first = first;
			this.second = second;
			this.weight = weight;
		}
		
		public Edge(Edge edge) {
			this.first = edge.getFirst();
			this.second = edge.getSecond();
			this.weight = edge.getWeight();
		}

		public String getFirst(){
			return this.first;
		}
		
		public String getSecond(){
			return this.second;
		}

		public double getWeight(){
			return this.weight;
		}
		
		public String toString(){
			StringBuilder st = new StringBuilder();
			st.append(getFirst()).append(" ").append(getSecond()).append(" ").append(getWeight());
			return st.toString();
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight > o.weight ? 1 : (this.weight < o.weight ? -1 : 0);
		}
	}
	
	
	public Graph(Graph graph) {
		for (String node : graph.getNodes())
			nodes.add(new String(node));
		for (Edge edge : graph.getEdges())
			edges.add(new Edge(edge));
	}

	public Graph() {
	}

	public void addEdge(String first, String second, double weight){
		addNode(first);
		addNode(second);
		edges.add(new Edge(first, second, weight));
	}
	
	public void addEdge(Edge e){
		addNode(e.getFirst());
		addNode(e.getSecond());
		edges.add(new Edge(e.getFirst(), e.getSecond(), e.getWeight()));
	}


	public void addNode(String node) {
		if(!isAdded(node))
			nodes.add(node);
	}


	public boolean isAdded(String node) {
		for (String n : nodes)
			if (n.equals(node))
				return true;
		return false;
	}
	
	public String toString(){
		int i=1;
		StringBuilder edgesData = new StringBuilder();
		for (Edge e : edges){
			edgesData.append(e.toString());
			if(i!=edges.size())
				edgesData.append("\n");
			i++;
		}
		return edgesData.toString();
	}


	public LinkedList<Edge> getEdges() {
		return this.edges;
	}


	public LinkedList<String> getNodes() {
		return this.nodes;
	}
}
