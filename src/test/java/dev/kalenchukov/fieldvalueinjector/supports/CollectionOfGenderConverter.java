/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvalueinjector.supports;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class CollectionOfGenderConverter implements Converting<Collection<Gender>>
{
    @Nullable
    @Override
    public Collection<@NotNull Gender> convertValueToType(@Nullable String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException
    {
        Gender[] convertValue = new ArrayOfGenderConverter().convertValueToType(value);

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
