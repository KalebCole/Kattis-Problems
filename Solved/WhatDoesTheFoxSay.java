import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class WhatDoesTheFoxSay {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < t; i++) {
			ArrayList<String> list = new ArrayList<>();
			String[] lineArr = sc.nextLine().split(" ");
			for (int j = 0; j < lineArr.length; j++) {
				list.add(lineArr[j]);
			}
			
			while(true) {
				String line = sc.nextLine();
				if(line.equals("what does the fox say?")) break; 
				lineArr = line.split(" ");
				line = lineArr[2]; //sound
				while(list.contains(line)) list.remove(line);
			}
			for (String s : list) {
				System.out.print(s+" ");
			}
			
		}

	}

}
