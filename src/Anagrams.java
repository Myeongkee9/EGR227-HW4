import java.util.*;

public class Anagrams {
    private List<String> thisDictionary;
    private Map<String, LetterInventory> dictLetters;

    public Anagrams (List<String> dictionary) {
        thisDictionary = dictionary;
        dictLetters = new HashMap<String, LetterInventory>();
        for (String word : thisDictionary) {
            dictLetters.put(word, new LetterInventory(word));
        }
    }

    public void print(String text, int max) {
        LetterInventory input = new LetterInventory(text);

        if (max < 0) {
            throw new IllegalArgumentException("Max < 0.");
        }
        else {
            List<String> letterList = new ArrayList<String>();
            LetterInventory sortedInventory = new LetterInventory(text);
            for (String word : thisDictionary) {
                if (sortedInventory.subtract(dictLetters.get(word)) != null) {
                    letterList.add(word);
                }
            }
            Stack<String> stack = new Stack<String>();
            if (sortedInventory.isEmpty()) {
                System.out.println(stack);
            }
            if (max == 0 || max != stack.size())
            {
                for (String word : letterList)
                {
                    LetterInventory newInventory = sortedInventory.subtract(dictLetters.get(word));
                    if (newInventory != null)
                    {
                        stack.push(word);
                        stack.pop();
                    }
                }
            }
        }
        print(text, max);
    }
}
