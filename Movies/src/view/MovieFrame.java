package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Movie;
import data.User;

public class MovieFrame extends JFrame {
	//The movie a page will be based on
	private Movie myMovie;

	//A User for if a user is logged in.
	private User myUser;

	//Labels for diplaying info about the movie.
	private JLabel title;
	private JLabel rating;
	private JLabel runTime;
	private JLabel releaseYear;
	private JLabel myActors;
	
	
	private JPanel northPanel;
	private JPanel centerPanel;
	
	private JButton homeButton;
	private JButton favAdd;
	private JButton watchAdd;
	
	private Color upperBarColor;
	private Box upperBox;
	
	private Box movieInfoBox;
	private Box movieBox;
	
	private int width;
	private int height;



//	//A Movie Frame for when a user is not logged in.
//	public MovieFrame(Movie inputMovie){
//		super("Reel Log");
//		myMovie = inputMovie;
//		buildNotLoggedFrame();
//	}

	//A Movie Frame for is a user is logged in.
	public MovieFrame(Movie inputMovie, User inputUser) {
		super("Reel Log");
		myMovie = inputMovie;
		myUser = inputUser;
		height = this.getHeight();
		width = this .getWidth();
//		myUser = inputUser;
		buildFrame();
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}


	private void buildFrame(){

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 10, screenSize.width/2, screenSize.height/2);
		buildUpper();
		buildCenter();
		add(northPanel,BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	
	private void buildCenter(){
		centerPanel = new JPanel();
		watchAdd = new JButton("Add to WatchList");
		favAdd = new JButton("Add to Favorites");
		movieBox = Box.createHorizontalBox();
		movieInfoBox = Box.createVerticalBox();
		movieBox.add(movieInfoBox);
		
		title = new JLabel(myMovie.getTitle());
		rating = new JLabel(myMovie.getMPAA());
		int hours = myMovie.getRunTime()/60;
		int minutes = myMovie.getRunTime()%60;
		String hrMin = String.valueOf(hours) + "hrs "+ String.valueOf(minutes)+"mins";
		runTime = new JLabel(hrMin);
		releaseYear = new JLabel(String.valueOf(myMovie.getYear()));
		String actors = myMovie.getActors(myMovie.getActorList());
		myActors = new JLabel(actors);
		
		movieInfoBox.add(title);
		String ratingTime = rating + " | " + runTime;
		movieInfoBox.add(rating);
		movieInfoBox.add(runTime);
		movieInfoBox.add(releaseYear);
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(favAdd);
		buttonBox.add(watchAdd);
		movieInfoBox.add(buttonBox);
		
		
		centerPanel.add(movieBox);
	}
	
	private void buildUpper(){
		northPanel = new JPanel();
		upperBox = Box.createHorizontalBox();
		upperBarColor = new Color(164,194,244);
		homeButton = new JButton("Home");
		homeButton.setBackground(upperBarColor);
		
		upperBox.add(homeButton);
		upperBox.setBackground(upperBarColor);
		northPanel.add(upperBox);

	}
	
	public JButton getHomeButton(){
		return homeButton;
	}
	
	public JButton getFavAdd(){
		return favAdd;
	}
	
	public JButton getWatchAdd(){
		return watchAdd;
	}

	public Movie getMovie(){
		return myMovie;
	}



}
