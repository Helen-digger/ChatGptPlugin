package com.helen.gptplugin.ui

import com.helen.gptplugin.util.PropertyValue
import com.intellij.openapi.ui.ComboBox
import java.awt.BorderLayout

import javax.swing.JPanel

class ChatGptSettingsPanel : ChatGptPanel() {

    @PropertyValue("chatgpt.model")
    lateinit var models : String

    @PropertyValue("chatgpt.temperature")
    var temperature : Long = 0

    var modelsBox: ComboBox<String>

    init {
        modelsBox = ComboBox<String>(models.split(",").toTypedArray())
        initialise()
    }

    private fun initialise() {
        add(JPanel(), BorderLayout.CENTER)
        add(modelsBox)
    }
}