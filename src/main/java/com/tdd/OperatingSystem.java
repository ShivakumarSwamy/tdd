package com.tdd;

import java.util.Objects;

public class OperatingSystem {

    private final int majorVersion;
    private final int minorVersion;
    private final OSType osType;

    public OperatingSystem(int majorVersion, int minorVersion, OSType osType) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.osType = Objects.requireNonNullElse(osType, OSType.UNKOWN);
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public OSType getOsType() {
        return osType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OperatingSystem that = (OperatingSystem) o;
        return getMajorVersion() == that.getMajorVersion()
                && getMinorVersion() == that.getMinorVersion()
                && getOsType() == that.getOsType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMajorVersion(), getMinorVersion(), getOsType());
    }
}
