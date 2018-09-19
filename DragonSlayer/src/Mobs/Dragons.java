package Mobs;

public class Dragons extends Characters {

    protected String id = null;//Identificação dos dragões.
    protected int xpd = 0;//XP dada pelo dragões.
    protected final int pls = 1;//+Bonus de tipo
    protected final int pls2 = 2;//++Bonus de tipo
    protected final int mns = -1;//-Desvantagem de tipo
    protected final int mns2 = -2;//--Desvantagem de tipo
    //int ptsDr = 0;
    
    /**********ENCAPSULAMENTO***********/
    
    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getXpd() {
        return xpd;
    }

    /**
     *
     * @param aXpGive
     */
    public void setXpd(int aXpGive) {
        xpd = aXpGive;
    }
    //-----------------------------------
    /*public int getPtsDr() {
        return ptsDr;
    }
    
    public void setPtsDr(int ptsDr) {
        this.ptsDr = ptsDr;
    }*/
    //-----------------------------------
    /**
     *
     * @return
     */
    public int getPls() {
        return pls;
    }

    /**
     *
     * @return
     */
    public int getPls2() {
        return pls2;
    }

     /**
     *
     * @return
     */
    public int getMns() {
        return mns;
    }


    /**
     *
     * @return
     */
    public int getMns2() {
        return mns2;
    }

    //Nivela os dragões com base em 25% sobre as habilidades atuais.
    public Dragons dragLvl(Dragons drg, int drlv) {
        double up = 1.25;
        for (int i = 1; i < drlv; i++) {
            drg.setHp((int) (drg.getHp() * 1.25));
            drg.setMaxHp(drg.getHp());
            drg.setAtk((int) (drg.getAtk() * 1.25));
            drg.setDef((int) (drg.getDef() * 1.25));
            drg.setSpd((int) (drg.getSpd() * 1.25));
        }
        return drg;
    }

    //Método que faz o dragão atacar.
    public int dragonAtk(Player pl, Dragons drg) {
        int damage = 0;
        damage = (int) (drg.getAtk() * 1.50 - (pl.getDef()));
       // System.out.println(this.getName() + " causou " + damage); DEV
        return damage;
    }
}
