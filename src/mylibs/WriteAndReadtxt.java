package mylibs;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import jxl.*;
import jxl.read.biff.BiffException;
/****************
 * 文件读取与保存
 * 
 * @author Administrator
 * 
 ****************/
public class WriteAndReadtxt {
	   public static BufferedReader bufread;
	    //指定文件路径和名称
	    private  String path;
	    private   File filename;
	    private static String readStr ="";
	    public WriteAndReadtxt() {
		}
	    public WriteAndReadtxt(String path){
	    	this.path = path;
	    	filename = new File(path);
	    }
//	逐行写数据
	public void writeFile(String str, String savePath){
		FileWriter rw = null;
		try {
			rw = new FileWriter(savePath,true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(rw);
		try {
			bw.write("\n");
			bw.write(str);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("保存文件失败（路径错误）");;
		}
	}
	public void writeFile(String str){
		FileWriter rw = null;
		try {
			rw = new FileWriter(filename,true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(rw);
		try {
			bw.write("\n");
			bw.write(new String(str.getBytes("UTF-8")));

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("保存文件失败（路径错误）");;
		}
	}
	
//	只写一行数据
	public void writeline(String str, String savePath){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(savePath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			bw.write(str);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("保存文件失败（路径错误）");;
		}
	}


	public void readFileByLines(String fileName,int line) {
		File file = new File(fileName);
		BufferedReader reader = null;
	
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line1 = 0;
			
			// 读取单行
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
					if(line1==line){
						tempString=reader.readLine();
						System.out.println(tempString);
			}
					line1++;
					
			}
			reader.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
//		return toString();

	}

	public String readTxtFile() {
		String read;
		FileReader fileread;
		try {
			fileread = new FileReader(filename);
			bufread = new BufferedReader(fileread);
			try {
				while ((read = bufread.readLine()) != null) {
					readStr = readStr + read + "\r\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readStr;
	}
	/**
	 * excel文件的读取和写入
	 * @param args
	 * getCell x 列 y 行
	 */
	@SuppressWarnings("unchecked")
	public List readExcel(){
		List list = new ArrayList();
//		filename = new File("F:/TestReady/XiGua/data/coupon.xlsx");
	    Workbook rwb = null;
	    Cell cell = null;
//	    String[] skey = null;  
	    try {
//	    	引入输入流
			InputStream fos = new FileInputStream(filename);
//			选择excel文件
			rwb = Workbook.getWorkbook(fos);
//			读取sheet
			Sheet sheet = rwb.getSheet("Sheet1");
//			循环读取每行数据
			for(int i=1;i<sheet.getRows();i++){			
				list.add(sheet.getCell(0,i).getContents());
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (BiffException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	    
/*	    Iterator it = list.iterator();
	    while(it.hasNext()){
	    	System.out.println(it.next());
	    }*/
			    
	}
	/**
	 * 读取CSV
	 * @param args
	 */
	public void readCSV(String path){
		List<String[]> csvlist = new ArrayList<String[]>();
		try {
			CsvReader reader = new CsvReader(path,',',Charset.forName("GBK"));
			reader.readHeaders();
			while(reader.readRecord()){
				csvlist.add(reader.getValues());
			}
			reader.close();
			for(int row = 0;row<csvlist.size();row++){
//				取得第row行的第0列的数据
				String cell = csvlist.get(row)[0];
				System.out.println(cell);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 写入csv 参数写入值
	 * 逗号分隔字符串写多行单元格】
	 * endRecord方法分隔符是setRecordDelimiter方法设置的字符
	 * 构造方法的设置的字符 每个write方法间隔的字符
	 * @param args
	 * 
	 */
	public void writeCSV(String path,String ...a){
		CsvWriter writer;
		Collection<String> ll = new LinkedList<String>();
		for(int i=0;i<a.length;i++){
			ll.add(a[i]);
		}		
		try {
			writer = new CsvWriter(new FileWriter(path, true),'\n');
			writer.setRecordDelimiter(".".charAt(0));
			for(int i=0;i<a.length;i++){
				writer.write(a[i]);
			}
			writer.write("wr,200");
			writer.write("ss,299");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		WriteAndReadtxt fop = new WriteAndReadtxt();
//		fop.writeFile("阿斯蒂芬");
/*		fop.writeline("100-151515","d:/temporderid.txt");
		String aa = fop.readTxtFile();
		System.out.println(aa);*/

		fop.writeCSV("F:/TestReady/XiGua/data/1.csv","a,100","b,100");
		fop.readCSV("F:/TestReady/XiGua/data/1.csv");
//		System.out.println(fop.readExcel().get(1));	
	}

}