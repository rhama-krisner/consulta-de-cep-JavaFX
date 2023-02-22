package com.example.mycep.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class ServicoDeCEP {
    static String webService = "https://viacep.com.br/ws/";
    static int codigoDeSucesso = 200;

    public static Endereco buscaEnderecoPelo(String cep){
        String urlParaChamada = webService + cep + "/json";

        try{
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if(conexao.getResponseCode()!= codigoDeSucesso){
                throw new RuntimeException("HTTP ERROR CODE: " + conexao.getResponseCode());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();

            Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);

            return endereco;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
