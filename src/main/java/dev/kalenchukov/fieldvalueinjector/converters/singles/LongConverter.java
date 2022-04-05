package dev.kalenchukov.fieldvalueinjector.converters.singles;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Long}.
 */
public final class LongConverter implements Converting<Long>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Long convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException
	{
		if (value == null || value[0] == null) {
			return null;
		}

		try
		{
			return Long.parseLong(value[0]);
		}
		catch (NumberFormatException exception)
		{
			throw new UnableConverterFieldValueInjectorException();
		}
	}
}
