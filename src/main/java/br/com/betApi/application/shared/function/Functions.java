package br.com.betApi.application.shared.function;

import br.com.betApi.domain.vo.IAction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @version 1.0.0
 * @Author: Luiz Augusto
 * @E-mail: luiz.develop@gmail.com
 * Do not change this class
 */
public final class Functions {
    private Functions() {
    }

    public static <T> void noPresent(T value, IAction emptyAction) {
        if (Boolean.FALSE.equals(notNullAndNotEmpty(value)))
            emptyAction.run();
    }

    public static <T> void ifPresent(T value, Consumer<? super T> action) {
        if (Boolean.TRUE.equals(notNullAndNotEmpty(value)))
            action.accept(value);
    }

    public static <T> void ifPresentOrElse(T value, Consumer<? super T> action, IAction emptyAction) {
        if (Boolean.TRUE.equals(notNullAndNotEmpty(value)))
            action.accept(value);
        else
            emptyAction.run();
    }

    public static <T, X extends Throwable> void ifPresent(T value, Supplier<? extends X> exceptionSupplier)
            throws X {
        if (Boolean.TRUE.equals(notNullAndNotEmpty(value)))
            throw exceptionSupplier.get();
    }

    public static <T, X extends Throwable> void noPresentThrowException
            (T value, Supplier<? extends X> exceptionSupplier)
            throws X {
        if (Boolean.FALSE.equals(notNullAndNotEmpty(value)))
            throw exceptionSupplier.get();
    }


    public static <Y, Z extends Throwable> List<Y> noListPresentThrowException
            (List<Y> list, Supplier<? extends Z> exceptionSupplier)
            throws Z {
        if (list == null || list.isEmpty())
            throw exceptionSupplier.get();

        return list;
    }

    public static <T> void equalTo(T firstValue, T secondValue, IAction emptyAction) {
        if (firstValue.equals(secondValue))
            emptyAction.run();
    }
    public static <T> void notNullAndEqualTo(T noNullValue, T otherValue, IAction emptyAction) {
        if (Boolean.TRUE.equals(noNullValue instanceof String
                && otherValue instanceof String
                && notNullAndNotEmpty(noNullValue)
                && notNullAndNotEmpty(otherValue))
                && Boolean.FALSE.equals(((String) noNullValue).equalsIgnoreCase((String) otherValue))) {
            emptyAction.run();
        }

        if (noNullValue != null && noNullValue.equals(otherValue))
            emptyAction.run();
    }

    public static <T> void bothNotNullAndEqual(T firstValue, T otherValues, IAction emptyAction) {
        if (Boolean.TRUE.equals(
                (notNullAndNotEmpty(firstValue)
                        && notNullAndNotEmpty(otherValues)
                        && firstValue.equals(otherValues))))
            emptyAction.run();
    }


    public static <T> Boolean bothNotNullAndNotEqual(T firstValue, T otherValues) {
        return notNullAndNotEmpty(firstValue) && notNullAndNotEmpty(otherValues) && !firstValue.equals(otherValues);

    }

    public static <T> Boolean notNullAndNotEqual(T firstValue, T otherValues) {
        return notNullAndNotEmpty(firstValue) &&  !firstValue.equals(otherValues);

    }

    public static <T> void notNullAndNull(T noNullValue, T nullValue, IAction emptyAction) {
        if (Boolean.TRUE.equals(notNullAndNotEmpty(noNullValue)) && nullValue == null)
            emptyAction.run();
    }


    public static <T> void nonNullAndNotEqualTo(T noNullValue, T otherValue, IAction emptyAction) {
        if (Boolean.TRUE.equals(noNullValue instanceof String
                && otherValue instanceof String
                && notNullAndNotEmpty(noNullValue)
                && notNullAndNotEmpty(otherValue))
                && Boolean.FALSE.equals(((String) noNullValue).equalsIgnoreCase((String) otherValue))) {
            emptyAction.run();
        }
        if (notNullAndNotEmpty(noNullValue)
                && notNullAndNotEmpty(otherValue)
                && Boolean.FALSE.equals(noNullValue.equals(otherValue))) {
            emptyAction.run();
        }

    }

    public static <T> Boolean notNullAndEqualTo(T noNullValue, T otherValue) {
        return notNullAndNotEmpty(noNullValue) && noNullValue.equals(otherValue);
    }

