package dev.kalenchukov.fieldvalueinjector.converters.arrays;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.singles.ByteConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Byte[]}.
 */
public final class ArrayOfByteConverter implements Converting<Byte[]>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Byte @Nullable [] convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null) {
			return null;
		}

		Byte[] convertValue = new Byte[value.length];

		for (int elm = 0; elm < value.length; elm++)
		{
			convertValue[elm] = new ByteConverter().convertValueToType(new String[]{value[elm]});
		}

		return convertValue;
	}
}
