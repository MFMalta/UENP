package Mobs.Species;

import Mobs.Dragons;
import java.util.Random;

//Aqui é feita toda a constyyrução dos Dragões Sábios.
public class Elder extends Dragons {
    //Construtor Vazio
    public Elder() {
    };
    //Base em 48 pontos
     public Elder(int dragLvl) {
        int aux = 0;
        Random rand = new Random();
        rand = new Random();
        aux = rand.nextInt(3) + 1;

        switch (aux) {
            case 1://Balanceado
                this.name = "Dragão Sábio";
                this.maxHp = 12 * 5;
                this.atk = 12;
                this.def = 12;
                this.spd = 12;
                this.id = "BBD-001";
                this.xpd = 15 * dragLvl;
                break;
            case 2://atk++,spd+,def-,hp--
                this.name = "Dragão Sábio Furioso";
                this.maxHp = (12 + this.mns2) * 5;
                this.atk = 12 + this.pls2;
                this.def = 12 + this.mns;
                this.spd = 12 + this.pls;
                this.id = "BBD-002";
                this.xpd = 19 * dragLvl;
                break;
            case 3://atk--,spd-,def++,hp+
                this.name = "Dragão Sábio Irritado";
                this.maxHp = (12 + this.pls) * 5;
                this.atk = 12 + this.mns2;
                this.def = 12 + this.pls2;
                this.spd = 12 + this.mns;
                this.id = "BBD-003";
                this.xpd = 17 * dragLvl;
                break;
            default:
                break;
        }
        this.hp = this.maxHp;
        this.lvl = dragLvl;

    }
}
