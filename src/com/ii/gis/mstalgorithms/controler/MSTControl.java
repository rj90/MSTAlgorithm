package com.ii.gis.mstalgorithms.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ii.gis.mstalgorithms.AlgorithmTypes.AlgType;
import com.ii.gis.mstalgorithms.AlgorithmTypes.ChooserType;
import com.ii.gis.mstalgorithms.Constants.Strings;
import com.ii.gis.mstalgorithms.Graph.GraphSaver;
import com.ii.gis.mstalgorithms.model.MSTModel;
import com.ii.gis.mstalgorithms.view.MSTView;

public class MSTControl {

	private MSTModel mstModel;
	private MSTView mstView;
	
	public MSTControl(MSTModel mstModel, MSTView mstView) {
		this.mstModel = mstModel;
		this.mstView = mstView;
		setListeners();
		mstView.setAlgOptions(new String[]{Strings.boruvkaOption,
				Strings.kruskalOptions, Strings.primOptions});
	}

	private void setListeners() {
		mstView.setbtnSolveListener(setSolveListener());
		mstView.setbtnLoadListener(setLoadListener());
		mstView.setbtnSaveListener(setSaveListener());
	}
	
	private ActionListener setSaveListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					GraphSaver.saveGraph(setGraphPath(), mstModel.getResult());
				} catch (Exception e) {
					mstView.popupMessage(e.toString());
				}
			}		
		};
	}

	private ActionListener setLoadListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					mstModel.loadGraph(getGraphPath());
				} catch (Exception e) {
					mstView.popupMessage(e.toString());
				}
			}		
		};
	}

	private ActionListener setSolveListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double time;
				if(mstModel.setAlgorithmType(getSelectedItem())){
					time = System.currentTimeMillis();
					mstModel.solve();
					time = System.currentTimeMillis() - time;
					mstView.popupMessage(Strings.solved + time/1000 + "s");
				}
				else
					mstView.popupMessage(Strings.solveErrorMessage);
			}			
		};
	}

	private AlgType getSelectedItem() {
		switch (mstView.getAlgOption()){
		case Strings.boruvkaOption:
			return AlgType.Boruvka;
		case Strings.primOptions:
			return AlgType.Prim;
		case Strings.kruskalOptions:
			return AlgType.Kruskal;
		default:
			return null;
		}
	}
	
	private String setGraphPath() {
		return mstView.getStringFromChooser(ChooserType.save);
	}
	
	private String getGraphPath() {
		return mstView.getStringFromChooser(ChooserType.load);
	}
}
