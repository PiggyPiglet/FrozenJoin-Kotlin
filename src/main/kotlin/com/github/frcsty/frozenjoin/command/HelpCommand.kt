package com.github.frcsty.frozenjoin.command

import com.github.frcsty.frozenjoin.configuration.MessageLoader
import com.github.frcsty.frozenjoin.util.color
import com.github.frcsty.frozenjoin.util.replacePlaceholder
import com.github.frcsty.frozenjoin.load.Settings
import com.github.frcsty.frozenjoin.load.logInfo
import me.mattstudios.mf.annotations.Command
import me.mattstudios.mf.annotations.Permission
import me.mattstudios.mf.annotations.SubCommand
import me.mattstudios.mf.base.CommandBase
import org.bukkit.command.CommandSender

@Command("frozenjoin")
class HelpCommand(private val messageLoader: MessageLoader) : CommandBase() {

    companion object {
        private const val COMMAND: String = "help"
        private const val PERMISSION: String = "join.command.help"
    }

    @SubCommand(COMMAND)
    @Permission(PERMISSION)
    fun helpCommand(sender: CommandSender) {
        val help = messageLoader.getMessageList("helpMessage")

        for (line in help) {
            sender.sendMessage(line.replacePlaceholder("{version}", Settings.PLUGIN_VERSION).color())
        }

        if (Settings.DEBUG) logInfo("Executor ${sender.name} executed action 'help'")
    }
}