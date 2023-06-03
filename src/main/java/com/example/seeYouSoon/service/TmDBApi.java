package com.example.seeYouSoon.service;

import com.example.seeYouSoon.model.Filme;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TmDBApi {

    private static String apiKey = "19527783d7ef11d125f70fd9ef510a1b";

    public static List<Filme> getFilmesPopulares(){

        String urlApiFilmesPopulares = "https://api.themoviedb.org/3/movie/popular?page=5&language=pt-BR&api_key=";
        String urlSolicitacaoFilmesPopulares = urlApiFilmesPopulares + apiKey;

        try {

            //inicia a conexão com a api
            URL url = new URL(urlSolicitacaoFilmesPopulares);
            HttpURLConnection conexaoApi = (HttpURLConnection) url.openConnection();

            //verifica o sucesso de retorno da api
            if (conexaoApi.getResponseCode() != 200){
                throw new RuntimeException("Erro na conexao codigo: " + conexaoApi.getResponseCode() );
            }

            //ler os resultados e tranforma em um um objeto
            JsonReader readerApi = Json.createReader(conexaoApi.getInputStream());
            JsonObject objetoJson = readerApi.readObject();

            //filtra os resultados
            JsonArray listaResultado = objetoJson.getJsonArray("results");

            //converte o objeto pra uma List
            List<Filme> listaDeFilmes = new ArrayList<>();
            listaResultado.forEach(filme -> {
                JsonObject filmeObjetoJson = (JsonObject) filme;
                listaDeFilmes.add(Filme.jsonParaFilme(filmeObjetoJson));
            });

            return listaDeFilmes;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
