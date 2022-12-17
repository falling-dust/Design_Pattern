package AbstractFactory;

public class JudcatPageantFactory implements JudgeIngredientFactory {
    // 吹罚选美
    @Override
    public Breed CreateRace() {
        return new Judcat();
    }

    @Override
    public GameType CreateType() {
        return new CompPageant();
    }
}
