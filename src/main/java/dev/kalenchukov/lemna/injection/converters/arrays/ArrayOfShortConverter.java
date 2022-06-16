package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.ShortConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Short[]}.
 */
public final class ArrayOfShortConverter implements Converting<Short[]>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Short @Nullable [] convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Short[] convertValue = new Short[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new ShortConverter().convertValueToType(new String[]{value[elm]});
		}

		return convertValue;
	}
}