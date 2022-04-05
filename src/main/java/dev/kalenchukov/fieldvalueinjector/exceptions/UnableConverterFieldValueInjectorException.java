/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvalueinjector.exceptions;

/**
 * Исключение для невозможности конвертирования значения внедрения.
 */
public class UnableConverterFieldValueInjectorException extends RuntimeException
{
    /**
     * Конструктор для {@code UnableConverterFieldValueInjectorException}.
     */
    public UnableConverterFieldValueInjectorException()
    {
        super();
    }

    /**
     * Конструктор для {@code UnableConverterFieldValueInjectorException}.
     *
     * @param message Сообщение.
     */
    public UnableConverterFieldValueInjectorException(String message)
    {
        super(message);
    }
}
