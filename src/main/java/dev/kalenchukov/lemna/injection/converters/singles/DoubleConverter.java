package dev.kalenchukov.lemna.injection.converters.singles;

import dev.kalenchukov.lemna.injection.Converting;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
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
		throws UnableConverterException
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
			throw new UnableConverterException();
		}
	}
}