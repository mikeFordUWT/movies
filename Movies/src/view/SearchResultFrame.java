package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Movie;

public class SearchResultFrame extends JFrame{
	private static final int LOGO_SIZE = 0;
	private JComboBox<String> movieBox;
	private ArrayList<Movie> movieList;
	
	private JLabel reelLogo;
	private JPanel upperPanel;
	private JLabel logOut;
	
	public SearchResultFrame(ArrayList<Movie> inputMovies) {
		super("Reel Log");
		movieList = inputMovies;
		movieBox = new JComboBox<String>();
		addMovies();
		setUp();
		
	}
	
	private void addMovies(){
		for(int i = 0; i<movieList.size(); i++){
			movieBox.addItem(movieList.get(i).getTitle());
		}
	}
	
	private void setUp(){
		buildUpper();
		buildCenter();
	}
	
	private void buildCenter(){
		
	}
	
	private void buildUpper(){
		Box upperBox = Box.createVerticalBox();
		
		Color back = new Color(164,194,244);
		upperPanel = new JPanel();
		
		reelLogo = new JLabel("Reel Log");
		reelLogo.setFont(new Font("Courier", Font.PLAIN, LOGO_SIZE));
		reelLogo.setOpaque(true);
		reelLogo.setAlignmentX(.5f);
		reelLogo.setBackground(back);
		
		logOut = new JLabel("<HTML><U>LOG OUT</U></HTML>");
		logOut.setAlignmentX(.5f);
		
		upperBox.add(reelLogo);
		upperBox.add(logOut);
		upperPanel.add(upperBox);
		
		upperPanel.setBackground(back);
		add(upperPanel, BorderLayout.NORTH);
	}
	
	public JComboBox<String> getMovieBox(){
		return movieBox;
	}
}
