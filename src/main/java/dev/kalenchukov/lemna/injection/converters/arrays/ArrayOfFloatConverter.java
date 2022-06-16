package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.FloatConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Float[]}.
 */
public final class ArrayOfFloatConverter implements Converting<Float[]>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Float @Nullable [] convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Float[] convertValue = new Float[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new FloatConverter().convertValueToType(new String[]{value[elm]});
		}

		return convertValue;
	}
}
