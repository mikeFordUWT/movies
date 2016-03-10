package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import data.Actor;
import data.Movie;
import data.User;

public class Runner {
		private static MovieFrame movie;
		private static UserFrame userFr;
		private static LogInFrame log;
		
		private static User currentUser;
	public static void main(String[] args) {
		log = new LogInFrame();

		currentUser = new User("U01", "Michael", "Ford", "fordm13@uw.edu");
		
		StartFrame hello = new StartFrame(currentUser);
		hello.setLayout(new BorderLayout());
		hello.setBackground(Color.WHITE);
		hello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		hello.setVisible(true);
		
		
		Actor a1 = new Actor("A61", "Jack", null, "Nicholson");
		Actor a2 = new Actor("A22", "Shelley", null, "Duvall");
		Actor a3 = new Actor("A50", "Danny", null, "Lloyd");
		Movie shining = new Movie("M09", "The Shining", 146, 1980, 44017374, "R");
		
		Movie Jaws = new Movie("M10", "Jaws", 115, 1976, 3737733, "PG");
		shining.addActor(a1);
		shining.addActor(a2);
		shining.addActor(a3);
		currentUser.addToFavorites(shining);
		currentUser.addToWatchList(Jaws);
		userFr = new UserFrame(currentUser);
		userFr.setVisible(false);
	
		
		movie = new MovieFrame(shining, currentUser);
//		movie.setVisible(false);
		movieFrameListeners();
		logInListeners();
		userFrameListeners();
	}
	
	private static void logInListeners(){
		logInButtonListen();
	}
	
	
	
	private static void logInButtonListen(){
		log.getLogButton().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(log.getUserMap().containsKey(log.getUserName())
						&& log.getUserMap().containsValue(log.getPassword())){
					
//					user.setUser(inputUser);
					//TODO set it up so that the user will be based on username, finding a user that matches email
					userFr.setVisible(true);
					
				}
			}
		});
	}
	
	private static void userFrameListeners(){
		userSearchButton();
	}
	
	private static void userSearchButton(){
		userFr.getSearchButton().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
			
//				System.out.println("Searching");
				String table = (String) userFr.getSearchType().getSelectedItem();
				System.out.println(table);
			
				String newTitle = userFr.getSearchText();
//				Movie newMovie = from title in database
//				movie = new MovieFrame();
//				movie.setVisible(true);
//				userFr.setVisible(false);
			}
		});
	}
	
	private static void movieFrameListeners(){
		movieHomeListen();
		movieAddWatchListen();
		movieAddFav();
	}
	
	//Listener for movie Frame home button, sends user back to home frame.
	private static void movieHomeListen(){
		movie.getHomeButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Going home!");
				movie.setVisible(false);
				userFr.setVisible(true);
			}
		});
	}
	
	private static void movieAddWatchListen(){
		movie.getWatchAdd().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				currentUser.addToWatchList(movie.getMovie());
				//TODO add it in database
			}
		});
	}
	
	private static void movieAddFav(){
		movie.getFavAdd().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
//				currentUser.addToFavorites(movie.getMovie());
				//TODO add in database
			}
		});
	}

}
