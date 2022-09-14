package org.openrsx.io.file.pattern

import com.fasterxml.jackson.annotation.JsonIgnore
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

/**
 * @author Tyluur <itstyluur@icloud.com>
 * @since September 13, 2022
 */
internal class YamlIOPatternTest {

    /**
     * Path to read from
     */
    private val path = "./output.yml"

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
     * The pattern used to save
     */
    private val pattern = YamlIOPattern()

    /**
     * The data used to save in this test
     */
    private data class SampleData(val name: String, val map: HashMap<String, Int>) {

        @Suppress("unused")
        @JsonIgnore
        val password = "ignore_test"
    }
}