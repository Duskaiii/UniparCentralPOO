/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Models;

import br.unipar.unipar.central.Enums.TipoTransacaoEnum;
import java.util.Date;

/**
 *
 * @author 00210402
 */
public class Transacao {
    
    
    private int id;
    private Date dataHora;
    private double valor;
    private TipoTransacaoEnum tipoTransacao;
    private AbstractBaseEntity RegistroAcademico;
    private int ra;
    private String contaOrigem;
    private String contaDestino;

    public Transacao() {
    }

    public Transacao(int id, Date dataHora, double valor, TipoTransacaoEnum tipoTransacao, AbstractBaseEntity RegistroAcademico, int ra, String contaOrigem, String contaDestino) {
        this.id = id;
        this.dataHora = dataHora;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.RegistroAcademico = RegistroAcademico;
        this.ra = ra;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoTransacaoEnum getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacaoEnum tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public AbstractBaseEntity getRegistroAcademico() {
        return RegistroAcademico;
    }

    public void setRegistroAcademico(AbstractBaseEntity RegistroAcademico) {
        this.RegistroAcademico = RegistroAcademico;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    public String toString() {
        return "Transacao{" + "id=" + id + ", dataHora=" + dataHora + ", valor=" + valor + ", tipoTransacao=" + tipoTransacao + ", RegistroAcademico=" + RegistroAcademico + ", ra=" + ra + ", contaOrigem=" + contaOrigem + ", contaDestino=" + contaDestino + '}';
    }
    
    
}
