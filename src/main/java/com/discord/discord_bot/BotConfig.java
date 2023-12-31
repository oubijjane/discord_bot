package com.discord.discord_bot;

import com.discord.discord_bot.music_player.MusicPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import com.discord.discord_bot.event.EventListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BotConfig {

    @Value("${token}")
    private String token;

    @Bean
    public AudioPlayerManager audioPlayerManager(){
        return new DefaultAudioPlayerManager();
    }

    @Bean
    public MusicPlayer musicPlayer(AudioPlayerManager audioPlayerManager) {
        return new MusicPlayer(audioPlayerManager);
    }
    @Bean
    public <T extends Event> GatewayDiscordClient gatewayDiscordClient(List<EventListener<T>> eventListenerList) {
        System.out.println(token);
        GatewayDiscordClient client = DiscordClientBuilder.create(token)
             .build()
             .login()
             .block();
        for(EventListener<T> listener : eventListenerList){
            client.on(listener.getEventType())
                    .flatMap(listener::execute)
                    .onErrorResume(listener::handleError)
                    .subscribe();
        }
        return client;
    }
}
