package trees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader; //All the pakages the program uses
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	//Checks if String is valid
	private static boolean isValid(String element){
		for(int i=0; i<element.length();i++){
			if((element.charAt(i)>=65 && element.charAt(i)<=90) || (element.charAt(i)>=97 && element.charAt(i)<=122)) //Checks if it is a character alphabet
				return true;
			else return false;
		}
		return true;
	}


	public static void main(String[] args)throws IOException { //Throws the file not found exception
		Scanner scanD=new Scanner(System.in); //Creates a scanner class
		int list[] = new int[15]; //creates an Array



		int numOfwords=0; //Declares a variable to count the total nodes
		int repeatedWords=0; //Keeps the count of the repeated counts
		int frequency=0; //tracks the number of frequency of the selected word
		String[] RepeatedWordList=new String[189509]; //String of repeated words
		BST tree = BST.BSTree(); //instance of the class BST




		Scanner scan=null;
		String delim="! @#$%^&*()_+-=/*-+.,.;[]\\<>?:{}\""; //checks to see the word contains any of the following characters.
		File file = new File("data.txt"); //reads the file called data
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found."); //Throws the file not found exception
		}


		StringTokenizer tok; //Tokenizer to separate the each word in aline from the text file
		while(scan.hasNextLine()){ //While there is more lines in the array
			tok=new StringTokenizer(scan.nextLine(),delim);

			while (tok.hasMoreElements()) //while there is more words left in the sentence
			{
				String nextword = tok.nextToken().toLowerCase(); //Changes everything to lowercase

				if(isValid(nextword)){ //while word is valid
					numOfwords++; //increases the count
					//If duplicate found go and increase that duplicates word count
					if(tree.contains(nextword)){
						System.out.println("NA");

						RepeatedWordList[repeatedWords]=nextword;
						repeatedWords++;
						//create an array to store all the repeated words....
						//then at last create an array to store the tree elements and counrt the frequency
					}
					//Else insert
					else{
						tree.insert(nextword);
					}

					//tree.insert(nextword);
					//word = input.readLine();
				}
			}

		}

		tree.printInOrder(); //Prints the inorder traversal


		System.out.println("Total Num of Words:"+numOfwords); //Displays the num of count

		//tree.displayArray();
		System.out.println("Enter the word to search the ferquency"); //User enters the frequency count
		String inputWord=scanD.nextLine();

		if(tree.contains(inputWord)){ //checks if the tree has the value
			for(int i=0;i<repeatedWords;i++){
				String currWord=RepeatedWordList[i]; //these process checks the frequency of the word entered by the user. 
				if(currWord.equals(inputWord)) 
					++frequency;
			}
			System.out.println("The word is repeated "+ (frequency+1)+" times");
		}
		for(int i=1;i<499;i++){ //This loop is used to display the most unique words used in the BST. Since the runtime is very high I have only testd for the first 400 words.
			String uniqueWords = null;
			for(int j=1;j<repeatedWords;j++){
				if(tree.anArray[i]!=RepeatedWordList[j]){
					uniqueWords=tree.anArray[i];
				}

			}
			System.out.print("   Unique Words: "+uniqueWords);

		}
		
		/*for(int i=0;i<400;i++){ //This loop is used to display the most unique words used in the BST. Since the runtime is very high I have only testd for the first 400 words.
String freqWords = null;
int minCount1=0;
int minCount2=0;
for(int j=0;j<repeatedWords-1;j++){
if(tree.anArray[i]==RepeatedWordList[j]){

minCount1++;
}
if(tree.anArray[i+1]==RepeatedWordList[j+1]){
minCount2++;
}
if(minCount2>minCount1){
freqWords=tree.anArray[i];
}
else freqWords=tree.anArray[i+1];

}
System.out.print("   Frequent Words: "+freqWords+" Times"+minCount1);


}}*/ //This is for the most frequent words in the list.



		System.out.println("\n \n PLEASE WAIT WHILE THE PROGRAM IS LOADING");

		//Displays an error message, program exits

		int count2 = 0;														//The variables that is going to be used in the method below
		int count1 = 0;
		String pupular1 =null;
		String popular2 =null;

		
		for (int i = 0; i < repeatedWords; i++)								//The following method stores the most frequent words in the file.
		{
			pupular1 = RepeatedWordList[i];									//initializes the variabe with the first element in the list
			count1 = 1;    //see edit

			for (int j = i + 1; j < repeatedWords; j++)
			{
				if (pupular1 == RepeatedWordList[j]) count1++;				
			}

			if (count1 > count2)										//This condition tells the program which word has the most frequency and stores in the variable popular2
			{
				popular2 = pupular1;
				count2 = count1;
			}

			else if(count1 == count2)
			{
				if(popular2.compareToIgnoreCase(pupular1)<0){			//THis does not affect the program

					popular2 = popular2;
				}    
				else popular2=pupular1;

			}

		}
		System.out.println();
		System.out.println("MOST FREQUENT WORD: "+popular2);								//Creates two local variable popular and displays the most popular word in the list.
		
		System.out.println("\n The List of words in Sorted order:");
		for(int i=0;i<1895;i++){															//The following displays the list of words in sorted order DUE TO LARGE RUN TIME, I HAVE ONLY DISPLAYED 2000 WORDS
			
			System.out.print(" "+tree.anArray[i]);
		}
		
		
		
		System.out.println("\n \n PLEASE WAIT WHILE THE PROGRAM IS LOADING");
		int[] countList=new int[400];													//Initializes the variables that is going to be used in the next method
		String[] frequentWordList=new String[400];
		//THIS METHOD IS USED TO DISPLAY THE LEAST FREQUENTLY USED WORDS
		for(int i=0;i<400;i++){
			int counter=0;
			String currWord=tree.anArray[i];
			for(int j=0;j<repeatedWords;j++){
			if(currWord.equalsIgnoreCase(RepeatedWordList[j])){
				counter++;
				//System.out.println(counter);
			}
			countList[i]=counter;
		}
			
			frequentWordList[i]=currWord;
		}
		int min=0,index=0;
		for(int i=0;i<400;i++){
			min=countList[i];
			System.out.println(min);
			index=i;
			for(int j=i;j<400;j++){
				
				if(min>countList[j] && (countList[j]>0)){
					min=countList[j];
					System.out.println(countList[j]);
					index=j;
				}
			}
			System.out.println("The less frequent word is "+frequentWordList[index]+" Repeated "+ countList[index]+" times");
		}
		
	}}