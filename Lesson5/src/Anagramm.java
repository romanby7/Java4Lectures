import java.util.HashSet;
import java.util.Set;

public class Anagramm {

    public static void main(String[] args) {
        Anagramm anagramm = new Anagramm("дата");
        anagramm.getAnagramm();
    }

    private Set<String> result = new HashSet<>();
    private char[] chars;

    public Anagramm(String word) {
        this.chars = word.toCharArray();
    }

    public void getAnagramm() {
        result.clear();
        getAnagramm(chars.length);
        for (String anagramm : result) {
            System.out.println(anagramm);
        }
    }

    private void getAnagramm(int currentSize) {
        if (currentSize == 1) {
            return;
        }

        for (int i = 0; i < currentSize; i++) {
            getAnagramm(currentSize - 1);
            result.add(new String(chars));
            rotate(currentSize);
        }
    }

    private void rotate(int currentSize) {
        int pos = chars.length - currentSize;
        char temp = chars[pos];
        for (int i = pos + 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = temp;
    }

    private void display() {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}
