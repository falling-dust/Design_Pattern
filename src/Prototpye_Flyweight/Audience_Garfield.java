package Prototpye_Flyweight;

public class Audience_Garfield extends Audience {
    public Audience_Garfield() {
        race = "加菲猫";
    }

    public Audience_Garfield(String color) {
        this.color = color;
    }

    @Override
    public void printRace() {
        System.out.println("这只加菲猫的颜色为：" + color + ", 年龄为:" + age + ", 性别为:" + sex);
    }
}
