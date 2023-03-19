package org.mibe.tribute.trickster.i18n

import java.util.Locale

interface MessageService {
    fun get(key: String, locale: Locale): String
    fun get(key: String, locale: Locale, args: Array<Any>?): String
}