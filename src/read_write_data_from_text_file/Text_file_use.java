package read_write_data_from_text_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Text_file_use {

	public static void main(String[] args) throws IOException {
		
		 //Create File In D: Driver.  
		String TextFile="D:\\SaiSmita\\Selenium Practise\\textfile.txt";
		
		File fc=new File(TextFile); //Created object of java File class.
		
		fc.createNewFile(); //Create file.
	
	
	
	//Writing In to file.
	  //Create Object of java FileWriter and BufferedWriter class.
	
	FileWriter FW=new FileWriter(TextFile);
	BufferedWriter BW=new BufferedWriter(FW);
	BW.write("This is my first line"); //Writing In To File.
	BW.newLine(); //To write next string on new line.
	BW.write("This Is Second Line."); //Writing In To File.
	BW.close();
	
	//Reading from file.
	  //Create Object of java FileReader and BufferedReader class.
	  FileReader FR = new FileReader(TextFile);
	  BufferedReader BR = new BufferedReader(FR);
	  String Content = "";
	  
	  //Loop to read all lines one by one from file and print It.
	  while((Content = BR.readLine())!= null){
	   System.out.println(Content);
	  }
	
}
}