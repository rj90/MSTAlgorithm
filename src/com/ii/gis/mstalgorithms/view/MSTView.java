package com.ii.gis.mstalgorithms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;

import com.ii.gis.mstalgorithms.AlgorithmTypes.ChooserType;
import com.ii.gis.mstalgorithms.Constants.Strings;

public class MSTView extends JFrame {

	private JPanel contentPane;
	private JButton btnSave, btnLoad, btnSolve;
	private JComboBox chosenAlg;

	public MSTView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSave = new JButton(Strings.saveButtonName);
		btnSave.setBounds(12, 144, 117, 25);
		contentPane.add(btnSave);
		
		btnLoad = new JButton(Strings.LoadButtonName);
		btnLoad.setBounds(165, 144, 117, 25);
		contentPane.add(btnLoad);
		
		btnSolve = new JButton(Strings.solveButtonName);
		btnSolve.setBounds(86, 203, 117, 25);
		contentPane.add(btnSolve);
		
		chosenAlg = new JComboBox();
		chosenAlg.setBounds(119, 12, 98, 24);
		contentPane.add(chosenAlg);
	}
	
	public void setbtnSaveListener(ActionListener action){
		btnSave.addActionListener(action);
	}
	
	public void setbtnLoadListener(ActionListener action){
		btnLoad.addActionListener(action);
	}
	
	public void setbtnSolveListener(ActionListener actionCistener){
		btnSolve.addActionListener(actionCistener);
	}
	
	public void setAlgOptions(String[] options){
		for (String s: options)
			chosenAlg.addItem(s);
	}
	
	public String getAlgOption(){
		return (String) chosenAlg.getSelectedItem();
	}
	
	public String getStringFromChooser(ChooserType chooserType){
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileFilter(new FileNameExtensionFilter(Strings.typeOfFiles,"txt"));
		if (chooserType == ChooserType.load)
			chooser.showOpenDialog(null);
		else
			chooser.showSaveDialog(null);
		File f = chooser.getSelectedFile();
		if (f != null)
			return f.getAbsolutePath();
		else
			return null;
	}
	
	public void popupMessage(String message){
		JOptionPane.showMessageDialog(this, message);
	}
}
