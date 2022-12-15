package LazyInitialization;

import SimpleFactory.Cat;
import SimpleFactory.CatFactory;

import java.util.Scanner;

public class PetCatBattle {
    private Cat petCat;

    //养成资金暂时放这里，不知道后续调用是否方便
    private int money;

    //让构造函数为 private，这样该类就不会被实例化
    private PetCatBattle() {
    }

    //实例化函数
    public static PetCatBattle getInstance() {
        return SingletonHolder.instance;
    }

    //用于测试
    public void showMessage() {
        System.out.println("PetCatBattle System Created Successfully!");
    }

    //用于控制系统的流程
    public void systemController() throws CloneNotSupportedException{
        System.out.println("欢迎来到猫猫养成大比拼系统！你一开始拥有10000猫猫币，合理规划资产，养成最棒的猫猫吧！");
        Scanner input = new Scanner(System.in);

        //创建宠物猫猫
        System.out.println("给你要养的猫猫起个名字吧：");
        String name = input.nextLine();
        System.out.println("选择你的物种 [1]中华田园猫 [2]布偶猫 [3]加菲猫");
        int breedNum = input.nextInt();
        System.out.println("选择你的宠物血统等级 [1]宠物级（免费！） [2]血统级（1000猫猫币） [3]赛级（2000猫猫币）");
        int ancestryNum = input.nextInt();

        String breed = "";
        String ancestry = "";
        switch (breedNum) {
            //不同品种的猫基础属性不同
            case 1:
                breed = "中华田园猫";
                break;
            case 2:
                breed = "布偶猫";
                break;
            case 3:
                breed = "加菲猫";
                break;
            default:
                break;
        }
        switch (ancestryNum) {
            //不同等级的猫猫有基础属性加成，宠物级*1，血统级*1.1,赛级*1.2
            case 1:
                ancestry = "宠物级";
                money= 10000;
                break;
            case 2:
                ancestry = "血统级";
                money= 9000;
                break;
            case 3:
                ancestry = "赛级";
                money= 8000;
                break;
            default:
                break;
        }

        //调用简单工厂，快速生成猫猫实例
        CatFactory catFactory =new CatFactory();
        petCat = catFactory.createCat(breed,ancestry);
        petCat.setCatName(name);

        //构建其他对手猫猫(暂时还没构建)

        //构建比赛项目（运动比赛、选美比赛）

        //喂养猫猫（对应饮品台，我们补充消耗金币功能）

        //购买装备（选美装备、强化体能的装备）

        //可以考虑的其他要素：费用赚取、训练猫猫（强化属性），此点为拓展点，运动会代码没有

        //查看比赛成绩（查看粉丝数、人气值等）

        //询问成绩（暂时不知道怎么对应）

        //粉丝见面会（根据实际情况进行调整）

        //设计菜单

        //考虑限时养成要素？（每次重新选择，天数+1，结束时查看最终猫猫比赛的成绩）
        petCat.showCatInfo();
        System.out.println("养成比拼到此结束！");
    }


    private static class SingletonHolder {
        // 静态初始化器，有JVM来保证线程安全
        private static PetCatBattle instance = new PetCatBattle();
    }
}
