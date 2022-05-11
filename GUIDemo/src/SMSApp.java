
import javax.swing.*;

import java.util.Scanner;

public class SMSApp{ // 
	
	public static void main(String args[]) { // The starting point of program execution 
		SMSApp obi = new SMSApp();
		
		String student = "John Doe"; // Anitialization
		int studentAge = 20;
		float studentHeight = 2.6F;
		char gender = 'F';
		double tuition = 200000;
		
		Scanner scan;
		String name;
		float height;
		int age;
		
		System.out.println(".................Students Details............");
		//.out.println("Students Name: " + student);
		//System.out.println("Students Age: " + studentAge);
		//System.out.println("Students Height: " + studentHeight);
		//System.out.println("Students Sex: " + gender);
		//System.out.println("Students Fee: " + tuition);
		
		
		
		System.out.println("------------------------------");
		
		//String students[] = {"John Doe", "Ron Weasley", "Basil Nzewure", "Jude Nzewure", "Cynthia Nzewure"};
		//System.out.println("The First Student In The List Is: " + students[0]);
		//System.out.println("The Second Student In The List Is: " + students[1]);
		
		for(int i = 1; i < 100000000; i++) {
			System.out.println("Litre sold: " + i);
			
			if(i == 500) {
				break;
				
				
			}
			scan = new Scanner(System.in);
			System.out.println("Please enter first number: ");
			int num1 = scan.nextInt();
			System.out.println("Please enter Second number: ");
			int num2 = scan.nextInt();
			System.out.println("Please enter third number: ");
			int num3 = scan.nextInt();
			int sum = num1 + num2 + num3;
			System.out.println("The summation of Num1, Num2 and Num3 is: " + sum);
			//name = scan.next();
			//System.out.println("Student Name: "+ name);
			age = scan.nextInt();
			System.out.println("Student Age: " + age);
			
		}
		
	}

}
