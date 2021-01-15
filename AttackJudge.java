interface AttackJudge {
        static final double bloodGrid = 25.0;//每二十个血量显示一个格子
        String[] skill_player = {"千钧一棒", "大闹天宫", "七十二变", "洪荒•开天辟地", "究极•洪荒之力","普通一击"};
        String[] skill_monster = {"吞噬星空", "泰坦之力", "不周山之怒", "原暗•开天辟地", "究极•黑洞","重力一击"};
        String[] equip_monster = {"涛姐的屠龙宝刀", "定海神针", "东皇钟", "封神榜", "捆仙绳"};
        class skill1_player{
                static String name = skill_player[0];
                static int attack = 20;
        }
        class skill2_player{
                static String name = skill_player[1];
                static int attack = 30;
        }
        class skill3_player{
                static String name = skill_player[2];
                static int attack = 50;
        }
        class skill4_player{
                static String name = skill_player[3];
                static int attack = 80;
        }
        class skill5_player{
                static String name = skill_player[4];
                static int attack = 100;
        }
        class skill1_monster{
                static String name = skill_monster[0];
                static int attack = 20;
        }
        class skill2_monster{
                static String name = skill_monster[1];
                static int attack = 30;
        }
        class skill3_monster{
                static String name = skill_monster[2];
                static int attack = 50;
        }
        class skill4_monster{
                static String name = skill_monster[3];
                static int attack = 80;
        }
        class skill5_monster{
                static String name = skill_monster[4];
                static int attack = 100;
        }
        class equip1{
                static String name = "涛姐的屠龙宝刀";
                static int attack = 20;
                static int define = 10;
        }
        class equip2{
                static String name = "定海神针";
                static int attack = 30;
                static int define = 15;
        }
        class equip3{
                static String name = "东皇钟";
                static int attack = 30;
                static int define = 40;
        }
        class equip4{
                static String name = "封神榜";
                static int attack = 50;
                static int define = 40;
        }
        class equip5{
                static String name = "捆仙绳";
                static int attack = 60;
                static int define = 30;
        }

        void attack(Player p, Monster m);

        void show();//显示血量
}
