import java.util.stream.IntStream;

public class Vector {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    protected static int LetterToInt(char bukva) {
        return IntStream.range(0, letters.length)
                .filter(i -> letters[i] == bukva)
                .findFirst()
                .orElse(-1);
    }

    Vector(String coords) {
        this.x = LetterToInt(coords.charAt(0));
        if (coords.length() == 3) {
            this.y = Integer.parseInt(String.valueOf(coords.charAt(1)) + "" + coords.charAt(2)) - 1;
        } else this.y = Integer.parseInt(String.valueOf(coords.charAt(1))) - 1;
    }

    Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }
}