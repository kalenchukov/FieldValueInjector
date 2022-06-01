package dev.kalenchukov.fieldvalueinjector.converters.lists;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.arrays.ArrayOfCharacterConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code List} из {@code Character}.
 */
public final class ListCharacterConverter implements Converting<List<Character>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public List<@NotNull Character> convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		Character[] convertValue = new ArrayOfCharacterConverter().convertValueToType(value);

		if (convertValue == null) {
			return null;
		}

		boolean has = Arrays.stream(convertValue).anyMatch(Objects::isNull);

		if (has) {
			throw new UnableConverterException();
		}

		return List.of(convertValue);
	}
}
