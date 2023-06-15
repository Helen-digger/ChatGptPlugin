package com.helen.gptplugin

import com.helen.gptplugin.configuration.ApplicationConfigurationState
import com.helen.gptplugin.ui.ChatGptSettingsPanel
import com.helen.gptplugin.ui.PropertiesChatGptSettingsPanel
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class ChatGptConfigurable : Configurable {

    private val state = ApplicationConfigurationState.getInstance()

    private val setPanel = ChatGptSettingsPanel(state)

    override fun createComponent(): JComponent {
        return setPanel
    }

    override fun isModified(): Boolean {
        val b = setPanel.propertiesChatGpt.getCurrentSettings().compareTo(state.settings)
        return b != 0
    }

    // TODO: Нужно добавить на поля валидаторы и не давать сохранять невалидную конфигурацию.
    // Сейчас вместо невалидных значений сохраняются значения по-умолчанию, для чисел.
    // TODO: Посмотреть в других плагинах как сделана обработка таких значений
    override fun apply() {

        /*configPanel.apiKey.let {
            state.settings.apiKey = it.toString()
        }*/
        setPanel.propertiesChatGpt.modelsBox.selectedItem?.let {
            state.settings.selectedModel = it.toString()
        }
        setPanel.propertiesChatGpt.rolesBox.selectedItem?.let {
            state.settings.selectedRole = it.toString()
        }
        setPanel.propertiesChatGpt.temperature.let {
            state.settings.temperature = it.text.toDouble()
        }
        setPanel.propertiesChatGpt.topP.let {
            state.settings.topP = it.text.toLong()
        }
        setPanel.propertiesChatGpt.nField.let {
            state.settings.n = it.text.toLong()
        }
        setPanel.propertiesChatGpt.stream.let {
            state.settings.stream = it.text.toBoolean()
        }
        setPanel.propertiesChatGpt.stop.let {
            state.settings.stopSequence = it.text.toString()
        }
        setPanel.propertiesChatGpt.maxTokens.let {
            state.settings.maxTokens = it.text.toLong()
        }
        setPanel.propertiesChatGpt.presencePenalty.let {
            state.settings.presencePenalty = it.text.toLong()
        }
        setPanel.propertiesChatGpt.frequencyPenalty.let {
            state.settings.frequencyPenalty = it.text.toLong()
        }
        setPanel.propertiesChatGpt.logitBias.let {
            state.settings.logitBias = it.text.toString()
        }
        setPanel.propertiesChatGpt.user.let {
            state.settings.user = it.text.toString()
        }
    }

    override fun getDisplayName(): String {
        return "ChatGpt"
    }
}