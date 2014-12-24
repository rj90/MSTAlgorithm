package com.ii.gis.mstalgorithms.AlgorithmFactory;

import java.util.LinkedList;

import com.ii.gis.mstalgorithms.Graph.Graph;
import com.ii.gis.mstalgorithms.Graph.Graph.Edge;
import com.ii.gis.mstalgorithms.Graph.Tree;

public class KruskalAlgorithm extends MSTAlgorithm{

	public KruskalAlgorithm(Graph graph) {
		super(graph);
	}
	
	public KruskalAlgorithm() {
		
	}

	@Override
	public Graph solve() {
		sortEdges();
		LinkedList<Tree> trees = new LinkedList<Tree>();
		for (String node : graph.getNodes()){
			trees.add(new Tree(node));
		}
		while (trees.size()!=1){
			Edge e = graph.getEdges().get(0);
			System.out.println("Krawędź: " + e.toString());
			Tree first, second;
			first = getTree(trees, e.getFirst());
			second = getTree(trees, e.getSecond());
			if(first!=second){
				System.out.println("Przyjmuję");
				mergeTree(trees, first, second, e);
			}
			else{
				System.out.println("Odrzucam");
			}
			graph.getEdges().remove(0);
		}
		return trees.get(0);
	}

	private void mergeTree(LinkedList<Tree> trees, Tree first, Tree second, Edge e) {
		Tree t = new Tree(first, second);
		t.addEdge(e);
		trees.remove(first);
		trees.remove(second);
		trees.add(t);
	}

	private Tree getTree(LinkedList<Tree> trees, String node) {
		for (Tree t : trees){
			for (String s : t.getNodes()){
				if (s.equals(node))
					return t;
			}
		}
		return null;
	}

}
