package org.mibe.tribute.trickster.i18n

import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import java.util.Locale

@Service
class MessageServiceImpl(
    private val messageSource: MessageSource
) : MessageService {

    override fun get(key: String, locale: Locale): String {
        return messageSource.getMessage(key, null, locale)
    }

    override fun get(key: String, locale: Locale, args: Array<Any>?): String {
        return messageSource.getMessage(key, args, locale)
    }
}