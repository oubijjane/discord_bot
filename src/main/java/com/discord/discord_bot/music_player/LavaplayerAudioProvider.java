package com.discord.discord_bot.music_player;

import com.sedmelluq.discord.lavaplayer.format.StandardAudioDataFormats;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import com.sedmelluq.discord.lavaplayer.track.playback.MutableAudioFrame;
import discord4j.voice.AudioProvider;

import java.nio.ByteBuffer;

public class LavaplayerAudioProvider extends AudioProvider {
    private final AudioPlayer audioPlayer;
    private final MutableAudioFrame frame = new MutableAudioFrame();

    public LavaplayerAudioProvider(final AudioPlayer audioPlayer) {
        super(
                ByteBuffer.allocate(
                        StandardAudioDataFormats.DISCORD_OPUS.maximumChunkSize()
                )
        );
        frame.setBuffer(getBuffer());
        this.audioPlayer = audioPlayer;
    }

    @Override
    public boolean provide() {
        // AudioPlayer writes audio data to its AudioFrame
        final boolean didProvide = audioPlayer.provide(frame);
        // If audio was provided, flip from write-mode to read-mode
        if (didProvide) {
            getBuffer().flip();
        }
        return didProvide;
    }
}
