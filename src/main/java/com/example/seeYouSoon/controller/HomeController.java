package com.example.seeYouSoon.controller;

import com.example.seeYouSoon.model.Filme;
import com.example.seeYouSoon.service.TmDBApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String home(Model model){

        List<Filme> listaFilmes = new ArrayList<Filme>(TmDBApi.getFilmesPopulares());
        model.addAttribute("filmes", listaFilmes);

        return("home");
    }
}
