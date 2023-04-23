package com.helen.gptplugin.ui

import com.helen.gptplugin.configuration.ApplicationConfigurationState
import com.helen.gptplugin.util.MessageBundle
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.ui.layout.selected
import com.intellij.util.ui.FormBuilder
import com.intellij.util.ui.JBUI
import java.awt.BorderLayout
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JPanel

class ChatGptSettingsPanel : JPanel(BorderLayout()) {

    private val COMPONENT_INSETS: Insets = JBUI.insets(4)

    val apiKeyLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.apikey.label"))
    var apiKey: JBTextField = JBTextField("")

    var modelsBox: ComboBox<String> =
            ComboBox<String>(ApplicationConfigurationState.settings.model.split(",").toTypedArray())
    var rolesBox: ComboBox<String> =
            ComboBox<String>(ApplicationConfigurationState.settings.roles.split(",").toTypedArray())
    var temperature: JBTextField = JBTextField("")

    init {
        modelsBox.item = ApplicationConfigurationState.settings.selectedModel
        rolesBox.item = ApplicationConfigurationState.settings.selectedRole
        initialize()
    }

    private fun initialize() {
        add(buildSettingPanel(), BorderLayout.WEST)
    }

    private fun buildSettingPanel() : JPanel {
        var optionalParameters: JBCheckBox = JBCheckBox()
        var builder = FormBuilder.createFormBuilder()
            .addLabeledComponent(apiKeyLabel, apiKey, 0, false)
            .addSeparator()
            .addLabeledComponent(JBLabel("Model: "), modelsBox, 1, false)
            .addLabeledComponent(JBLabel("Role: "), rolesBox, 2, false)
            .addSeparator()
            .addLabeledComponent(JBLabel("Optional parameters: "), optionalParameters, 3, false)
            .addSeparator()
            .addLabeledComponent(JBLabel("Temperature: "), temperature, 4, false)

        return builder.panel


        /*val settingPanel = JPanel(GridBagLayout())
        settingPanel.add(apiKey,
            GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        settingPanel.add(modelsBox,
            GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        settingPanel.add(rolesBox,
            GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        settingPanel.add(temperature,
            GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        return settingPanel*/
    }
}