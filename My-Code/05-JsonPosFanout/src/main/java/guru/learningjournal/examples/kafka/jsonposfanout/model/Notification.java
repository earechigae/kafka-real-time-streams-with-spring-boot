/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package guru.learningjournal.examples.kafka.jsonposfanout.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Notification extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6239250390735853710L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Notification\",\"namespace\":\"guru.learningjournal.examples.kafka.jsonposfanout.model\",\"fields\":[{\"name\":\"InvoiceNumber\",\"type\":[\"null\",\"string\"]},{\"name\":\"CustomerCardNo\",\"type\":[\"null\",\"double\"]},{\"name\":\"TotalAmount\",\"type\":[\"null\",\"double\"]},{\"name\":\"EarnedLoyaltyPoints\",\"type\":[\"null\",\"double\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Notification> ENCODER =
      new BinaryMessageEncoder<Notification>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Notification> DECODER =
      new BinaryMessageDecoder<Notification>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Notification> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Notification> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Notification>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Notification to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Notification from a ByteBuffer. */
  public static Notification fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence InvoiceNumber;
  @Deprecated public java.lang.Double CustomerCardNo;
  @Deprecated public java.lang.Double TotalAmount;
  @Deprecated public java.lang.Double EarnedLoyaltyPoints;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Notification() {}

  /**
   * All-args constructor.
   * @param InvoiceNumber The new value for InvoiceNumber
   * @param CustomerCardNo The new value for CustomerCardNo
   * @param TotalAmount The new value for TotalAmount
   * @param EarnedLoyaltyPoints The new value for EarnedLoyaltyPoints
   */
  public Notification(java.lang.CharSequence InvoiceNumber, java.lang.Double CustomerCardNo, java.lang.Double TotalAmount, java.lang.Double EarnedLoyaltyPoints) {
    this.InvoiceNumber = InvoiceNumber;
    this.CustomerCardNo = CustomerCardNo;
    this.TotalAmount = TotalAmount;
    this.EarnedLoyaltyPoints = EarnedLoyaltyPoints;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return InvoiceNumber;
    case 1: return CustomerCardNo;
    case 2: return TotalAmount;
    case 3: return EarnedLoyaltyPoints;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: InvoiceNumber = (java.lang.CharSequence)value$; break;
    case 1: CustomerCardNo = (java.lang.Double)value$; break;
    case 2: TotalAmount = (java.lang.Double)value$; break;
    case 3: EarnedLoyaltyPoints = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'InvoiceNumber' field.
   * @return The value of the 'InvoiceNumber' field.
   */
  public java.lang.CharSequence getInvoiceNumber() {
    return InvoiceNumber;
  }

  /**
   * Sets the value of the 'InvoiceNumber' field.
   * @param value the value to set.
   */
  public void setInvoiceNumber(java.lang.CharSequence value) {
    this.InvoiceNumber = value;
  }

  /**
   * Gets the value of the 'CustomerCardNo' field.
   * @return The value of the 'CustomerCardNo' field.
   */
  public java.lang.Double getCustomerCardNo() {
    return CustomerCardNo;
  }

  /**
   * Sets the value of the 'CustomerCardNo' field.
   * @param value the value to set.
   */
  public void setCustomerCardNo(java.lang.Double value) {
    this.CustomerCardNo = value;
  }

  /**
   * Gets the value of the 'TotalAmount' field.
   * @return The value of the 'TotalAmount' field.
   */
  public java.lang.Double getTotalAmount() {
    return TotalAmount;
  }

  /**
   * Sets the value of the 'TotalAmount' field.
   * @param value the value to set.
   */
  public void setTotalAmount(java.lang.Double value) {
    this.TotalAmount = value;
  }

  /**
   * Gets the value of the 'EarnedLoyaltyPoints' field.
   * @return The value of the 'EarnedLoyaltyPoints' field.
   */
  public java.lang.Double getEarnedLoyaltyPoints() {
    return EarnedLoyaltyPoints;
  }

  /**
   * Sets the value of the 'EarnedLoyaltyPoints' field.
   * @param value the value to set.
   */
  public void setEarnedLoyaltyPoints(java.lang.Double value) {
    this.EarnedLoyaltyPoints = value;
  }

  /**
   * Creates a new Notification RecordBuilder.
   * @return A new Notification RecordBuilder
   */
  public static guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder newBuilder() {
    return new guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder();
  }

  /**
   * Creates a new Notification RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Notification RecordBuilder
   */
  public static guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder newBuilder(guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder other) {
    return new guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder(other);
  }

  /**
   * Creates a new Notification RecordBuilder by copying an existing Notification instance.
   * @param other The existing instance to copy.
   * @return A new Notification RecordBuilder
   */
  public static guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder newBuilder(guru.learningjournal.examples.kafka.jsonposfanout.model.Notification other) {
    return new guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder(other);
  }

  /**
   * RecordBuilder for Notification instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Notification>
    implements org.apache.avro.data.RecordBuilder<Notification> {

    private java.lang.CharSequence InvoiceNumber;
    private java.lang.Double CustomerCardNo;
    private java.lang.Double TotalAmount;
    private java.lang.Double EarnedLoyaltyPoints;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.InvoiceNumber)) {
        this.InvoiceNumber = data().deepCopy(fields()[0].schema(), other.InvoiceNumber);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.CustomerCardNo)) {
        this.CustomerCardNo = data().deepCopy(fields()[1].schema(), other.CustomerCardNo);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.TotalAmount)) {
        this.TotalAmount = data().deepCopy(fields()[2].schema(), other.TotalAmount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.EarnedLoyaltyPoints)) {
        this.EarnedLoyaltyPoints = data().deepCopy(fields()[3].schema(), other.EarnedLoyaltyPoints);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Notification instance
     * @param other The existing instance to copy.
     */
    private Builder(guru.learningjournal.examples.kafka.jsonposfanout.model.Notification other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.InvoiceNumber)) {
        this.InvoiceNumber = data().deepCopy(fields()[0].schema(), other.InvoiceNumber);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.CustomerCardNo)) {
        this.CustomerCardNo = data().deepCopy(fields()[1].schema(), other.CustomerCardNo);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.TotalAmount)) {
        this.TotalAmount = data().deepCopy(fields()[2].schema(), other.TotalAmount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.EarnedLoyaltyPoints)) {
        this.EarnedLoyaltyPoints = data().deepCopy(fields()[3].schema(), other.EarnedLoyaltyPoints);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'InvoiceNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getInvoiceNumber() {
      return InvoiceNumber;
    }

    /**
      * Sets the value of the 'InvoiceNumber' field.
      * @param value The value of 'InvoiceNumber'.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder setInvoiceNumber(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.InvoiceNumber = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'InvoiceNumber' field has been set.
      * @return True if the 'InvoiceNumber' field has been set, false otherwise.
      */
    public boolean hasInvoiceNumber() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'InvoiceNumber' field.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder clearInvoiceNumber() {
      InvoiceNumber = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'CustomerCardNo' field.
      * @return The value.
      */
    public java.lang.Double getCustomerCardNo() {
      return CustomerCardNo;
    }

    /**
      * Sets the value of the 'CustomerCardNo' field.
      * @param value The value of 'CustomerCardNo'.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder setCustomerCardNo(java.lang.Double value) {
      validate(fields()[1], value);
      this.CustomerCardNo = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'CustomerCardNo' field has been set.
      * @return True if the 'CustomerCardNo' field has been set, false otherwise.
      */
    public boolean hasCustomerCardNo() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'CustomerCardNo' field.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder clearCustomerCardNo() {
      CustomerCardNo = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'TotalAmount' field.
      * @return The value.
      */
    public java.lang.Double getTotalAmount() {
      return TotalAmount;
    }

    /**
      * Sets the value of the 'TotalAmount' field.
      * @param value The value of 'TotalAmount'.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder setTotalAmount(java.lang.Double value) {
      validate(fields()[2], value);
      this.TotalAmount = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'TotalAmount' field has been set.
      * @return True if the 'TotalAmount' field has been set, false otherwise.
      */
    public boolean hasTotalAmount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'TotalAmount' field.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder clearTotalAmount() {
      TotalAmount = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'EarnedLoyaltyPoints' field.
      * @return The value.
      */
    public java.lang.Double getEarnedLoyaltyPoints() {
      return EarnedLoyaltyPoints;
    }

    /**
      * Sets the value of the 'EarnedLoyaltyPoints' field.
      * @param value The value of 'EarnedLoyaltyPoints'.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder setEarnedLoyaltyPoints(java.lang.Double value) {
      validate(fields()[3], value);
      this.EarnedLoyaltyPoints = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'EarnedLoyaltyPoints' field has been set.
      * @return True if the 'EarnedLoyaltyPoints' field has been set, false otherwise.
      */
    public boolean hasEarnedLoyaltyPoints() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'EarnedLoyaltyPoints' field.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.jsonposfanout.model.Notification.Builder clearEarnedLoyaltyPoints() {
      EarnedLoyaltyPoints = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Notification build() {
      try {
        Notification record = new Notification();
        record.InvoiceNumber = fieldSetFlags()[0] ? this.InvoiceNumber : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.CustomerCardNo = fieldSetFlags()[1] ? this.CustomerCardNo : (java.lang.Double) defaultValue(fields()[1]);
        record.TotalAmount = fieldSetFlags()[2] ? this.TotalAmount : (java.lang.Double) defaultValue(fields()[2]);
        record.EarnedLoyaltyPoints = fieldSetFlags()[3] ? this.EarnedLoyaltyPoints : (java.lang.Double) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Notification>
    WRITER$ = (org.apache.avro.io.DatumWriter<Notification>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Notification>
    READER$ = (org.apache.avro.io.DatumReader<Notification>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
