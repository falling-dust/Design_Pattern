import Singleton_LazyInitialization.PetCatBattle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("欢迎使用猫猫养成battle模拟系统！");
        System.out.println("选择启动模式 [1]游玩模式");
        Scanner input = new Scanner(System.in);
        int opt = input.nextInt();

        //创建比赛实例
        PetCatBattle petBattle = PetCatBattle.getInstance();

        //调用模拟比拼系统控制器（用于完成完整流程）
        petBattle.systemController();
    }
}