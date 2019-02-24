COMP90049 Knowledge Technologies - Project 1

The project includes the following files:
-	README.txt: this file describes the files that have been used in the project and how they work
-	misspell.txt: a list of 716 misspelled words, one per line.
-	correct.txt: a list of words which are the correct spellings for the 716 misspelled words
-	dictionary.txt: a list of about 400,000 English language words
-	EditDistance.java: it implements the Levenshtein distance on each word in the misspelled.txt file and dictionary.txt file and returns the distance in the form of an integer. 
-	Ngram.java: it implements the N-Gram Distance method on each word in the misspelled.txt and dictionary.txt file and returns the distances in the form of a double.
-	Main.java: it reads the 3 text files, namely, misspell.txt, dictionary.txt and correct.txt and puts them into an arraylist. It then evaluates the performance of the two methods on the basis of Precision and Recall. 
-	The Levenshtein distance has been sourced from: https://blog.csdn.net/zzq900503/article/details/36901149
-	The N-Gram Distance has been sourced from: https://itssmee.wordpress.com/2010/06/28/java-example-of-n-gram/