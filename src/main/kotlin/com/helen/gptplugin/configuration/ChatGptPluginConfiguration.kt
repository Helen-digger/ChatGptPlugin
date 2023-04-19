package com.helen.gptplugin.configuration

import com.helen.gptplugin.util.InterfacePropertyValueLoader
import com.helen.gptplugin.util.PropertyValue
import net.jcip.annotations.Immutable
import org.jetbrains.annotations.NotNull

@Immutable
// todo read about stopSequence, maxTokens, logitBias, user
// see long or int
class ChatGptPluginConfiguration() : InterfacePropertyValueLoader {

    @PropertyValue("chatgpt.models")
    lateinit var model : String

    @PropertyValue("chatgpt.selected_model")
    lateinit var selectedModel: String

    @PropertyValue("chatgpt.role")
    lateinit var role : String

    @PropertyValue("chatgpt.temperature")
    var temperature : Long = 0

    @PropertyValue("chatgpt.top_p")
    var topP: Long = 0

    @PropertyValue("chatgpt.n")
    var n: Long = 0

    @PropertyValue("chatgpt.stream")
    var stream: Boolean = false

    @PropertyValue("chatgpt.stop_sequence")
    lateinit var stopSequence: String //Array<String>

    @PropertyValue("chatgpt.max_tokens")
    lateinit var maxTokens: String //Long

    @PropertyValue("chatgpt.presence_penalty")
    var presencePenalty: Long = 0

    @PropertyValue("chatgpt.frequency_penalty")
    var frequencyPenalty: Long = 0

    @PropertyValue("chatgpt.logit_bias")
    lateinit var logitBias: String

    @PropertyValue("chatgpt.user")
    lateinit var user: String

    constructor(@NotNull model: String,
                @NotNull role: String,
                temperature: Long,
                topP: Int,
                n: Int,
                stream: Boolean,
                stopSequence: String, //Array<String>,
                maxTokens: Int,
                presencePenalty: Int,
                frequencyPenalty: Int,
                logitBias: String,
                user: String) : this()

    init {
        initProperties(this, InterfacePropertyValueLoader.properties)
    }

    fun getDefaultConfig(): ChatGptPluginConfiguration {
        return ChatGptPluginConfiguration()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChatGptPluginConfiguration

        if (model != other.model) return false
        if (role != other.role) return false
        if (temperature != other.temperature) return false
        if (topP != other.topP) return false
        if (n != other.n) return false
        if (stream != other.stream) return false
        if (stopSequence != other.stopSequence) return false
        if (maxTokens != other.maxTokens) return false
        if (presencePenalty != other.presencePenalty) return false
        if (frequencyPenalty != other.frequencyPenalty) return false
        if (logitBias != other.logitBias) return false
        if (user != other.user) return false

        return true
    }

    override fun hashCode(): Int {
        var result = model.hashCode()
        result = 31 * result + role.hashCode()
        result = 31 * result + temperature.hashCode()
        result = 31 * result + topP.hashCode()
        result = 31 * result + n.hashCode()
        result = 31 * result + stream.hashCode()
        result = 31 * result + stopSequence.hashCode()
        result = 31 * result + maxTokens.hashCode()
        result = 31 * result + presencePenalty.hashCode()
        result = 31 * result + frequencyPenalty.hashCode()
        result = 31 * result + logitBias.hashCode()
        result = 31 * result + user.hashCode()
        return result
    }
}
