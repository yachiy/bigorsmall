package yachiy.bigorsmall.domain;

/**
 * プレイヤーを表すモデル
 */
public class Player {
    private Long playerId;
    private String name;
    private Score score;

    public Player(Long playerId, String name, Score score) {
        this.playerId = playerId;
        this.name = name == null || name.isEmpty() ? "名無しさん" : name;
        this.score = score;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }
}
