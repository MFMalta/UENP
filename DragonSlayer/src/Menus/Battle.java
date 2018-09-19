package Menus;

import Mobs.Species.Elder;
import Mobs.Species.Baby;
import Mobs.Species.Adult;
import Mobs.Species.Boss1;
import static Menus.Main.drg;
import static Menus.Main.pl;
import Mobs.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    //Variáveis declaradas
    Battle bt;
    Baby bbd;
    Adult add;
    Elder eld;
    //Legendary lgd; Em desenvolvimento
    //Master msd; Em desenvolvimento.
    Boss1 boss1;
    Random rand;
    Main main = new Main();

    //Método para verificar nível do jogador e chamar um construtor de dragão
    public Dragons genDragon(int plLvl) {
        drg = new Dragons();//Instancia drg
        rand = new Random();//Sorteia um numero dentro do nível do jogador.
        int drLvl = rand.nextInt(pl.getLvl()) + 1;//Converte o random para inteiro.

        //Aqui gerará um dragão conforme o nível do jogador.
        if (drLvl <= 3) {//Gera um Dragão Bebê.
            bbd = new Baby(drLvl);
            drg = (Dragons) bbd.dragLvl(bbd, drLvl);
        } else if (drLvl > 3 && drLvl <= 6) {//Gera um Dragão Adulto.
            add = new Adult(drLvl);
            drg = (Dragons) add.dragLvl(add, drLvl);
        } else if (drLvl > 7 && drLvl <= 9) {//Gera um Dragão Sábio.
            eld = new Elder(drLvl);
            drg = (Dragons) add.dragLvl(eld, drLvl);
        } /*else if (drLvl > 15) {//Gera Ahrmaak, o último chefe. Em Desenvolvimento.
            boss1 = new Boss1(drLvl);
            drg = (Dragons) boss1.dragLvl(boss1, drLvl);
        }*/
        return drg;//Sempre retornará o tipo Dagons.
    }

    //Método para batalha
    public Player battle(Player pl, Dragons drg) {
        int dmg = 0;//Dano de batalha.
        boolean run = false;//Caso jogador queira fugir.
        System.out.println("\nVocê encontrou um " + drg.getName() + " nível " + drg.getLvl() + "!");
        bt = new Battle();//Instancia a classe Battle.
        run = bt.battleMenu(run);//Trata se ojogador irá luitar ou fugir.
        if (run == false && drg.getHp() > 0) {
            if (pl.getSpd() > drg.getSpd()) {
                /*A batalha irá ocorrer conforme a velocidade, quem for mais rápido
                ataca primeiro.*/
                System.out.println("\nUma batalha feroz acontece...");
                do {
                    dmg = pl.playerAtk(pl, drg);//Jogador ataca
                    dmg = verDamage(dmg);//Verifica o dano
                    drg.setHp(drg.getHp() - dmg);//Dragão sofre o dano
                    //System.out.println("Player Damage: " + dmg);
                    dmg = drg.dragonAtk(pl, drg);//Dragão ataca
                    dmg = verDamage(dmg);//Verifica o dano
                    pl.setHp(pl.getHp() - dmg);//Jogador sofre o dano
                    inBattle(pl);//Verifica PV do jogador
                    if (pl.isAlive() == false) {
                        pl = gameOver(pl);
                        break;
                    }
                } while (pl.getHp() > 0 && drg.getHp() > 0);
            } else {
                do {
                    dmg = drg.dragonAtk(pl, drg);//Dragão ataca.
                    dmg = verDamage(dmg);//Verifica o dano
                    //System.out.println("Dragon Damage: " + dmg);// DEV
                    pl.setHp(pl.getHp() - dmg);//Jogador sofre o dano.
                    inBattle(pl);//Verifica PV do jogador
                    if (pl.isAlive() == false) {
                        pl = gameOver(pl);//Se zerou, o mesmo morre.
                        break;
                    } else {
                        dmg = pl.playerAtk(pl, drg);//Jogador ataca
                        dmg = verDamage(dmg);//Verifica o dano
                        //System.out.println("Player Damage: " + dmg);//DEV
                        drg.setHp(drg.getHp() - dmg);//Dragão sofre o dano

                    }
                } while (pl.getHp() > 0 && drg.getHp() > 0);
            }
            afterBattle(pl, drg);//Faz a checagem de XP após a batalha.
        } else {
            return pl;
        }
        return pl;
    }

    //Método para o menu da batalha.
    public boolean battleMenu(boolean run) {
        int aux = 0;//Variável auxiliar para escolha da ação.
        boolean exit = true;//Variável para exceção.
        Scanner scan = new Scanner(System.in);//Variável scanner para reveber dados do teclado.

        do {
            System.out.println("1 - Enfrentar");
            System.out.println("2 - Fugir");
            do {//Tratamento de exceção, caso usuário digite letras onde são números.
                try {
                    aux = scan.nextInt();
                    exit = false;
                } catch (InputMismatchException exc) {
                    Main.exceptions();
                    scan.nextLine();
                }
            } while (exit);
            if (aux == 1) {//Caso seja 1, o jogador luta.
            } else if (aux == 2) {//Caso seja 2, o jogador foge.
                run = true;//Diz que o jogador fugiu.
            }
        } while (aux > 3);
        return run;//Retorna se o jogador fugiu ou não.
    }

    //Método para verificar a XP do jogador.
    private void afterBattle(Player pl, Dragons drg) {
        if (pl.getHp() > 0) {
            pl.setXp(pl.getXp() + drg.getXpd());
            System.out.println("\nVocê venceu!\n");
            pl = pl.verifyXp(pl);
        }
    }
    
    //Finaliza o jogo, caso jogador morra.
    public Player gameOver(Player pl) {
        pl.setAlive(false);
        System.out.println("\nVocê morreu!\n");
        return pl;
    }

    //Método para tratar os PVs durante a batalha.
    private void inBattle(Player pl) {
        if (pl.getHp() <= 0) {
            pl = gameOver(pl);
        }
    }

    //Método pára verificar se o dano está negativo ou zerado.
    private int verDamage(int dmg) {
        if (dmg <= 0) {
            dmg = 1;//Dano mínimo é de 1 ponto.
            return dmg;
        } else {
            return dmg;
        }
    }
}
