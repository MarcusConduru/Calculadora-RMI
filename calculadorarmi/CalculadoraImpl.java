package calculadorarmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {

    public CalculadoraImpl() throws RemoteException {
        super();
    }

    @Override
    public Resposta soma(Requisicao r) throws RemoteException {
        Resposta resp = new Resposta();
        resp.setResult((r.getOp1()) + (r.getOp2()));
        resp.setStatus(0);

        return resp;
    }

    @Override
    public Resposta sub(Requisicao r) throws RemoteException {
        Resposta resp = new Resposta();
        resp.setResult((r.getOp1()) - (r.getOp2()));
        resp.setStatus(0);

        return resp;
    }

    @Override
    public Resposta mul(Requisicao r) throws RemoteException {
        Resposta resp = new Resposta();
        resp.setResult((r.getOp1()) * (r.getOp2()));
        resp.setStatus(0);

        return resp;
    }

    @Override
    public Resposta div(Requisicao r) throws RemoteException {
        Resposta resp = new Resposta();
        if (r.getOp2() == 0) {
            resp.setStatus(1);
        } else {
            resp.setResult((r.getOp1()) / (r.getOp2()));
            resp.setStatus(0);
        }
        return resp;
    }

    @Override
    public Resposta pot(Requisicao r) throws RemoteException {
        Resposta resp = new Resposta();
        resp.setResult((float) Math.pow(r.getOp1(),r.getOp2()));
        resp.setStatus(0);

        return resp;
    }

    @Override
    public Resposta por(Requisicao r) throws RemoteException {
        Resposta resp = new Resposta();
        if (r.getOp2() == 0) {
            resp.setStatus(1);
        } else {
            resp.setResult((r.getOp1()*r.getOp2())/100);
            resp.setStatus(0);
        }
        return resp;
    }

    @Override
    public Resposta raiz(Requisicao r) throws RemoteException {
        Resposta resp = new Resposta();
        resp.setResult((float) Math.pow (r.getOp1(), 1.0 / r.getOp2()));
        resp.setStatus(0);

        return resp;
    }
}