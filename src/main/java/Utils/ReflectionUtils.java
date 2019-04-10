package Utils;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Internal class for reflection utilities.
 */
public class ReflectionUtils {


//    public static List<PropertyManager> findProperties(Object instance, Class clazz) {
//        if (clazz.isPrimitive())
//            return new ArrayList<>();
//
//        List<PropertyManager> properties = new ArrayList<>();
//        for (Field field : getAllFields(clazz)) {
//            if (!Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
//                properties.add(new PropertyManager(instance, field));
//            }
//        }
//        return properties;
//    }

    public static List<Field> getAllFields(Class clazz) {
        List<Field> fields = new ArrayList<>();
        Collections.addAll(fields, clazz.getDeclaredFields());
        Collections.addAll(fields, clazz.getFields());
        return fields;
    }

    public static List<Method> getAllMethods(Class clazz) {
        List<Method> methods = new ArrayList<>();
        Collections.addAll(methods, clazz.getDeclaredMethods());
        Collections.addAll(methods, clazz.getMethods());
        return methods;
    }

//    public static <T> T createInstance(Class<T> clazz) {
//        if (int.class.equals(clazz) || Integer.class.equals(clazz)) {
//            return (T) (Integer) 0;
//        } else if (long.class.equals(clazz) || Long.class.equals(clazz)) {
//            return (T) (Long) 0L;
//        } else if (double.class.equals(clazz) || Double.class.equals(clazz)) {
//            return (T) (Double) 0D;
//        } else if (void.class.equals(clazz) || Void.class.equals(clazz)) {
//            return null;
//        } else if (float.class.equals(clazz) || Float.class.equals(clazz)) {
//            return (T) (Float) 0F;
//        } else if (byte.class.equals(clazz) || Byte.class.equals(clazz)) {
//            return (T) (Byte) (byte) 0;
//        } else if (char.class.equals(clazz) || Character.class.equals(clazz)) {
//            return (T) (Character) (char) 0;
//        } else if (boolean.class.equals(clazz) || Boolean.class.equals(clazz)) {
//            return (T) (Boolean) false;
//        } else if (short.class.equals(clazz) || Short.class.equals(clazz)) {
//            return (T) (Short) (short) 0;
//        }
//
//        if (clazz.isArray()) {
//            return (T) Array.newInstance(clazz.getComponentType(), 0);
//        }
//
//        if (UNSAFE != null) { //Unsafe available, use it to instantiate the class
//            try {
//                return (T) ((sun.misc.Unsafe) UNSAFE).allocateInstance(clazz);
//            } catch (InstantiationException e) {
//            }
//        }
//
//        //Fallback to reflection
//        try {
//            return clazz.getConstructor().newInstance();
//        } catch (Exception e) {
//            throw new ETFException(e);
//        }
//    }

