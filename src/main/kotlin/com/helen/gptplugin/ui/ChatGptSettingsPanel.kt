package com.helen.gptplugin.ui

import com.helen.gptplugin.configuration.ApplicationConfigurationState
import com.helen.gptplugin.util.PropertyValue
import com.intellij.openapi.observable.util.whenStateChanged
import com.intellij.openapi.ui.ComboBox
import java.awt.BorderLayout

import javax.swing.JPanel

class ChatGptSettingsPanel : JPanel(BorderLayout()) {

    var modelsBox: ComboBox<String> =
            ComboBox<String>(ApplicationConfigurationState.settings.model.split(",").toTypedArray())

    init {
        modelsBox.item = ApplicationConfigurationState.settings.selectedModel
        initialize()
    }

    private fun initialize() {
        add(JPanel(), BorderLayout.CENTER)
        add(modelsBox)
    }
}