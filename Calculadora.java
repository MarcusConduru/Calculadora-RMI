package calculadorarmi;

public interface Calculadora extends java.rmi.Remote {

    public Resposta soma(Requisicao r) throws java.rmi.RemoteException;

    public Resposta sub(Requisicao r) throws java.rmi.RemoteException;

    public Resposta mul(Requisicao r) throws java.rmi.RemoteException;

    public Resposta div(Requisicao r) throws java.rmi.RemoteException;

    public Resposta pot(Requisicao r) throws java.rmi.RemoteException;

    public Resposta por(Requisicao r) throws java.rmi.RemoteException;

    public Resposta raiz(Requisicao r) throws java.rmi.RemoteException;
}