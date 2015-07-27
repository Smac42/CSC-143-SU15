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
		String str = BOOK_FORMAT + delimiter + NAME_FORMAT + delimiter + GENRE_FORMAT
				+ delimiter + ISBN_FORMAT + delimiter + YEAR_FORMAT
				+ System.getProperty("line.separator");
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
	public static void appendFile(Path file, String s){
		try
		{
			OutputStream outStr = new BufferedOutputStream(Files.newOutputStream(file, APPEND));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStr));
			writer.write(s + "\n");
			writer.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
	public static void changeFile(Path file, String oldRecord, String newRecord){
		// need to search for entry, replace it
		// changeFile(Path file, String s) -- String s will search for every field/entire myBook.toString()
		// will not work lel
		
		try
		{
			InputStream iStream = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
			OutputStream outStr = new BufferedOutputStream(Files.newOutputStream(file, WRITE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStr));
			String testRec = reader.readLine();
			if(oldRecord.equalsIgnoreCase(testRec)){
				writer.write(newRecord);
			}
			

			writer.close();

		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
	public static void deleteFile(Path file, String s){
		// need to search for entry, delete it/replace with blank
		
		try
		{
			InputStream iStream = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
			OutputStream outStr = new BufferedOutputStream(Files.newOutputStream(file, WRITE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStr));
			writer.write(" \n");
			writer.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
	public static void displayFile(/* need to figure out what argument */){
	// checks each text field and searches file, displays matches	
	}
	public static void displayStats(Path file){ // unnecessary atm
	// displays attributes of file
	}
	
}
