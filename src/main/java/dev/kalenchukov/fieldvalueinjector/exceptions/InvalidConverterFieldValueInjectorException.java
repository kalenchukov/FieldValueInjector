/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvalueinjector.exceptions;

/**
 * Исключение для некорректного конвертера значений внедрения.
 */
public class InvalidConverterFieldValueInjectorException extends RuntimeException
{
    /**
     * Конструктор для {@code InvalidConverterFieldValueInjectorException}.
     */
    public InvalidConverterFieldValueInjectorException()
    {
        super();
    }

    /**
     * Конструктор для {@code InvalidConverterFieldValueInjectorException}.
     *
     * @param message Сообщение.
     */
    public InvalidConverterFieldValueInjectorException(String message)
    {
        super(message);
    }
}
