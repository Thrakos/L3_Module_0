package IntroToArrayLists;

import java.util.ArrayList;

public class IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> strings = new ArrayList<String>();
		
		//2. Add five Strings to your list
		strings.add("this is the first string");
		strings.add("this is the second string");
		strings.add("this is the fourth string");
		strings.add("no, it's not broken");
		strings.add("Exception in thread \"main\" java.lang.Error: Unresolved compilation problem: \n" + 
				"	Syntax error, insert \";\" to complete Statement\n" + 
				"\n" + 
				"	at IntroToArrayLists.IntroToArrayLists.main(IntroToArrayLists.java:16)");
		
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < strings.size(); i++) {
			String j = strings.get(i);
			System.out.println(j);
		}
		
		//4. Print all the Strings using a for-each loop
		System.out.println("\n");
		for (String s : strings) {
			System.out.println(s);
		}
		
		//5. Print only the even numbered elements in the list.
		System.out.println("\n");
		for (int i = 0; i < strings.size(); i += 2) {
			String j = strings.get(i);
			System.out.println(j);
		}
		
		//6. Print all the Strings in reverse order.
		System.out.println("\n");
		for (int i = strings.size() - 1; i >= 0; i--) {
			String j = strings.get(i);
			System.out.println(j);
		}
		
		//7. Print only the Strings that have the letter 'e' in them.
		System.out.println("\n");
		for (int i = 0; i < strings.size(); i++) {
			String j = strings.get(i);
			if (j.contains("e")) {
				System.out.println(j);
			}
		}
	}
}