    public static void setField(Field field, Object instance, Object value) throws IllegalAccessException {
        if (value == null && field.getType().isPrimitive()) {
            return;
        }
        try {
            field.setAccessible(true);
            if (Integer.class.equals(field.getType())) {
                field.set(instance, (Integer.valueOf(String.valueOf(value))));
            } else if (Long.class.equals(field.getType())) {
                field.setLong(instance, (Long.valueOf(String.valueOf(value))));
            } else if (Double.class.equals(field.getType())) {
                field.setDouble(instance, (Double.valueOf(String.valueOf(value))));
            } else if (Float.class.equals(field.getType())) {
                field.setFloat(instance, (Float.valueOf(String.valueOf(value))));
            } else if (Byte.class.equals(field.getType())) {
                field.setByte(instance, (Byte.valueOf(String.valueOf(value))));
            } else if (Boolean.class.equals(field.getType())) {
                field.set(instance, (Boolean.valueOf(String.valueOf(value))));
            } else if (Short.class.equals(field.getType())) {
                field.setShort(instance, (Short.valueOf(String.valueOf(value))));
            } else {
                field.set(instance, value);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    public static Object getField(Object instance, Field field) throws IllegalAccessException {

        field.setAccessible(true);
        if (int.class.equals(field.getType())) {
            return field.getInt(instance);
        } else if (long.class.equals(field.getType())) {
            return field.getLong(instance);
        } else if (double.class.equals(field.getType())) {
            return field.getDouble(instance);
        } else if (void.class.equals(field.getType())) {
            return null;
        } else if (float.class.equals(field.getType())) {
            return field.getFloat(instance);
        } else if (byte.class.equals(field.getType())) {
            return field.getByte(instance);
        } else if (char.class.equals(field.getType())) {
            return field.getChar(instance);
        } else if (boolean.class.equals(field.getType())) {
            return field.getBoolean(instance);
        } else if (short.class.equals(field.getType())) {
            return field.getShort(instance);
        } else {
            return field.get(instance);
        }
    }

    public static ArrayList<String> getAllFieldsStringValue(Object instance) {

        List<Field> fields = ReflectionUtils.getAllFields(instance.getClass());
        ArrayList<String> value = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
        }

        for (Field field : fields) {
            try {
                if (int.class.equals(field.getType())) {
                    value.add(String.valueOf(field.getInt(instance)));

                } else if (long.class.equals(field.getType())) {
                    value.add(String.valueOf(field.getLong(instance)));

                } else if (double.class.equals(field.getType())) {
                    value.add(String.valueOf(field.getDouble(instance)));

                } else if (float.class.equals(field.getType())) {
                    value.add(String.valueOf(field.getFloat(instance)));

                } else if (byte.class.equals(field.getType())) {
                    value.add(String.valueOf(field.getByte(instance)));

                } else if (boolean.class.equals(field.getType())) {
                    value.add(Boolean.toString(field.getBoolean(instance)));

                } else if (short.class.equals(field.getType())) {
                    value.add(String.valueOf(field.getShort(instance)));

                } else {
                    value.add(String.valueOf(field));
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return value;
    }


//    public static Object setAllFields(Object instance, Field field) throws IllegalAccessException {
//
//        field.setAccessible(true);
//        if (int.class.equals(field.getType())) {
//            return field.getInt(instance);
//        } else if (long.class.equals(field.getType())) {
//            return field.getLong(instance);
//        } else if (double.class.equals(field.getType())) {
//            return field.getDouble(instance);
//        } else if (void.class.equals(field.getType())) {
//            return null;
//        } else if (float.class.equals(field.getType())) {
//            return field.getFloat(instance);
//        } else if (byte.class.equals(field.getType())) {
//            return field.getByte(instance);
//        } else if (char.class.equals(field.getType())) {
//            return field.getChar(instance);
//        } else if (boolean.class.equals(field.getType())) {
//            return field.getBoolean(instance);
//        } else if (short.class.equals(field.getType())) {
//            return field.getShort(instance);
//        } else {
//            return field.get(instance);
//        }
//    }


//    public interface IPropertyAccessor {
//
//        Object get();
//
//        Class<?> getType();
//    }
//
//    public interface IPropertyMutator {
//
//        void set(Object o);
//
//        Class<?> getType();
//    }
//
//    public static class FieldAccessorAndMutator implements IPropertyAccessor, IPropertyMutator {
//
//        private final Object object;
//        private final Field field;
//
//        public FieldAccessorAndMutator(Object object, Field field) {
//            this.object = object;
//            this.field = field;
//            this.field.setAccessible(true);
//        }
//
//        @Override
//        public Object get() {
//            try {
//                return getField(object, field);
//            } catch (Throwable e) {
//                throw new ETFException("Cannot access " + field.toGenericString(), e);
//            }
//        }
//
//        @Override
//        public void set(Object o) {
//            try {
//                setField(object, field, o);
//            } catch (Throwable e) {
//                throw new ETFException("Cannot modify " + field.toGenericString(), e);
//            }
//        }
//
//        @Override
//        public Class<?> getType() {
//            return field.getType();
//        }
//    }
//
//    public static class MethodAccessorAndMutator implements IPropertyAccessor, IPropertyMutator {
//
//        private final Object object;
//        private final Method method;
//
//        public MethodAccessorAndMutator(Object object, Method method) {
//            this.object = object;
//            this.method = method;
//            this.method.setAccessible(true);
//        }
//
//        @Override
//        public Object get() {
//            try {
//                return method.invoke(object);
//            } catch (Exception e) {
//                throw new ETFException("Cannot invoke " + method.toGenericString(), e);
//            }
//        }
//
//        @Override
//        public void set(Object o) {
//            try {
//                method.invoke(object, o);
//            } catch (Exception e) {
//                throw new ETFException("Cannot invoke " + method.toGenericString(), e);
//            }
//        }
//
//        @Override
//        public Class<?> getType() {
//            return method.getParameterCount() == 0 ? method.getReturnType() : method.getParameterTypes()[0];
//        }
//    }
//
//    public static class NOPAccessorAndMutator implements IPropertyAccessor, IPropertyMutator {
//
//        public static final NOPAccessorAndMutator INSTANCE = new NOPAccessorAndMutator();
//
//        @Override
//        public Object get() {
//            return null;
//        }
//
//        @Override
//        public void set(Object o) {
//        }
//
//        @Override
//        public Class<?> getType() {
//            return Void.class;
//        }
//    }
//
//    public static class PropertyManager {
//
//        private final Object instance;
//        private final IPropertyMutator mutator;
//        private final IPropertyAccessor accessor;
//        private final String name;
//
//        private static String capitalize(String s) {
//            return s.substring(0, 1).toUpperCase() + (s.length() > 1 ? s.substring(1) : "");
//        }
//
//        public PropertyManager(Object instance, Field field) {
//            this.instance = instance;
//            field.setAccessible(true);
//            IPropertyAccessor accessor = null;
//            boolean isFinal = Modifier.isFinal(field.getModifiers());
//            IPropertyMutator mutator = isFinal ? NOPAccessorAndMutator.INSTANCE : null;
//            for (Method m : getAllMethods(instance.getClass())) {
//                if (mutator != null && accessor != null)
//                    break;
//
//                m.setAccessible(true);
//
//                if (m.getName().equals(String.format("get%s", capitalize(field.getName())))) {
//                    accessor = new MethodAccessorAndMutator(instance, m);
//                    continue;
//                } else if (!isFinal
//                        && m.getName().equals(String.format("set%s", capitalize(field.getName())))
//                        && m.getParameterCount() == 1 && m.getParameterTypes()[0].equals(field.getType())) {
//                    mutator = new MethodAccessorAndMutator(instance, m);
//                    continue;
//                } else if (m.getDeclaredAnnotation(GetterMethod.class) != null) {
//                    if (m.getDeclaredAnnotation(GetterMethod.class).value().equals(field.getName())) {
//                        accessor = new MethodAccessorAndMutator(instance, m);
//                        continue;
//                    }
//                } else if (!isFinal && m.getDeclaredAnnotation(SetterMethod.class) != null
//                        && m.getParameterCount() == 1) {
//                    if (m.getDeclaredAnnotation(SetterMethod.class).value().equals(field.getName())) {
//                        mutator = new MethodAccessorAndMutator(instance, m);
//                        continue;
//                    }
//                }
//            }
//
//            if (accessor == null)
//                accessor = new FieldAccessorAndMutator(instance, field);
//
//            if (mutator == null)
//                mutator = new FieldAccessorAndMutator(instance, field);
//
//            this.accessor = accessor;
//            this.mutator = mutator;
//
//            this.name = field.getName();
//        }
//
//        public void setValue(Object value) {
//            mutator.set(value);
//        }
//
//        public Object getValue() {
//            return accessor.get();
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public Class<?> getSetterType() {
//            return mutator.getType();
//        }
//
//        public Class<?> getGetterType() {
//            return accessor.getType();
//        }
//    }


    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }
}
