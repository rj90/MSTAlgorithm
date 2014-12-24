package com.ii.gis.mstalgorithms.AlgorithmFactory;

import com.ii.gis.mstalgorithms.Graph.Graph;

public class BoruvkaAlgorithm extends MSTAlgorithm{

	public BoruvkaAlgorithm(Graph graph) {
		super(graph);
	}
	
	public BoruvkaAlgorithm() {
		
	}

	@Override
	public Graph solve() {
		return graph;
	}

}
