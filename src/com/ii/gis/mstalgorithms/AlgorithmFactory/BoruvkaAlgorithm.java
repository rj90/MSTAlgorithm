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
	public void solve() {
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
	}

	private void solveTree(Tree tree) {
		addPossibleEdges(tree);
		sortPossibleEdges(tree);
		Edge e = tree.getPossibleEdges().get(0);
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
				if (tree1 == tree2);
				else if (possibleToAdd(tree2, tree1.getPossibleEdges().get(0))){
					Edge e = tree1.getPossibleEdges().get(0);
					addLog(e.toString());
					tree1.getPossibleEdges().clear();
					mergeTree(trees, tree1, tree2, e);
					return;
				}
			}
			tree1.setToMerge(false);
		}
	}

}
