package AbstractFactory;

public class JudcatQuizFactory implements JudgeIngredientFactory {
    //吹罚测验
    @Override
    public Breed CreateRace() {
        return new Judcat();
    }

    @Override
    public GameType CreateType() {
        return new CompQuiz();
    }
}
