package AbstractFactory;

public class JudcatHandcraftFactory implements JudgeIngredientFactory {
    // 吹罚技术比赛
    @Override
    public Breed CreateRace() {
        return new Judcat();
    }

    @Override
    public GameType CreateType() {
        return new CompHandcraft();
    }
}
