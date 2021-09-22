package com.mycompany.bancoabc;

public class Transaccion {

    private String cuenta;
    private String password;
    private float saldo;

    public Transaccion(String cuenta, String password, float saldo) {
        this.cuenta = cuenta;
        this.password = password;
        this.saldo = saldo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Float depositar(float d)//método con un parámetro
    {
        setSaldo(getSaldo() + d);
        return saldo;
    }
    
    public Float retirar(float r)//método con un parámetro
    {
        setSaldo(getSaldo() - r);
        return saldo;
    }

    public Float transferir(float m)//método con un parámetro
    {
        setSaldo(getSaldo() - m);
        return saldo;
    }

    public void info() //método sin parámetros
    {
        System.out.println("\tNúmero de cuenta:  " + getCuenta());
        System.out.println("\tSaldo:             $" + getSaldo());
        System.out.println("\t\t==========================");
    }
}
