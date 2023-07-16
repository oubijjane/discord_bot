package com.discord.discord_bot.pokemon;

public class AbilityName {

    private String name;

    public AbilityName(){}
    public AbilityName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " ";
    }
}
