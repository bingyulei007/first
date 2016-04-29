package com.bing.testMy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;

import com.bing.excel.reader.ExcelReadListener;
import com.bing.excel.reader.ExcelReaderFactory;
import com.bing.excel.reader.ReadHandler;
import com.bing.excel.vo.ListRow;


/**
 * Unit test for simple App.
 */
public class BingExcelTest1 
{
	@Test
	public void testme(){
		System.out.println(-6%3);
	}
	@Test
    public void  readExcel() throws Exception{
    	File file=new File("E:/test/person.xlsx");
    	ReadHandler handler = ExcelReaderFactory.create(file, new mylistener());
    	
    	handler.readSheet(0, 50);
    	
    }
    public class mylistener implements ExcelReadListener{

		public void endSheet(int index, String name) {
			System.out.println("第"+index+"个工作表,名称是："+name);
			
		}

		public void endWorkBook() {
			// TODO Auto-generated method stub
			
		}

		public void optRow(int arg0, ListRow arg1) {
			// TODO Auto-generated method stub
			System.out.println(arg1);
		}

		public void startSheet(int arg0, String arg1) {
			// TODO Auto-generated method stub
			System.out.println(arg0+arg1 );
		}
    	
    }
    
    
}
