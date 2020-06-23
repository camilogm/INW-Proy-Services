/*
 * package com.inw.proy.utils;
 * 
 * import java.lang.reflect.Constructor; import java.lang.reflect.Field; import
 * java.lang.reflect.InvocationTargetException; import java.lang.reflect.Method;
 * 
 * public class Cloneable {
 * 
 * 
 * 
 * public Object execute(Class<? extends Object> classObject , Object
 * childObject) {
 * 
 * Object newObject = this.createNewInstance(classObject); return
 * this.cloneProperties(newObject, childObject,classObject); }
 * 
 * private Object createNewInstance(Class<? extends Object> classObject ) {
 * 
 * Constructor<?>[] constructors = classObject.getConstructors(); for
 * (Constructor<?> constructor : constructors) {
 * 
 * if (constructor.getParameterTypes().length==0) { try { Object newInstance =
 * constructor.newInstance(); return newInstance; } catch
 * (InstantiationException | IllegalAccessException | IllegalArgumentException |
 * InvocationTargetException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * break; } } return null; }
 * 
 * private Object cloneProperties(Object newObject, Object cloneableObject ,
 * Class<? extends Object> classObject ) {
 * 
 * Field[] fields = classObject.getDeclaredFields();
 * 
 * for (Field field: fields) {
 * 
 * String fieldName = field.getName();
 * 
 * String property = fieldName.substring(0,1).toUpperCase();
 * property+=fieldName.substring(1,fieldName.length());
 * 
 * 
 * String getterName = "get" + property; String setterName = "set" + property;
 * 
 * 
 * try { Method getterMethod = classObject.getMethod(getterName);
 * System.out.println(field.getClass()); Method setterMethod =
 * classObject.getMethod(setterName, field.getClass());
 * 
 * } catch (NoSuchMethodException | SecurityException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * 
 * }
 * 
 * return newObject; }
 * 
 * }
 */