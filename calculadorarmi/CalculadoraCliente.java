package calculadorarmi;

import javax.swing.*;
import java.rmi.Naming;

public class CalculadoraCliente {

    public static void main(String[] args) {
        char oper;
        float op2 = 0;
        float op1 = 0;
        Requisicao r;
        Resposta resp = null;
        try {

            Calculadora c = (Calculadora) Naming.lookup("rmi://localhost:1099/CalculatorService");

            oper = (char) Integer.parseInt(JOptionPane.showInputDialog("Qual operação desejada? 1= +, 2= -,3= X,4= /,5= ^,6= %,7= √"));

            op1 = Float.parseFloat(JOptionPane.showInputDialog("Digite o Primeiro operando:"));
            op2 = Float.parseFloat(JOptionPane.showInputDialog("Digite o Segundo operando:"));

            r = new Requisicao(op1, op2);

            switch (oper) {
                case 1:
                    resp = c.soma(r);
                    oper = '+';
                    break;
                case 2:
                    resp = c.sub(r);
                    oper = '-';
                    break;
                case 3:
                    resp = c.mul(r);
                    oper = '*';
                    break;
                case 4:
                    resp = c.div(r);
                    oper = '/';
                    break;
                case 5:
                    resp = c.pot(r);
                    oper = '^';
                    break;
                case 6:
                    resp = c.por(r);
                    oper = '%';
                    break;
                case 7:
                    resp = c.raiz(r);
                    oper = '√';
                    break;
                default:
                    resp.setStatus(1);
                    break;
            }

            System.out.println("O resultado para a Operacao: "+op1+" " + oper + " " + op2 + " =");
            if(resp.getStatus() != 1){
                System.out.println(resp.getResult());
            }else{
                System.out.println("Operação nao Realizada.");
            }

        } catch (Exception e) {
            System.out.println("Nenhuma operação realizada.");
            System.out.println(e);
        }
    }
}