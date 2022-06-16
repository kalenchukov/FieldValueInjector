package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.DoubleConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Double[]}.
 */
public final class ArrayOfDoubleConverter implements Converting<Double[]>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Double @Nullable [] convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Double[] convertValue = new Double[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new DoubleConverter().convertValueToType(new String[]{value[elm]});
		}

		return convertValue;
	}
}