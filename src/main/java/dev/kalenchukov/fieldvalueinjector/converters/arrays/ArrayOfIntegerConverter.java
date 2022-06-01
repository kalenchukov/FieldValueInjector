package dev.kalenchukov.fieldvalueinjector.converters.arrays;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.singles.IntegerConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Integer[]}.
 */
public final class ArrayOfIntegerConverter implements Converting<Integer[]>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Integer @Nullable [] convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Integer[] convertValue = new Integer[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new IntegerConverter().convertValueToType(new String[]{value[elm]});
		}

		return convertValue;
	}
}
