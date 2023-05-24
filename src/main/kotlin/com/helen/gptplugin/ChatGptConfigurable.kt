package com.helen.gptplugin

import com.helen.gptplugin.configuration.ApplicationConfigurationState
import com.helen.gptplugin.ui.ChatGptSettingsPanel
import com.helen.gptplugin.ui.PropertiesChatGptSettingsPanel
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class ChatGptConfigurable : Configurable {

    private val state = ApplicationConfigurationState

    private val setPanel = ChatGptSettingsPanel(state)
    private val configPanel = PropertiesChatGptSettingsPanel(state)
    //private val dialogPanel =

    override fun createComponent(): JComponent {
        return setPanel
    }

    override fun isModified(): Boolean {
        return configPanel.getCurrentSettings().compareTo(state.settings) != 0
    }

    override fun apply() {

        /*configPanel.apiKey.let {
            state.settings.apiKey = it.toString()
        }*/
        configPanel.modelsBox.selectedItem?.let {
            state.settings.selectedModel = it.toString()
        }
        configPanel.rolesBox.selectedItem?.let {
            state.settings.selectedRole = it.toString()
        }
        configPanel.temperature.let {
            state.settings.temperature = it.text.toDouble()
        }
        configPanel.topP.let {
            state.settings.topP = it.text.toLong()
        }
        configPanel.nField.let {
            state.settings.n = it.text.toLong()
        }
        configPanel.stream.let {
            state.settings.stream = it.text.toBoolean()
        }
        configPanel.stop.let {
            state.settings.stopSequence = it.text.toString()
        }
        configPanel.maxTokens.let {
            state.settings.maxTokens = it.text.toLong()
        }
        configPanel.presencePenalty.let {
            state.settings.presencePenalty = it.text.toLong()
        }
        configPanel.frequencyPenalty.let {
            state.settings.frequencyPenalty = it.text.toLong()
        }
        configPanel.logitBias.let {
            state.settings.logitBias = it.text.toString()
        }
        configPanel.user.let {
            state.settings.user = it.text.toString()
        }
    }

    override fun getDisplayName(): String {
        return "ChatGpt"
    }
}