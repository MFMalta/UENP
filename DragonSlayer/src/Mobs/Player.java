package Mobs;

//CLASSE DEDICADA AO JOGADOR
public class Player extends Characters {

    /*VARIÁVEIS EXCLUSIVAS DO JOGADOR*/
    private int xp = 0;//XP do jogador.
    private int maxXp = 0;//Xp necessária para subir de nível.
    private int pts = 20;//Pontos de habilidade.

    /**
     * @Construtor vazio
     */
    public Player() {
    }

    ;
    
    //********ENCAPSULAMENTO**********//
    /**
     * @return 
     */
    public int getPts() {//Retorna os pontos de habilidade
        return pts;
    }

    /**
     * @param pts
     * @Altera os pontos de habilidade
     */
    public void setPts(int pts) {
        this.pts = pts;
    }

    /**
     * @return @Retorna a exp. máxima
     */
    public int getXp() {
        return xp;
    }

    /**
     * @param xp
     * @Retorna a exp. máxima
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * @return @Retorna a exp. máxima
     */
    public int getMaxXp() {
        return maxXp;
    }

    /**
     * @param maxXp
     * @Altera a exp. máxima
     */
    public void setMaxXp(int maxXp) {
        this.maxXp = maxXp;
    }

    //***********MÉTODOS****************//
    //Método para exibir as habilidades do jogador
    /**
     * @return
     */
    public String showStats() {
        String stats
                = getName()
                + "     Nvl: " + getLvl()
                + "\nPV: " + getHp() + "/" + getMaxHp()
                + "\nAtq: " + getAtk()
                + "     Def: " + getDef()
                + "     Vel: " + getSpd()
                + "\nExp: " + xp + "/" + maxXp;
        return stats;
    }

    //Método para verificar a exp. do jogador
    /**
     * @param pl
     * @return
     * @Método para verificar a experiência do jogador
     */
    public Player verifyXp(Player pl) {
        if (pl.getXp() >= pl.getMaxXp()) {
            pl = lvlUp(pl);
        } else {
        }
        return pl;
    }

    //Método para subir o nível do jogador
    /**
     *
     */
    private Player lvlUp(Player p1) {
        double up = 1.25;

        this.setLvl(p1.getLvl() + 1);
        this.setMaxXp((int) (p1.maxXp * up));
        this.setHp((int) (p1.getHp() * up));
        this.setMaxHp((int) (p1.getMaxHp() * up));
        this.setAtk((int) (p1.getAtk() * up));
        this.setDef((int) (p1.getDef() * up));
        this.setSpd((int) (p1.getSpd() * up));
        this.maxXp = this.maxXp * 2;
        System.out.println("Você subiude nível!\n");
        return p1;
    }

    //Método para restaurar HP, MP, etc.
    /**
     * @param pl
     * @return
     */
    public Player meditade(Player pl) {
        pl.setHp(pl.getMaxHp());//A variável hp receberá o máximo de HP atual do jogador(maxHp).
        System.out.println("Suas feridas estão curadas!\n");
        return pl;
    }
     public int playerAtk(Player pl, Dragons drg){
         int damage = 0;
         damage = (int) (pl.getAtk() * 1.50 - (drg.getDef()));
         //System.out.println(this.getName() + " causou " + damage);
        return damage;
    }

}
