package com.helen.gptplugin.configuration

import com.helen.gptplugin.util.InterfacePropertyValueLoader
import com.helen.gptplugin.util.PropertyValue
import net.jcip.annotations.Immutable
import org.jetbrains.annotations.NotNull

//@Immutable
// todo read about stopSequence, maxTokens, logitBias, user
// see long or int
class ChatGptPluginConfiguration() : InterfacePropertyValueLoader, Comparable<ChatGptPluginConfiguration> {

    @PropertyValue("chatgpt.models")
    lateinit var model : String

    @PropertyValue("chatgpt.selected_model")
    lateinit var selectedModel: String

    @PropertyValue("chatgpt.messages.roles")
    lateinit var roles : String

    @PropertyValue("chatgpt.messages.selected_role")
    lateinit var selectedRole: String

    @PropertyValue("chatgpt.temperature")
    var temperature : Double = 0.0

    @PropertyValue("chatgpt.top_p")
    var topP: Long = 0

    @PropertyValue("chatgpt.n")
    var n: Long = 0

    @PropertyValue("chatgpt.stream")
    var stream: Boolean = false

    @PropertyValue("chatgpt.stop")
    lateinit var stopSequence: String //Array<String>

    @PropertyValue("chatgpt.max_tokens")
    var maxTokens: Long = 0

    @PropertyValue("chatgpt.presence_penalty")
    var presencePenalty: Long = 0

    @PropertyValue("chatgpt.frequency_penalty")
    var frequencyPenalty: Long = 0

    @PropertyValue("chatgpt.logit_bias")
    lateinit var logitBias: String

    @PropertyValue("chatgpt.user")
    lateinit var user: String

    /**
     * TODO: Initializer blocks are called for every object construction.
     * No matter what constructor is used, it is called in consecutive order, i.e. from top to down.
     *
     * Correction suggestion: introduce a new variable, that will be used to check if we need to call initProperties.
     * We only need to call this method if it is created from empty constructor, i.e. fill it with default values.
     *
     * Correction suggestion 2: move it to the top, above all non-default constructors, as it done right now
     */
    init {
        initProperties(this, InterfacePropertyValueLoader.properties)
    }

    /**
     * TODO: Looks like a bug.
     * Arguments are passed, but not setted in parent constructor.
     * IDEA Marks those fields as unused, because they are not, in fact.
     *
     * Correction suggestion: It is now correct, but I suggest to create a method in this class, that
     * will creat current configuration from panel.
     */
    constructor(
        @NotNull model: String,
        @NotNull role: String,
        temperature: Double,
        topP: Long,
        n: Long,
        stream: Boolean,
        stopSequence: String, //Array<String>,
        maxTokens: Long,
        presencePenalty: Long,
        frequencyPenalty: Long,
        logitBias: String,
        user: String
    ) : this() {
        this.selectedModel = model
        this.selectedRole = role
        this.temperature = temperature
        this.topP = topP
        this.n = n
        this.stream = stream
        this.stopSequence = stopSequence
        this.maxTokens = maxTokens
        this.presencePenalty = presencePenalty
        this.frequencyPenalty = frequencyPenalty
        this.logitBias = logitBias
        this.user = user
    }

    /**
     * Returns a new object with default configuration
     */
    fun getDefaultConfig(): ChatGptPluginConfiguration {
        return ChatGptPluginConfiguration()
    }

    override fun compareTo(other: ChatGptPluginConfiguration): Int {
        return Comparator
            .comparing(ChatGptPluginConfiguration::selectedModel)
            .thenComparing(ChatGptPluginConfiguration::selectedRole)
            .thenComparing(ChatGptPluginConfiguration::temperature)
            .thenComparing(ChatGptPluginConfiguration::topP)
            .thenComparing(ChatGptPluginConfiguration::n)
            .thenComparing(ChatGptPluginConfiguration::stream)
            .thenComparing(ChatGptPluginConfiguration::stopSequence)
            .thenComparing(ChatGptPluginConfiguration::maxTokens)
            .thenComparing(ChatGptPluginConfiguration::presencePenalty)
            .thenComparing(ChatGptPluginConfiguration::frequencyPenalty)
            .thenComparing(ChatGptPluginConfiguration::logitBias)
            .thenComparing(ChatGptPluginConfiguration::user)
            .compare(this, other)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChatGptPluginConfiguration

        if (model != other.model) return false
        if (selectedModel != other.selectedModel) return false
        if (roles != other.roles) return false
        if (selectedRole != other.selectedRole) return false
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
        result = 31 * result + selectedModel.hashCode()
        result = 31 * result + roles.hashCode()
        result = 31 * result + selectedRole.hashCode()
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
