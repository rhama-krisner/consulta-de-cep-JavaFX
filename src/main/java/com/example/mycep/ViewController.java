package com.example.mycep;

import com.example.mycep.util.Endereco;
import com.example.mycep.util.ServicoDeCEP;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class ViewController {
    @FXML
    private TextField txtCEP;
    @FXML
    private Button btnBuscar;
    @FXML
    private Text txtCepGuardado;
    @FXML
    private TextField txtRua;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtDDD;


    @FXML
    protected void onClickBuscar() {
        String cep = txtCEP.getText();

        txtCepGuardado.setText(cep);

        Endereco endereco = ServicoDeCEP.buscaEnderecoPelo(cep);
        txtRua.setText(endereco.getLogradouro());
        txtBairro.setText(endereco.getBairro());
        txtCidade.setText(endereco.getLocalidade());

        int ddd = endereco.getDdd();

        txtDDD.setText(Integer.toString(ddd));

        if (endereco.getDdd() == 0) {
            Alerts.showAlerts("Erro", null, "CEP com erro ou não existe.", Alert.AlertType.ERROR);
            txtDDD.setText("");
            txtCepGuardado.setText("");
        }

    }

    private void buscarEndereco() {

    }

    @FXML
    public void initialize() {
        txtCEP.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                onClickBuscar();
                txtCEP.setText("");
            }
        });
    }
}