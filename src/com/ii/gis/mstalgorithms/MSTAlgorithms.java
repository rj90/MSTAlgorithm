package com.ii.gis.mstalgorithms;

import java.awt.EventQueue;

import com.ii.gis.mstalgorithms.controler.MSTControl;
import com.ii.gis.mstalgorithms.model.MSTModel;
import com.ii.gis.mstalgorithms.view.MSTView;

public class MSTAlgorithms{
	private MSTModel mstModel;
	private MSTControl mstControl;
	private MSTView mstView;
	
	public static void main(String [] args){
		MSTAlgorithms mstAlgorithms = new MSTAlgorithms();
		mstAlgorithms.run();
	}

	private void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				mstModel = new MSTModel();
				mstView = new MSTView();
				mstControl = new MSTControl(mstModel, mstView);
				mstView.setVisible(true);
			}
		});
	}
}
