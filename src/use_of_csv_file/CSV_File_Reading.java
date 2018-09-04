package use_of_csv_file;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;

public class CSV_File_Reading {

	public static void main(String[] args)  {
		
		try {
			CsvReader readfile =new CsvReader("D:\\SaiSmita\\Selenium Practise\\CSV_File\\text1.csv");
			readfile.readHeaders();
			
			int noOfheadrer=readfile.getHeaderCount();
			
			for(int i=0;i<noOfheadrer;i++) {
				System.out.print(readfile.getHeader(i)+",    ");
			}
			
			System.out.println();
			while(readfile.readRecord()) {
			String TestId = readfile.get("TestId");
			String TestName = readfile.get("TestName");
			

			System.out.println(TestId +",   " +TestName +",   ");
			}
			
			readfile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
