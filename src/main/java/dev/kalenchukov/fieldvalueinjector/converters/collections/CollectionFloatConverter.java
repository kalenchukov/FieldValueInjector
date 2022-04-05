package dev.kalenchukov.fieldvalueinjector.converters.collections;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.arrays.ArrayOfFloatConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Collection} из {@code Float}.
 */
public final class CollectionFloatConverter implements Converting<Collection<Float>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Collection<@NotNull Float> convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException
	{
		Float[] convertValue = new ArrayOfFloatConverter().convertValueToType(value);

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
