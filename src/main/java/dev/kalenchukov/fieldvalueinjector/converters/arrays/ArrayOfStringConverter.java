package dev.kalenchukov.fieldvalueinjector.converters.arrays;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.singles.StringConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code String[]}.
 */
public final class ArrayOfStringConverter implements Converting<String[]>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public String @Nullable [] convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException
	{
		if (value == null) {
			return null;
		}

		String[] convertValue = new String[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new StringConverter().convertValueToType(new String[]{value[elm]});
		}

		return convertValue;
	}
}
