package com.helen.gptplugin

import com.helen.gptplugin.configuration.ApplicationConfigurationState
import com.helen.gptplugin.ui.ChatGptSettingsPanel
import com.helen.gptplugin.ui.PropertiesChatGptSettingsPanel
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class ChatGptConfigurable : Configurable {

    private val setPanel = ChatGptSettingsPanel()
    private val configPanel = PropertiesChatGptSettingsPanel()
    private val mutConfigPanel = PropertiesChatGptSettingsPanel() // для сравнение с модифицировааной панелью

    override fun createComponent(): JComponent {
        return setPanel
    }

    override fun isModified(): Boolean {
        return true
    }

    override fun apply() {
        val state = ApplicationConfigurationState
        configPanel.modelsBox.selectedItem?.let {
            state.settings.selectedModel = it.toString()
        }
        configPanel.rolesBox.selectedItem?.let {
            state.settings.selectedRole = it.toString()
        }
    }

    override fun getDisplayName(): String {
        return "ChatGpt"
    }
}