package controller;

import models.Veiculo;

import java.util.ArrayList;

public class VeiculoController {
    private ArrayList<Veiculo>listaVeiculo = new ArrayList<>();

    public Boolean salvar(Veiculo veiculo){
        if (!listaVeiculo.contains(veiculo)) {
            listaVeiculo.add(veiculo);
            return true;
        }
        return false;
    }

    public ArrayList<Veiculo> getListaVeiculo() {
        return listaVeiculo;
    }
}
