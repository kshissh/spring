/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.notification.schema;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SubscriptionAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7496567419049239003L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Subscription\",\"namespace\":\"com.example.notification.schema\",\"fields\":[{\"name\":\"subscriptionId\",\"type\":\"string\"},{\"name\":\"createdAt\",\"type\":\"string\"},{\"name\":\"expiresAt\",\"type\":\"string\"},{\"name\":\"status\",\"type\":\"string\"},{\"name\":\"family\",\"type\":\"string\"},{\"name\":\"transport\",\"type\":{\"type\":\"record\",\"name\":\"Transport\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"endpoint\",\"type\":\"string\"}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SubscriptionAvro> ENCODER =
      new BinaryMessageEncoder<SubscriptionAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SubscriptionAvro> DECODER =
      new BinaryMessageDecoder<SubscriptionAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<SubscriptionAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<SubscriptionAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SubscriptionAvro>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Subscription to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Subscription from a ByteBuffer. */
  public static SubscriptionAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence subscriptionId;
  @Deprecated public java.lang.CharSequence createdAt;
  @Deprecated public java.lang.CharSequence expiresAt;
  @Deprecated public java.lang.CharSequence status;
  @Deprecated public java.lang.CharSequence family;
  @Deprecated public TransportAvro transport;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SubscriptionAvro() {}

  /**
   * All-args constructor.
   * @param subscriptionId The new value for subscriptionId
   * @param createdAt The new value for createdAt
   * @param expiresAt The new value for expiresAt
   * @param status The new value for status
   * @param family The new value for family
   * @param transport The new value for transport
   */
  public SubscriptionAvro(java.lang.CharSequence subscriptionId, java.lang.CharSequence createdAt, java.lang.CharSequence expiresAt, java.lang.CharSequence status, java.lang.CharSequence family, TransportAvro transport) {
    this.subscriptionId = subscriptionId;
    this.createdAt = createdAt;
    this.expiresAt = expiresAt;
    this.status = status;
    this.family = family;
    this.transport = transport;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return subscriptionId;
    case 1: return createdAt;
    case 2: return expiresAt;
    case 3: return status;
    case 4: return family;
    case 5: return transport;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: subscriptionId = (java.lang.CharSequence)value$; break;
    case 1: createdAt = (java.lang.CharSequence)value$; break;
    case 2: expiresAt = (java.lang.CharSequence)value$; break;
    case 3: status = (java.lang.CharSequence)value$; break;
    case 4: family = (java.lang.CharSequence)value$; break;
    case 5: transport = (TransportAvro)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'subscriptionId' field.
   * @return The value of the 'subscriptionId' field.
   */
  public java.lang.CharSequence getSubscriptionId() {
    return subscriptionId;
  }

  /**
   * Sets the value of the 'subscriptionId' field.
   * @param value the value to set.
   */
  public void setSubscriptionId(java.lang.CharSequence value) {
    this.subscriptionId = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   * @return The value of the 'createdAt' field.
   */
  public java.lang.CharSequence getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.lang.CharSequence value) {
    this.createdAt = value;
  }

  /**
   * Gets the value of the 'expiresAt' field.
   * @return The value of the 'expiresAt' field.
   */
  public java.lang.CharSequence getExpiresAt() {
    return expiresAt;
  }

  /**
   * Sets the value of the 'expiresAt' field.
   * @param value the value to set.
   */
  public void setExpiresAt(java.lang.CharSequence value) {
    this.expiresAt = value;
  }

  /**
   * Gets the value of the 'status' field.
   * @return The value of the 'status' field.
   */
  public java.lang.CharSequence getStatus() {
    return status;
  }

  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(java.lang.CharSequence value) {
    this.status = value;
  }

  /**
   * Gets the value of the 'family' field.
   * @return The value of the 'family' field.
   */
  public java.lang.CharSequence getFamily() {
    return family;
  }

  /**
   * Sets the value of the 'family' field.
   * @param value the value to set.
   */
  public void setFamily(java.lang.CharSequence value) {
    this.family = value;
  }

  /**
   * Gets the value of the 'transport' field.
   * @return The value of the 'transport' field.
   */
  public TransportAvro getTransport() {
    return transport;
  }

  /**
   * Sets the value of the 'transport' field.
   * @param value the value to set.
   */
  public void setTransport(TransportAvro value) {
    this.transport = value;
  }

  /**
   * Creates a new Subscription RecordBuilder.
   * @return A new Subscription RecordBuilder
   */
  public static SubscriptionAvro.Builder newBuilder() {
    return new SubscriptionAvro.Builder();
  }

  /**
   * Creates a new Subscription RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Subscription RecordBuilder
   */
  public static SubscriptionAvro.Builder newBuilder(SubscriptionAvro.Builder other) {
    return new SubscriptionAvro.Builder(other);
  }

  /**
   * Creates a new Subscription RecordBuilder by copying an existing Subscription instance.
   * @param other The existing instance to copy.
   * @return A new Subscription RecordBuilder
   */
  public static SubscriptionAvro.Builder newBuilder(SubscriptionAvro other) {
    return new SubscriptionAvro.Builder(other);
  }

  /**
   * RecordBuilder for Subscription instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SubscriptionAvro>
    implements org.apache.avro.data.RecordBuilder<SubscriptionAvro> {

    private java.lang.CharSequence subscriptionId;
    private java.lang.CharSequence createdAt;
    private java.lang.CharSequence expiresAt;
    private java.lang.CharSequence status;
    private java.lang.CharSequence family;
    private TransportAvro transport;
    private TransportAvro.Builder transportBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(SubscriptionAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.subscriptionId)) {
        this.subscriptionId = data().deepCopy(fields()[0].schema(), other.subscriptionId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[1].schema(), other.createdAt);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.expiresAt)) {
        this.expiresAt = data().deepCopy(fields()[2].schema(), other.expiresAt);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.family)) {
        this.family = data().deepCopy(fields()[4].schema(), other.family);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.transport)) {
        this.transport = data().deepCopy(fields()[5].schema(), other.transport);
        fieldSetFlags()[5] = true;
      }
      if (other.hasTransportBuilder()) {
        this.transportBuilder = TransportAvro.newBuilder(other.getTransportBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing Subscription instance
     * @param other The existing instance to copy.
     */
    private Builder(SubscriptionAvro other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.subscriptionId)) {
        this.subscriptionId = data().deepCopy(fields()[0].schema(), other.subscriptionId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[1].schema(), other.createdAt);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.expiresAt)) {
        this.expiresAt = data().deepCopy(fields()[2].schema(), other.expiresAt);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.family)) {
        this.family = data().deepCopy(fields()[4].schema(), other.family);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.transport)) {
        this.transport = data().deepCopy(fields()[5].schema(), other.transport);
        fieldSetFlags()[5] = true;
      }
      this.transportBuilder = null;
    }

    /**
      * Gets the value of the 'subscriptionId' field.
      * @return The value.
      */
    public java.lang.CharSequence getSubscriptionId() {
      return subscriptionId;
    }

    /**
      * Sets the value of the 'subscriptionId' field.
      * @param value The value of 'subscriptionId'.
      * @return This builder.
      */
    public SubscriptionAvro.Builder setSubscriptionId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.subscriptionId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'subscriptionId' field has been set.
      * @return True if the 'subscriptionId' field has been set, false otherwise.
      */
    public boolean hasSubscriptionId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'subscriptionId' field.
      * @return This builder.
      */
    public SubscriptionAvro.Builder clearSubscriptionId() {
      subscriptionId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdAt' field.
      * @return The value.
      */
    public java.lang.CharSequence getCreatedAt() {
      return createdAt;
    }

    /**
      * Sets the value of the 'createdAt' field.
      * @param value The value of 'createdAt'.
      * @return This builder.
      */
    public SubscriptionAvro.Builder setCreatedAt(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.createdAt = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public SubscriptionAvro.Builder clearCreatedAt() {
      createdAt = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'expiresAt' field.
      * @return The value.
      */
    public java.lang.CharSequence getExpiresAt() {
      return expiresAt;
    }

    /**
      * Sets the value of the 'expiresAt' field.
      * @param value The value of 'expiresAt'.
      * @return This builder.
      */
    public SubscriptionAvro.Builder setExpiresAt(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.expiresAt = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'expiresAt' field has been set.
      * @return True if the 'expiresAt' field has been set, false otherwise.
      */
    public boolean hasExpiresAt() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'expiresAt' field.
      * @return This builder.
      */
    public SubscriptionAvro.Builder clearExpiresAt() {
      expiresAt = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * @return The value.
      */
    public java.lang.CharSequence getStatus() {
      return status;
    }

    /**
      * Sets the value of the 'status' field.
      * @param value The value of 'status'.
      * @return This builder.
      */
    public SubscriptionAvro.Builder setStatus(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.status = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'status' field has been set.
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'status' field.
      * @return This builder.
      */
    public SubscriptionAvro.Builder clearStatus() {
      status = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'family' field.
      * @return The value.
      */
    public java.lang.CharSequence getFamily() {
      return family;
    }

    /**
      * Sets the value of the 'family' field.
      * @param value The value of 'family'.
      * @return This builder.
      */
    public SubscriptionAvro.Builder setFamily(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.family = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'family' field has been set.
      * @return True if the 'family' field has been set, false otherwise.
      */
    public boolean hasFamily() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'family' field.
      * @return This builder.
      */
    public SubscriptionAvro.Builder clearFamily() {
      family = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'transport' field.
      * @return The value.
      */
    public TransportAvro getTransport() {
      return transport;
    }

    /**
      * Sets the value of the 'transport' field.
      * @param value The value of 'transport'.
      * @return This builder.
      */
    public SubscriptionAvro.Builder setTransport(TransportAvro value) {
      validate(fields()[5], value);
      this.transportBuilder = null;
      this.transport = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'transport' field has been set.
      * @return True if the 'transport' field has been set, false otherwise.
      */
    public boolean hasTransport() {
      return fieldSetFlags()[5];
    }

    /**
     * Gets the Builder instance for the 'transport' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public TransportAvro.Builder getTransportBuilder() {
      if (transportBuilder == null) {
        if (hasTransport()) {
          setTransportBuilder(TransportAvro.newBuilder(transport));
        } else {
          setTransportBuilder(TransportAvro.newBuilder());
        }
      }
      return transportBuilder;
    }

    /**
     * Sets the Builder instance for the 'transport' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public SubscriptionAvro.Builder setTransportBuilder(TransportAvro.Builder value) {
      clearTransport();
      transportBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'transport' field has an active Builder instance
     * @return True if the 'transport' field has an active Builder instance
     */
    public boolean hasTransportBuilder() {
      return transportBuilder != null;
    }

    /**
      * Clears the value of the 'transport' field.
      * @return This builder.
      */
    public SubscriptionAvro.Builder clearTransport() {
      transport = null;
      transportBuilder = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SubscriptionAvro build() {
      try {
        SubscriptionAvro record = new SubscriptionAvro();
        record.subscriptionId = fieldSetFlags()[0] ? this.subscriptionId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.createdAt = fieldSetFlags()[1] ? this.createdAt : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.expiresAt = fieldSetFlags()[2] ? this.expiresAt : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.status = fieldSetFlags()[3] ? this.status : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.family = fieldSetFlags()[4] ? this.family : (java.lang.CharSequence) defaultValue(fields()[4]);
        if (transportBuilder != null) {
          record.transport = this.transportBuilder.build();
        } else {
          record.transport = fieldSetFlags()[5] ? this.transport : (TransportAvro) defaultValue(fields()[5]);
        }
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SubscriptionAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<SubscriptionAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SubscriptionAvro>
    READER$ = (org.apache.avro.io.DatumReader<SubscriptionAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}