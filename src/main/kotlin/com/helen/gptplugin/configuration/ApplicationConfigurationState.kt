package com.helen.gptplugin.configuration

import com.helen.gptplugin.ChatGptPlugin
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(name = ChatGptPlugin.ID_PLUGIN_APP,
    storages = [Storage(ChatGptPlugin.PLUGIN_STORAGE)])
object ApplicationConfigurationState : PersistentStateComponent<ApplicationConfigurationState> {

    var settings: ChatGptPluginConfiguration = ChatGptPluginConfiguration().getDefaultConfig()

    override fun getState(): ApplicationConfigurationState {
        return this
    }

    override fun loadState(state: ApplicationConfigurationState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}