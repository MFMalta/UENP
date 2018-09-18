package Menus;

import Mobs.*;
import java.util.Scanner;

/**
 * @author Matheus Malta <mathmalta96 at gmail.com>
 * @version Demo 0.7
 */
/**
 * ****CLASSE PRINCIPAL******
 */
public class Main {

    //bt = new Battle();
    //Variáveis estáticas
    static Scanner scan;
    static Player pl;
    static Dragons drg;
    static Battle bt = new Battle();
    static Logs log = new Logs();
    static boolean start;
    static boolean quitGame = false;//Variável para sair do jogo
    
    /***********FUNÇÃO PRINCIPAL***************************/
    public static void main(String[] args) {
        start = true;
        pl = new Player();
        drg = new Dragons();
        startMenu(pl);
        if (quitGame == false) {
            do {
                quitGame = gameMenu(pl, quitGame);
            } while (quitGame == false);
        }
    }

    //Menu do início do jogo
    private static void startMenu(Player pl) {
        int aux = 0;
        boolean quit = false;//Variável para sair do jogo no menu inicial.
        scan = new Scanner(System.in);

        do {
            System.out.println("1-Novo");
            //System.out.println("2-Carregar");
            System.out.println("2-Sair");
            aux = scan.nextInt();
            switch (aux) {
                case 1:
                    quit = true;
                    quitGame = false;
                    start = true;
                    pl = createPlayer();
                    System.out.println(pl.showStats());
                    break;
                /*case 2:
                    System.out.println("Carregar");
                    break;*/
                case 2:
                    quit = true;
                    quitGame = true;
                    start = false;
                    break;
                case 260596:
                    start = false;
                    System.out.println(log.showLogs());
                    break;
                default:
                    break;
            }
        } while (quit == false);
    }

    //Menu do jogo
    private static boolean gameMenu(Player pl, boolean quitGame) {
        int aux = 0;//Variável auxiliar para navegar no Menu do jogo.
        boolean run = false;
        do {
            System.out.println(pl.showStats());
            System.out.println("\n1-Batalhar");
            System.out.println("2-Meditar");
            //System.out.println("3-Loja");
            //System.out.println("4-Orar");
            System.out.println("3-Sair");
            aux = scan.nextInt();
            switch (aux) {
                case 1:
                    drg = new Dragons();
                    drg = bt.genDragon(pl.getLvl());// Chama o método para verificar o nível do jogador.
                    pl = bt.battle(pl, drg);//Vai para a batalaha.
                    if(pl.isAlive() == false) quitGame = true;
                    break;
                case 2:
                    pl = pl.meditade(pl);//Chama o método para meditar.
                    break;
                /* case 3:
                    System.out.println("Loja");
                    break;
                case 4:
                    System.out.println("Salvar");
                    break;*/
                case 3:
                    quitGame = true;//Sai do jogo.
                    break;
                default:
                    break;
            }
        } while (quitGame == false);
        return quitGame;
    }

    //Método para criar o jogador
    static Player createPlayer() {
        //@Variáveis
        int aux;
        scan = new Scanner(System.in);
        pl = new Player();
        //@NAME
        System.out.println("Como você se chama?");
        String au = scan.nextLine();
        pl.setName(au);
        do {
            pl.setPts(26);
            //**@LVL
            pl.setLvl(1);
            //**@XP
            pl.setXp(0);
            pl.setMaxXp(20);
            //**@HP
            System.out.println("Distribua os pontos conforme desejar...");
            System.out.println("Pontos: " + pl.getPts());
            System.out.print("\nVida (múltiplo de 5): ");
            aux = scan.nextInt();
            //if(aux > pl.getPts()) System.out.println("Erro!");;
            pl.setMaxHp(aux * 5);
            pl.setHp(pl.getMaxHp());
            pl.setPts(pl.getPts() - aux);
            //**@ATK
            System.out.println("Pontos: " + pl.getPts());
            System.out.print("\nAtaque: ");
            aux = scan.nextInt();
            //if(aux > pl.getPts()) System.out.println("Erro!");;
            pl.setAtk(aux);
            pl.setPts(pl.getPts() - aux);
            //**@DEF
            System.out.println("Pontos: " + pl.getPts());
            System.out.print("\nDefesa: ");
            aux = scan.nextInt();
            //if(aux > pl.getPts()) System.out.println("Erro!");;
            pl.setDef(aux);
            pl.setPts(pl.getPts() - aux);
            //**@SPD
            aux = pl.getPts();
            //if(aux > pl.getPts()) System.out.println("Erro!");;
            pl.setSpd(aux);
            pl.setPts(pl.getPts() - aux);
            System.out.println("\n\n\n");
        } while (pl.getSpd() < 0);

        return pl;
    }
}
