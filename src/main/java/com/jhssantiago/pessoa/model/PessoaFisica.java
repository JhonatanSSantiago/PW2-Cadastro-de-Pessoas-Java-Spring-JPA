
package com.jhssantiago.pessoa.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author jhons
 */
@Entity
@Table(name = "tb_pessoafisica")
public class PessoaFisica extends Pessoa implements Serializable{

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
