package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import data.Actor;
import data.Movie;

public class Runner {

	public static void main(String[] args) {
		StartFrame hello = new StartFrame();
		hello.setLayout(new BorderLayout());
		hello.setBackground(Color.WHITE);
		hello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hello.setVisible(true);
		
		LogInFrame log = new LogInFrame();
		log.setLayout(new BorderLayout());
		log.setBackground(Color.WHITE);
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		log.setVisible(true);
		
		Actor a1 = new Actor("A61", "Jack", null, "Nicholson");
		Actor a2 = new Actor("A22", "Shelley", null, "Duvall");
		Actor a3 = new Actor("A50", "Danny", null, "Lloyd");
		Movie shining = new Movie("M09", "The Shining", 146, 1980, 44017374, "R");
		shining.addActor(a1);
		shining.addActor(a2);
		shining.addActor(a3);
		
		MovieFrame movie = new MovieFrame(shining);
		movie.setVisible(true);
		System.out.println(shining.toString());
	}
	
	
	

}
