package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import data.Movie;
import data.User;

public class UserFrame extends JFrame {
	private User currentUser;
	
	private ArrayList<Movie> favorites;
	private ArrayList<Movie> watchList;
	
	private JLabel firstName;
	
	public UserFrame(User inputUser) {
		super("Reel Log");
		currentUser = inputUser;
	}

	private void buildFrame() {
		firstName = new JLabel("Welcome, " + currentUser.getFirstName());
	}
}
