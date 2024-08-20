package br.unoeste.imccalculatorjfx.util;

import br.unoeste.imccalculatorjfx.repository.PessoaRepo;

public class Singleton {
    static private PessoaRepo repo = new PessoaRepo();

    static public PessoaRepo getRepo() {
        return repo;
    }

    //  Um construtor 'private' impede que esta classe seja instanciada
    private Singleton () {}
}