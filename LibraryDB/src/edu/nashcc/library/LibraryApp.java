/*	Matthew S. Coley
 * 	LibraryDB
 *  29 July 2015
 */

// Uses Apache Commons IO

package edu.nashcc.library;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class LibraryApp {

	private JFrame frame;
	private JTextField bookTitleField;
	private JTextField authorField;
	private JTextField genreField;
	private JTextField iSBNField;
	private JTextField yearField;
	
	private static final File library = new File("C:\\Java\\LibraryDB.dat");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// need to wrap in an if(file does not exist) block
		//FileOps.createFile(library, "");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryApp window = new LibraryApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibraryApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(25, 11, 46, 14);
		frame.getContentPane().add(lblTitle);
		
		bookTitleField = new JTextField();
		bookTitleField.setBounds(25, 31, 86, 20);
		frame.getContentPane().add(bookTitleField);
		bookTitleField.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(25, 62, 46, 14);
		frame.getContentPane().add(lblAuthor);
		
		authorField = new JTextField();
		authorField.setBounds(25, 81, 86, 20);
		frame.getContentPane().add(authorField);
		authorField.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(25, 112, 46, 14);
		frame.getContentPane().add(lblGenre);
		
		genreField = new JTextField();
		genreField.setBounds(25, 131, 86, 20);
		frame.getContentPane().add(genreField);
		genreField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(25, 162, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		iSBNField = new JTextField();
		iSBNField.setBounds(25, 179, 86, 20);
		frame.getContentPane().add(iSBNField);
		iSBNField.setColumns(10);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(25, 210, 46, 14);
		frame.getContentPane().add(lblYear);
		
		yearField = new JTextField();
		yearField.setBounds(25, 230, 86, 20);
		frame.getContentPane().add(yearField);
		yearField.setColumns(10);
						
		JTextPane textPane = new JTextPane();
		textPane.setBounds(121, 31, 178, 219);
		frame.getContentPane().add(textPane);
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(121, 31, 178, 219);
		frame.getContentPane().add(scrollPane);
		scrollPane.createVerticalScrollBar();
		scrollPane.setEnabled(true);
		scrollPane.setVisible(true);
		
		JButton addBtn = new JButton("Add Record");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title, author, genre, iSBN, year;
				try
				{
					title = bookTitleField.getText();
					author = authorField.getText();
					genre = genreField.getText();
					iSBN = iSBNField.getText();
					year = yearField.getText();
					LibraryBook myBook = new LibraryBook(title, author, genre, iSBN, year);
					System.out.println("myBook.toString(): " + myBook.toString()); // testing output
					FileOps.appendFile(library, myBook.toString());
					textPane.setText(myBook.displayBook());
				//	scrollPane.add(textPane);
					System.out.println("myBook.displayBook(): " + myBook.displayBook()); // testing output
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return;
				}
			}
		});
		addBtn.setBounds(309, 30, 115, 23);
		frame.getContentPane().add(addBtn);
			
		JButton changeBtn = new JButton("Change Record");
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titleOld, authorOld, genreOld, iSBNOld, yearOld;
				String titleNew, authorNew, genreNew, iSBNNew, yearNew;
				try
				{
					titleOld = bookTitleField.getText();
					authorOld = authorField.getText();
					genreOld = genreField.getText();
					iSBNOld = iSBNField.getText();
					yearOld = yearField.getText();
					titleNew = newBookInput("Enter the title: ");
					authorNew = newBookInput("Enter the author: ");
					genreNew = newBookInput("Enter the genre: ");
					iSBNNew = newBookInput("Enter the ISBN: ");
					yearNew = newBookInput("Enter the year: ");
					
					LibraryBook oldBook = new LibraryBook(titleOld, authorOld, genreOld, iSBNOld, yearOld);
					LibraryBook newBook = new LibraryBook(titleNew, authorNew, genreNew, iSBNNew, yearNew);

					FileOps.changeFile(library, oldBook.toString(), newBook.toString());
					textPane.setText(newBook.displayBook());
					System.out.println("newBook.displayBook(): " + newBook.displayBook()); // testing output
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					return;
				}
			}
		});
		changeBtn.setBounds(309, 80, 115, 23);
		frame.getContentPane().add(changeBtn);
		
		JButton delBtn = new JButton("Delete Record");
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lineToRemove;
				String title, author, genre, iSBN, year;
				try
				{
					title = bookTitleField.getText();
					author = authorField.getText();
					genre = genreField.getText();
					iSBN = iSBNField.getText();
					year = yearField.getText();
					lineToRemove = title + "," + author + "," + genre + "," + iSBN + "," + year;
					FileOps.deleteFromFile(library, lineToRemove);
					textPane.setText("Record has been removed");
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		delBtn.setBounds(309, 130, 115, 23);
		frame.getContentPane().add(delBtn);
		
		JButton recordBtn = new JButton("DO NOT PRESS");
		recordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title, author, genre, iSBN, year;
				title = bookTitleField.getText();
				author = authorField.getText();
				genre = genreField.getText();
				iSBN = iSBNField.getText();
				year = yearField.getText();
				LibraryBook testBook = new LibraryBook(title, author, genre, iSBN, year);
				String fields = title + "," + author + "," + genre + "," + iSBN + "," + year;
				String formattedBook = testBook.toString(); //FileOps.formatDisplay(title, author, genre, iSBN, year);
				System.out.println("fields: " + fields);
				System.out.println("formattedBook: " + formattedBook); // testing output
				if(fields.equalsIgnoreCase(formattedBook)){
					String formatted = FileOps.displayRecord(library, testBook.toString());
				textPane.setText(formatted);
				} else {
					textPane.setText("That record does not exist. \n\n\nE:Show");
				}
			}
		});
		recordBtn.setToolTipText("DOES NOT WORK lel");
		recordBtn.setBounds(309, 178, 115, 23);
		frame.getContentPane().add(recordBtn);
		
		JButton clearBtn = new JButton("CLEAR");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookTitleField.setText("");
				authorField.setText("");
				genreField.setText("");
				iSBNField.setText("");
				yearField.setText("");
				textPane.setText("");
			}
		});
		clearBtn.setBounds(309, 229, 115, 23);
		frame.getContentPane().add(clearBtn);
		
	}
	public static String newBookInput(String prompt){
		return JOptionPane.showInputDialog(null, prompt, "Change Record", JOptionPane.QUESTION_MESSAGE);
	}
}
