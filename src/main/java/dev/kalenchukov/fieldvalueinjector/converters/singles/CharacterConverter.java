package dev.kalenchukov.fieldvalueinjector.converters.singles;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Character}.
 */
public final class CharacterConverter implements Converting<Character>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Character convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		if (value == null || value[0] == null) {
			return null;
		}

		try
		{
			return value[0].charAt(0);
		}
		catch (IndexOutOfBoundsException exception)
		{
			throw new UnableConverterException();
		}
	}
}
