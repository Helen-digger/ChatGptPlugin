package com.helen.gptplugin.util

object TypeUtils {

    fun inferType(value: String?): Any? {
        // isNull narrowest type in the whole chain
        return IS_NULL.infer(value)
    }

    private abstract class InferStep {
        private var next: InferStep? = null
        abstract fun inferType(value: String?): Any?
        fun setNext(step: InferStep): InferStep {
            next = step
            return step
        }

        open fun inferrable(value: String?): Boolean {
            return inferType(value) != null
        }

        fun infer(value: String?): Any? {
            return if (inferrable(value)) {
                inferType(value)
            } else next!!.infer(value)
        }
    }

    private val IS_NULL: InferStep = object : InferStep() {
        override fun inferType(value: String?): Any? {
            return if (value == null || value == "null") {
                null
            } else value
        }

        override fun inferrable(value: String?): Boolean {
            return inferType(value) == null
        }
    }

    private val IS_BOOLEAN: InferStep = object : InferStep() {
        override fun inferType(value: String?): Any? {
            return if (value.equals("true", ignoreCase = true)
                || value.equals("false", ignoreCase = true)
            ) java.lang.Boolean.parseBoolean(value) else null
        }
    }

    private val IS_STRING: InferStep = object : InferStep() {
        override fun inferType(value: String?): Any? {
            return value
        }
    }

    private val IS_DOUBLE: InferStep = object : InferStep() {
        override fun inferType(value: String?): Any? {
            try {
                if (value != null) {
                    val number = value.toDouble()
                    return if (java.lang.Double.isFinite(number)) number else null
                }
            } catch (e: NumberFormatException) {
            }
            return null
        }
    }

    private val IS_LONG: InferStep = object : InferStep() {
        override fun inferType(value: String?): Any? {
            return try {
                if (value != null) java.lang.Long.decode(value) else null
            } catch (e: NumberFormatException) {
                null
            }
        }
    }

    init {
        IS_NULL.setNext(IS_BOOLEAN)
            .setNext(IS_LONG)
            .setNext(IS_DOUBLE)
            .setNext(IS_STRING);
    }
}