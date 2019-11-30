/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.teso.story.lib;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-11-29")
public class category_storyLib implements org.apache.thrift.TBase<category_storyLib, category_storyLib._Fields>, java.io.Serializable, Cloneable, Comparable<category_storyLib> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("category_storyLib");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField STORY_C_FIELD_DESC = new org.apache.thrift.protocol.TField("storyC", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField CATEGORY_S_FIELD_DESC = new org.apache.thrift.protocol.TField("categoryS", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new category_storyLibStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new category_storyLibTupleSchemeFactory();

  public long id; // required
  public storyLib storyC; // required
  public categoryLib categoryS; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    STORY_C((short)2, "storyC"),
    CATEGORY_S((short)3, "categoryS");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // STORY_C
          return STORY_C;
        case 3: // CATEGORY_S
          return CATEGORY_S;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.STORY_C, new org.apache.thrift.meta_data.FieldMetaData("storyC", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "storyLib")));
    tmpMap.put(_Fields.CATEGORY_S, new org.apache.thrift.meta_data.FieldMetaData("categoryS", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "categoryLib")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(category_storyLib.class, metaDataMap);
  }

  public category_storyLib() {
  }

  public category_storyLib(
    long id,
    storyLib storyC,
    categoryLib categoryS)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.storyC = storyC;
    this.categoryS = categoryS;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public category_storyLib(category_storyLib other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetStoryC()) {
      this.storyC = new storyLib(other.storyC);
    }
    if (other.isSetCategoryS()) {
      this.categoryS = new categoryLib(other.categoryS);
    }
  }

  public category_storyLib deepCopy() {
    return new category_storyLib(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.storyC = null;
    this.categoryS = null;
  }

  public long getId() {
    return this.id;
  }

  public category_storyLib setId(long id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public storyLib getStoryC() {
    return this.storyC;
  }

  public category_storyLib setStoryC(storyLib storyC) {
    this.storyC = storyC;
    return this;
  }

  public void unsetStoryC() {
    this.storyC = null;
  }

  /** Returns true if field storyC is set (has been assigned a value) and false otherwise */
  public boolean isSetStoryC() {
    return this.storyC != null;
  }

  public void setStoryCIsSet(boolean value) {
    if (!value) {
      this.storyC = null;
    }
  }

  public categoryLib getCategoryS() {
    return this.categoryS;
  }

  public category_storyLib setCategoryS(categoryLib categoryS) {
    this.categoryS = categoryS;
    return this;
  }

  public void unsetCategoryS() {
    this.categoryS = null;
  }

  /** Returns true if field categoryS is set (has been assigned a value) and false otherwise */
  public boolean isSetCategoryS() {
    return this.categoryS != null;
  }

  public void setCategorySIsSet(boolean value) {
    if (!value) {
      this.categoryS = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((java.lang.Long)value);
      }
      break;

    case STORY_C:
      if (value == null) {
        unsetStoryC();
      } else {
        setStoryC((storyLib)value);
      }
      break;

    case CATEGORY_S:
      if (value == null) {
        unsetCategoryS();
      } else {
        setCategoryS((categoryLib)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case STORY_C:
      return getStoryC();

    case CATEGORY_S:
      return getCategoryS();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case STORY_C:
      return isSetStoryC();
    case CATEGORY_S:
      return isSetCategoryS();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof category_storyLib)
      return this.equals((category_storyLib)that);
    return false;
  }

  public boolean equals(category_storyLib that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_storyC = true && this.isSetStoryC();
    boolean that_present_storyC = true && that.isSetStoryC();
    if (this_present_storyC || that_present_storyC) {
      if (!(this_present_storyC && that_present_storyC))
        return false;
      if (!this.storyC.equals(that.storyC))
        return false;
    }

    boolean this_present_categoryS = true && this.isSetCategoryS();
    boolean that_present_categoryS = true && that.isSetCategoryS();
    if (this_present_categoryS || that_present_categoryS) {
      if (!(this_present_categoryS && that_present_categoryS))
        return false;
      if (!this.categoryS.equals(that.categoryS))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(id);

    hashCode = hashCode * 8191 + ((isSetStoryC()) ? 131071 : 524287);
    if (isSetStoryC())
      hashCode = hashCode * 8191 + storyC.hashCode();

    hashCode = hashCode * 8191 + ((isSetCategoryS()) ? 131071 : 524287);
    if (isSetCategoryS())
      hashCode = hashCode * 8191 + categoryS.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(category_storyLib other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetStoryC()).compareTo(other.isSetStoryC());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStoryC()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.storyC, other.storyC);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCategoryS()).compareTo(other.isSetCategoryS());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCategoryS()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.categoryS, other.categoryS);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("category_storyLib(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("storyC:");
    if (this.storyC == null) {
      sb.append("null");
    } else {
      sb.append(this.storyC);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("categoryS:");
    if (this.categoryS == null) {
      sb.append("null");
    } else {
      sb.append(this.categoryS);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class category_storyLibStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public category_storyLibStandardScheme getScheme() {
      return new category_storyLibStandardScheme();
    }
  }

  private static class category_storyLibStandardScheme extends org.apache.thrift.scheme.StandardScheme<category_storyLib> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, category_storyLib struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.id = iprot.readI64();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STORY_C
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.storyC = new storyLib();
              struct.storyC.read(iprot);
              struct.setStoryCIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CATEGORY_S
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.categoryS = new categoryLib();
              struct.categoryS.read(iprot);
              struct.setCategorySIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, category_storyLib struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI64(struct.id);
      oprot.writeFieldEnd();
      if (struct.storyC != null) {
        oprot.writeFieldBegin(STORY_C_FIELD_DESC);
        struct.storyC.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.categoryS != null) {
        oprot.writeFieldBegin(CATEGORY_S_FIELD_DESC);
        struct.categoryS.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class category_storyLibTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public category_storyLibTupleScheme getScheme() {
      return new category_storyLibTupleScheme();
    }
  }

  private static class category_storyLibTupleScheme extends org.apache.thrift.scheme.TupleScheme<category_storyLib> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, category_storyLib struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetStoryC()) {
        optionals.set(1);
      }
      if (struct.isSetCategoryS()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetId()) {
        oprot.writeI64(struct.id);
      }
      if (struct.isSetStoryC()) {
        struct.storyC.write(oprot);
      }
      if (struct.isSetCategoryS()) {
        struct.categoryS.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, category_storyLib struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.id = iprot.readI64();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.storyC = new storyLib();
        struct.storyC.read(iprot);
        struct.setStoryCIsSet(true);
      }
      if (incoming.get(2)) {
        struct.categoryS = new categoryLib();
        struct.categoryS.read(iprot);
        struct.setCategorySIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

