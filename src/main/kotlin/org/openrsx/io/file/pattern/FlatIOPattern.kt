package org.openrsx.io.file.pattern

import com.fasterxml.jackson.databind.ObjectMapper
import org.openrsx.io.file.IOPattern
import java.io.File
import java.nio.file.Paths

/**
 * @author Tyluur <itstyluur@icloud.com>
 * @since September 13, 2022
 */
abstract class FlatIOPattern : IOPattern() {

    /**
     * The instance of the mapper for flat file storage patterns
     */
    abstract val mapper: ObjectMapper
    override fun <T : Any> save(data: T, path: String): Boolean {
        return try {
            mapper.writeValue(Paths.get(path).toFile(), data)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    /**
     * Loads an object from the file using the [mapper]
     */
    inline fun <reified T : Any> load(path: String): T? {
        return try {
            mapper.readValue(File(path), T::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}