package dev.kalenchukov.fieldvalueinjector.converters.singles;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Double}.
 */
public final class DoubleConverter implements Converting<Double>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Double convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException
	{
		if (value == null || value[0] == null) {
			return null;
		}

		try
		{
			return Double.parseDouble(value[0]);
		}
		catch (NumberFormatException exception)
		{
			throw new UnableConverterFieldValueInjectorException();
		}
	}
}
