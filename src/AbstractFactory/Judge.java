package AbstractFactory;

public class Judge {
    /*   软件包指定种类和吹罚比赛，名字在game设置    */
    private String JudgeName;
    private Breed JudgeRace;
    private GameType gameType;

    private JudgeIngredientFactory factory;

    //getter & setter
    public JudgeIngredientFactory getFactory() {
        return factory;
    }

    public void setFactory(JudgeIngredientFactory factory) {//bind product factory
        this.factory = factory;
    }

    public String getJudgeName() {
        return JudgeName;
    }

    public void setJudgeName(String judgeName) {
        JudgeName = judgeName;
    }

    public GameType getGameType() {
        return gameType;
    }

    public Breed getJudgeRace() {
        return JudgeRace;
    }

    public void setJudgeRace(Breed judgeRace) {
        JudgeRace = judgeRace;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}
