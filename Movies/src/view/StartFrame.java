package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.User;

public class StartFrame extends JFrame {
	private User myUser;
	// A4C2F4 <- blue color
	private static final int LOGO_SIZE = 36;
	private static final int SIGN_IN_SIZE = 18;
	private JLabel searchLogo;
	private JLabel signIn;
	private String siteName;
	private JPanel northPanel; 
	private JPanel centerPanel;
	private Color upperBarColor;
	private Box upperBox;
	private Box centerLowerBox;
	private Box centerWhole;
	private JTextField searchText;
	private JComboBox<String> searchType;
	private JButton searchButton;


	public StartFrame(User theUser) {
		super("Reel Log");
		
		myUser = theUser;
		searchText = new JTextField("", 15);
		searchButton = new JButton("Search");

		signIn= new JLabel("<HTML><U>LOG-IN</U></HTML>", JLabel.RIGHT);
		String[] choices = {"Actor", "Director", "Movie"};
		searchType = new JComboBox(choices);
		siteName = "Reel Log";
		searchLogo = new JLabel(siteName);
		
		northPanel = new JPanel();
		centerPanel = new JPanel();
		upperBox = Box.createHorizontalBox();
		centerLowerBox = Box.createHorizontalBox();
		centerWhole = Box.createVerticalBox();
		buildGUI();

	}

	private void buildGUI(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100,100, screenSize.width/2, screenSize.height/2);
		buildCenter();
		buildUpper();
		upperBarColor = new Color(164,194,244);


		northPanel.setBackground(upperBarColor);

		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
		
	}

	private void buildCenter(){
		siteName = "Reel Log";
		searchLogo = new JLabel(siteName);
		searchLogo.setFont(new Font("Courier",Font.PLAIN, LOGO_SIZE));
		searchLogo.setOpaque(true);


		searchLogo.setBackground(getBackground());
		searchLogo.setForeground(Color.BLACK);
		searchLogo.setAlignmentX(.5f);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int h = screenSize.height/2;
		int w = screenSize.width/2;
		centerWhole.setSize(w,h);
		centerWhole.setBackground(Color.WHITE);
		searchClicked();
		
		centerLowerBox.add(searchType);
		centerLowerBox.add(searchText);
		centerLowerBox.add(searchButton);
		centerWhole.add(searchLogo);
		centerWhole.add(centerLowerBox);
		centerPanel.add(centerWhole);
	}

	private void buildUpper(){
		signIn.setFont(new Font("Courier", Font.PLAIN, SIGN_IN_SIZE));
		signInListen();
		
		
		upperBox.setBackground(upperBarColor);
		upperBox.add(signIn);
		northPanel.add(upperBox);
		
	}
	
	private void signInListen(){
		signIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				System.out.println("LOG_IN CLICKED");
			}
		});
	}
	
	private void searchClicked(){
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				System.out.println("SEARCH!");
			}
		});
	}
	
	public String getSearchText(){
		return searchText.getText();
	}

	public JComboBox<String> getBox(){
		return searchType;
	}
	
}
