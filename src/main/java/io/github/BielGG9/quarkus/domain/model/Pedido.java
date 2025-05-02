package io.github.BielGG9.quarkus.domain.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Pedido extends DefaultEntity {

    @ManyToOne(optional = false)
    private Cliente cliente;

    private double valorTotal;

    private LocalDate data;

    private String status;

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
