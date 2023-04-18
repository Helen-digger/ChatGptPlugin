package com.helen.gptplugin.configuration

import com.helen.gptplugin.ChatGptPlugin
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(name = ChatGptPlugin.ID_PLUGIN + "-app",
    storages = [Storage("chatgpt-idea.xml")])
class ApplicationConfigurationState : PersistentStateComponent<ApplicationConfigurationState> {

    public val settings: ChatGptPluginConfiguration = ChatGptPluginConfiguration().getDefaultConfig();

    companion object {
        //val instance = ApplicationConfigurationState()
        val instance: ApplicationConfigurationState
        = ApplicationManager.getApplication().getService(ApplicationConfigurationState::class.java)
    }

    override fun getState(): ApplicationConfigurationState {
        return this;
    }

    override fun loadState(state: ApplicationConfigurationState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}