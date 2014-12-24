package com.ii.gis.mstalgorithms.AlgorithmFactory;

import java.util.Collections;
import java.util.LinkedList;

import com.ii.gis.mstalgorithms.Graph.Graph;
import com.ii.gis.mstalgorithms.Graph.Tree;
import com.ii.gis.mstalgorithms.Graph.Graph.Edge;

public abstract class MSTAlgorithm {
	protected Graph graph;
	protected StringBuilder log = new StringBuilder();
	
	public MSTAlgorithm(Graph graph){
		loadGraph(graph);
	}
	
	public MSTAlgorithm(){
	}

	public void loadGraph(Graph graph) {
		this.graph = new Graph(graph);		
	}
	
	public abstract void solve();
	
	protected boolean graphHasCycles(){
		return false;
	}
	
	protected void sortEdges() {
		Collections.sort(graph.getEdges());		
	}
	
	protected void sortPossibleEdges(Tree tree) {
		Collections.sort(tree.getPossibleEdges());
	}
	
	protected LinkedList<Tree> prepareTrees() {
		LinkedList<Tree> trees = new LinkedList<Tree>();
		for (String node : graph.getNodes())
			trees.add(new Tree(node));
		return trees;
	}
	
	protected void addPossibleEdges(Tree tree) {
		for (Edge e: graph.getEdges())
			if(possibleToAdd(tree, e))
				tree.addPossibleEdge(e);
	}
	
	protected boolean possibleToAdd(Tree tree, Edge e) {
		if ((tree.isAdded(e.getFirst()) && !tree.isAdded(e.getSecond())) || 
				(!tree.isAdded(e.getFirst()) && tree.isAdded(e.getSecond())))
			return true;
		else return false;
	}
	
	protected void mergeTree(LinkedList<Tree> trees, Tree first, Tree second, Edge e) {
		Tree t = new Tree(first, second);
		t.addEdge(e);
		trees.remove(first);
		trees.remove(second);
		trees.add(t);
	}
	
	protected void addLog(String log){
		this.log.append(log);
		this.log.append("\n");
	}
	
	public String getLog(){
		return this.log.toString();
	}
	
	public Graph getGraph(){
		return graph;
	}
}
