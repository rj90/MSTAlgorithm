package com.ii.gis.mstalgorithms.AlgorithmFactory;

import com.ii.gis.mstalgorithms.Graph.Graph;
import com.ii.gis.mstalgorithms.Graph.Graph.Edge;
import com.ii.gis.mstalgorithms.Graph.Tree;

public class PrimAlgorithm extends MSTAlgorithm{

	public PrimAlgorithm(Graph graph) {
		super(graph);
	}
	
	public PrimAlgorithm() {

	}

//	@Override
//	public Graph solve() {
//		Tree tree = new Tree(graph.getNodes().get(0));
//		while (graph.getNodes().size()!=tree.getNodes().size()){
//			addPossibleEdges(tree);
//			sortPossibleEdges(tree);
//			Edge e = tree.getPossibleEdges().get(0);
//			System.out.println("Krawędź: " + e.toString());
//			if(possibleToAdd(tree, e)){
//				System.out.println("Przyjmuję");
//				tree.addEdge(e);
//				tree.addNode(possibleNode(tree, e));
//			}
//			else{
//				System.out.println("Odrzucam");
//			}
//			tree.getPossibleEdges().clear();
//			graph.getEdges().remove(getGraphEdge(e));
//		}
//		return tree;
//	}
	
	@Override
	public void solve(){
		Tree tree = new Tree(graph.getNodes().get(0));
		while (graph.getNodes().size()!=tree.getNodes().size()){
			addPossibleEdges(tree);
			sortPossibleEdges(tree);
			Edge e = tree.getPossibleEdges().get(0);
			addLog(e.toString());
			tree.addEdge(e);
			tree.addNode(possibleNode(tree, e));
			tree.getPossibleEdges().clear();
			graph.getEdges().remove(getGraphEdge(e));
		}
	}

	private Object getGraphEdge(Edge e) {
		for (Edge e2 : graph.getEdges()){
			if (e2.getFirst().equals(e.getFirst()) && e2.getFirst().equals(e.getFirst()) && e2.getWeight()==e.getWeight()){
				return e2;
			}
		}
		return null;
	}

	private String possibleNode(Tree tree, Edge e) {
		for (String s : tree.getNodes()){
			if(s.equals(e.getFirst())){
				return e.getSecond();
			}
			else if(s.equals(e.getSecond())){
				return e.getFirst();
			}
		}
		return null;
	}

}
