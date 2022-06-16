package dev.kalenchukov.lemna.injection.converters.sets;

import dev.kalenchukov.lemna.injection.Converting;
import dev.kalenchukov.lemna.injection.converters.arrays.ArrayOfIntegerConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Set} из {@code Integer}.
 */
public final class SetIntegerConverter implements Converting<Set<Integer>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Set<@NotNull Integer> convertValueToType(@Nullable final String @Nullable [] value)
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

		return Set.of(convertValue);
	}
}