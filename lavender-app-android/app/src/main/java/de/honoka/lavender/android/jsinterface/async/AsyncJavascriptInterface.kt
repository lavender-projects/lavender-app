package de.honoka.lavender.android.jsinterface.async

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class AsyncJavascriptInterface(

    val isPlainText: Boolean = false
)
