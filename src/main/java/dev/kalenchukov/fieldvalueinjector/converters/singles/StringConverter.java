package dev.kalenchukov.fieldvalueinjector.converters.singles;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code String}.
 */
public final class StringConverter implements Converting<String>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public String convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null || value[0] == null) {
			return null;
		}

		return value[0];
	}
}
