package com.discord.discord_bot.event;

import com.discord.discord_bot.DicV2;
import com.discord.discord_bot.Dictionary;
import com.discord.discord_bot.Pokemon;
import com.discord.discord_bot.PokemonV2;
import discord4j.core.object.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public abstract class MessageListener {

    @Autowired
    private RestTemplate restTemplate;
    private List<String> tasks = new ArrayList<>();



    public MessageListener(){
        tasks.add("sleep");
        tasks.add("eat");
        tasks.add("code");
    }

    public Mono<Void> processCommand(Message eventMessage) {
        /*return Mono.just(eventMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .filter(message -> message.getContent().startsWith("!pokemon:"))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(poke(eventMessage.getContent())))
                .then();*/
        /*return Mono.just(eventMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .filter(message -> message.getContent().startsWith("!word"))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(dictionery()))
                .then();*/
        return Mono.just(eventMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .flatMap(message -> {
                    String content = message.getContent();
                    if (content.startsWith("!poke:")) {
                        return message.getChannel().flatMap(channel -> channel.createMessage(poke(content)));
                    } else if (content.startsWith("!word:")) {
                        return message.getChannel().flatMap(channel -> channel.createMessage(dictionery(content)));
                    } else if (content.startsWith("!customCommand:")) {
                        // Handle custom command logic
                        return Mono.empty(); // or any other desired result
                    } else {
                        // Unknown command, do nothing
                        return Mono.empty();
                    }
                })
                .then();
    }

    public String game1(String word) {
        char last = word.charAt(word.length()-1);
        System.out.println(last);
        char first = ' ';
        for(String w : tasks) {
            first = w.charAt(0);
            System.out.println(first);
            if(last == first) {
                System.out.println(w);
                return w;
            }
        }

        return "you lose";
    }

    public String poke(String pokemon) {

        String[] words = pokemon.split(":");
        PokemonV2 pokemonV2;
        try{
            pokemonV2 = restTemplate.getForObject(
                "https://pokeapi.co/api/v2/pokemon/" + words[1], PokemonV2.class
        );}
        catch (Exception e){
            System.out.println(e);
            return "Not found";
        }
        System.out.println("!!!!!!" + pokemonV2.toString());
        return words[1]+ ": " + pokemonV2.toString();
    }

    public String dictionery(String word){

        String[] words = word.split(":");

        Dictionary[] dictionaries = restTemplate.getForObject(
                "https://api.dictionaryapi.dev/api/v2/entries/en/" +  words[1], Dictionary[].class
        );

        return dictionaries[0].toString();
    }
}
