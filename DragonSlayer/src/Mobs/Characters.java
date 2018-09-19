package Mobs;

//Aqui contém todas as variáveis básicas para os personagens.
public abstract class Characters {
    
    /*VARIÁVEIS DOS PERSONAGENS, JOGADOR E INIMIGOS*/
    protected String name = null;//Nome dos personagens.
    protected int lvl = 0;//Nível dos personagens.
    protected int hp = 0;//Pontos de vida dos personagens.
    protected int maxHp = 0;//Máximo de pontos de vida.
    protected int atk = 0;//Ataque dos personagens.
    protected int def = 0;//Defesa dos personagens.
    protected int spd = 0;//Velocidade dos personagens.
    
    //********ENCAPSULAMENTO**********//
    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getLvl() {
        return lvl;
    }

    /**
     *
     * @param lvl
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    /**
     *
     * @return
     */
    public int getHp() {
        return hp;
    }

    /**
     *
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     *
     * @return
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     *
     * @param maxHp
     */
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    /**
     *
     * @return
     */
    public int getAtk() {
        return atk;
    }

    /**
     *
     * @param atk
     */

    public void setAtk(int atk) {
        this.atk = atk;
    }

    /**
     *
     * @return
     */
    public int getDef() {
        return def;
    }

    /**
     *
     * @param def
     */
    public void setDef(int def) {
        this.def = def;
    }

    /**
     *
     * @return
     */
    public int getSpd() {
        return spd;
    }

    /**
     *
     * @param spd
     */
    public void setSpd(int spd) {
        this.spd = spd;
    }
}
