package IntroToStacks;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		//Stack of Strings
		System.out.println("Here is a Stack of Strings: \n");
		
		Stack<String> flavors = new Stack<String>();
		flavors.push("Strawberry");
		flavors.push("Mint");
		flavors.push("Chocolate");
		flavors.push("Apple");
		flavors.push("Vanilla");
		flavors.push("Mango");
		
		//Since Mango was the last one pushed, it will be the first one popped.
		System.out.println("Popping off the top of the stack:");
		System.out.println(flavors.pop());
		
		//Clearing the stack
		int sz = flavors.size();
		System.out.println("\nPopping all the strings off the Stack:");
		for(int i = 0; i < sz; i++){
			System.out.println(flavors.pop());
		}
	}
}
