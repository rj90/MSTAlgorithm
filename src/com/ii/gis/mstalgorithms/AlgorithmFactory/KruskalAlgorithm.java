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
		addLog("Kruskal:");
		sortEdges();
		LinkedList<Tree> trees = prepareTrees();
		while (trees.size()!=1){
			Edge e = graph.getEdges().get(0);
			LinkedList<Tree> toMerge = getTreeList(trees, e);
			if(toMerge.get(0)!=toMerge.get(1)){
				addLog(e.toString());
				mergeTree(trees, toMerge.get(0), toMerge.get(1), e);
			}
			graph.getEdges().remove(0);
		}
		return trees.get(0);
	}

	private LinkedList<Tree> getTreeList(LinkedList<Tree> trees, Edge e) {
		LinkedList<Tree> toMerge = new LinkedList<Tree>();
		for (Tree t : trees)
			for (String s : t.getNodes()){
				if (s.equals(e.getFirst()) || s.equals(e.getSecond()))
					toMerge.add(t);
				if (toMerge.size()==2)
					return toMerge;
			}
		return null;
	}

}
