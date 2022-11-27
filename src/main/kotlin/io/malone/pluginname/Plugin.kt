package io.malone.pluginname

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Plugin : JavaPlugin(), Listener {

    override fun onEnable() {
        registerCommands()
    }

    private fun registerCommands() {
        val cmdMap = Utils.getCommandMap(server) ?: return
        // cmdMap.register(name, YourCommand())
    }
}

