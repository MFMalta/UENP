package Mobs.Species;

import Mobs.Dragons;
import java.util.Random;

/*
 * Pontos de distribuição 24 por dragão/ id1=atk bb vulcao id2=def bb id3=spd bb
 * id4=hp bb id5=std bb normal
 *
 * ATRIBUTOS: HP = 5* ++/-- *(5*(NÍVEL)) ATK/DEF/SPD = 5 * Lvl
 *
 */
public class Baby extends Dragons {

    //Construtor Vazio//
    public Baby() {
    }

    //Construtor Dragões Bebês 24 pts
    public Baby(int dragLvl) {
        int aux = 0;
        Random rand = new Random();
        rand = new Random();
        aux = rand.nextInt(3) + 1;

        switch (aux) {
            case 1://Balanceado
                this.name = "Dragao Bebê";
                this.maxHp = 5 * 5;
                this.atk = 5;
                this.def = 5;
                this.spd = 5;
                this.id = "BBD-001";
                this.xpd = 5 * dragLvl;
                break;
            case 2://atk++,spd+,def-,hp--
                this.name = "Dragao Bebê Furioso";
                this.maxHp = (5 + this.mns2) * 5;
                this.atk = 5 + this.pls2;
                this.def = 5 + this.mns;
                this.spd = 5 + this.pls;
                this.id = "BBD-002";
                this.xpd = 7 * dragLvl;
                break;
            case 3://atk--,spd-,def++,hp+
                this.name = "Dragao Bebê Irritado";
                this.maxHp = (5 + this.pls) * 5;
                this.atk = 5 + this.mns2;
                this.def = 5 + this.pls2;
                this.spd = 5 + this.mns;
                this.id = "BBD-003";
                this.xpd = 6 * dragLvl;
                break;
            default:
                break;
        }
        this.hp = this.maxHp;
        this.lvl = dragLvl;

    }
}
