package Singleton_LazyInitialization;

import Composite.Menu;
import Composite.MenuOption;
import Facade.Facade;
import Iterator.CatContainer;
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
    public void systemController() throws CloneNotSupportedException {
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
                money = 10000;
                break;
            case 2:
                ancestry = "血统级";
                money = 9000;
                break;
            case 3:
                ancestry = "赛级";
                money = 8000;
                break;
            default:
                break;
        }

        //调用简单工厂，快速生成猫猫实例
        CatFactory catFactory = new CatFactory();
        petCat = catFactory.createCat(breed, ancestry);
        petCat.setCatName(name);
        CatContainer.getInstance().add(petCat);
        //构建其他对手猫猫(暂时还没构建)
        CatContainer.getInstance().add(catFactory.createCat("中华田园猫", "血统级"));
        CatContainer.getInstance().add(catFactory.createCat("布偶猫", "宠物级"));
        CatContainer.getInstance().add(catFactory.createCat("加菲猫", "赛级"));
        CatContainer.getInstance().add(catFactory.createCat("中华田园猫", "血统级"));
        CatContainer.getInstance().add(catFactory.createCat("布偶猫", "宠物级"));
        CatContainer.getInstance().add(catFactory.createCat("中华田园猫", "宠物级"));
        CatContainer.getInstance().add(catFactory.createCat("加菲猫", "血统级"));
        CatContainer.getInstance().add(catFactory.createCat("布偶猫", "赛级"));
        CatContainer.getInstance().add(catFactory.createCat("中华田园猫", "赛级"));
        CatContainer.getInstance().add(catFactory.createCat("加菲猫", "血统级"));
        //构建比赛项目