    public static <T, X extends Throwable> void notEqualThrowException(T firstValue, T secondValue,
                                                                       Supplier<? extends X> exceptionSupplier)
            throws X {
        if (Boolean.FALSE.equals(firstValue.equals(secondValue))) {
            throw exceptionSupplier.get();
        }
    }

    public static void acceptTrue(Boolean value, IAction emptyAction) {
        if (Boolean.TRUE.equals(value))
            emptyAction.run();
    }

    public static void acceptFalse(Boolean value, IAction emptyAction) {
        if (Boolean.FALSE.equals(value))
            emptyAction.run();

    }

    public static <T> T acceptTrue(Boolean value, Supplier<T> supplier, Supplier<T> supplierOther) {
        if (Boolean.TRUE.equals(value))
            return supplier.get();
        else
            return supplierOther.get();
    }

    public static void acceptTrueOrElse(Boolean value, IAction emptyAction, IAction emptyActionElse) {
        if (Boolean.TRUE.equals(value))
            emptyAction.run();
        else
            emptyActionElse.run();
    }

    public static <X extends Throwable> void acceptTrue(Boolean value, Supplier<? extends X> exceptionSupplier)
            throws X {
        if (Boolean.TRUE.equals(value)) {
            throw exceptionSupplier.get();
        }
    }

    public static <X extends Throwable> void acceptTrueOrElseThrow
            (Boolean value, IAction emptyAction, Supplier<? extends X> exceptionSupplier)
            throws X {
        if (Boolean.TRUE.equals(value))
            emptyAction.run();
        else
            throw exceptionSupplier.get();
    }

    @SafeVarargs
    public static <T> Boolean notNull(T... value) {
        return value != null && Arrays.stream(value).allMatch(Objects::nonNull);

    }

    @SafeVarargs
    public static <T> Boolean notNullAny(T... value) {
        return value != null && Arrays.stream(value).anyMatch(Objects::nonNull);

    }

    @SafeVarargs
    public static <T> void notNullAny(IAction emptyAction, T... value) {
        if (Boolean.TRUE.equals(value != null && Arrays.stream(value).anyMatch(Objects::nonNull)))
            emptyAction.run();

    }

    @SafeVarargs
    public static <T> void nonNull(IAction emptyAction, T... value) {
        if (value != null && Arrays.stream(value).allMatch(Objects::nonNull))
            emptyAction.run();
    }

    public static <T> void notNull(T value, IAction emptyAction) {
        if (Boolean.TRUE.equals(notNullAndNotEmpty(value)))
            emptyAction.run();
    }


    public static <T> Boolean notNullAndNotEmptyValue(T value) {
        return notNullAndNotEmpty(value);
    }


    public static <T> Boolean objectPropertiesNotNull(T object, String... properties) {
        var fieldList = Arrays.asList(properties);
        return objectPropertiesNotNull(object, fieldList);
    }

    public static <T> void objectPropertiesNotNull(T object, IAction emptyAction, String... properties) {
        if (Boolean.TRUE.equals(objectPropertiesNotNull(object, properties)))
            emptyAction.run();
    }

    public static <T> void objectPropertiesNotNull(T object, IAction emptyAction,
                                                   IAction otherAction, String... properties) {
        if (Boolean.TRUE.equals(objectPropertiesNotNull(object, properties)))
            emptyAction.run();
        else
            otherAction.run();
    }

    private static <T> Boolean objectPropertiesNotNull(T object, List<String> fieldList) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(currentField -> fieldList.contains(currentField.getName()))
                .allMatch(currentField ->
                        notNullAndNotEmpty(getValue(object.getClass(), currentField.getName(), object)));
    }

    private static <T> Boolean notNullAndNotEmpty(T value) {
        if (value instanceof List)
            return !((List<?>) value).isEmpty();

        if (value instanceof String)
            return !((String) value).isEmpty();

        return value != null;

    }

    private static String capitalizeField(String field) {
        return field.length() == 0 ? field : field.substring(0, 1).toUpperCase() + field.substring(1);
    }


    private static Object getValue(Class<?> clazz, String fieldName, Object data) {
        try {
            Method method = clazz.getMethod("get" + capitalizeField(fieldName));
            return Objects.requireNonNull(method).invoke(data, (Object[]) null);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}