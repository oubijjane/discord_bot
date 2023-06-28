package com.discord.discord_bot.event;

import com.discord.discord_bot.Definition;

import java.util.List;

public class Meaning {

   private String partOfSpeech;

   private List<Definition> definitions;

   private List<String> synonyms;

   private List<String> antonyms;

   public Meaning(){
       System.out.println(toString());
   }

    public Meaning(String partOfSpeech, List<Definition> definitions, List<String> synonyms, List<String> antonyms) {
        this.partOfSpeech = partOfSpeech;
        this.definitions = definitions;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Definition> getDefinetions() {
        return definitions;
    }

    public void setDefinetions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }

    @Override
    public String toString() {
        return "partOfSpeech='" + partOfSpeech + '\n' +
                definitions +
                ", synonyms=" + synonyms + '\n' +
                ", antonyms=" + antonyms;
    }
}
