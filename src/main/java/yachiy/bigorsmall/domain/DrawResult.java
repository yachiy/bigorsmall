package yachiy.bigorsmall.domain;

/**
 * 山札からトランプを一枚引いた結果を返却するPair
 */
public class DrawResult {
    private TrumpCard drew;
    private TrumpCards cards;

    public DrawResult(TrumpCard drew, TrumpCards cards) {
        this.drew = drew;
        this.cards = cards;
    }

    public TrumpCards getCards() {
        return cards;
    }

    public TrumpCard getDrew() {
        return drew;
    }
}
