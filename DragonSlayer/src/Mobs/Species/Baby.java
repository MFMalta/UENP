package Mobs.Species;

import Mobs.Dragons;
import java.util.Random;

//Aqui é feita toda a constyyrução dos Dragões Bebês.
public class Baby extends Dragons {

    //Construtor Vazio
    public Baby() {
    }

    //Base em 20 pontos.
    public Baby(int dragLvl) {
        int aux = 0;
        Random rand = new Random();
        //Sorteia um tipo de dragão
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
            case 2://Agressivo
                this.name = "Dragao Bebê Furioso";
                this.maxHp = (5 + this.mns2) * 5;
                this.atk = 5 + this.pls2;
                this.def = 5 + this.mns;
                this.spd = 5 + this.pls;
                this.id = "BBD-002";
                this.xpd = 7 * dragLvl;
                break;
            case 3://Defensivo
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
