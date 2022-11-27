package io.malone.pluginname

import org.bukkit.Server
import org.bukkit.command.CommandMap
import org.bukkit.plugin.PluginManager
import java.lang.reflect.Field

class Utils {
    companion object {
        fun getCommandMap(server: Server): CommandMap? {
            return try {
                val manager: PluginManager = server.pluginManager
                val field: Field = manager.javaClass.getDeclaredField("commandMap")
                field.isAccessible = true
                CommandMap::class.java.cast(field.get(manager))
            } catch (error: NoSuchFieldException) {
                throw IllegalStateException("Intake could not find CommandMap from server", error)
            } catch (error: IllegalAccessException) {
                throw IllegalStateException("Intake could not find CommandMap from server", error)
            }
        }
    }
}