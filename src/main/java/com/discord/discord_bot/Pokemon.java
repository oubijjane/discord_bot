package com.discord.discord_bot;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.Array;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pokemon(Array[] abilities) {
}

