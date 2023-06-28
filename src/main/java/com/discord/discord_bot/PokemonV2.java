package com.discord.discord_bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonV2 {

    private List<Ability> abilities;
    private String weight;

    public PokemonV2(){}

    public PokemonV2(List<Ability> abilities, String weight) {
        this.abilities = abilities;
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "abilities= " + abilities +
                ", weight= " + weight;
    }

}
