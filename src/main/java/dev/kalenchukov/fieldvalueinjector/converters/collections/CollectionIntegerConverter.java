package dev.kalenchukov.fieldvalueinjector.converters.collections;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.arrays.ArrayOfIntegerConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Collection} из {@code Integer}.
 */
public final class CollectionIntegerConverter implements Converting<Collection<Integer>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Collection<@NotNull Integer> convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		Integer[] convertValue = new ArrayOfIntegerConverter().convertValueToType(value);

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
