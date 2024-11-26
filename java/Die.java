package Hello;

public class Die {
    private int faceValue;

    public Die() {
        this.faceValue = 0;
    }

    public int roll() {
        faceValue = (int) (Math.random() * 6) + 1;
        return faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }
}
