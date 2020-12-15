package calculadorarmi;

public class Requisicao implements java.io.Serializable {

    private float op1;
    private float op2;

    public Requisicao(float op1, float op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    public float getOp1() {
        return op1;
    }

    public float getOp2() {
        return op2;
    }
}