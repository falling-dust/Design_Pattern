package Template_Strategy;

import Builder.Game;
import Observer.ScoreSubject;
import Servant.Preparation;
import SimpleFactory.Athlete;
import SimpleFactory.Cat;
import State.StateCommon;
import State.StateGood;
import State.StatePerfect;
import State.StateTired;

import java.util.Random;

public class RaceComp extends Game implements Preparation {
    public RaceComp(String Name) {
        super(Name);
    }

    @Override
    public void gamePreparation() {
        System.out.println("OneHundredMetersRunning Game is preparing!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("OneHundredMetersRunning Game prepared!");
    }

    @Override
    public void gameStart() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("OneHundredMetersRunning Game Started!");
        for (int i = 0; i < 8; ++i) {
            getValue(i);
        }
        sortScore();
    }

    @Override
    public void gameEnd() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setVisited(true);
        System.out.println("OneHundredMetersRunning Game Finished!");
        System.out.println("100m赛跑最终成绩：");
        for (int i = 1; i <= 8; ++i) {
            System.out.println("参赛猫猫号码：" + i + "  名字：" + getCatLists().get(i - 1).getAnimalName() + "  成绩：" + getScore()[i - 1] + "秒");
        }
        System.out.println("第一名：" + getCatLists().get(getRankByRank()[0]).getAnimalName());
        System.out.println("第二名：" + getCatLists().get(getRankByRank()[1]).getAnimalName());
        System.out.println("第三名：" + getCatLists().get(getRankByRank()[2]).getAnimalName());
        System.out.println("你的名次：" + getRankByNO()[0]);
        ScoreSubject.getInstance().notifyObserver(2, getRankByNO(), getScore());
        if (getRankByNO()[0] >= 6) {
            switch (getCatLists().get(0).getAnimalState().toString()) {
                case "StatePerfect":
                    getCatLists().get(0).setAnimalState(new StateCommon());
                    break;
                case "StateGood":
                    getCateLists().get(0).setAnimalState(new StateTired());
                    break;
                case "StateTired":
                    break;
                default:
                    break;
            }
        } else if (getRankByNO()[0] == 1) {
            switch (getCatLists().get(0).getAnimalState().toString()) {
                case "StatePerfect":
                    break;
                case "StateGood":
                    getCatLists().get(0).setAnimalState(new StatePerfect());
                    break;
                case "StateTired":
                    getCatLists().get(0).setAnimalState(new StateCommon());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void getValue(int no) {
        Random rand = new Random();
        double random = (rand.nextInt(2000) + 9000);
        Cat athlete = getCatLists().get(no);
        double value = (athlete.getSpeed() * 1.1 + athlete.getBeauty() * 1.2 + athlete.getIntelligence() * 1 + athlete.getSkill() * 1.3) / athlete.getAnimalState().getState();
        double time = value * 0.5623183 * random / 10000;
        getScore()[no] = time;
    }

}
