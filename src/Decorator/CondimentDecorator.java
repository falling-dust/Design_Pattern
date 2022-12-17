package Decorator;

public class CondimentDecorator extends Food {
    //装饰者类（食品添加配料）

    private Food myFood;

    public CondimentDecorator(Food myFood) {
        this.myFood = myFood;
    }

    public Food getMyFood() {
        return myFood;
    }

    public String getDescription() {
        return "null";
    }

}
