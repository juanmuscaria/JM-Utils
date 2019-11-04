package io.github.juanmuscaria.jmutils.utils;

import java.io.*;
import java.util.Arrays;
import java.util.Base64;

/**
 * Several simple functions you can find on Google.
 *
 * @author juanmuscaria
 */
public final class Utils {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    private Utils() {
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String objectToString(Serializable object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
    }

    public static Object stringToObject(String string) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(string);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
        Object readObject = objectInputStream.readObject();
        objectInputStream.close();
        return readObject;
    }

    public static String[] getNamesFromEnum(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    public static boolean parseBoolean(Object object){
        if (object == null)return false;
        if (object instanceof Boolean)return (boolean) object;
        if (object instanceof String)return Boolean.parseBoolean((String) object);
        try {
            int value = (int) object;
            return value == 1;
        } catch (ClassCastException e){
            return false;
        }
    }
}
