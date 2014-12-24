package com.ii.gis.mstalgorithms.AlgorithmFactory;

import java.util.LinkedList;

import com.ii.gis.mstalgorithms.Graph.Graph;
import com.ii.gis.mstalgorithms.Graph.Graph.Edge;
import com.ii.gis.mstalgorithms.Graph.Tree;

public class BoruvkaAlgorithm extends MSTAlgorithm{

	public BoruvkaAlgorithm(Graph graph) {
		super(graph);
	}
	
	public BoruvkaAlgorithm() {
		
	}

	@Override
	public Graph solve() {
		LinkedList<Tree> trees = prepareTrees();
		
		while (trees.size() != 1){
			for (Tree tree : trees){
				//Dodawanie nowej krawędzi do drzewa.
				solveTree(tree);
			}
			//Scalanie nowych drzew
			while(isToMerge(trees))
				mergeTrees(trees);
		}
		
		return trees.get(0);
	}

	private void solveTree(Tree tree) {
		addPossibleEdges(tree);
		sortPossibleEdges(tree);
		while(!possibleToAdd(tree, tree.getPossibleEdges().get(0))){
			tree.getPossibleEdges().remove(0);
		}
		Edge e = tree.getPossibleEdges().get(0);
		//tree.addEdge(tree.getPossibleEdges().get(0));
		tree.getPossibleEdges().clear();
		tree.getPossibleEdges().add(e);
		tree.setToMerge(true);
	}

	private boolean isToMerge(LinkedList<Tree> trees) {
		for (Tree tree : trees)
			if(tree.getToMerge())
				return true;
		return false;
	}

	private void mergeTrees(LinkedList<Tree> trees) {
		for (Tree tree1 :trees){
			for (Tree tree2 :trees){
				if (possibleToAdd(tree1, tree2.getPossibleEdges().get(0))){
					Edge e = tree2.getPossibleEdges().get(0);
					tree2.getPossibleEdges().clear();
					mergeTree(trees, tree1, tree2, e);
					return;
				}
			}
			tree1.setToMerge(false);
		}
	}

}
