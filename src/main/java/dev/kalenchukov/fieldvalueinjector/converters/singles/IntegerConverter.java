package dev.kalenchukov.fieldvalueinjector.converters.singles;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Integer}.
 */
public final class IntegerConverter implements Converting<Integer>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Integer convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null || value[0] == null) {
			return null;
		}

		try
		{
			return Integer.parseInt(value[0]);
		}
		catch (NumberFormatException exception)
		{
			throw new UnableConverterException();
		}
	}
}
