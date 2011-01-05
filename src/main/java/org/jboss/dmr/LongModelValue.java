/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.dmr;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
final class LongModelValue extends ModelValue {

    private final long value;

    LongModelValue(final long value) {
        super(ModelType.LONG);
        this.value = value;
    }

    long asLong() {
        return value;
    }

    long asLong(final long defVal) {
        return value;
    }

    int asInt() {
        return (int) value;
    }

    int asInt(final int defVal) {
        return (int) value;
    }

    boolean asBoolean() {
        return value != 0;
    }

    boolean asBoolean(final boolean defVal) {
        return value != 0;
    }

    double asDouble() {
        return value;
    }

    double asDouble(final double defVal) {
        return value;
    }

    byte[] asBytes() {
        final byte[] bytes = new byte[8];
        bytes[0] = (byte) (value >>> 56);
        bytes[1] = (byte) (value >>> 48);
        bytes[2] = (byte) (value >>> 40);
        bytes[3] = (byte) (value >>> 32);
        bytes[4] = (byte) (value >>> 24);
        bytes[5] = (byte) (value >>> 16);
        bytes[6] = (byte) (value >>> 8);
        bytes[7] = (byte) (value);
        return bytes;
    }

    BigDecimal asBigDecimal() {
        return new BigDecimal(value);
    }

    BigInteger asBigInteger() {
        return BigInteger.valueOf(value);
    }

    String asString() {
        return Long.toString(value);
    }


    /**
     * Determine whether this object is equal to another.
     *
     * @param other the other object
     * @return {@code true} if they are equal, {@code false} otherwise
     */
    public boolean equals(Object other) {
        return other instanceof LongModelValue && equals((LongModelValue)other);
    }

    /**
     * Determine whether this object is equal to another.
     *
     * @param other the other object
     * @return {@code true} if they are equal, {@code false} otherwise
     */
    public boolean equals(LongModelValue other) {
        return this == other || other != null && other.value == value;
    }

    public int hashCode() {
        return (int) value;
    }
}
