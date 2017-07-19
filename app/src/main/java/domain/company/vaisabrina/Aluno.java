package domain.company.vaisabrina;

import java.io.Serializable;
import java.util.List;

/**
 * Created by emiliano on 7/18/17.
 */

public class Aluno implements Serializable{
    private Long id;
    private String caminhoFoto;
    private String nome;
    private String telefone;
    private String endereco;
    private String site;
    private Float nota;

    @Override
    public String toString() {
        return this.getId() + " - " + this.getNome();
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
}
