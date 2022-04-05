/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvalueinjector.exceptions;

/**
 * Исключение для неопределённого конвертера для значения внедрения.
 */
public class UnknownConverterFieldValueInjectorException extends RuntimeException
{
    /**
     * Конструктор для {@code UnknownConverterFieldValueInjectorException}.
     */
    public UnknownConverterFieldValueInjectorException()
    {
        super();
    }

    /**
     * Конструктор для {@code UnknownConverterFieldValueInjectorException}.
     *
     * @param message Сообщение.
     */
    public UnknownConverterFieldValueInjectorException(String message)
    {
        super(message);
    }
}
