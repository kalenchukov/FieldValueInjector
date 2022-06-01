package dev.kalenchukov.fieldvalueinjector.converters.arrays;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.singles.LongConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
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
