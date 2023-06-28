package com.discord.discord_bot;

import com.discord.discord_bot.event.Meaning;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dictionary {

    private String word;

    private String phonetic;

    private List<Meaning> meanings;

    private List<String> synonyms;

    private List<String> antonyms;


    public Dictionary(){}


    public Dictionary(String word, String phonetic, List<Meaning> meanings, List<String> synonyms, List<String> antonyms) {
        this.word = word;
        this.phonetic = phonetic;
        this.meanings = meanings;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public String antonyms(){
        StringBuilder str = new StringBuilder();

        getAntonyms().stream().map(antonym -> str.append(antonym + " "));

        return getAntonyms().toString();
    }

    @Override
    public String toString() {
        if(meanings.size()>1) {
            return "word='" + word + '\n' +
                    "phonetic='" + phonetic + '\n' +
                    meanings.get(0).getDefinetions().get(0) + '\n' + "Synonyms: " + meanings.get(0).getSynonyms() + '\n' + "Antonyms: " + meanings.get(0).getAntonyms()
                    + '\n' + meanings.get(1).getDefinetions().get(0) + '\n' + "Synonyms: " + meanings.get(1).getSynonyms() + '\n' + "Antonyms: "  + meanings.get(1).getAntonyms();
        }
        return "word='" + word + '\n' +
                "phonetic='" + phonetic + '\n' +
                meanings.get(0).getDefinetions().get(0) + '\n'
                + '\n' + "Synonyms: " + meanings.get(0).getSynonyms() + '\n' + "Antonyms: " + meanings.get(0).getAntonyms();
    }
}
