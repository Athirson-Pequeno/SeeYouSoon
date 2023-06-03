package com.example.seeYouSoon.model;

import javax.json.JsonObject;

public class Filme {


    private String nome;
    private String urlPoster;
    private String descricao;
    private String nota;

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public void setUrlPoster(String urlPoster) {
        this.urlPoster = urlPoster;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public static Filme jsonParaFilme(JsonObject jsonFilme){

        Filme filme = new Filme();
        filme.setDescricao(jsonFilme.getString("overview"));
        filme.setNome(jsonFilme.getString("title"));
        filme.setUrlPoster("https://image.tmdb.org/t/p/w220_and_h330_face" + jsonFilme.getString("poster_path"));
        filme.setNota("✰"+jsonFilme.getJsonNumber("vote_average").toString());
        return filme;
    }
}
