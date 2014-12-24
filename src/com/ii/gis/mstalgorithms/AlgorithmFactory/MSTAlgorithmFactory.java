package com.ii.gis.mstalgorithms.AlgorithmFactory;

import com.ii.gis.mstalgorithms.AlgorithmTypes.AlgType;
import com.ii.gis.mstalgorithms.Graph.Graph;

public class MSTAlgorithmFactory {
	private static final MSTAlgorithmFactory mstAlgorithm = new MSTAlgorithmFactory();
	
	private MSTAlgorithmFactory(){
		
	}
	public static final MSTAlgorithmFactory getInstance(){
		return mstAlgorithm;
	}
	
	public MSTAlgorithm getAlgorithm(AlgType algType){
		switch (algType){
			case Kruskal:
				return new KruskalAlgorithm();
			case Prim:
				return new PrimAlgorithm();
			case Boruvka:
				return new BoruvkaAlgorithm();
			default:
				return null;
		}
	}
	
	public MSTAlgorithm getAlgorithm(Graph graph, AlgType algType){
		MSTAlgorithm mstAlgorithm = getAlgorithm(algType);
		mstAlgorithm.loadGraph(graph);
		return mstAlgorithm;
	}
}
