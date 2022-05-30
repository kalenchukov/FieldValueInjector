/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvalueinjector;

import dev.kalenchukov.fieldvalueinjector.annotations.Converter;
import dev.kalenchukov.fieldvalueinjector.converters.ConverterRepository;
import dev.kalenchukov.fieldvalueinjector.exceptions.*;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Внедряет данные в поля класса.
 */
public class FieldValueInjector implements FieldValueInjectable
{
	/**
	 * Локализация.
	 */
	@NotNull
	private Locale locale = new Locale("ru", "RU");

	/**
	 * Объект класса в который необходимо внедрять данные.
	 */
	@NotNull
	private final Object object;

	/**
	 * Репозиторий конвертеров типов данных.
	 */
	@NotNull
	private final ConverterRepository converterRepository = new ConverterRepository();

	/**
	 * Устанавливает логгер для данного класса.
	 */
	@NotNull
	private static final Logger LOG = Logger.getLogger(FieldValueInjector.class);

	/**
	 * Устанавливает тексты локализации логирования.
	 */
	@NotNull
	private ResourceBundle localeLogs = ResourceBundle.getBundle("localizations/logs", locale);

	/**
	 * Устанавливает локализованные тексты исключений.
	 */
	@NotNull
	private ResourceBundle localeExceptions = ResourceBundle.getBundle("localizations/exceptions", locale);

	/**
	 * Конструктор для {@code FieldValueInjector}.
	 *
	 * @param object Объект класса в который необходимо внедрить данные.
	 */
	public FieldValueInjector(@NotNull final Object object)
	{
		this.object = object;
	}

	/**
	 * @see FieldValueInjectable#setLocale(Locale)
	 */
	public void setLocale(@NotNull Locale locale)
	{
		Objects.requireNonNull(locale);

		if (!this.locale.equals(locale))
		{
			this.locale = locale;

			localeLogs = ResourceBundle.getBundle("localizations/logs", this.locale);
			localeExceptions = ResourceBundle.getBundle("localizations/exceptions", this.locale);
		}
	}

	/**
	 * @see FieldValueInjectable#inject(Map)
	 */
	@Override
	public void inject(@NotNull final Map<@NotNull String, @Nullable String @Nullable []> data)
		throws IllegalValueFieldValueInjectorException, UnknownConverterFieldValueInjectorException, InvalidConverterFieldValueInjectorException
	{
		Objects.requireNonNull(data);

		LOG.debug(String.format(
			localeLogs.getString("60001"),
			this.object.getClass().getName()
		));

		if (data.size() > 0)
		{
			this.findPersonalConverters();

			for (Field field : this.object.getClass().getDeclaredFields())
			{
				String[] value = data.get(field.getName());

				if (value == null)
				{
					LOG.debug(String.format(
							localeLogs.getString("60003"),
							field.getName()
					));

					continue;
				}

				field.setAccessible(true);

				this.injectValueField(field, value);

				field.setAccessible(false);
			}
		}

		LOG.debug(String.format(
			localeLogs.getString("60002"),
			this.object.getClass().getName()
		));
	}

	/**
	 * Внедряет значение в поле класса.
	 *
	 * @param field Поле класса в которое необходимо внедрить значение.
	 * @param value Коллекция значений которые необходимо внедрить в поле класса.
	 *
	 * @throws IllegalValueFieldValueInjectorException Если передано некорректное значение для внедрения в данное поле класса.
	 * @throws UnknownConverterFieldValueInjectorException Если для типа поля не реализован персональный конвертер.
	 * @throws InvalidConverterFieldValueInjectorException Если конвертер некорректный.
	 */
	private void injectValueField(@NotNull final Field field, @Nullable final String @Nullable [] value)
		throws IllegalValueFieldValueInjectorException, UnknownConverterFieldValueInjectorException, InvalidConverterFieldValueInjectorException
	{
		Objects.requireNonNull(field);
		Objects.requireNonNull(value);

		boolean has = this.converterRepository.getConverters().containsKey(
			field.getGenericType().getTypeName()
		);

		if (!has) {
			throw new UnknownConverterFieldValueInjectorException(String.format(
				localeExceptions.getString("70002"),
				field.getGenericType().getTypeName(),
				this.object.getClass().getName()
			));
		}

		Class<? extends Converting<?>> converter = this.converterRepository.getConverters().get(
			field.getGenericType().getTypeName()
		);

		try
		{
			Method method = converter.getDeclaredMethod("convertValueToType", String[].class);

//			System.out.println(String[].class.getTypeName());
//			System.out.println(value.getClass().getTypeName());

			field.set(
				this.object,
				method.invoke(
						converter.getConstructor().newInstance(),
						(Object) value
				)
			);
		}
		catch (InvocationTargetException exception)
		{
			throw new IllegalValueFieldValueInjectorException(String.format(
				localeExceptions.getString("70001"),
				field.getName(),
				this.object.getClass().getName()
			));
		}
		catch (IllegalArgumentException | NoSuchMethodException |
			IllegalAccessException | InstantiationException exception)
		{
			throw new InvalidConverterFieldValueInjectorException(String.format(
				localeExceptions.getString("70003"),
				converter.getName(),
				this.object.getClass().getName()
			));
		}

		LOG.debug(String.format(
			localeLogs.getString("60004"),
			field.getName()
		));
	}

	/**
	 * Ищет персональные конвертеры для типов данных.
	 */
	private void findPersonalConverters()
	{
		for (Field field : this.object.getClass().getDeclaredFields())
		{
			Converter[] annotationsConverter = field.getAnnotationsByType(Converter.class);

			if (annotationsConverter.length == 0) {
				return;
			}

			for (Converter annotationConverter : annotationsConverter)
			{
				this.converterRepository.addConverter(
					field.getGenericType().getTypeName(),
					annotationConverter.converter()
				);

				LOG.debug(String.format(
					localeLogs.getString("60005"),
					annotationConverter.converter().getTypeName(),
					field.getGenericType().getTypeName()
				));
			}
		}
	}
}
