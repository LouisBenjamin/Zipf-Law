# Zipf-Law
In 1935, the American linguist George Zipf noticed something very peculiar with the books he was reading. Whenever he would count the words in his books, he noticed that most of the words appeared only once and a small number of words appeared very frequently. In addition, this phenomenon seemed to hold true for any text and in any language.
In technical terms: 
- Words that appear frequently and that happen to be short are called stop-words.
- Words that only appear once are called happax legomena.

This program verifies Zipf’s law with any text. Specifically, it prompts the user to input a file and counts how many words the file contains and displays each word in the text along with its rank and frequency. It only scans words that contains only letters. For example “U2”, “data-base” and “hi!” are not counted as words. The list of rank/word/frequency is displayed in descending order of frequency, and all words with the same frequency are displayed in alphabetical order (uppercases before lowercases).

This program:
- Displays the total number of word tokens and word types. The number of word tokens refers to the total number of words in the text; whereas the number of word types refers to the number of different words in the text. For example, if the word “the” appears 30 times, it will count as 30 word tokens, but only 1 word type.
- Displays statistics on the happax legomena:  the number of happax, the percentage of happax, and how many of the tokens in the text they account for.
- Displays statistics on the stops words: the number of stop words, the percentage of stop words (nb stop words ÷ nb of word types), and how many of the tokens in the text they account for.

I am not the owner of this text, I simply edited it.
All credit goes to Dr. Aiman Hanna and the ENCS Department of Concordia University.

