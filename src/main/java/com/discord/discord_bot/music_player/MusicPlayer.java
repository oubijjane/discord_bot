package com.discord.discord_bot.music_player;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import discord4j.voice.AudioProvider;

public class MusicPlayer {
    private final AudioPlayerManager playerManager;
    private final AudioPlayer audioPlayer;

    private final AudioProvider audioProvider;

    public MusicPlayer(AudioPlayerManager playerManager) {
        this.playerManager = playerManager;
        this.audioPlayer = playerManager.createPlayer();
        this.audioProvider = new LavaplayerAudioProvider(audioPlayer);
        AudioSourceManagers.registerRemoteSources(this.playerManager);
        AudioSourceManagers.registerLocalSource(this.playerManager);
    }

    public AudioProvider getAudioProvider() {
        return audioProvider;
    }

    public void playTrack(String trackUrl) {
        playerManager.loadItem(trackUrl, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack audioTrack) {
                audioPlayer.playTrack(audioTrack);
            }

            @Override
            public void playlistLoaded(AudioPlaylist audioPlaylist) {

            }

            @Override
            public void noMatches() {

            }

            @Override
            public void loadFailed(FriendlyException e) {

            }
        });
    }
    public void pauseTrack() {
        audioPlayer.stopTrack();
    }
}
