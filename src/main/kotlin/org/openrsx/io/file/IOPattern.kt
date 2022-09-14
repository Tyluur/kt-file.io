package org.openrsx.io.file

/**
 * @author Tyluur <itstyluur@icloud.com>
 * @since September 13, 2022
 */
abstract class IOPattern {

    /**
     * @param data The data to store
     */
    abstract fun <T : Any> save(data: T, path: String): Boolean

}