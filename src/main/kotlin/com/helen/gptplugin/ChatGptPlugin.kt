package com.helen.gptplugin

import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.extensions.PluginId

class ChatGptPlugin {

    companion object {
        const val ID_PLUGIN = "ChatGpt-IDEA"
        const val ID_PLUGIN_APP = "$ID_PLUGIN-app"
        const val PLUGIN_STORAGE = "chatgpt-idea.xml"
    }

    fun version(): String? {
        try {
            val plugin = PluginManagerCore.getPlugin(PluginId.getId(ID_PLUGIN))
            if (plugin != null) {
                return plugin.version
            }
        } catch (ignored: Throwable) {
            // thrown if plugin isn't initialised, e.g. during tests
        }
        return "unknown"
    }
}