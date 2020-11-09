/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        List<Player> listPlayers = new ArrayList<>();
        Arrays.stream(players)
            .forEach(player -> {
                if (player.getNationality().equals("FIN")) {
                    //listPlayers.add(player);
                    listPlayers.add(new Player(player.getName(), player.getNationality(), player.getAssists(), player.getGoals(), (player.getAssists() + player.getGoals())));
                }
            });
        System.out.println();
        System.out.println("Players from FIN " + LocalDate.now());
        System.out.println();
        listPlayers.stream()
            .sorted()
            .forEach(p -> System.out.println(p.getName() + " " + p.getNationality() + " " + p.getAssists() + " + " + p.getGoals() + " = " + p.getPoints()));
    }
  
}
