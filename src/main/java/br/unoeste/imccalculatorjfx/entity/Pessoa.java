package br.unoeste.imccalculatorjfx.entity;

public class Pessoa {
    private String name;
    private double weight;
    private double height;
    private double imc;

    public Pessoa(String name, double weight, double height, double imc) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.imc = imc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
}
