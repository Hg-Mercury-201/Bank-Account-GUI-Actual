import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class HomeScreen extends JFrame
{
	/*
 * create one arraylist object and make an arraylist reference constructor
 */
	private ArrayList<BankAccount> accounts;
	
	public HomeScreen(ArrayList<BankAccount> account)
	{
		accounts = account;
		CardLayout cl = new CardLayout();
		GridBagConstraints gbc  = new GridBagConstraints();
		setLayout(cl);
		setBounds(300,300,400,400);
		setTitle("BBBank");
		
		JPanel Start = new JPanel();
		Start.setLayout(new GridBagLayout());
		gbc.gridy = 0;
		JMenuBar mBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem clear = new JMenuItem("Exit Program");
		file.add(clear);
		mBar.add(file);
		setJMenuBar(mBar);
		clear.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						System.exit(1);
					}
			
				});
		gbc.gridy = 1;
		JLabel startTitle = new JLabel("Welcome to BBBank");
		Start.add(startTitle);
		BufferedImage bankjpg = null; 	// add a picture
		try 
		{
			bankjpg =ImageIO.read(new File("stereotypical average guy.PNG"));					
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		JLabel lblHome = new JLabel(new ImageIcon(bankjpg));
		JTabbedPane tabs = new JTabbedPane();
		Start.add(lblHome,gbc);
		tabs.addTab("Start", Start);
		tabs.addTab("Account Creation", new accountsPanel(account));
		tabs.addTab("Transaction", new transactionPanel(account));
		add(tabs);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	//		JPanel homePanel = new JPanel();
//		
//		setTitle("BBBank");
//		homePanel.setLayout(cl);
//		
//		JTabbedPane tabs = new JTabbedPane();
//		JPanel Start = new JPanel();
//		tabs.addTab("Start", Start);
//		tabs.addTab("Account Creation", new accountsPanel(account));
//		tabs.addTab("Transaction", new transactionPanel(account));
//		JLabel startTitle = new JLabel("Welcome to BBBank");
//		Start.add(startTitle);
//		homePanel.add(tabs);
}
