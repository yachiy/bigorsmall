package yachiy.bigorsmall.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 山札を表すモデル
 */
public class TrumpCards {
    private List<TrumpCard> cards;

    public TrumpCards() {
        this.cards = initializeCards();
    }

    private TrumpCards(List<TrumpCard> cards) {
        this.cards = cards;
    }

    /**
     * カードを山札から1枚引き、引いたカードと残りの山札のペアを返却する。
     *
     * @return 引いたカードと山札のペア
     */
    public DrawResult draw() {
        List<TrumpCard> copy = new ArrayList<>(cards);
        TrumpCard drew = copy.get(0);
        copy.remove(0);
        Collections.shuffle(copy);
        return new DrawResult(drew, new TrumpCards(copy));
    }

    // TODO streamに直す
    private List<TrumpCard> initializeCards() {
        List<TrumpCard> initialList = new ArrayList<>();
        for (int i = TrumpCard.MIN_VALUE; i < TrumpCard.MAX_VALUE + 1; i++) {
            for (int k = 0; k < TrumpCard.MARKS_COUNT; k++) {
                initialList.add(new TrumpCard(i));
            }
        }
        Collections.shuffle(initialList);
        return initialList;
    }
}
