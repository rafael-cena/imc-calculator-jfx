package br.unoeste.imccalculatorjfx.repository;

import br.unoeste.imccalculatorjfx.entity.Pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepo implements Serializable {
    private List<Pessoa> list;

    public PessoaRepo() {
        list = new ArrayList<>();
    }

    public void add (Pessoa pessoa) {
        list.add(pessoa);
    }

    public List<Pessoa> getList() {
        return list;
    }
}
