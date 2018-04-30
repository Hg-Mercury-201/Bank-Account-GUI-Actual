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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class transactionPanel extends JPanel
{
	private String[] transactionType = {"Deposit","Withdraw","Transfer"};
	private ArrayList<BankAccount> accounts;
	
	
	
	public transactionPanel(ArrayList<BankAccount> account)
	{
	this.accounts = account;
	GridBagConstraints gbc  = new GridBagConstraints();
	setLayout(new GridBagLayout());
	JPanel Transaction = new JPanel();
	JLabel transactionHeader =  new JLabel("Make transactions here");
	setLayout(new GridBagLayout());
	
	gbc.gridx = 0;
	gbc.gridy = 0;
	JLabel lblAccountNumber = new JLabel("Account Number: ");
	add(lblAccountNumber,gbc);
	gbc.gridy = 1;
	JLabel lblAmount = new JLabel("Amount: ");
	add(lblAmount, gbc);
	gbc.gridy = 2;
	JLabel lblTransactionType = new JLabel("Transaction Type: ");
	add(lblTransactionType,gbc);
	gbc.gridy = 3;
	JLabel lblTransferAccountNumber = new JLabel("Account to Transfer to: ");
	add(lblTransferAccountNumber,gbc);
	
	gbc.gridx = 1;
	gbc.gridy = 0;
	JTextField txtAccountNum = new JTextField();
	txtAccountNum.setPreferredSize(new Dimension(60,30));
	add(txtAccountNum,gbc);
	gbc.gridy = 1;
	JTextField txtDeposit = new JTextField();
	txtDeposit.setPreferredSize(new Dimension(60,30));
	add(txtDeposit,gbc);
	gbc.gridy = 2;
	JList TransactionType = new JList(transactionType);
	add(TransactionType,gbc);
	gbc.gridy = 3;
	JTextField txtTransferAccountNumber = new JTextField();
	txtTransferAccountNumber.setPreferredSize(new Dimension (60,30));
	add(txtTransferAccountNumber,gbc);
	gbc.gridx = 0;
	gbc.gridy = 4;
	JButton btnSubmit = new JButton("Submit");
	add(btnSubmit,gbc);
	btnSubmit.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try
			{
				if (TransactionType.getSelectedValue().equals("Checking"))
				{
					BankAccount depositing = checkAccountNumber(Integer.parseInt(txtAccountNum.getText()),accounts);	
					if(depositing != null)
					{
						depositing.deposit(Double.parseDouble(txtDeposit.getText()));
						txtAccountNum.setText("");
						txtDeposit.setText("");
					}
				}
				else if (TransactionType.isSelectedIndex(1))
				{
					BankAccount withdrawing = checkAccountNumber(Integer.parseInt(txtAccountNum.getText()),accounts);
					if(withdrawing != null)
					{
						withdrawing.withdraw(Double.parseDouble(txtDeposit.getText()));
						txtAccountNum.setText("");
						txtDeposit.setText("");
					}

				}
				else if (TransactionType.isSelectedIndex(2));
				{
					BankAccount transfering;
					BankAccount transfering2;

					transfering = checkAccountNumber(Integer.parseInt(txtAccountNum.getText()),accounts);
					transfering2 = checkAccountNumber(Integer.parseInt(txtTransferAccountNumber.getText()), accounts);
					if(transfering != null && transfering2 != null)
					{
						transfering.transfer(transfering2, Double.parseDouble(txtDeposit.getText()));
						txtAccountNum.setText("");
						txtDeposit.setText("");
					}

				}
				System.out.println(accounts);
			}

			catch(IllegalArgumentException e) 
			{
				System.out.print("error");
			}

		}
	});
	
	Transaction.add(transactionHeader);
	setVisible(true);
	
	
}
	
	private static BankAccount checkAccountNumber(int enteredNum,ArrayList<BankAccount> accts)
	{
		for (BankAccount specifiedAccount : accts)
		{
			if (enteredNum == (specifiedAccount.getAccountNumber()))	
			{
				return specifiedAccount;
			}
		}
		return null;
	}
}
