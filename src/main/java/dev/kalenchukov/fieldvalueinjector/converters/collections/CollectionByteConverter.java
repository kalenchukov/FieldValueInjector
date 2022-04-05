package dev.kalenchukov.fieldvalueinjector.converters.collections;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.arrays.ArrayOfByteConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Collection} из {@code Byte}.
 */
public final class CollectionByteConverter implements Converting<Collection<Byte>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Collection<@NotNull Byte> convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException
	{
		Byte[] convertValue = new ArrayOfByteConverter().convertValueToType(value);

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
