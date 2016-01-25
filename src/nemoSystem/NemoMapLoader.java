package nemoSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 */

/**
 * <pre>
 * 
 * 	|_ LoadMap
 * 
 * 1. 개요 : 맵 txt파일들을 읽어오는 함수들을 담아놓은 클래스이다.
 * 2. 작성일 : 2015. 11. 23.
 * </pre>
 * 
 * @author		: 최재혁
 * @version		: 1.0
 */
public class NemoMapLoader {

	public static final int XSIZE = 25;
	public static final int YSIZE = 20;
	
	/**
	 * text 파일로 작성된 맵을 불러와 배열 형태로 반환한다.
	 * @param dir
	 * @return
	 */
	public static byte[][] load(String dir) {
		String str;
		byte [][] arr = new byte [YSIZE][XSIZE];
		
		try(BufferedReader in = new BufferedReader(new FileReader(dir))) {
		
			String list="";
			
			
			while((str=in.readLine()) != null) {
				list += str;
			}
			
			int k=0;
			for(int y=0; y<YSIZE; y++) {
				for(int x=0; x<XSIZE; x++) { 
					arr[y][x] = (byte)(list.charAt(k++)-48);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arr;
	}
	
	/**
	 * maps 폴더에 들어있는 맵 리스트를 뽑아온다. 이중 랜덤으로 지정된 맵이 로딩된다.
	 * @return
	 */
	public static String[] searchFolder() {
		String path="maps/";
		
		File dirFiles=new File(path);
		File[] fileList=dirFiles.listFiles();
		String[] fileNames = new String[(int) fileList.length];
		
		for(int i = 0; i < fileList.length; ++i) {
		  if(fileList[i].isFile()) {
			  fileNames[i] = fileList[i].getName();
		  }
		}
		
		return fileNames;
	}
	
}
