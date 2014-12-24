package com.ii.gis.mstalgorithms.Graph;

import java.util.LinkedList;

public class Tree extends Graph{

	private LinkedList<Edge> possibleEdges = new LinkedList<Edge>();
	private Boolean toMerge = false;
	
	public Tree(String node) {
		super();
		nodes.add(node);
	}

	public Tree(Tree first, Tree second) {
		super();
		for(String s: first.getNodes()){
			nodes.add(s);
		}
		for(String s: second.getNodes()){
			nodes.add(s);
		}
		for(Edge e : first.getEdges()){
			edges.add(e);
		}
		for(Edge e : second.getEdges()){
			edges.add(e);
		}
	}
	
	public void addPossibleEdge(Edge e){
		addPossibleEdge(e.getFirst(), e.getSecond(), e.getWeight());
	}

	private void addPossibleEdge(String first, String second, double weight) {
		possibleEdges.add(new Edge(first, second, weight));		
	}
	
	public LinkedList<Edge> getPossibleEdges(){
		return this.possibleEdges;
	}
	
	public void setToMerge(boolean toMerge){
		this.toMerge = toMerge;
	}
	
	public boolean getToMerge(){
		return this.toMerge;
	}
}
