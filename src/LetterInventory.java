public class LetterInventory {
    private int size;
    private int[] elementData;

    public static final int ALPHABETS = 26;

    // Create an empty inventory.
    public LetterInventory() {
        elementData = new int[ALPHABETS];
    }

    // Create an inventory of letters based on the given data.
    public LetterInventory(String data) {
        elementData = new int[ALPHABETS];
        data = data.toLowerCase();
        for (int i = 0; i < data.length(); i++) {
            if (Character.isLetter(data.charAt(i))) {
                size++;
                elementData[data.charAt(i) - 'a']++;
            }
        }
    }

    // Return the amount of times a letter appears.
    public int get(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException();
        }
        letter = Character.toLowerCase(letter);
        return elementData[letter - 'a'];
    }

    // Set the count for a letter to a given value.
    public void set(char letter, int value) {
        if (!Character.isLetter(letter) || value < 0) {
            throw new IllegalArgumentException();
        }
        letter = Character.toLowerCase(letter);
        size -= elementData[letter - 'a'];
        elementData[letter - 'a'] = value;
        size += value;
    }

    // Return the size of the inventory.
    public int size() {
        return size;
    }

    // Return true if the inventory is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Return a String representation of the inventory.
    public String toString() {
        String result = "[";
        for (int i = 0; i < ALPHABETS; i++) {
            for (int j = 0; j < elementData[i]; j++) {
                result += (char) (i + 'a');
            }
        }
        return result + "]";
    }

    // Construct and return a new inventory representing the sum of the 2 inventories.
    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory("");
        for (int i = 0; i < ALPHABETS; i++) {
            char ch = (char) ('a' + i);
            int value = elementData[i] - other.get(ch);
            sum.set(ch, value);
        }
        return sum;
    }

    // Construct and return a new inventory representing the difference between the 2 inventories.
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory diff = new LetterInventory("");
        for (int i = 0; i < ALPHABETS; i++) {
            char ch = (char) ('a' + i);
            int value = elementData[i] - other.get(ch);
            if (value < 0) {
                return null;
            }
            diff.set(ch, value);
        }
        return diff;
    }

    // Return a double representing the percentage of the given letter in the inventory.
    public double getLetterPercentage(char letter) {
        if (isEmpty()) {
            return 0;
        }
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException();
        }
        return get(letter) / size();
    }
}
