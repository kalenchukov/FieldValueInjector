package dev.kalenchukov.fieldvalueinjector.converters.arrays;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.singles.FloatConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
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
		throws UnableConverterFieldValueInjectorException
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
