package structure.sparsearray;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SparseArray {
	
	public static void main(String[] args) {
		//1. 原数组
		int[][] arr = new int[11][11];
		arr[1][2] = 1;
		arr[2][3] = 2;
		arr[6][5] = 2;
				
		for(int i = 0; i < 11 ;i++) {
			for(int j = 0; j < 11; j++) {
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.println();
		}
		
		//2.转为稀疏数组
		int sum = 0;
		for(int i = 0; i < 11 ;i++) {
			for(int j = 0; j < 11; j++) {
				if(arr[i][j] != 0) {
					sum++;
				}
			}
		}
		
		int[][] parseArr = new int[sum+1][3];
		// 记录原数组行数，列数以及有效数据个数
		parseArr[0][0] = 11;
		parseArr[0][1] = 11;
		parseArr[0][2] = sum;
		
		int count = 0;
		for(int i = 0; i < 11; i++ ) {
			for(int j = 0; j < 11; j++) {
				if(arr[i][j] != 0) {
					count++;
					parseArr[count][0] = i;
					parseArr[count][1] = j;
					parseArr[count][2] = arr[i][j];
					
				}
			}
		}
		
		OutputStream out = null;
		InputStream is = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(new File("src/structure/sparsearray/map.data"),true));
			is = new BufferedInputStream(new FileInputStream(new File("src/structure/sparsearray/map.data")));
			byte[] bytes = null;
			for(int[] row : parseArr) {
				bytes = String.format("%d\t%d\t%d\n", row[0],row[1],row[2]).getBytes();
				out.write(bytes);
				out.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//读取数据
		
		byte[] buffer = new byte[1024];
		int len = -1;
		String ar = null;
		try {
			System.out.println("读取文件...");
			len = is.read(buffer);
			ar = new String(buffer, 0, len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//转换为数组
		String[] rows = ar.split("\n");
		int[][] readArr = new int[rows.length][3];
		for(int i = 0; i < rows.length; i++) {
			String[] cells = rows[i].split("\t");
			for(int j = 0; j < cells.length; j++) {
				readArr[i][j] = Integer.parseInt(cells[j]);
			}
		}
		
		//3.转换为原数组
		int[][] rest = new int[readArr[0][0]][readArr[0][1]];
		for(int i = 1; i < sum+1; i++) {
			rest[readArr[i][0]][readArr[i][1]] = readArr[i][2];
		}
		
		System.out.println("转换为原数组");
		for(int i = 0; i < 11 ;i++) {
			for(int j = 0; j < 11; j++) {
				System.out.printf("%d\t", rest[i][j]);
			}
			System.out.println();
		}
		
	}

}
