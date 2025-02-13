package io.sui.bcsgen;


public final class BLS12381Signature {
    public final java.util.@com.novi.serde.ArrayLen(length=48) List<@com.novi.serde.Unsigned Byte> sig;

    public BLS12381Signature(java.util.@com.novi.serde.ArrayLen(length=48) List<@com.novi.serde.Unsigned Byte> sig) {
        java.util.Objects.requireNonNull(sig, "sig must not be null");
        this.sig = sig;
    }

    public void serialize(com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        serializer.increase_container_depth();
        TraitHelpers.serialize_array48_u8_array(sig, serializer);
        serializer.decrease_container_depth();
    }

    public byte[] bcsSerialize() throws com.novi.serde.SerializationError {
        com.novi.serde.Serializer serializer = new com.novi.bcs.BcsSerializer();
        serialize(serializer);
        return serializer.get_bytes();
    }

    public static BLS12381Signature deserialize(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        deserializer.increase_container_depth();
        Builder builder = new Builder();
        builder.sig = TraitHelpers.deserialize_array48_u8_array(deserializer);
        deserializer.decrease_container_depth();
        return builder.build();
    }

    public static BLS12381Signature bcsDeserialize(byte[] input) throws com.novi.serde.DeserializationError {
        if (input == null) {
             throw new com.novi.serde.DeserializationError("Cannot deserialize null array");
        }
        com.novi.serde.Deserializer deserializer = new com.novi.bcs.BcsDeserializer(input);
        BLS12381Signature value = deserialize(deserializer);
        if (deserializer.get_buffer_offset() < input.length) {
             throw new com.novi.serde.DeserializationError("Some input bytes were not read");
        }
        return value;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        BLS12381Signature other = (BLS12381Signature) obj;
        if (!java.util.Objects.equals(this.sig, other.sig)) { return false; }
        return true;
    }

    public int hashCode() {
        int value = 7;
        value = 31 * value + (this.sig != null ? this.sig.hashCode() : 0);
        return value;
    }

    public static final class Builder {
        public java.util.@com.novi.serde.ArrayLen(length=48) List<@com.novi.serde.Unsigned Byte> sig;

        public BLS12381Signature build() {
            return new BLS12381Signature(
                sig
            );
        }
    }
}
