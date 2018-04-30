import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class accountsPanel extends JPanel
{
	private ArrayList<BankAccount> accounts;
	private String[] accountType = {"Checking","Savings"};
	
	public accountsPanel(ArrayList<BankAccount> account)
	{
	this.accounts = account;
	GridBagConstraints gbc  = new GridBagConstraints();
	setLayout(new GridBagLayout());
	

	
	gbc.gridx = 0;
	gbc.gridy = 0;
	JLabel lblName = new JLabel("Name: ");
	add(lblName,gbc);
	gbc.gridy++;
	JLabel lblDeposit = new JLabel("Initial Deposit: ");
	add(lblDeposit, gbc);
	gbc.gridy++;
	JLabel lblAccountType = new JLabel("Account Type: ");
	add(lblAccountType,gbc);
	gbc.gridx++;
	gbc.gridy = 0;
	JTextField txtName = new JTextField();
	txtName.setPreferredSize(new Dimension(180,30));
	add(txtName,gbc);
	gbc.gridy = 1;
	JTextField txtDeposit = new JTextField();
	txtDeposit.setPreferredSize(new Dimension(180,30));
	add(txtDeposit,gbc);
	gbc.gridy = 2;
	JList AccountType = new JList(accountType);
	add(AccountType,gbc);
	gbc.gridx = 0;
	gbc.gridy = 3;
	JButton btnSubmit = new JButton("Submit");
	add(btnSubmit,gbc);
	btnSubmit.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try
			{
			if (AccountType.getSelectedValue().equals("Checking"))
			{
				CheckingAccount newAccount = new CheckingAccount(txtName.getText(),Double.parseDouble(txtDeposit.getText()), 1, 1, 1);
				accounts.add(newAccount);
				txtName.setText("");
				txtDeposit.setText("");
			}
			else if (AccountType.isSelectedIndex(1))
			{
				SavingsAccount newAccount = new SavingsAccount(txtName.getText(),Double.parseDouble(txtDeposit.getText()), 1, 1, 1);
				accounts.add(newAccount);
				txtName.setText("");
				txtDeposit.setText("");
						
			}
			}
			catch(IllegalArgumentException e)
			{
				System.out.print("error");
			}
			System.out.println(accounts);
		}

	});

	
	setVisible(true);
	}
	
}
