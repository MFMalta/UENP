package Mobs.Species;

import Mobs.Dragons;

public class Boss1 extends Dragons {

    public Boss1() {
    }

    ;
    //48 pontos
     public Boss1(int dragLvl) {
        dragLvl = 15;
        this.name = "Ahrmaak";
        this.maxHp = 55 * 5;
        this.hp = this.maxHp;
        this.atk = 75;
        this.def = 53;
        this.spd = 80;
        this.id = "BBD-001";
        this.xpd = 50 * dragLvl;
        this.lvl = dragLvl;
    }
}
