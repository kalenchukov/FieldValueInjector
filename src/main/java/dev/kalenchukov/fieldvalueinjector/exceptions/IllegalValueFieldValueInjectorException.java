/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvalueinjector.exceptions;

/**
 * Исключение для некорректного значения для внедрения.
 */
public class IllegalValueFieldValueInjectorException extends RuntimeException
{
    /**
     * Конструктор для {@code IllegalValueFieldValueInjectorException}.
     */
    public IllegalValueFieldValueInjectorException()
    {
        super();
    }

    /**
     * Конструктор для {@code IllegalValueFieldValueInjectorException}.
     *
     * @param message Сообщение.
     */
    public IllegalValueFieldValueInjectorException(String message)
    {
        super(message);
    }
}
