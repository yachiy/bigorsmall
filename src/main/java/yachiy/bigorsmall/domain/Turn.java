package yachiy.bigorsmall.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * ターンを表すモデル
 */
public class Turn {
    /**
     * 何ターン目か
     */
    private int count;

    /**
     * 各プレイヤーの賭け情報
     */
    private Map<Player, Bet> bets;

    /**
     * 山札から引いたカードと残りの山札のペア
     */
    private TrumpCard drawResult;

    /**
     * 山札
     */
    private TrumpCards trumpCards;

    /**
     * 初期化用コンストラクタ
     */
    public Turn() {
        this.count = 1;
    }

    /**
     * 内部変更用コンストラクタ
     *
     * @param count      ターン数
     * @param bets       賭け情報
     * @param drawResult 山札から引いたカード
     * @param trumpCards 残りの山札
     */
    private Turn(int count, Map<Player, Bet> bets, TrumpCard drawResult, TrumpCards trumpCards) {
        this.count = count;
        this.bets = bets;
        this.drawResult = drawResult;
        this.trumpCards = trumpCards;
    }

    /**
     * 各プレイヤーの賭けの意思を聞く。
     *
     * @param bets 各プレイヤーのかけの意思
     * @return 各プレイヤーの賭けの意思を示した状態のターンオブジェクト
     */
    public Turn bet(Map<Player, Bet> bets) {
        return new Turn(this.count, new HashMap<>(bets), null, this.trumpCards);
    }

    /**
     * 山札からカードを1枚引く処理を行う。
     *
     * @return 山札を引いた状態のターンオブジェクト
     */
    public Turn draw() {
        DrawResult drawResult = trumpCards.draw();
        return new Turn(this.count, this.bets, drawResult.getDrew(), drawResult.getCards());
    }

    /**
     * 次のターンに移行する処理を行う。
     *
     * @return 次のターンオブジェクト
     */
    public Turn next() {
        return new Turn(this.count + 1, null, null, this.trumpCards);
    }

    public Integer getCount() {
        return count;
    }

    public Map<Player, Bet> getBets() {
        return bets;
    }

    public TrumpCard getDrawResult() {
        return drawResult;
    }

    public TrumpCards getTrumpCards() {
        return trumpCards;
    }
}
