package org.github.collich.domain;

import org.github.collich.commands.PingCommand;
import org.javacord.api.DiscordApi;
import io.github.cdimascio.dotenv.Dotenv;
import org.javacord.api.DiscordApiBuilder;

public class Bot {

    public void start(){
        Dotenv dotenv = Dotenv.load();
        String discordToken = dotenv.get("DISCORD_TOKEN");
        DiscordApi api = new DiscordApiBuilder().setToken(discordToken)
                .login().join();

        new PingCommand(api);
    }
}
