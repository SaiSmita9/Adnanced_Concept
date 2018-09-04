package use_of_csv_file;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;

public class ReadCSVFile {

	public static void main(String[] args) {
        try {

            CsvReader testcases = new CsvReader("D:\\SaiSmita\\Selenium Practise\\CSV_File\\text.csv");

            testcases.readHeaders();
            //get total numbers of header column
           int numberOfHeaders=testcases.getHeaderCount();
           
         //  System.out.println(numberOfHeaders);
           
            //print header column
            for(int i=0;i<numberOfHeaders;i++)
            {
                System.out.print(testcases.getHeader(i)+",  ");
            }
            System.out.println();
            while (testcases.readRecord())
            {
                String TestId = testcases.get("TestId");
                String TestName = testcases.get("TestName");
                String TestModule = testcases.get("TestModule");
                String TestType = testcases.get("TestType");
                String TestSteps = testcases.get("TestSteps");
                String Action = testcases.get("Action");
                String TestResult = testcases.get("TestResult");
                String Note = testcases.get("Note");
                 // output file content
                System.out.println(TestId +",   " + TestName +",    " + TestModule +",  " + TestType +",    " + TestSteps +",   " + Action +",  " + TestResult+",   "+Note);
            }

            testcases.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