//        GamesBuilder.getInstance().buildGames();
//        for (Game game : GameContainer.getInstance().getGames()) {
//            game.showGameInfo();
//        }
        //检录
        Facade facade = new Facade();
        facade.method();
        //比赛正式开始
        Menu rootMenu = new Menu("大厅选择");
        //第一个比赛菜单
        Menu gameMenu = new Menu("比赛");
        //创建比赛实例
        //实例待填写
        int element = 0;
        MenuOption run_100 = new MenuOption("", CatContainer.getInstance().get(0));
        MenuOption run_1000 = new MenuOption("", CatContainer.getInstance().get(1));
        MenuOption swim_400 = new MenuOption("", CatContainer.getInstance().get(2));
        MenuOption boxing = new MenuOption("", CatContainer.getInstance().get(3));

        gameMenu.add(run_100);
        gameMenu.add(run_1000);
        gameMenu.add(swim_400);
        gameMenu.add(boxing);
        //喂养猫猫（对应饮品台，我们补充消耗金币功能）
        MenuOption drinkTable = new MenuOption("饮品台", element);
        MenuOption queryRank = new MenuOption("询问成绩", element);
        MenuOption buyEquipment = new MenuOption("买装备", element);
        MenuOption printRank = new MenuOption("打印成绩单", element);
        MenuOption meetAudience = new MenuOption("粉丝见面会", element);
        rootMenu.add(gameMenu);
        rootMenu.add(drinkTable);
        rootMenu.add(queryRank);
        rootMenu.add(buyEquipment);
        rootMenu.add(printRank);
        rootMenu.add(meetAudience);
        // 菜单以及选择返回
        rootMenu.printMenu();
        int i = input.nextInt();
        int gameVisited = 0;
        while (i != 0) {
            switch (i) {
                case 1: {//比赛
//                    gameMenu.printMenu();
//                    Game game;
//                    switch (input.nextInt()) {
//                        case 1:
//                            game = (OneHundredMetersRunning) (gameMenu.getMenu().get(0).option);
//                            if (game.isVisited()) {
//                                System.out.println("该项目已结束，请参加其他项目！");
//                                break;
//                            }
//                            Worker worker1 = new Worker();
//                            worker1.prepare((Preparation) game);
//                            game.gameStart();
//                            game.gameEnd();
//                            ++gameVisited;
//                            break;
//                        case 2:
//                            game = (OneThousandMetersRunning) (gameMenu.getMenu().get(1).option);
//                            if (game.isVisited()) {
//                                System.out.println("该项目已结束，请参加其他项目！");
//                                break;
//                            }
//                            Worker worker2 = new Worker();
//                            worker2.prepare((Preparation) game);
//                            game.gameStart();
//                            game.gameEnd();
//                            ++gameVisited;
//                            break;
//                        case 3:
//                            game = (FourHundredMetersSwimming) (gameMenu.getMenu().get(2).option);
//                            if (game.isVisited()) {
//                                System.out.println("该项目已结束，请参加其他项目！");
//                                break;
//                            }
//                            Worker worker3 = new Worker();
//                            worker3.prepare((Preparation) game);
//                            game.gameStart();
//                            game.gameEnd();
//                            ++gameVisited;
//                            break;
//                        case 4:
//                            game = (Boxing) (gameMenu.getMenu().get(3).option);
//                            if (game.isVisited()) {
//                                System.out.println("该项目已结束，请参加其他项目！");
//                                break;
//                            }
//                            game.gameStart();
//                            game.gameEnd();
//                            ++gameVisited;
//                            break;
//                        case 0:
//                            run_100.getLast().printMenu();
//                            i = input.nextInt();
//                            break;
//                        default:
//                            break;
//                    }
//                    if (gameVisited == 3) {
//                        System.out.println("");
//                    }
                    break;
                }
                case 2://饮品台
//                    CCommandFn CCommandFn = (CCommandFn) rootMenu.getMenu().get(1).option;
//                    boolean isDrink = false;
//                    try {
//                        isDrink = CCommandFn.CommandFn();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    if(isDrink){
//                        System.out.println("在饮品台休息了一会儿，状态提升！");
//                        switch (petCat.getCatState().toString()) {
//                            case "StatePerfect":
//                                break;
//                            case "StateGood":
//                                petCat.setCatState(new StatePerfect());
//                                break;
//                            case "StateTired":
//                                petCat.setCatState(new StateGood());
//                                break;
//                            default:
//                                break;
//                        }
//                        CMediatorFn.getInstance().MediateFn();
//                    }
                    break;
                //查看比赛成绩（查看粉丝数、人气值等）
                case 3://询问成绩
//                    System.out.println("输入要询问的猫猫编号：");
//                    int n = input.nextInt() - 1;
//                    //待修改
//                    System.out.println("选择要询问的比赛 [1]100m赛跑 [2]1000m赛跑 [3]400m游泳");
//                    int m = input.nextInt();
//                    Game game = GameContainer.getInstance().get(m - 1);
//                    if (!game.isVisited()) {
//                        System.out.println("该比赛尚未开始！");
//                        break;
//                    }
//                    CVisitorFn.VisitorFn(n, game);
                    break;
                case 4://购买装备
//                    //待修改
//                    System.out.println("欢迎光临运动装备专卖店！");
//                    System.out.println("选购心仪的装备 [1]运动跑鞋 [2]运动护腕");
//                    int k = input.nextInt();
//                    if (k == 1) {
//                        SportShoesFactory sportShoesFactory = new SportShoesFactory();
//                        Equipment sportShoes = sportShoesFactory.createEquipment(player);
//                        EquipmentImplementor ei = new PerfectEquip();
//                        AbstractAnimalEquip equipment = new SportShoesEquipment(ei);
//                        equipment.EquipEquipment(player, sportShoes);
//                    } else if (k == 2) {
//                        BracerFactory bracerFactory = new BracerFactory();
//                        Equipment bracer = bracerFactory.createEquipment(player);
//                        EquipmentImplementor ei = new PerfectEquip();
//                        AbstractAnimalEquip equipment = new BracerEquipment(ei);
//                        equipment.EquipEquipment(player, bracer);
//                    }
                    break;
                case 5:
//                    ScoreSheet proxyScoreSheet = new ProxyScoreSheet();
//                    proxyScoreSheet.printScoreSheet();
                    break;
                case 6:
//                    try {
//                        CPrototypeFn.PrototypeFn();
//                    } catch (CloneNotSupportedException e) {
//                        e.printStackTrace();
//                    }
                case 0:
                    break;
                default:
                    break;
            }
//            if (gameVisited == 3) {
//                System.out.println("所有比赛均已结束！");
//                break;
//            }
            rootMenu.printMenu();
            i = input.nextInt();
//        }
//        System.out.println("动物运动会到此结束！");
//    }
        }
        petCat.showCatInfo();
        System.out.println("养成比拼到此结束！");
    }
    private static class SingletonHolder {
        // 静态初始化器，有JVM来保证线程安全
        private static PetCatBattle instance = new PetCatBattle();
    }
}
