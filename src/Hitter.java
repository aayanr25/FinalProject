public class Hitter {
    private String name;
    private int skill;
    public Hitter(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }
    public String getName() {
        return name;
    }
    public int getHittingSkill() {
        return skill;
    }
    public void changeHittingSkill(int factor) {
        skill *= factor;
    }
}
