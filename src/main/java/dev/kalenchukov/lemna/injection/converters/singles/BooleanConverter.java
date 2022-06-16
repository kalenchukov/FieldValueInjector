package dev.kalenchukov.lemna.injection.converters.singles;

import dev.kalenchukov.lemna.injection.Converting;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Boolean}.
 */
public final class BooleanConverter implements Converting<Boolean>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Boolean convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null || value[0] == null) {
			return null;
		}

		return switch (value[0].toLowerCase())
		{
			case "true" -> true;
			case "false" -> false;
			default	-> throw new UnableConverterException();
		};
	}
}