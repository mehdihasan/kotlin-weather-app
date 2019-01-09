package mehdi.me.kotlinweatherapp.domain

/**
 * Copyright (c) 2019 Cefalo AS. All rights reserved.
 *
 */

public interface Command<out T> {
    fun execute(): T
}