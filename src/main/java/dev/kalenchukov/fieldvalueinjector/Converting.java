/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvalueinjector;

import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.Nullable;

/**
 * Интерфейс для реализации конвертера типа значений.
 *
 * @param <T> Объект типа возвращаемых данных.
 */
public interface Converting<T>
{
	/**
	 * Конвертирует значение в указанный тип данных.
	 *
	 * @param value Значения, тип данных которых необходимо конвертировать.
	 * @return Возвращает значение конвертированное в указанный тип данных.
	 * @throws UnableConverterFieldValueInjectorException Если конвертировать значение в нужный тип данных не удалось.
	 */
	@Nullable
	T convertValueToType(@Nullable String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException;
}
