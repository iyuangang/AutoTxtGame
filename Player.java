import java.util.Scanner;

public class Player extends Character implements AttackJudge {
        //创建新的角色
        Player(String name, int HPMax, int attack, int define) {
                this.name = name;
                this.HPMax = HPMax;
                this.HP = HPMax;
                this.attack = attack;
                this.define = define;
        }

        @Override
        public void attack(Player p, Monster m) {
                System.out.println("现在是【" + p.getName() + "】的回合：");
                int randNum = (int) (Math.random() * 6);
                int finalAttack = this.attack;
                String attackName = null;
                switch (randNum) {
                        case 0 :
                                finalAttack += skill1_player.attack;
                                attackName = skill1_player.name;
                        case 1 :
                                finalAttack += skill2_player.attack;
                                attackName = skill2_player.name;
                        case 2 :
                                finalAttack += skill3_player.attack;
                                attackName = skill3_player.name;
                        case 3 :
                                finalAttack += skill4_player.attack;
                                attackName = skill4_player.name;
                        case 4 :
                                finalAttack += skill5_player.attack;
                                attackName = skill5_player.name;
                        case 5 :
                                attackName = "普通一击";
                }
                finalAttack -= m.getDefine();
                if (finalAttack < 0) finalAttack = 0;
                m.setHP(m.getHP() - finalAttack);
                System.out.println("【" + p.getName() + "】对【" + m.getName() + "】使用了@@" + attackName + "@@,造成了" + finalAttack + "点伤害");
                System.out.println("你的回合结束。");
        }

        /*
         **显示玩家血量值
         */
        @Override
        public void show() {
                int j;
                System.out.print("【" + getName() + "】" + "的血量为：");
                for (j = 0; j < getHP() / bloodGrid; j++) System.out.print("■");
                for (j = 0; j < (getHPMax() - getHP()) / bloodGrid; j++) System.out.print("□");
                System.out.println();
        }
}
