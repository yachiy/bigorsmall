package yachiy.bigorsmall.domain;

/**
 * トランプのカード1枚を表すモデル
 */
public class TrumpCard {

    public static int MIN_VALUE = 1;
    public static int MAX_VALUE = 13;
    public static int MARKS_COUNT = 4;

    /**
     * トランプに描かれている数字
     */
    private int number;

    public TrumpCard(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(
              String.format("トランプに存在しない数値です（number:%s）", number));
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}