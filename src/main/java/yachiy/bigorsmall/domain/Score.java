package yachiy.bigorsmall.domain;

/**
 * プレイヤーのスコア（所持コインの枚数）を表すモデル
 */
public class Score {

    /**
     * 初期所持枚数
     */
    private final int INITIAL_SCORE = 1000;

    /**
     * ゲームが終了するスコアの下限と上限
     */
    private final int MIN_OVER_SCORE = 0;
    private final int MAX_OVER_SCORE = 10000;

    /**
     * 所持コインの枚数
     */
    private int value;

    /**
     * スコアの初期生成時に使用するコンストラクタ
     */
    public Score() {
        this.value = INITIAL_SCORE;
    }

    private Score(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(
              String.format("負のスコアは生成できません(指定された値:%s)", value));
        }
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    /**
     * 現在のスコアに指定されたスコアを加算します。
     *
     * @param value 加算するスコア
     * @return 加算後のスコア
     */
    public Score plus(int value) {
        if (value < 1) {
            throw new IllegalArgumentException(
              String.format("スコアに加算できない数値です(指定された値:%s)", value));
        }
        return new Score(this.value + value);
    }

    /**
     * 現在のスコアから指定されたスコアを減算します。
     *
     * @param value 減算するスコア
     * @return 減算後のスコア
     */
    public Score minus(int value) {
        if (value < 1 || this.value - value < 0) {
            throw new IllegalArgumentException(
              String.format("スコアから減算できない数値です(指定された値:%s)", value));
        }
        return new Score(this.value - value);
    }

    /**
     * ゲームが終了するスコアか否かを返却します。
     *
     * @return ゲームが終了するスコアか否か
     */
    public boolean isOver() {
        return this.value == MIN_OVER_SCORE || this.value >= MAX_OVER_SCORE;
    }

}
