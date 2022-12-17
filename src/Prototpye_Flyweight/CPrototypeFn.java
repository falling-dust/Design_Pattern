package Prototpye_Flyweight;

import java.util.Scanner;




public class CPrototypeFn {
    public static void PrototypeFn() throws CloneNotSupportedException {
        AudienceCache.loadCache();

        System.out.println("请选择要接见的观众的种类：[1]中华田园猫 [2]加菲猫 [3]布偶猫");
        int counter = 0;
        int ChCountryCatCounter = 0;
        int GarfieldCounter = 0;
        int RagdollCounter = 0;
        String str = "";
        boolean flag = true;
        while (flag) {
            Scanner sc = new Scanner(System.in);
            str = sc.nextLine();
            switch (str) {
                case "1": {
                    //System.out.println("From Audience clone a new DogAudience!");
                    Audience clonedAudience = AudienceCache.getAudience("1");
                    System.out.println("这是一只" + clonedAudience.getRace());
                    counter++;
                    ChCountryCatCounter++;
                }
                ;
                break;
                case "2": {
                    //System.out.println("From Audience clone a new CatAudience!");
                    Audience clonedAudience = AudienceCache.getAudience("2");
                    System.out.println("这是一只" + clonedAudience.getRace());
                    counter++;
                    GarfieldCounter++;
                }
                ;
                break;
                case "3": {
                    //System.out.println("From Audience clone a new BirdAudience!");
                    Audience clonedAudience = AudienceCache.getAudience("3");
                    System.out.println("这是一只" + clonedAudience.getRace());
                    counter++;
                    RagdollCounter++;
                }
                ;
                break;
                case "view": {
                    System.out.println("观众数量为:" + counter);
                    System.out.println("中华田园猫数量为:" + ChCountryCatCounter);
                    System.out.println("加菲猫数量为:" + GarfieldCounter);
                    System.out.println("布偶猫数量为:" + RagdollCounter);
                }
                ;
                break;
                case "Q": {
                    flag = false;
                }
                ;
                break;
                default: {
                    System.out.println("输入无效，请重试!");
                }
                break;
            }
        }
    }
}
