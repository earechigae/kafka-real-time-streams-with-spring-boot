/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package guru.learningjournal.examples.kafka.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DepartmentAggregate extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4212970139118711573L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DepartmentAggregate\",\"namespace\":\"guru.learningjournal.examples.kafka.model\",\"fields\":[{\"name\":\"total_salary\",\"type\":[\"null\",\"int\"]},{\"name\":\"employee_count\",\"type\":[\"null\",\"int\"]},{\"name\":\"avg_salary\",\"type\":[\"null\",\"double\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<DepartmentAggregate> ENCODER =
      new BinaryMessageEncoder<DepartmentAggregate>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<DepartmentAggregate> DECODER =
      new BinaryMessageDecoder<DepartmentAggregate>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<DepartmentAggregate> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<DepartmentAggregate> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<DepartmentAggregate>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this DepartmentAggregate to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a DepartmentAggregate from a ByteBuffer. */
  public static DepartmentAggregate fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.Integer total_salary;
  @Deprecated public java.lang.Integer employee_count;
  @Deprecated public java.lang.Double avg_salary;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public DepartmentAggregate() {}

  /**
   * All-args constructor.
   * @param total_salary The new value for total_salary
   * @param employee_count The new value for employee_count
   * @param avg_salary The new value for avg_salary
   */
  public DepartmentAggregate(java.lang.Integer total_salary, java.lang.Integer employee_count, java.lang.Double avg_salary) {
    this.total_salary = total_salary;
    this.employee_count = employee_count;
    this.avg_salary = avg_salary;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return total_salary;
    case 1: return employee_count;
    case 2: return avg_salary;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: total_salary = (java.lang.Integer)value$; break;
    case 1: employee_count = (java.lang.Integer)value$; break;
    case 2: avg_salary = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'total_salary' field.
   * @return The value of the 'total_salary' field.
   */
  public java.lang.Integer getTotalSalary() {
    return total_salary;
  }

  /**
   * Sets the value of the 'total_salary' field.
   * @param value the value to set.
   */
  public void setTotalSalary(java.lang.Integer value) {
    this.total_salary = value;
  }

  /**
   * Gets the value of the 'employee_count' field.
   * @return The value of the 'employee_count' field.
   */
  public java.lang.Integer getEmployeeCount() {
    return employee_count;
  }

  /**
   * Sets the value of the 'employee_count' field.
   * @param value the value to set.
   */
  public void setEmployeeCount(java.lang.Integer value) {
    this.employee_count = value;
  }

  /**
   * Gets the value of the 'avg_salary' field.
   * @return The value of the 'avg_salary' field.
   */
  public java.lang.Double getAvgSalary() {
    return avg_salary;
  }

  /**
   * Sets the value of the 'avg_salary' field.
   * @param value the value to set.
   */
  public void setAvgSalary(java.lang.Double value) {
    this.avg_salary = value;
  }

  /**
   * Creates a new DepartmentAggregate RecordBuilder.
   * @return A new DepartmentAggregate RecordBuilder
   */
  public static guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder newBuilder() {
    return new guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder();
  }

  /**
   * Creates a new DepartmentAggregate RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DepartmentAggregate RecordBuilder
   */
  public static guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder newBuilder(guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder other) {
    return new guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder(other);
  }

  /**
   * Creates a new DepartmentAggregate RecordBuilder by copying an existing DepartmentAggregate instance.
   * @param other The existing instance to copy.
   * @return A new DepartmentAggregate RecordBuilder
   */
  public static guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder newBuilder(guru.learningjournal.examples.kafka.model.DepartmentAggregate other) {
    return new guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder(other);
  }

  /**
   * RecordBuilder for DepartmentAggregate instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DepartmentAggregate>
    implements org.apache.avro.data.RecordBuilder<DepartmentAggregate> {

    private java.lang.Integer total_salary;
    private java.lang.Integer employee_count;
    private java.lang.Double avg_salary;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.total_salary)) {
        this.total_salary = data().deepCopy(fields()[0].schema(), other.total_salary);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.employee_count)) {
        this.employee_count = data().deepCopy(fields()[1].schema(), other.employee_count);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.avg_salary)) {
        this.avg_salary = data().deepCopy(fields()[2].schema(), other.avg_salary);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing DepartmentAggregate instance
     * @param other The existing instance to copy.
     */
    private Builder(guru.learningjournal.examples.kafka.model.DepartmentAggregate other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.total_salary)) {
        this.total_salary = data().deepCopy(fields()[0].schema(), other.total_salary);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.employee_count)) {
        this.employee_count = data().deepCopy(fields()[1].schema(), other.employee_count);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.avg_salary)) {
        this.avg_salary = data().deepCopy(fields()[2].schema(), other.avg_salary);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'total_salary' field.
      * @return The value.
      */
    public java.lang.Integer getTotalSalary() {
      return total_salary;
    }

    /**
      * Sets the value of the 'total_salary' field.
      * @param value The value of 'total_salary'.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder setTotalSalary(java.lang.Integer value) {
      validate(fields()[0], value);
      this.total_salary = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'total_salary' field has been set.
      * @return True if the 'total_salary' field has been set, false otherwise.
      */
    public boolean hasTotalSalary() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'total_salary' field.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder clearTotalSalary() {
      total_salary = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'employee_count' field.
      * @return The value.
      */
    public java.lang.Integer getEmployeeCount() {
      return employee_count;
    }

    /**
      * Sets the value of the 'employee_count' field.
      * @param value The value of 'employee_count'.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder setEmployeeCount(java.lang.Integer value) {
      validate(fields()[1], value);
      this.employee_count = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'employee_count' field has been set.
      * @return True if the 'employee_count' field has been set, false otherwise.
      */
    public boolean hasEmployeeCount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'employee_count' field.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder clearEmployeeCount() {
      employee_count = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'avg_salary' field.
      * @return The value.
      */
    public java.lang.Double getAvgSalary() {
      return avg_salary;
    }

    /**
      * Sets the value of the 'avg_salary' field.
      * @param value The value of 'avg_salary'.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder setAvgSalary(java.lang.Double value) {
      validate(fields()[2], value);
      this.avg_salary = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'avg_salary' field has been set.
      * @return True if the 'avg_salary' field has been set, false otherwise.
      */
    public boolean hasAvgSalary() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'avg_salary' field.
      * @return This builder.
      */
    public guru.learningjournal.examples.kafka.model.DepartmentAggregate.Builder clearAvgSalary() {
      avg_salary = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public DepartmentAggregate build() {
      try {
        DepartmentAggregate record = new DepartmentAggregate();
        record.total_salary = fieldSetFlags()[0] ? this.total_salary : (java.lang.Integer) defaultValue(fields()[0]);
        record.employee_count = fieldSetFlags()[1] ? this.employee_count : (java.lang.Integer) defaultValue(fields()[1]);
        record.avg_salary = fieldSetFlags()[2] ? this.avg_salary : (java.lang.Double) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<DepartmentAggregate>
    WRITER$ = (org.apache.avro.io.DatumWriter<DepartmentAggregate>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<DepartmentAggregate>
    READER$ = (org.apache.avro.io.DatumReader<DepartmentAggregate>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
