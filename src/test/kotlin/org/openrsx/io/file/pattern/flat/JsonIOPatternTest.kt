package org.openrsx.io.file.pattern.flat

import com.fasterxml.jackson.annotation.JsonIgnore
import com.github.michaelbull.logging.InlineLogger
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.file.Paths

/**
 * @author Tyluur <itstyluur@icloud.com>
 * @since November 06, 2022
 */
internal class JsonIOPatternTest {

    /**
     * The logger used to print logs for this test case
     */
    private val logger = InlineLogger()

    /**
     * The pattern used for storage in this test case - specifically json
     */
    private val pattern = JsonIOPattern()

    /**
     * Path to read from
     */
    private val path = "${Paths.get("src", "test", "resources")}/json-test-output.json"

    @Test
    fun save() {
        val map = hashMapOf<String, Int>().apply {
            this["first"] = 1
            this["second"] = 2
        }
        val sample = SampleData("test", map)

        val result = pattern.save(sample, path)

        assertTrue(result)

        logger.debug { "Json unit test case complete" }
    }

    @Test
    fun load() {
        val dataRead = pattern.load<SampleData>(path)

        assertTrue(dataRead != null)

        logger.info { "Data read from $path = $dataRead" }
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