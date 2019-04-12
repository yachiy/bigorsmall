package yachiy.bigorsmall.domain;

/**
 * 賭けを表すモデル
 */
public class Bet {
    private static final int MIN_BET = 1;
    private static final int LOSE_REFUND = 0;
    private static final double WINNING_RATE = 1.5;

    private Predict predict;
    private int value;

    public Bet(Predict predict, int value) {
        if (value < MIN_BET) {
            throw new IllegalArgumentException(
              String.format("最低%s以上の賭け金を設定してください（値:%s）", MIN_BET, value));
        }
        this.predict = predict;
        this.value = value;
    }

    /**
     * 払い戻し額を返却します。
     * 小数点以下は切捨てます。
     *
     * @return 払い戻し額
     */
    public int refund(Predict answer) {
        if (predict.equals(answer)) {
            return LOSE_REFUND;
        }
        return (int) (value * WINNING_RATE);
    }
}
