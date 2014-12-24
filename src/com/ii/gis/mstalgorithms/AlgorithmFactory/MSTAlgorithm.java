package com.ii.gis.mstalgorithms.AlgorithmFactory;

import java.util.Collections;

import com.ii.gis.mstalgorithms.Graph.Graph;
import com.ii.gis.mstalgorithms.Graph.Tree;

public abstract class MSTAlgorithm {
	protected Graph graph;
	
	public MSTAlgorithm(Graph graph){
		loadGraph(graph);
	}
	
	public MSTAlgorithm(){
	}

	public void loadGraph(Graph graph) {
		this.graph = graph;		
	}
	
	public abstract Graph solve();
	
	protected boolean graphHasCycles(){
		return false;
	}
	
	protected void sortEdges() {
		Collections.sort(graph.getEdges());		
	}
	
	protected void sortPossibleEdges(Tree tree) {
		Collections.sort(tree.getPossibleEdges());
	}
}
