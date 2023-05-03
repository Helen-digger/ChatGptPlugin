package com.helen.gptplugin.ui

import com.helen.gptplugin.configuration.ApplicationConfigurationState
import com.helen.gptplugin.util.MessageBundle
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.IdeBorderFactory
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.JBUI
import java.awt.BorderLayout
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JPanel

class PropertiesChatGptSettingsPanel : JPanel(BorderLayout()) {

    private val COMPONENT_INSETS: Insets = JBUI.insets(4)

    val apiKeyLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.apikey.label"))
    var apiKey: JBTextField = JBTextField()

    val modelsLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.models.label"))
    var modelsBox: ComboBox<String> =
            ComboBox<String>(ApplicationConfigurationState.settings.model.split(",").toTypedArray())

    val rolesLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.roles.label"))
    var rolesBox: ComboBox<String> =
            ComboBox<String>(ApplicationConfigurationState.settings.roles.split(",").toTypedArray())

    val temperatureLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.temperature.label"))
    var temperature: JBTextField = JBTextField()

    val topPLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.top_p.label"))
    var topP: JBTextField = JBTextField()

    val nLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.n.label"))
    var nField: JBTextField = JBTextField()

    val streamLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.stream.label"))
    var stream: JBTextField = JBTextField()

    val stopLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.stop.label"))
    var stop: JBTextField = JBTextField()

    val maxTokensLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.max_tokens.label"))
    var maxTokens: JBTextField = JBTextField()

    val presencePenaltyLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.presence_penalty.label"))
    var presencePenalty: JBTextField = JBTextField()

    val frequencyPenaltyLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.frequency_penalty.label"))
    var frequencyPenalty: JBTextField = JBTextField()

    val logitBiasLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.logit_bias.label"))
    var logitBias: JBTextField = JBTextField()

    val userLabel: JBLabel = JBLabel(MessageBundle.message("chatgpt.message.setting.user.label"))
    var user: JBTextField = JBTextField()

    init {
        modelsBox.item = ApplicationConfigurationState.settings.selectedModel
        rolesBox.item = ApplicationConfigurationState.settings.selectedRole
        initialize()
    }

    private fun initialize() {
        add(buildApiKeyPanel(), BorderLayout.NORTH)
        add(buildSettingPanel(), BorderLayout.CENTER)
        add(buildOptionalSettingPanel(), BorderLayout.SOUTH)
    }

    private fun buildApiKeyPanel() : JPanel {
        val apiPanel = JPanel(GridBagLayout())
        apiPanel.border = IdeBorderFactory.createTitledBorder(MessageBundle.message("chatgpt.message.setting.apikey.label"))

        apiPanel.add(apiKeyLabel, GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        apiPanel.add(apiKey,
            GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        return apiPanel
    }

    private fun buildSettingPanel() : JPanel {
        val settingPanel = JPanel(GridBagLayout())
        settingPanel.border = IdeBorderFactory.createTitledBorder("Settings")

        settingPanel.add(modelsLabel, GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        settingPanel.add(modelsBox,
            GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        settingPanel.add(rolesLabel, GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        settingPanel.add(rolesBox,
            GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        return settingPanel
    }

    private fun buildOptionalSettingPanel() : JPanel {
        var optionalParameters: JBCheckBox = JBCheckBox()
        val optionalSettingPanel = JPanel(GridBagLayout())

        optionalSettingPanel.border = IdeBorderFactory.createTitledBorder(MessageBundle.message("chatgpt.message.setting.optional.label"))

        optionalSettingPanel.add(JBLabel(MessageBundle.message("chatgpt.message.setting.optional.label")), GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(optionalParameters,
            GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        optionalSettingPanel.add(temperatureLabel, GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(temperature,
            GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        optionalSettingPanel.add(topPLabel, GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(topP,
            GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        optionalSettingPanel.add(nLabel, GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(nField,
            GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        optionalSettingPanel.add(streamLabel, GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(stream,
            GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        optionalSettingPanel.add(stopLabel, GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(stop,
            GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        optionalSettingPanel.add(maxTokensLabel, GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(maxTokens,
            GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        optionalSettingPanel.add(presencePenaltyLabel, GridBagConstraints(0, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(presencePenalty,
            GridBagConstraints(1, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        optionalSettingPanel.add(frequencyPenaltyLabel, GridBagConstraints(0, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(frequencyPenalty,
            GridBagConstraints(1, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        optionalSettingPanel.add(logitBiasLabel, GridBagConstraints(0, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(logitBias,
            GridBagConstraints(1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        optionalSettingPanel.add(userLabel, GridBagConstraints(0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))
        optionalSettingPanel.add(user,
            GridBagConstraints(1, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, COMPONENT_INSETS, 0, 0))

        return optionalSettingPanel
    }
}