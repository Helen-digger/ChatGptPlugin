package com.helen.gptplugin

import com.helen.gptplugin.configuration.ApplicationConfigurationState
import com.helen.gptplugin.ui.ChatGptSettingsPanel
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class ChatGptConfigurable : Configurable {


    private val configPanel = ChatGptSettingsPanel()
    private val mutConfigPanel = ChatGptSettingsPanel() // для сравнение с модифицировааной панелью

    override fun createComponent(): JComponent {
        return configPanel
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