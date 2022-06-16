package dev.kalenchukov.lemna.injection.converters.arrays;

import dev.kalenchukov.lemna.injection.Converting;
import dev.kalenchukov.lemna.injection.converters.singles.LongConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Long[]}.
 */
public final class ArrayOfLongConverter implements Converting<Long[]>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Long @Nullable [] convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Long[] convertValue = new Long[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new LongConverter().convertValueToType(new String[]{value[elm]});
		}

		return convertValue;
	}
}
