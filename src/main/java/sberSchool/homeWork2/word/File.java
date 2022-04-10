package sberSchool.homeWork2.word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class File {
    private String path;
    private List<String> text = new ArrayList<>();

    public File(String path) {
        this.path = path;
    }

    public List<String> readFile() {
        try (FileReader fr = new FileReader(path);
             BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            while (line != null) {
                text.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public Set<String> uniqueWord() {
        if (text.size() == 0) {
            readFile();
        }
        String join = String.join(" ", text);
        String[] words = join.replaceAll("[^\\w^\\s]", "").split(" ");
        Set<String> uniqueWord = new HashSet<>();
        Collections.addAll(uniqueWord, words);
        return uniqueWord;
    }

    //Задание 1: Подсчитайте количество различных слов в файле.
    public Integer countUniqueWord() {
        return uniqueWord().size();
    }

    //Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
    public Set<String> uniqueWordSortedLength() {
        Set<String> sortedUniqueWord = new TreeSet<String>(Comparator.comparing(String::length)
                .thenComparing(String::compareTo));
        sortedUniqueWord.addAll(uniqueWord());
        return sortedUniqueWord;
    }

    //Задание 3. Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    public Map<String, Integer> countRepeatWord() {
        Map<String, Integer> countRepeatWord = new HashMap<>();
        Set<String> uniqueWord = uniqueWord();
        String join = String.join(" ", text);
        String[] words = join.replaceAll("[^\\w^\\s]", "").split(" ");
        for (String key: uniqueWord) {
            countRepeatWord.put(key,(int) Arrays.stream(words).filter(v -> v.equalsIgnoreCase(key)).count());
        }
        return countRepeatWord;
    }

    //Задание 4: Выведите на экран все строки файла в обратном порядке
    public List<String> reverseText() {
        if (text.size() == 0) {
            readFile();
        }
        List<String> reverseText = new ArrayList<>(text);
        Collections.reverse(reverseText);
        return reverseText;
    }

    public String choseLine(int numberLine) throws Exception {
        if (text.size() == 0) {
            readFile();
        }
        if (numberLine > text.size() || numberLine <= 0) {
            throw new Exception("Строки такой нет");
        }
        return text.get(numberLine - 1);
    }
}

