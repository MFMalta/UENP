package Mobs.Species;

import Mobs.Dragons;
import java.util.Random;

//Aqui é feita toda a construção dos Dragões Adultos.
public class Adult extends Dragons {
    //Construtor Vazio
    public Adult() {
    }
    ;
    //Base em 32 pontos.
     public Adult(int dragLvl) {
        int aux = 0;
        Random rand = new Random();
        rand = new Random();
        aux = rand.nextInt(3) + 1;

        switch (aux) {
            case 1://Balanceado.
                this.name = "Dragão";
                this.maxHp = 8 * 5;
                this.atk = 8;
                this.def = 8;
                this.spd = 8;
                this.id = "ADD-001";
                this.xpd = 10 * dragLvl;
                break;
            case 2://Ofensivo.
                this.name = "Dragão Ruby Furioso";
                this.maxHp = (8 + this.mns2) * 5;
                this.atk = 8 + this.pls2;
                this.def = 8 + this.mns;
                this.spd = 8 + this.pls;
                this.id = "ADD-002";
                this.xpd = 14 * dragLvl;
                break;
            case 3://Defensivo.
                this.name = "Dragão Safira Irritado";
                this.maxHp = (8 + this.pls) * 5;
                this.atk = 8 + this.mns2;
                this.def = 8 + this.pls2;
                this.spd = 8 + this.mns;
                this.id = "ADD-003";
                this.xpd = 12 * dragLvl;
                break;
            default:
                break;
        }
        this.hp = this.maxHp;
        this.lvl = dragLvl;

    }
}
