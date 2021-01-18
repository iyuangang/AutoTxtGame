public class Monster extends Character implements AttackJudge {

        Monster(String name, int HPMax, int attack, int define, int equipNum) {
                this.name = name;
                this.HPMax = HPMax;
                this.attack = attack;
                this.HP = HPMax;
                this.define = define;
                switch (equipNum) {
                        case 0:
                                this.equip = equip1.name;
                                this.attack += equip1.attack;
                                this.define += equip1.define;
                                break;
                        case 1 :
                                this.equip = equip2.name;
                                this.attack += equip2.attack;
                                this.define += equip2.define;
                                break;
                        case 2 :
                                this.equip = equip3.name;
                                this.attack += equip3.attack;
                                this.define += equip3.define;
                                break;
                        case 3 :
                                this.equip = equip4.name;
                                this.attack += equip4.attack;
                                this.define += equip4.define;
                                break;
                        case 4 :
                                this.equip = equip5.name;
                                this.attack += equip5.attack;
                                this.define += equip5.define;
                }
        }

        @Override
        public void attack(Player p, Monster m) {
                System.out.println("现在是【" + m.getName() + "】的回合：");
                int randNum = (int) (Math.random() * 6);
                int finalAttack = this.attack;
                String attackName = null;
                switch (randNum) {
                        case 0 :
                                finalAttack += skill1_monster.attack;
                                attackName = skill1_monster.name;
                                break;
                        case 1 :
                                finalAttack += skill2_monster.attack;
                                attackName = skill2_monster.name;
                                break;
                        case 2 :
                                finalAttack += skill3_monster.attack;
                                attackName = skill3_monster.name;
                                break;
                        case 3 :
                                finalAttack += skill4_monster.attack;
                                attackName = skill4_monster.name;
                                break;
                        case 4 :
                                finalAttack += skill5_monster.attack;
                                attackName = skill5_monster.name;
                                break;
                        case 5 :
                                attackName = "重力一击";
                }
                finalAttack -= p.getDefine();
                if (finalAttack > 0) {
                        p.setHP(p.getHP() - finalAttack);
                        System.out.println("【" + m.getName() + "】对【" + p.getName() + "】使用了@@" + attackName + "@@,造成了" + finalAttack + "点伤害");
                } else System.out.println(m.getName() + "对你没有造成伤害");
                System.out.println(m.getName() + "的回合结束。");
        }

        /*
         **显示怪物的血量
         */
        @Override
        public void show() {
                int j;
                System.out.print("【" + getName() + "】的血量为：");
                for (j = 0; j < getHP() / bloodGrid; j++) System.out.print("■");
                for (j = 0; j < (getHPMax() - getHP()) / bloodGrid; j++) System.out.print("□");
                System.out.println();
        }
}
