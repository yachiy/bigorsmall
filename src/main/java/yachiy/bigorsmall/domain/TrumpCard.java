package yachiy.bigorsmall.domain;

/**
 * トランプのカード1枚を表すモデル
 */
public class TrumpCard {
    /**
     * トランプに描かれている数字
     */
    private int number;

    public TrumpCard(int number) {
        if (number < 1 || number > 13) {
            throw new IllegalArgumentException(
              String.format("トランプに存在しない数値です（number:%s）", number));
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}