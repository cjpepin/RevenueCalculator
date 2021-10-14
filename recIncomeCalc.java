package JFrames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class recIncomeCalc implements ActionListener {
	
	private static JLabel prompt;
	private static JLabel wage;
	private static JLabel singles;
	private static JLabel doubles;
	private static JLabel triples;
	private static JLabel income;
	private static JTextField singlesText;
	private static JTextField doublesText;
	private static JTextField triplesText;

	private static JTextField wageText;
	private static JButton submit;
	
	public static void main(String[] args) {
		
		
		JFrame ourFrame = new JFrame("Prompt");
		
		ourFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ourFrame.setVisible(true);
		ourFrame.setBounds(200, 100, 450, 450);
		
		Container container = ourFrame.getContentPane();
		container.setLayout(null);
		
		prompt = new JLabel("How much will you make from working at the AC?");
		prompt.setBounds(75,5,300,30);
		
		singles = new JLabel("How many singles are you working?");
		singles.setBounds(125,30,250,30);
		
		singlesText = new JTextField();
		singlesText.setBounds(150, 55, 150, 30);
		
		doubles = new JLabel("How many doubles are you working?");
		doubles.setBounds(125, 85, 250, 30);
		
		doublesText = new JTextField();
		doublesText.setBounds(150, 110, 150, 30);
		
		triples = new JLabel("How many triples are you working?");
		triples.setBounds(125, 140, 250, 30);
		
		triplesText = new JTextField();
		triplesText.setBounds(150, 165, 150, 30);
		
		wage = new JLabel("How much do you earn per hour?");
		wage.setBounds(134, 195, 250, 30);
		
		wageText = new JTextField();
		wageText.setBounds(150, 220, 150, 30);		
		
		submit = new JButton("Submit");
		submit.setBounds(175, 260, 100, 30);
		submit.addActionListener(new recIncomeCalc());
		
		income = new JLabel("", JLabel.CENTER);
		//income.setAlignmentX(0);
		//income.setAlignmentY(0);
		income.setBounds(5,295,395,30);
		
		container.add(prompt);
		container.add(singles);
		container.add(doubles);
		container.add(triples);
		container.add(singlesText);
		container.add(doublesText);
		container.add(triplesText);
		container.add(wage);
		container.add(wageText);
		container.add(submit);
		container.add(income);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(singlesText.getText().equals("") ||  doublesText.getText().equals("") || triplesText.getText().equals("") || wageText.getText().equals("")) {
			JFrame newFrame = new JFrame("ERROR");
			
			//newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newFrame.setVisible(true);
			newFrame.setBounds(300,150, 300, 150);
			
			Container containerTwo = newFrame.getContentPane();
			containerTwo.setLayout(null);
			
			JLabel error = new JLabel("You gotta put in some real values");
			error.setBounds(50,35,200,25);
			
			containerTwo.add(error);
		}
		else {
		String singles = singlesText.getText();
		String doubles = doublesText.getText();
		String triples = triplesText.getText();
		String wage = wageText.getText();
		double wageUp = Double.parseDouble(wage);
		double singlesUp = Double.parseDouble(singles);
		double doublesUp = Double.parseDouble(doubles);
		double triplesUp = Double.parseDouble(triples);
		double hours = (singlesUp*2.25) + (doublesUp*4.25) + (triplesUp*6.25);
		double rev1 = Math.round((hours*wageUp)*100.0)/100.0;
		
		double revTot = rev1 - singlesUp - (doublesUp*2) - (triplesUp*3);
		income.setText("Your income (after parking) should be approximately $" + revTot);
		income.setHorizontalTextPosition(JLabel.CENTER);
		
		if(singles.equals("") || doubles.equals("") || wage.equals("")) {
			JFrame ourFrame = new JFrame("ERROR");
			
			ourFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ourFrame.setVisible(true);
			ourFrame.setBounds(100, 60, 100, 60);
		}
		}
	
	}

}
