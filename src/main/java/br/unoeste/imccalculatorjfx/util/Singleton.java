package br.unoeste.imccalculatorjfx.util;

import br.unoeste.imccalculatorjfx.repository.PessoaRepo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Singleton {
    static private PessoaRepo repo = new PessoaRepo();

    static public PessoaRepo getRepo() {
        return repo;
    }

    //  Um construtor 'private' impede que esta classe seja instanciada
    private Singleton () {}

    static public boolean ler () {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream("dados.obj");
            objectInputStream = new ObjectInputStream(fileInputStream);
            repo = (PessoaRepo)objectInputStream.readObject();
            objectInputStream.close();
            return true;
        }
        catch (Exception e) {System.out.println(e.getMessage());}
        return false;
    }

    static public boolean salvar () {
        // serializar o objeto repo
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream;
        try {
            // gravar o objeto serializado em arquivo
            fileOutputStream = new FileOutputStream("dados.obj");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(repo);
            objectOutputStream.close();
            return true;
        }
        catch (Exception e) {System.out.println(e.getMessage());}
        return false;
    }
}