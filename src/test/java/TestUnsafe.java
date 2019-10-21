import io.github.juanmuscaria.jmutils.utils.UnsafeUtils;
import org.junit.Test;

public class TestUnsafe {
    @Test
    public void testUnsafeArray(){
        UnsafeUtils.UnsafeByteArray unsafeByteArray = new UnsafeUtils.UnsafeByteArray(10);
        for (int i = 0; i < unsafeByteArray.size(); i++) {
            System.out.println("Read " + String.format("%02x",unsafeByteArray.get(i)) + " from " + Long.toHexString(unsafeByteArray.getAddress() + i));
        }
        for (int i = 0; i < unsafeByteArray.size(); i++) {
            System.out.println("Write " + String.format("%02x",(byte)-1) + " on " + Long.toHexString(unsafeByteArray.getAddress() + i));
            unsafeByteArray.set(i,(byte)-1);
        }
        for (int i = 0; i < unsafeByteArray.size(); i++) {
            System.out.println("Read " + String.format("%02x",unsafeByteArray.get(i)) + " from " + Long.toHexString(unsafeByteArray.getAddress() + i));
        }
        try {
            unsafeByteArray.set(-1,Byte.MAX_VALUE);
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        try {
            unsafeByteArray.set(unsafeByteArray.size(),Byte.MAX_VALUE);
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        unsafeByteArray.freeMemory();
        try {
            unsafeByteArray.set(1,Byte.MAX_VALUE);
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
    }
}
