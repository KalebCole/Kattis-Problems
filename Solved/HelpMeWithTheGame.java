import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;

class HelpMeWithTheGame {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String[][] board = new String[8][8];
		fillBoard(board);
		
		ArrayList<String> white = new ArrayList<>();
		ArrayList<String> black = new ArrayList<>();
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if(board[row][col].equals("P")) white.add("T"+(char)(col+97)+((8-row)));
				else if(board[row][col].equals("p")) black.add("t"+(char)(col+97)+((8-row)));
				else if(board[row][col].equals("k") || board[row][col].equals("q") || board[row][col].equals("r") || board[row][col].equals("n") || board[row][col].equals("b")) black.add(board[row][col]+(char)(col+97)+((8-row)));
				else if(board[row][col].equals("K") || board[row][col].equals("Q") || board[row][col].equals("R") || board[row][col].equals("N") || board[row][col].equals("B")) white.add(board[row][col]+(char)(col+97)+((8-row)));
			}
		}
		Collections.sort(white, new HelpMeWithTheGameComparator());
		Collections.sort(black, new HelpMeWithTheGameComparator());
		
		
		
		System.out.print("White: ");
		for (int i = 0; i < white.size(); i++) {
			if(i == white.size()-1) {
				if(white.get(i).charAt(0) =='T') System.out.printf("%s",white.get(i).substring(1));
				else System.out.printf("%s",white.get(i));
			}
			else {
				if(white.get(i).charAt(0) =='T') System.out.printf("%s,",white.get(i).substring(1));
				else System.out.printf("%s,",white.get(i));
			}
			
		}
		System.out.print("\nBlack: ");
		for (int i = 0; i < black.size(); i++) {
			if(i == black.size()-1) {
				if(black.get(i).charAt(0) =='t') System.out.printf("%s",black.get(i).substring(1));
				else {
					char temp = Character.toUpperCase(black.get(i).charAt(0));
					System.out.printf("%c%s",temp, black.get(i).substring(1));	
				}
			}
			else {
				if(black.get(i).charAt(0) =='t') System.out.printf("%s,",black.get(i).substring(1));
				else {
					char temp = Character.toUpperCase(black.get(i).charAt(0));
					System.out.printf("%c%s,",temp, black.get(i).substring(1));	
				}
			}
			
		}
		

	}

	public static void fillBoard(String[][] board) {

		String space = "";
		for (int i = 0; i < 8; i++) {
			sc.next(); // part of board
			space = sc.next();
			int k = 0;
			int spaceIndex = 0;
			int j = 0;
			while (j < space.length()) {// go from beginning to end of the row
				if (spaceIndex == 2) {
					board[i][k] = "" + space.charAt(j);
					k++;
				}
				if (space.charAt(j) == '|')
					spaceIndex = 1;
				else
					spaceIndex++;
				j++;

			}
		}
	}

}
class HelpMeWithTheGameComparator implements Comparator<String> {
	
	@Override
	public int compare(String o1, String o2) {
		HashMap<Character, Integer> whitePiece = new HashMap<>();
		whitePiece.put('K', 4);
		whitePiece.put('Q', 3);
		whitePiece.put('R', 2);
		whitePiece.put('B', 1);
		whitePiece.put('N', 0);
		HashMap<Character, Integer> blackPiece = new HashMap<>();
		blackPiece.put('k', 4);
		blackPiece.put('q', 3);
		blackPiece.put('r', 2);
		blackPiece.put('b', 1);
		blackPiece.put('n', 0);

		if (whitePiece.containsKey(o1.charAt(0)) && whitePiece.containsKey(o2.charAt(0))) { // white pieces
			if (whitePiece.get(o1.charAt(0)) < whitePiece.get(o2.charAt(0)))
				return 1;
			else if (whitePiece.get(o1.charAt(0)) > whitePiece.get(o2.charAt(0)))
				return -1;
			else {
				if (o1.charAt(2) < o2.charAt(2))
					return -1;
				else if (o1.charAt(2) > o2.charAt(2))
					return 1;
				else
					return 0;
			}
		} else if (blackPiece.containsKey(o1.charAt(0)) && blackPiece.containsKey(o2.charAt(0))) { // black pieces
			if (blackPiece.get(o1.charAt(0)) > blackPiece.get(o2.charAt(0)))
				return -1;
			else if (blackPiece.get(o1.charAt(0)) < blackPiece.get(o2.charAt(0)))
				return 1;
			else {
				if (o1.charAt(2) > o2.charAt(2))
					return -1;
				else if (o1.charAt(2) < o2.charAt(2))
					return 1;
				else
					return 0;
			}
		} else if (whitePiece.containsKey(o1.charAt(0)) || blackPiece.containsKey(o1.charAt(0))) { // o2 is a pawn
			return -1;
		} else if (whitePiece.containsKey(o2.charAt(0)) || blackPiece.containsKey(o2.charAt(0))) { // o1 is a pawn
			return 1;
		}

		else { //both are pawns
			if(Character.isLowerCase(o1.charAt(0)) && Character.isLowerCase(o2.charAt(0))) { //black pawns
					if(o1.charAt(2) > o2.charAt(2)) return -1;
					else if(o1.charAt(2) < o2.charAt(2)) return 1;
					else return 0;
			}
			else if(Character.isUpperCase(o1.charAt(0)) && Character.isUpperCase(o2.charAt(0))) { //white pawns
					if(o1.charAt(2) < o2.charAt(2)) return -1;
					else if(o1.charAt(2) > o2.charAt(2)) return 1;
					else return 0;
			} 
		}
		
		

		return 0;

	}

}
