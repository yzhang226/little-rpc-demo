// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WorldClockProtocol.proto

package org.cook.rpc.sample.model.clock;

/**
 * Protobuf type {@code org.cook.rpc.sample.model.clock.LocalTime}
 */
public  final class LocalTime extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:org.cook.rpc.sample.model.clock.LocalTime)
    LocalTimeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LocalTime.newBuilder() to construct.
  private LocalTime(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LocalTime() {
    year_ = 0;
    month_ = 0;
    dayOfMonth_ = 0;
    dayOfWeek_ = 1;
    hour_ = 0;
    minute_ = 0;
    second_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LocalTime(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            bitField0_ |= 0x00000001;
            year_ = input.readUInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            month_ = input.readUInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000004;
            dayOfMonth_ = input.readUInt32();
            break;
          }
          case 40: {
            int rawValue = input.readEnum();
              @SuppressWarnings("deprecation")
            org.cook.rpc.sample.model.clock.DayOfWeek value = org.cook.rpc.sample.model.clock.DayOfWeek.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(5, rawValue);
            } else {
              bitField0_ |= 0x00000008;
              dayOfWeek_ = rawValue;
            }
            break;
          }
          case 48: {
            bitField0_ |= 0x00000010;
            hour_ = input.readUInt32();
            break;
          }
          case 56: {
            bitField0_ |= 0x00000020;
            minute_ = input.readUInt32();
            break;
          }
          case 64: {
            bitField0_ |= 0x00000040;
            second_ = input.readUInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.cook.rpc.sample.model.clock.WorldClockProtocol.internal_static_org_cook_rpc_sample_model_clock_LocalTime_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.cook.rpc.sample.model.clock.WorldClockProtocol.internal_static_org_cook_rpc_sample_model_clock_LocalTime_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.cook.rpc.sample.model.clock.LocalTime.class, org.cook.rpc.sample.model.clock.LocalTime.Builder.class);
  }

  private int bitField0_;
  public static final int YEAR_FIELD_NUMBER = 1;
  private int year_;
  /**
   * <code>required uint32 year = 1;</code>
   */
  public boolean hasYear() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>required uint32 year = 1;</code>
   */
  public int getYear() {
    return year_;
  }

  public static final int MONTH_FIELD_NUMBER = 2;
  private int month_;
  /**
   * <code>required uint32 month = 2;</code>
   */
  public boolean hasMonth() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>required uint32 month = 2;</code>
   */
  public int getMonth() {
    return month_;
  }

  public static final int DAYOFMONTH_FIELD_NUMBER = 4;
  private int dayOfMonth_;
  /**
   * <code>required uint32 dayOfMonth = 4;</code>
   */
  public boolean hasDayOfMonth() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>required uint32 dayOfMonth = 4;</code>
   */
  public int getDayOfMonth() {
    return dayOfMonth_;
  }

  public static final int DAYOFWEEK_FIELD_NUMBER = 5;
  private int dayOfWeek_;
  /**
   * <code>required .org.cook.rpc.sample.model.clock.DayOfWeek dayOfWeek = 5;</code>
   */
  public boolean hasDayOfWeek() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>required .org.cook.rpc.sample.model.clock.DayOfWeek dayOfWeek = 5;</code>
   */
  public org.cook.rpc.sample.model.clock.DayOfWeek getDayOfWeek() {
    @SuppressWarnings("deprecation")
    org.cook.rpc.sample.model.clock.DayOfWeek result = org.cook.rpc.sample.model.clock.DayOfWeek.valueOf(dayOfWeek_);
    return result == null ? org.cook.rpc.sample.model.clock.DayOfWeek.SUNDAY : result;
  }

  public static final int HOUR_FIELD_NUMBER = 6;
  private int hour_;
  /**
   * <code>required uint32 hour = 6;</code>
   */
  public boolean hasHour() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>required uint32 hour = 6;</code>
   */
  public int getHour() {
    return hour_;
  }

  public static final int MINUTE_FIELD_NUMBER = 7;
  private int minute_;
  /**
   * <code>required uint32 minute = 7;</code>
   */
  public boolean hasMinute() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <code>required uint32 minute = 7;</code>
   */
  public int getMinute() {
    return minute_;
  }

  public static final int SECOND_FIELD_NUMBER = 8;
  private int second_;
  /**
   * <code>required uint32 second = 8;</code>
   */
  public boolean hasSecond() {
    return ((bitField0_ & 0x00000040) == 0x00000040);
  }
  /**
   * <code>required uint32 second = 8;</code>
   */
  public int getSecond() {
    return second_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasYear()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasMonth()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasDayOfMonth()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasDayOfWeek()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasHour()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasMinute()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasSecond()) {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeUInt32(1, year_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeUInt32(2, month_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeUInt32(4, dayOfMonth_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeEnum(5, dayOfWeek_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeUInt32(6, hour_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      output.writeUInt32(7, minute_);
    }
    if (((bitField0_ & 0x00000040) == 0x00000040)) {
      output.writeUInt32(8, second_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, year_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, month_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(4, dayOfMonth_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, dayOfWeek_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(6, hour_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(7, minute_);
    }
    if (((bitField0_ & 0x00000040) == 0x00000040)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(8, second_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.cook.rpc.sample.model.clock.LocalTime)) {
      return super.equals(obj);
    }
    org.cook.rpc.sample.model.clock.LocalTime other = (org.cook.rpc.sample.model.clock.LocalTime) obj;

    boolean result = true;
    result = result && (hasYear() == other.hasYear());
    if (hasYear()) {
      result = result && (getYear()
          == other.getYear());
    }
    result = result && (hasMonth() == other.hasMonth());
    if (hasMonth()) {
      result = result && (getMonth()
          == other.getMonth());
    }
    result = result && (hasDayOfMonth() == other.hasDayOfMonth());
    if (hasDayOfMonth()) {
      result = result && (getDayOfMonth()
          == other.getDayOfMonth());
    }
    result = result && (hasDayOfWeek() == other.hasDayOfWeek());
    if (hasDayOfWeek()) {
      result = result && dayOfWeek_ == other.dayOfWeek_;
    }
    result = result && (hasHour() == other.hasHour());
    if (hasHour()) {
      result = result && (getHour()
          == other.getHour());
    }
    result = result && (hasMinute() == other.hasMinute());
    if (hasMinute()) {
      result = result && (getMinute()
          == other.getMinute());
    }
    result = result && (hasSecond() == other.hasSecond());
    if (hasSecond()) {
      result = result && (getSecond()
          == other.getSecond());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasYear()) {
      hash = (37 * hash) + YEAR_FIELD_NUMBER;
      hash = (53 * hash) + getYear();
    }
    if (hasMonth()) {
      hash = (37 * hash) + MONTH_FIELD_NUMBER;
      hash = (53 * hash) + getMonth();
    }
    if (hasDayOfMonth()) {
      hash = (37 * hash) + DAYOFMONTH_FIELD_NUMBER;
      hash = (53 * hash) + getDayOfMonth();
    }
    if (hasDayOfWeek()) {
      hash = (37 * hash) + DAYOFWEEK_FIELD_NUMBER;
      hash = (53 * hash) + dayOfWeek_;
    }
    if (hasHour()) {
      hash = (37 * hash) + HOUR_FIELD_NUMBER;
      hash = (53 * hash) + getHour();
    }
    if (hasMinute()) {
      hash = (37 * hash) + MINUTE_FIELD_NUMBER;
      hash = (53 * hash) + getMinute();
    }
    if (hasSecond()) {
      hash = (37 * hash) + SECOND_FIELD_NUMBER;
      hash = (53 * hash) + getSecond();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.cook.rpc.sample.model.clock.LocalTime parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.cook.rpc.sample.model.clock.LocalTime parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.cook.rpc.sample.model.clock.LocalTime prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code org.cook.rpc.sample.model.clock.LocalTime}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.cook.rpc.sample.model.clock.LocalTime)
      org.cook.rpc.sample.model.clock.LocalTimeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.cook.rpc.sample.model.clock.WorldClockProtocol.internal_static_org_cook_rpc_sample_model_clock_LocalTime_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.cook.rpc.sample.model.clock.WorldClockProtocol.internal_static_org_cook_rpc_sample_model_clock_LocalTime_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.cook.rpc.sample.model.clock.LocalTime.class, org.cook.rpc.sample.model.clock.LocalTime.Builder.class);
    }

    // Construct using org.cook.rpc.sample.model.clock.LocalTime.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      year_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      month_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      dayOfMonth_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      dayOfWeek_ = 1;
      bitField0_ = (bitField0_ & ~0x00000008);
      hour_ = 0;
      bitField0_ = (bitField0_ & ~0x00000010);
      minute_ = 0;
      bitField0_ = (bitField0_ & ~0x00000020);
      second_ = 0;
      bitField0_ = (bitField0_ & ~0x00000040);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.cook.rpc.sample.model.clock.WorldClockProtocol.internal_static_org_cook_rpc_sample_model_clock_LocalTime_descriptor;
    }

    @java.lang.Override
    public org.cook.rpc.sample.model.clock.LocalTime getDefaultInstanceForType() {
      return org.cook.rpc.sample.model.clock.LocalTime.getDefaultInstance();
    }

    @java.lang.Override
    public org.cook.rpc.sample.model.clock.LocalTime build() {
      org.cook.rpc.sample.model.clock.LocalTime result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.cook.rpc.sample.model.clock.LocalTime buildPartial() {
      org.cook.rpc.sample.model.clock.LocalTime result = new org.cook.rpc.sample.model.clock.LocalTime(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.year_ = year_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.month_ = month_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.dayOfMonth_ = dayOfMonth_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.dayOfWeek_ = dayOfWeek_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.hour_ = hour_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      result.minute_ = minute_;
      if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
        to_bitField0_ |= 0x00000040;
      }
      result.second_ = second_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.cook.rpc.sample.model.clock.LocalTime) {
        return mergeFrom((org.cook.rpc.sample.model.clock.LocalTime)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.cook.rpc.sample.model.clock.LocalTime other) {
      if (other == org.cook.rpc.sample.model.clock.LocalTime.getDefaultInstance()) return this;
      if (other.hasYear()) {
        setYear(other.getYear());
      }
      if (other.hasMonth()) {
        setMonth(other.getMonth());
      }
      if (other.hasDayOfMonth()) {
        setDayOfMonth(other.getDayOfMonth());
      }
      if (other.hasDayOfWeek()) {
        setDayOfWeek(other.getDayOfWeek());
      }
      if (other.hasHour()) {
        setHour(other.getHour());
      }
      if (other.hasMinute()) {
        setMinute(other.getMinute());
      }
      if (other.hasSecond()) {
        setSecond(other.getSecond());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasYear()) {
        return false;
      }
      if (!hasMonth()) {
        return false;
      }
      if (!hasDayOfMonth()) {
        return false;
      }
      if (!hasDayOfWeek()) {
        return false;
      }
      if (!hasHour()) {
        return false;
      }
      if (!hasMinute()) {
        return false;
      }
      if (!hasSecond()) {
        return false;
      }
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.cook.rpc.sample.model.clock.LocalTime parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.cook.rpc.sample.model.clock.LocalTime) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int year_ ;
    /**
     * <code>required uint32 year = 1;</code>
     */
    public boolean hasYear() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required uint32 year = 1;</code>
     */
    public int getYear() {
      return year_;
    }
    /**
     * <code>required uint32 year = 1;</code>
     */
    public Builder setYear(int value) {
      bitField0_ |= 0x00000001;
      year_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required uint32 year = 1;</code>
     */
    public Builder clearYear() {
      bitField0_ = (bitField0_ & ~0x00000001);
      year_ = 0;
      onChanged();
      return this;
    }

    private int month_ ;
    /**
     * <code>required uint32 month = 2;</code>
     */
    public boolean hasMonth() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required uint32 month = 2;</code>
     */
    public int getMonth() {
      return month_;
    }
    /**
     * <code>required uint32 month = 2;</code>
     */
    public Builder setMonth(int value) {
      bitField0_ |= 0x00000002;
      month_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required uint32 month = 2;</code>
     */
    public Builder clearMonth() {
      bitField0_ = (bitField0_ & ~0x00000002);
      month_ = 0;
      onChanged();
      return this;
    }

    private int dayOfMonth_ ;
    /**
     * <code>required uint32 dayOfMonth = 4;</code>
     */
    public boolean hasDayOfMonth() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required uint32 dayOfMonth = 4;</code>
     */
    public int getDayOfMonth() {
      return dayOfMonth_;
    }
    /**
     * <code>required uint32 dayOfMonth = 4;</code>
     */
    public Builder setDayOfMonth(int value) {
      bitField0_ |= 0x00000004;
      dayOfMonth_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required uint32 dayOfMonth = 4;</code>
     */
    public Builder clearDayOfMonth() {
      bitField0_ = (bitField0_ & ~0x00000004);
      dayOfMonth_ = 0;
      onChanged();
      return this;
    }

    private int dayOfWeek_ = 1;
    /**
     * <code>required .org.cook.rpc.sample.model.clock.DayOfWeek dayOfWeek = 5;</code>
     */
    public boolean hasDayOfWeek() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required .org.cook.rpc.sample.model.clock.DayOfWeek dayOfWeek = 5;</code>
     */
    public org.cook.rpc.sample.model.clock.DayOfWeek getDayOfWeek() {
      @SuppressWarnings("deprecation")
      org.cook.rpc.sample.model.clock.DayOfWeek result = org.cook.rpc.sample.model.clock.DayOfWeek.valueOf(dayOfWeek_);
      return result == null ? org.cook.rpc.sample.model.clock.DayOfWeek.SUNDAY : result;
    }
    /**
     * <code>required .org.cook.rpc.sample.model.clock.DayOfWeek dayOfWeek = 5;</code>
     */
    public Builder setDayOfWeek(org.cook.rpc.sample.model.clock.DayOfWeek value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000008;
      dayOfWeek_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>required .org.cook.rpc.sample.model.clock.DayOfWeek dayOfWeek = 5;</code>
     */
    public Builder clearDayOfWeek() {
      bitField0_ = (bitField0_ & ~0x00000008);
      dayOfWeek_ = 1;
      onChanged();
      return this;
    }

    private int hour_ ;
    /**
     * <code>required uint32 hour = 6;</code>
     */
    public boolean hasHour() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>required uint32 hour = 6;</code>
     */
    public int getHour() {
      return hour_;
    }
    /**
     * <code>required uint32 hour = 6;</code>
     */
    public Builder setHour(int value) {
      bitField0_ |= 0x00000010;
      hour_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required uint32 hour = 6;</code>
     */
    public Builder clearHour() {
      bitField0_ = (bitField0_ & ~0x00000010);
      hour_ = 0;
      onChanged();
      return this;
    }

    private int minute_ ;
    /**
     * <code>required uint32 minute = 7;</code>
     */
    public boolean hasMinute() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>required uint32 minute = 7;</code>
     */
    public int getMinute() {
      return minute_;
    }
    /**
     * <code>required uint32 minute = 7;</code>
     */
    public Builder setMinute(int value) {
      bitField0_ |= 0x00000020;
      minute_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required uint32 minute = 7;</code>
     */
    public Builder clearMinute() {
      bitField0_ = (bitField0_ & ~0x00000020);
      minute_ = 0;
      onChanged();
      return this;
    }

    private int second_ ;
    /**
     * <code>required uint32 second = 8;</code>
     */
    public boolean hasSecond() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    /**
     * <code>required uint32 second = 8;</code>
     */
    public int getSecond() {
      return second_;
    }
    /**
     * <code>required uint32 second = 8;</code>
     */
    public Builder setSecond(int value) {
      bitField0_ |= 0x00000040;
      second_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required uint32 second = 8;</code>
     */
    public Builder clearSecond() {
      bitField0_ = (bitField0_ & ~0x00000040);
      second_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:org.cook.rpc.sample.model.clock.LocalTime)
  }

  // @@protoc_insertion_point(class_scope:org.cook.rpc.sample.model.clock.LocalTime)
  private static final org.cook.rpc.sample.model.clock.LocalTime DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.cook.rpc.sample.model.clock.LocalTime();
  }

  public static org.cook.rpc.sample.model.clock.LocalTime getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<LocalTime>
      PARSER = new com.google.protobuf.AbstractParser<LocalTime>() {
    @java.lang.Override
    public LocalTime parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LocalTime(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LocalTime> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LocalTime> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.cook.rpc.sample.model.clock.LocalTime getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

