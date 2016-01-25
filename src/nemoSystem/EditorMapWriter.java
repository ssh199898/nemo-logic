package nemoSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 
 */

/**
 * <pre>
 * 
 * 	|_ LoadMap
 * 
 * 1. 개요 : Editor에서 작성된 배열을 불러와 txt파일로 삭성한다.
 * 2. 작성일 : 2015. 11. 23.
 * </pre>
 * 
 * @author		: 최재혁
 * @version		: 1.0
 */
public class EditorMapWriter {

	public static final int XSIZE = 25;
	public static final int YSIZE = 20;
	
	public static void write(String dir, byte[][] arr) {
		String str="";
		
		StringBuilder sb = new StringBuilder(str);
		String path = "./maps/" + dir + ".txt";
		try(BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
		
			for(int y=0; y<YSIZE; y++) {
				for(int x=0; x<XSIZE; x++) { 
					str = ((Byte)arr[y][x]).toString();
					sb.append(str);
				}
				sb.append("\n");
			}
			out.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
	}
	
}
