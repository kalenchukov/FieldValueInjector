package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.BooleanConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Boolean[]}.
 */
public final class ArrayOfBooleanConverter implements Converting<Boolean[]>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Boolean @Nullable [] convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Boolean[] convertValue = new Boolean[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new BooleanConverter().convertValueToType(new String[]{value[elm]});
		}

		return convertValue;
	}
}
