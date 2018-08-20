package br.com.entra21java.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CategoriaBean {


    private int id;
    @NotEmpty(message = "Nome não deve ser vazio")
    @Size(min = 5, max = 100)
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
