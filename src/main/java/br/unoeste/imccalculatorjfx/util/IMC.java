package br.unoeste.imccalculatorjfx.util;

import br.unoeste.imccalculatorjfx.MainController;

public class IMC {
    static public double get (double peso, double altura) {
        return peso/(Math.pow(altura,2));
    }

    static public String getCondicao (double imc) {
        String cond = "";

        if (imc >= 40) {
            cond = "Obesidade mórbida";
        }
        else if (imc >= 30) {
            cond = "Obesidade";
        }
        else if (imc >= 25) {
            cond = "Sobrepeso";
        }
        else if (imc >= 20) {
            cond = "Peso normal";
        }
        else if (imc >= 14.5) {
            cond = "Peso abaixo do normal";
        }
        else {
            cond = "Desnutrição";
        }

        return cond;
    }
}