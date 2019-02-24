import java.io.*;
import java.util.*;

public class Main 
{
	/*
	 * This class reads the misspell.txt, dictionary.txt and correct.txt and evaluates the
	 * performance of Edit distance an N-Gram distance approximate matching methods 
	 * according to two evalauation metrics, Precision and Recall.
	 */
	public static void main(String [] args) throws Exception
	{	
		//Putting the list of words of misspell, dictionary and correct file into 3 different arrays
		ArrayList<String> misspell = new ArrayList<>();
		ArrayList<String> dictionary = new ArrayList<>();
		ArrayList<String> correct = new ArrayList<>();
		
		double misspell_counter = 0;
		BufferedReader misspell_file = new BufferedReader(new FileReader("src/Data/misspell.txt"));
		String misspell_word;
		
		while((misspell_word = misspell_file.readLine())!= null)  
		{
			misspell.add(misspell_word);
			misspell_counter++;
		}
	
		BufferedReader dictionary_file = new BufferedReader(new FileReader("src/Data/dictionary.txt"));
		String dictionary_word;
		while((dictionary_word = dictionary_file.readLine()) != null) 
		{
				dictionary.add(dictionary_word);
		}
						
		BufferedReader correct_file = new BufferedReader(new FileReader("src/Data/correct.txt"));
		String correct_word;		
		while((correct_word = correct_file.readLine()) != null) 
		{
			correct.add(correct_word);
		}
		
		//Levenshtein Distance evaluation
		double attempted_prediction_ed = 0;
		double correct_prediction_ed = 0;
		
		double precision_ed = 0;
		double recall_ed = 0;
		
		
		EditDistance obj_ed = new EditDistance();
		for(int i= 0; i<misspell.size(); i++)
		{
			for(int j = 0; j<dictionary.size();j++)
			{
				/*
				 * We have taken the maximum Edit Distance to be less than 2, to get the words
				 * which are close to the misspelled word as explained in the report.
				 */
				if(obj_ed.ld(misspell.get(i), dictionary.get(j)) < 2)
				{
					attempted_prediction_ed++;
					if(dictionary.get(j).equals(correct.get(i)))
					{
						correct_prediction_ed++;
					}
				}			
			}
		}
		
		System.out.println("Edit Distance performance:");
		
		precision_ed = (correct_prediction_ed/attempted_prediction_ed)*100;
		recall_ed = (correct_prediction_ed/misspell_counter)*100;
		System.out.printf("Precision is: %.2f \n",precision_ed);
		System.out.printf("Recall is: %.2f \n\n",recall_ed);
	
		//N-Gram Distance method evaluation
		double attempted_prediction_ngram = 0;
		double correct_prediction_ngram = 0;
		
		double precision_ngram = 0;
		double recall_ngram = 0;
		
		Ngram obj2 = new Ngram();
		for(int i = 0; i <misspell.size();i++)
		{
			for(int j = 0; j<dictionary.size();j++)
			{
				/*
				 * We have taken the maximum Distance to be greater than 2, to get the words
				 * which are close to the misspelled word as explained in the report.
				 */
				if(obj2.getSimilarity(misspell.get(i), dictionary.get(j), 2) > 0.5)
				{
					attempted_prediction_ngram++;
					if(dictionary.get(j).equals(correct.get(i)))
					{
						correct_prediction_ngram++;	
					}
				}
			}
		}
		
		System.out.println("2-gram performance:");
		precision_ngram = (correct_prediction_ngram/attempted_prediction_ngram)*100;
		recall_ngram = (correct_prediction_ngram/misspell_counter)*100;
		System.out.printf("Precision is: %.2f \n",precision_ngram);
		System.out.printf("Recall is: %.2f",recall_ngram);
		
		
	}
}
	
		
	

