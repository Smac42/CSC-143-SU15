package edu.nashcc.library;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class LibraryApp {

	private JFrame frame;
	private JTextField bookTitleField;
	private JTextField authorField;
	private JTextField genreField;
	private JTextField iSBNField;
	private JTextField yearField;
	
	final String BOOK_FORMAT = "               "; // 15 chars
	final String NAME_FORMAT = "               "; // 15 chars
	final int NAME_LENGTH = NAME_FORMAT.length();
	final String GENRE_FORMAT = "            "; // 12 chars
	final String ISBN_FORMAT = "          "; // 10 chars
	final String YEAR_FORMAT = "    ";
	String delimiter = ",";
	String s = BOOK_FORMAT + delimiter + NAME_FORMAT + delimiter + GENRE_FORMAT
			+ delimiter + ISBN_FORMAT + delimiter + YEAR_FORMAT
			+ System.getProperty("line.separator");
	final int RECSIZE = s.length();

	Path library = Paths.get("C:\\Java\\LibraryDB.dat");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Path library = Paths.get("C:\\Java\\LibraryDB.dat");
		FileOps.createFile(library, "");
		
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
		
		/* attempting scroll bar on pane, not sure
		 * if need to add scrollbar to textPane or
		 * switch to scrollPane
		 */
		JTextPane textPane = new JTextPane();
		//textPane.setContentType("text/html");
		textPane.setBounds(121, 31, 178, 219);
		frame.getContentPane().add(textPane);
		textPane.setEditable(false);
	//	JScrollPane scrollPane = new JScrollPane();
	//	scrollPane.setBounds(121, 31, 178, 219);
	//	frame.getContentPane().add(scrollPane);
	//	scrollPane.createVerticalScrollBar();
	//	scrollPane.setEnabled(true);
	//	scrollPane.setVisible(true);
		
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
					System.out.println(myBook.toString()); // testing output
					Path library = Paths.get("C:\\Java\\LibraryDB.dat");
					FileOps.appendFile(library, myBook.toString());
					textPane.setText(myBook.displayBook());
				//	scrollPane.add(textPane);
					System.out.println(myBook.displayBook()); // testing output
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
		
		/* For changeBtn, delBtn, recordBtn:
		 * will need to test each field to
		 * search through records 
		 */
		
		JButton changeBtn = new JButton("Change Record");
		changeBtn.setBounds(309, 80, 115, 23);
		frame.getContentPane().add(changeBtn);
		
		JButton delBtn = new JButton("Delete Record");
		delBtn.setBounds(309, 130, 115, 23);
		frame.getContentPane().add(delBtn);
		
		JButton recordBtn = new JButton("Show Record");
		recordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				// attempting to search file? lolidk
					
				FileInputStream inStream = new FileInputStream("C:\\Java\\LibraryDB.dat");
				FileChannel fileChan = inStream.getChannel();
				String title, author, genre, iSBN, year;
				title = bookTitleField.getText();
				author = authorField.getText();
				genre = genreField.getText();
				iSBN = iSBNField.getText();
				year = yearField.getText();
				String str = title + "," + author + "," + genre + "," + iSBN + "," + year;
				byte[] data = str.getBytes();
				ByteBuffer byteBuf = ByteBuffer.wrap(data);
				fileChan.read(byteBuf);
				
				//while(title != null){ // infinite loop FIX
					String[] strArray = str.split(delimiter);
					if(strArray[0].equals(title)){
						textPane.setText(str);
						System.out.println(str);// testing output
					}
				//}

				}
				catch(Exception exc)
				{
					exc.printStackTrace();
				}
			}
		});
		recordBtn.setToolTipText("Show Record Only Works With TITLE, AUTHOR, or ISBN");
		recordBtn.setBounds(309, 178, 115, 23);
		frame.getContentPane().add(recordBtn);
		
		JButton statsBtn = new JButton("Statistics");
		statsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Path library = Paths.get("C:\\Java\\LibraryDB.dat");
				try
		       {
				BasicFileAttributes attr =
		                 Files.readAttributes(library, BasicFileAttributes.class);
				StringBuilder sb = new StringBuilder();
				      sb.append("File: " + library.getFileName());
				      sb.append("\n\nCreation time: " + attr.creationTime());
		              sb.append("\n\nLast modified time: " + attr.lastModifiedTime());
		              sb.append("\n\nSize: " + attr.size());
		        textPane.setText(sb.toString());
		       }
		       catch(Exception ex)
		       {
		    	   ex.printStackTrace();
		       }
			}
		});
		statsBtn.setBounds(309, 227, 115, 23);
		frame.getContentPane().add(statsBtn);
		
	}
}
