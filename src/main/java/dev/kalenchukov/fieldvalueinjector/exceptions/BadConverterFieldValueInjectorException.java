/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvalueinjector.exceptions;

/**
 * Исключение для некорректного конвертера значений внедрения.
 */
public class BadConverterFieldValueInjectorException extends RuntimeException
{
    /**
     * Конструктор для {@code BadConverterFieldValueInjectorException}.
     */
    public BadConverterFieldValueInjectorException()
    {
        super();
    }

    /**
     * Конструктор для {@code BadConverterFieldValueInjectorException}.
     *
     * @param message Сообщение.
     */
    public BadConverterFieldValueInjectorException(String message)
    {
        super(message);
    }
}
