import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AutoTxtGame {
        private static final String[] monsterNames = {"奶大", "站长", "甘蔗佬", "小白白", "shmt86", "淡总"};
        private static int flag = 0;//1代表玩家胜利，2代表怪物胜利
        private static int reLife = 3;//可复活次数
        private static int award = 0;//记录玩家一共打败的怪物数

        public static void sleep(int time) {
                try {
                        Thread.sleep(time);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }

        public static void main(String[] args) {
                System.out.println("欢迎来到《文本自动打怪游戏》\n");
                Player player = createPlayer();
                System.out.println("角色创建完毕，开始您的游戏之旅吧。");
                while (player.getHP() > 0) {
                        sleep(300);
                        ArrayList<Monster> monsters = new ArrayList<>();
                        //随机生成1到3个怪物
                        int i;
                        int monsterNum = (int) (Math.random() * 3 + 1);
                        for (i = 0; i < monsterNum; i++) {
                                monsters.add(createMonster());
                        }
                        System.out.println("新的怪物已生成，勇敢的【" + player.getName() + "】，快去挑战他们叭！");
                        sleep(300);
                        for (i = 0; i < monsterNum; i++) {
                                System.out.println((i + 1) + ".【注意】您遇见了带有【" + monsters.get(i).getEquip() + "】的" + monsters.get(i).getName());
                        }
                        while (flag == 0) {
                                player.show();
                                for (i = 0; i < monsterNum; i++) {
                                        monsters.get(i).show();
                                }
                                sleep(300);
                                //随机指定一个怪物攻击
                                int attackedMon = (int) (Math.random() * monsterNum);
                                //玩家的回合
                                player.attack(player, monsters.get(attackedMon));
                                sleep(300);
                                //怪物的回合
                                for (i = 0; i < monsterNum; i++) {
                                        if (monsters.get(i).getHP() > 0) {
                                                monsters.get(i).attack(player, monsters.get(i));
                                                if(player.getHP()<=0) break;
                                        } else {
                                                award += 1;
                                                System.out.println("【" + monsters.get(i).getName() + "】已战死。");
                                                monsters.remove(i);
                                                if (monsterNum > 0) monsterNum -= 1;
                                        }
                                }
                                //如果怪物全部都已经被打败的话
                                if (monsterNum == 0) {
                                        flag = 1;
                                        System.out.println("【" + player.getName() + "】获得了胜利！");
                                        break;
                                }
                                if (player.getHP() <= 0) {
                                        flag = 2;
                                        System.out.println(monsters.get(i).getName() + "获得了胜利！");
                                        break;
                                }
                                sleep(200);
                        }
                        if (reLife > 0 && player.getHP() <= 0) {
                                player.setHP(player.getHPMax());
                                player.setDefine(player.getDefine() + 10);
                                reLife -= 1;
                                System.out.println("【来自曙光女神的庇护】您已复活一次，剩余复活次数：" + reLife);
                        } else if (reLife <= 0 && player.getHP() <= 0) {
                                System.out.println("勇士，您已战败......");
                                break;
                        }
                        flag = 0;
                        sleep(500);
                }
                System.out.println("您共计打败【" + award + "】只怪物，好样的，勇士！");
        }

        /*
         **创建玩家信息
         */
        private static Player createPlayer() {
                System.out.println("请先创建玩家角色：\n");
                Scanner sc = new Scanner(System.in);
                System.out.println("您的玩家名称为：");
                String name = sc.nextLine();
                //生命值判断
                System.out.println("\n您的生命值：");
                int bloodInit;
                while (!sc.hasNextInt()) {
                        System.out.println("请输入合理的血量值...");
                        sc = new Scanner(System.in);
                }
                bloodInit = sc.nextInt();
                while (bloodInit > 9999 || bloodInit < 0) {
                        System.out.println("请输入合理的血量值...");
                        bloodInit = sc.nextInt();
                }
                //攻击力判断
                System.out.println("\n您的攻击力：");
                int attack;
                while (!sc.hasNextInt()) {
                        System.out.println("请输入合理的攻击值...");
                        sc = new Scanner(System.in);
                }
                attack = sc.nextInt();
                while (attack > 999 || attack < 0) {
                        System.out.println("请输入合理的攻击值...");
                        attack = sc.nextInt();
                }
                //防御力判断
                System.out.println("\n您的防御力：");
                int define;
                while (!sc.hasNextInt()) {
                        System.out.println("请输入合理的防御值...");
                        sc = new Scanner(System.in);
                }
                define = sc.nextInt();
                while (define > 999 || define < 0) {
                        System.out.println("请输入合理的防御值...");
                        define = sc.nextInt();
                }
                //创建玩家角色
                return new Player(name, bloodInit, attack, define);
        }

        /*
         **随机生成怪物属性
         */
        private static Monster createMonster() {
                return new Monster(monsterNames[(int) (Math.random() * monsterNames.length)],
                                (int) (Math.random() * 60) + 60,
                                (int) (Math.random() * 10) + 1,
                                (int) (Math.random() * 19 + 1),
                                (int) (Math.random() * 5));
        }

        //    /*
        //    **展示选择界面:
        //    * 1.未战斗状态下的菜单
        //    * 2.战斗状态下的菜单
        //    * 3.使用道具菜单 ->暂未开启
        //    * 4.选择攻击的怪物菜单 -> 暂时只支持单个怪物
        //    * 5.展示商店物品菜单
        //    * 6.展示玩家的属性
        //     */
        //    private static void showChoice(int choice){
        //        switch (choice) {
        //            case 1 -> System.out.println("勇士，接下来您想 1.探索 2.商店 3.属性 4.退出？");
        //            case 2 -> System.out.println("勇士，接下来您想 1.选择攻击怪物 2.使用道具(暂未开启) 3.逃跑？");
        //            case 3 -> System.out.println("暂未开启");
        //            case 4 -> System.out.println("1."+monster.getName());
        //            case 5 -> System.out.println("商店系统暂未开启");
        //            case 6 -> System.out.println("玩家【"+player.getName()+"】\n"
        //                    +"当前血量："+player.getBlood()+"\n"
        //                    +"攻击力："+player.getAttack()+"   防御力："+player.getDefine());
        //        }
        //    }
}
