package edu.nashcc.library;

import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

import static java.nio.file.StandardOpenOption.*;

import java.text.*;

public class FileOps {

	public static void createFile(Path file, String s) {

		final String BOOK_FORMAT = "               "; // 15 chars
		final String NAME_FORMAT = "               "; // 15 chars
		final int NAME_LENGTH = NAME_FORMAT.length();
		final String GENRE_FORMAT = "            "; // 12 chars
		final String ISBN_FORMAT = "          "; // 10 chars
		final String YEAR_FORMAT = "    ";
		String delimiter = ",";
		String str = BOOK_FORMAT + delimiter + NAME_FORMAT + delimiter
				+ GENRE_FORMAT + delimiter + ISBN_FORMAT + delimiter
				+ YEAR_FORMAT + System.getProperty("line.separator");
		final int RECSIZE = str.length();

		try {
			OutputStream outputStr = new BufferedOutputStream(
					Files.newOutputStream(file, CREATE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					outputStr));
			writer.write(str, 0, RECSIZE);
			writer.write("\n");
			writer.close();
		} catch (Exception e) {
			System.out.println("Error message: " + e);
		}
	}

	public static void appendFile(Path file, String s) {
		try {
			OutputStream outStr = new BufferedOutputStream(
					Files.newOutputStream(file, APPEND));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					outStr));
			writer.write(s + "\n");
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void changeFile(Path file, String oldRecord, String newRecord) {
		// need to search for entry, replace it
		// changeFile(Path file, String s) -- String s will search for every
		// field/entire myBook.toString()
		// will not work lel

		try {
			InputStream iStream = new BufferedInputStream(
					Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					iStream));
			OutputStream outStr = new BufferedOutputStream(
					Files.newOutputStream(file, WRITE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					outStr));
			String testRec;
			do {
				testRec = reader.readLine();
				
				if (oldRecord.equalsIgnoreCase(testRec)) {
					// call delete method on oldRecord
					
					writer.write(newRecord);
					
				} // end if
				
			} while (testRec != null);
			writer.close();

		} // end try
		catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void deleteFromFile(String oldRecord) {

		try {
			// read file, alter file, lolwat idk...

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String displayRecord(String titleField, String authorField,
			String genreField, String iSBNField, String yearField) {
		// need to check each text field and search file, display matches
		String str = "";

		/*
		 * Currently not working. Displays the text fields, does not search the
		 * file. Need to figure out how to properly access and read from file
		 * then display that record
		 */

		try {
			// attempting to search file? lolidk

			FileInputStream inStream = new FileInputStream(
					"C:\\Java\\LibraryDB.dat");
			FileChannel fileChan = inStream.getChannel();
			String title, author, genre, iSBN, year;
			title = titleField;
			author = authorField;
			genre = genreField;
			;
			iSBN = iSBNField;
			year = yearField;
			// String str = title + "," + author + "," + genre + "," + iSBN +
			// "," + year;
			StringBuilder sb = new StringBuilder();
			sb.append("Title:\t");
			sb.append(title);
			sb.append("\n\nAuthor:\t");
			sb.append(author);
			sb.append("\n\nGenre:\t");
			sb.append(genre);
			sb.append("\n\nISBN:\t");
			sb.append(iSBN);
			sb.append("\n\nYear:\t");
			sb.append(year);
			str = sb.toString();
			byte[] data = str.getBytes();
			ByteBuffer byteBuf = ByteBuffer.wrap(data);
			fileChan.read(byteBuf);

			/*
			 * //while(title != null){ // infinite loop FIX String[] strArray =
			 * str.split(","); if(strArray[0].equalsIgnoreCase(title)){ //
			 * textPane.setText(str); book = str; System.out.println(str);//
			 * testing output }
			 */// }

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return str;
	}

	public static void displayStats(Path file) { // unnecessary atm
		// displays attributes of file
	}

}
