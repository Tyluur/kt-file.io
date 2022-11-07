package org.openrsx.io.file.pattern.flat

import com.fasterxml.jackson.annotation.JsonIgnore
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.nio.file.Paths

/**
 * @author Tyluur <itstyluur@icloud.com>
 * @since September 13, 2022
 */
internal class YamlIOPatternTest {

    /**
     * The pattern used for storage in this test case - specifically yaml
     */
    private val pattern = YamlIOPattern()

    /**
     * Path to read from
     */
    private val path = "${Paths.get("src", "test", "resources")}/yaml-test-output.yml"

    @Test
    fun save() {
        val map = hashMapOf<String, Int>().apply {
            this["first"] = 1
            this["second"] = 2
        }
        val sample = SampleData("test", map)

        val result = pattern.save(sample, path)

        assertTrue(result)
    }

    @Test
    fun load() {
        val dataRead = pattern.load<SampleData>(path)

        assertTrue(dataRead != null)
    }

    /**
     * The data used to save in this test
     */
    private data class SampleData(val name: String, val map: HashMap<String, Int>) {

        @Suppress("unused")
        @JsonIgnore
        val password = "ignore_test"
    }
}