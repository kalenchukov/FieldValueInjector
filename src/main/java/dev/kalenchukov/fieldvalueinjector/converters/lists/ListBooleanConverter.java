package dev.kalenchukov.fieldvalueinjector.converters.lists;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.arrays.ArrayOfBooleanConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code List} из {@code Boolean}.
 */
public final class ListBooleanConverter implements Converting<List<Boolean>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public List<@NotNull Boolean> convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException
	{
		Boolean[] convertValue = new ArrayOfBooleanConverter().convertValueToType(value);

		if (convertValue == null) {
			return null;
		}

		boolean has = Arrays.stream(convertValue).anyMatch(Objects::isNull);

		if (has) {
			throw new UnableConverterFieldValueInjectorException();
		}

		return List.of(convertValue);
	}
}
