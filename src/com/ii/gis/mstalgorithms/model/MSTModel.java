package com.ii.gis.mstalgorithms.model;

import com.ii.gis.mstalgorithms.AlgorithmFactory.MSTAlgorithm;
import com.ii.gis.mstalgorithms.AlgorithmFactory.MSTAlgorithmFactory;
import com.ii.gis.mstalgorithms.AlgorithmTypes.AlgType;
import com.ii.gis.mstalgorithms.Graph.Graph;
import com.ii.gis.mstalgorithms.Graph.GraphLoader;

public class MSTModel {
	private MSTAlgorithm mstAlgorithm;
	private Graph graph;
	
	public void loadGraph(String filename) throws Exception{
		if(filename!=null)
			graph = GraphLoader.getGraph(filename);
	}
	
	public String getResult(){
		if (mstAlgorithm!=null)
			return mstAlgorithm.getLog();
		return null;
	}
	
	public boolean solve(){
		if (graph == null)
			return false;
		mstAlgorithm.solve();
		return true;
	}
	
	public boolean setAlgorithmType(AlgType algtype){
		if (graph==null || algtype==null)
			return false;
		mstAlgorithm = MSTAlgorithmFactory.getInstance().getAlgorithm(graph, algtype);
		return true;
	}
	
	public void resetModel(){
		mstAlgorithm = null;
		graph = null;
	}
}
