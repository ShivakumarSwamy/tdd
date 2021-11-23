package com.tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OperatingSystemTest {

    private static final int MAJOR_VERSION_3 = 3;
    private static final int MAJOR_VERSION_2 = 2;

    private static final int MINOR_VERSION_15 = 15;
    private static final int MINOR_VERSION_18 = 18;

    @Nested
    class EqualsHashCode {

        @Test
        void shouldBeNotEqualForDifferentMajorVersion() {
            OperatingSystem operatingSystem = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_15, OSType.MACOS);
            OperatingSystem operatingSystemTwo = new OperatingSystem(MAJOR_VERSION_2, MINOR_VERSION_15, OSType.MACOS);

            assertThat(operatingSystem).isNotEqualTo(operatingSystemTwo);
        }

        @Test
        void shouldBeNotEqualForDifferentMinorVersion() {
            OperatingSystem operatingSystem = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_15, OSType.MACOS);
            OperatingSystem operatingSystemTwo = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_18, OSType.MACOS);

            assertThat(operatingSystem).isNotEqualTo(operatingSystemTwo);
        }

        @Test
        void shouldBeNotEqualForDifferentType() {
            OperatingSystem operatingSystem = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_15, OSType.MACOS);
            OperatingSystem operatingSystemTwo = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_15, OSType.WINDOWS);

            assertThat(operatingSystem).isNotEqualTo(operatingSystemTwo);
        }

        @Test
        void shouldBeEqualForSameValues() {
            OperatingSystem operatingSystem = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_15, OSType.MACOS);
            OperatingSystem operatingSystemTwo = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_15, OSType.MACOS);

            assertThat(operatingSystem).isEqualTo(operatingSystemTwo);
        }

        @Test
        void shouldNotBeEqualWhenComparedWithNull() {
            OperatingSystem operatingSystem = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_15, OSType.MACOS);

            assertThat(operatingSystem).isNotEqualTo(null);
        }

        @Test
        void shouldNotBeEqualWhenComparedWithDifferentClass() {
            OperatingSystem operatingSystem = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_15, OSType.MACOS);

            assertThat(operatingSystem).isNotEqualTo("");
        }

        @Test
        void shouldBeEqualForItself() {
            OperatingSystem operatingSystem = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_15, OSType.MACOS);

            assertThat(operatingSystem).isEqualTo(operatingSystem);
        }
    }

    @Nested
    class PropertyValidation {

        @Test
        void shouldDefaultToUnknownOsTypeWhenOsTypeIsNull() {
            OperatingSystem operatingSystem = new OperatingSystem(MAJOR_VERSION_3, MINOR_VERSION_15, null);

            assertThat(operatingSystem.getOsType()).isEqualTo(OSType.UNKOWN);
        }
    }
}
