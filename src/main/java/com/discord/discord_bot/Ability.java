package com.discord.discord_bot;

public class Ability {

    private AbilityName ability;

    private boolean is_hidden;

    private int slot;

    public Ability(){}

    public Ability(AbilityName ability, boolean is_hidden, int slot) {
        this.ability = ability;
        this.is_hidden = is_hidden;
        this.slot = slot;
    }

    public AbilityName getAbility() {
        return ability;
    }

    public void setAbility(AbilityName ability) {
        this.ability = ability;
    }

    public boolean isIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "ability= " + ability +
                ", is_hidden= " + is_hidden +
                ", slot= " + slot;
    }
}
