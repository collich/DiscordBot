package org.github.collich.commands;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandInteraction;

public class PingCommand extends AbstractSlashCommands implements SlashCommands {
    private static final String COMMANDNAME = "ping";
    private static final String DESCRIPTION = "Replies with a pong!";

    public PingCommand(DiscordApi api) {
        SlashCommand.with(COMMANDNAME, DESCRIPTION)
                .createGlobal(api).join();

        api.addSlashCommandCreateListener(this::handle);
    }

    private void handle(SlashCommandCreateEvent event) {
        SlashCommandInteraction interaction = event.getSlashCommandInteraction();
        if (COMMANDNAME.equals(interaction.getCommandName())){
            interaction.createImmediateResponder()
                    .setContent("Pong!")
                    .respond();
        }
    }
}
