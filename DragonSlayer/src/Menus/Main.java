package Menus;

import Mobs.*;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @author Matheus Malta <mathmalta96 at gmail.com>
 * @version Alpha 0.2.7
 */


/*******CLASSE PRINCIPAL*******/
public class Main {
    //Variáveis estáticas
    static Scanner scan;//Inicia o Scanner.
    static Player pl;//Inicia o Jogador
    static Dragons drg;//Inicia Dragão.
    static Battle bt = new Battle();//Instancia classe batalha.
    static Logs log = new Logs();//Instancia classe Logs.
    static boolean start;;//Variável para iniciar o jogo.
    static boolean quitGame = false;//Variável para sair do jogo

    /************FUNÇÃO PRINCIPAL***************************/
    //Método inicia o  jogo, junto com as variáveis necessárias.
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
    
    //Menu do início do jogo, apenas para iniciar o mesmo.
    private static void startMenu(Player pl) {

        boolean quit = false;//Variável para sair do jogo no menu inicial.
        boolean exit = true;//Variável auxiliar para exceção.
        scan = new Scanner(System.in);//Inicia o Scanner.
        int aux = 0;//Variável auxiliar.
        do {
            do {
                System.out.println("1-Novo");
                //System.out.println("2-Carregar";//Em desenvolvimento.
                System.out.println("2-Sair");
                //Tratamento de exceção, caso usuário digite letras onde são números.
                try {
                    aux = scan.nextInt();
                    exit = false;
                } catch (InputMismatchException exc) {
                    exceptions();
                    scan.nextLine();
                }
            } while (exit);

            switch (aux) {
                case 1://Acerta o jogo para ser iniciado e inicia a criação de personagem..
                    quit = true;
                    quitGame = false;
                    start = true;
                    pl = createPlayer();
                    //System.out.println(pl.showStats());//remover.
                    break;
                /*case 2://Em desenvolvimento.
                    System.out.println("Carregar");
                    break;*/
                case 2://Finaliza o jogo.
                    quit = true;
                    quitGame = true;
                    start = false;
                    break;
                case 260596://Função para consulta dos logs.
                    start = false;
                    System.out.println(log.showLogs());
                    break;
                default:
                    break;
            }
        } while (quit == false);
    }

    //Menu do jogo, aqui onde se passa a maior parte do jogo.
    private static boolean gameMenu(Player pl, boolean quitGame) {
        int aux = 0;//Variável auxiliar para navegar no Menu do jogo.
        boolean run = false, exit=true;
        do {
            System.out.println(pl.showStats());//Mostra os atributos do jogador
            System.out.println("\n1-Batalhar");
            System.out.println("2-Meditar");
            //System.out.println("3-Loja"); Em desenvolvimento.
            //System.out.println("4-Salvar"); Em desenvolvimento
            System.out.println("3-Sair");
            do {
                try {//Tratamento de exceção, caso usuário digite letras onde são números.
                    aux = scan.nextInt();
                    exit = false;
                } catch (InputMismatchException exc) {
                    exceptions();
                    scan.nextLine();
                }
            } while (exit);
            aux = scan.nextInt();
            switch (aux) {
                case 1:
                    drg = new Dragons();//Instancua o dragão.
                    drg = bt.genDragon(pl.getLvl());// Gerar o dragão.
                    pl = bt.battle(pl, drg);//Vai para a batalaha.
                    if (pl.isAlive() == false) {
                        quitGame = true;
                    }
                    break;
                case 2:
                    pl = pl.meditade(pl);//Chama o método para meditar.
                    break;
                /* case 3: Em desenvolvimento.
                    System.out.println("Loja");
                    break;
                case 4: Em desenvolvimento.
                    System.out.println("Salvar");
                    break;*/
                case 3://Sai do jogo.
                    quitGame = true;
                    break;
                default:
                    break;
            }
        } while (quitGame == false);
        return quitGame;
    }

    //Método para criar o jogador
    static Player createPlayer() {
        int aux = 0;//Var. auxiliar.
        boolean exit = true;//Sair da exceção;.
        scan = new Scanner(System.in);//Recebe dados do teclado.
        pl = new Player();//Instancia jogador.
        //Define o nome do jogador.
        System.out.println("Como você se chama?");
        String au = scan.nextLine();//Variável apenas para o nome.
        pl.setName(au);
        do {
            pl.setPts(26);
            //Define o nível.
            pl.setLvl(1);
            //Define s Experiência.
            pl.setXp(0);
            pl.setMaxXp(20);
            //Colocando atributos em Pontos de Vida.
            System.out.println("Distribua os pontos conforme desejar...");
            System.out.println("Pontos: " + pl.getPts());
            System.out.print("\nVida (múltiplo de 5): ");
            do {//Tratamento de exceção, caso usuário digite letras onde são números.
                try {
                    aux = scan.nextInt();
                    exit = false;
                } catch (InputMismatchException exc) {
                    exceptions();
                    scan.nextLine();
                }
            } while (exit);
            pl.setMaxHp(aux * 5);
            pl.setHp(pl.getMaxHp());
            pl.setPts(pl.getPts() - aux);
            //Colocando atributos em Ataque.
            System.out.println("Pontos: " + pl.getPts());
            System.out.print("\nAtaque: ");
            do {//Tratamento de exceção, caso usuário digite letras onde são números.
                try {
                    aux = scan.nextInt();
                    exit = false;
                } catch (InputMismatchException exc) {
                    exceptions();
                    scan.nextLine();
                }
            } while (exit);
            pl.setAtk(aux);
            pl.setPts(pl.getPts() - aux);
            //Colocando atributos em Defesa.
            System.out.println("Pontos: " + pl.getPts());
            System.out.print("\nDefesa: ");
            do {//Tratamento de exceção, caso usuário digite letras onde são números.
                try {
                    aux = scan.nextInt();
                    exit = false;
                } catch (InputMismatchException exc) {
                    exceptions();
                    scan.nextLine();
                }
            } while (exit);
            pl.setDef(aux);
            pl.setPts(pl.getPts() - aux);
            //**@SPD
            aux = pl.getPts();
            //Definido automaticamente com o restante das pontuações.
            pl.setSpd(aux);
            pl.setPts(pl.getPts() - aux);
            System.out.println("\n\n\n");
        } while (pl.getSpd() < 0);

        return pl;
    }

    //Método para tratar exceção de inteiro.
    public static void exceptions() {
        System.out.println("\nDigite apenas números!\n");
    }
}
