package subtask4

class Pangram {


    val vowelsArray = arrayOf('a', 'e', 'i', 'o', 'u', 'y')
    val consonantsArray = arrayOf('b', 'c', 'd', 'f', 'g', 'j', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z')

    fun isPangramVowelsConsonants(inputString: String, lettersArray: Array<Char>): Boolean {
        for (vowel in lettersArray)
        {
            if  (!inputString.toLowerCase().contains(vowel)) {
                return false
            }
        }
        return  true
    }


    // является ли строка панграммой
    fun isPangram(inputString: String): Boolean {
        if (isPangramVowelsConsonants(inputString, vowelsArray) and isPangramVowelsConsonants(inputString, consonantsArray))
            return  true
        return  false
    }


    // является ли символ гласной буквой
    fun isVowel(symb: Char): Boolean {
        if (vowelsArray.contains(symb.toLowerCase()))
            return true
        else return false
    }

    // является ли символ  согласной буквой
    fun isConsonant(symb: Char): Boolean {
        if (consonantsArray.contains(symb.toLowerCase()))
            return true
        else return false
    }


    // количество гласных (согласных ) в слове
    fun countOfLettersInWord(word: String, lettersFun: (symb: Char) -> Boolean):String
    {
        var lettersCount = 0
        var newWord = ""
        for (letter in word) {
            // текущая буква является гласной (согласной)
          if (lettersFun(letter)) {
              lettersCount++
              newWord += letter.toUpperCase()
          }
            else
          {
              newWord += letter
          }
        }
        newWord = lettersCount.toString() + newWord
        return  newWord
    }

    // количество букв в каждом cлове предложения
   fun countOfLettersInSentence(inputString: String, lettersFun: (symb: Char) -> Boolean):MutableMap<Int, List<String>> {
        var words = inputString.split("\\s++".toRegex()).toMutableList()
        // слова в предложении с количеством гласных/согласных
        var wordsMap : MutableMap<Int, List<String>> = mutableMapOf()
        for (i in 0..words.size-1)
        {
            var wordsList: MutableList<String> = mutableListOf()
            // текущее слово в строке
            var word = words[i]
            if (word  == "")
                continue
             //  перевод гласных/согласных в Upper и подсчет
            word = countOfLettersInWord(word, lettersFun)
            var symb:Int = word[0].toInt() - 48
            if (wordsMap.contains(symb))
                wordsList = wordsMap[symb] as MutableList<String>
            wordsList.add(word)
            wordsMap[symb] = wordsList
        }
        return wordsMap
   }

    fun sortWords(allWords : MutableMap<Int, List<String>>) : String
    {
        var sentence =  ""
        val sorted = allWords.toSortedMap()
        for ((key, value) in sorted)
        {
            var wordsList: MutableList<String> = mutableListOf()
            if (sorted.contains(key))
                wordsList = sorted[key] as MutableList<String>
                for (word in wordsList)
                    sentence += word + " "
        }
        return  sentence.substring(0,sentence.length-1)
    }

    // TODO: Complete the following function
    fun getResult(inputString: String): String {
        var answer = "";
        if (inputString == "")
            return  answer
        var allWords : MutableMap<Int, List<String>> = mutableMapOf()
        //  если текущая строка - панграмма
        if (isPangram(inputString))
            //  анализ гласных букв
            allWords = countOfLettersInSentence(inputString, ::isVowel)
        // если нет - анализ согласных букв
         else
            allWords = countOfLettersInSentence(inputString, ::isConsonant)
        // сортировка слов в мапе
        if (allWords.size != 0)
            answer = sortWords(allWords)
        return answer
    }
}



fun main(args: Array<String>) {
    val pangram = Pangram()
    //val str = "Pack my box with five dozen liquor jugs. - Mark Dunn"
    //val str =             "Sympathizing would fix Quaker objectives. Sympathizing would fix Quaker objectives. Sympathizing would fix Quaker objectives."
    //val str = "By Jove, my quick study of lexicography won a prize!"
    //val str = "1I'M 1Doe!!! 3HeLLo! 3JHoN"
    //val res = pangram.isPangram(str)
    val str = "Hello! I'm Jhon Doe!!!"
    val res = pangram.getResult(str)
    //print(res)
}



