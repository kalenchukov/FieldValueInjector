package dev.kalenchukov.lemna.injection.converters.sets;

import dev.kalenchukov.lemna.injection.Converting;
import dev.kalenchukov.lemna.injection.converters.arrays.ArrayOfFloatConverter;
import dev.kalenchukov.lemna.injection.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Set;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Set} из {@code Float}.
 */
public final class SetFloatConverter implements Converting<Set<Float>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Set<@NotNull Float> convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		Float[] convertValue = new ArrayOfFloatConverter().convertValueToType(value);

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