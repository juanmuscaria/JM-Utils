package io.github.juanmuscaria.jmutils.utils;

import com.google.common.annotations.Beta;
import org.jetbrains.annotations.Nullable;
import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A set of functions and classes that can mess up the JVM, use with caution.
 *
 * @author juanmuscaria
 */
@Beta
public final class UnsafeUtils {
    private UnsafeUtils(){

    }

    /**
     * An accessor for theUnsafe.
     */
    public static final Reflection.FieldAccessor<Unsafe> unsafeAccessor = Reflection.getField(Unsafe.class, "theUnsafe", Unsafe.class);


    /**
     * Create an instance of the class without calling any constructors.
     *
     * @param clazz The class to instantiate.
     * @param <T>   Object type.
     * @return A wrapped object. The wrapped object may be null if it is not possible to instantiate the object.
     */
    @SuppressWarnings("unchecked")
    public static <T> WrappedObject<T> createInstance(Class<T> clazz) {
        T object = null;
        try {
            object = (T) unsafeAccessor.get(null).allocateInstance(clazz);
        } catch (InstantiationException ignored) {
        }
        T finalObject = object;
        return () -> finalObject;
    }

    private interface WrappedObject<T> {
        @Nullable
        T get();
    }

    /**
     * A byte array allocated outside of the heap.
     * Use with caution, may cause corruption and memory leak
     */
    public static final class UnsafeByteArray {
        private final long baseAddress;
        private final long size;
        private AtomicBoolean isFinalized = new AtomicBoolean(false);

        /**
         * Creates a new UnsafeByteArray.
         *
         * @param size The size of memory to be allocated by UnsafeByteArray.
         */
        public UnsafeByteArray(long size) {
            this.size = size;
            baseAddress = unsafeAccessor.get(null).allocateMemory(size);
        }

        /**
         * Defines a value in the received index.
         *
         * @param index The index to set the value.
         * @param value The value to set.
         * @throws ArrayIndexOutOfBoundsException If you try to access an out of bounds index.
         * @throws IllegalStateException          If the memory used by the object has been freed.
         */
        public void set(long index, byte value) {
            if (isFinalized.get())
                throw new IllegalStateException("The allocated memory of this object has already been freed.");
            checkBounds(index);
            unsafeAccessor.get(null).putByte(baseAddress + index, value);
        }

        /**
         * Get a value in the received index.
         *
         * @param index The index to get the value.
         * @return The value contained in this index.
         * @throws ArrayIndexOutOfBoundsException If you try to access an out of bounds index.
         * @throws IllegalStateException          If the memory used by the object has been freed.
         */
        public byte get(long index) {
            if (isFinalized.get())
                throw new IllegalStateException("The allocated memory of this object has already been freed.");
            checkBounds(index);
            return unsafeAccessor.get(null).getByte(baseAddress + index);
        }

        public long size() {
            return size;
        }


        /**
         * Free memory allocated by this object.
         * Must be called when this object is no longer used.
         */
        public void freeMemory() {
            if (!isFinalized.get()) {
                unsafeAccessor.get(null).freeMemory(baseAddress);
                isFinalized.set(true);
            }
        }

        public long getAddress(){
            return baseAddress;
        }
        private void checkBounds(long index) {
            if (index < 0 || index > (size - 1)) throw new ArrayIndexOutOfBoundsException("index " + index);
        }

        @Override
        protected void finalize() {
            if (!isFinalized.get()) {
                freeMemory();
            }
        }
    }
}
