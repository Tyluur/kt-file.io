package org.openrsx.io.file.pattern.flat

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.openrsx.io.file.pattern.FlatIOPattern

/**
 * @author Tyluur <itstyluur@icloud.com>
 * @since November 06, 2022
 */
class JsonIOPattern : FlatIOPattern() {

    /**
     * The instance of the mapper for json files
     */
    override val mapper: ObjectMapper = ObjectMapper(JsonFactory())

    /**
     * Initial dependencies for the storage pattern
     */
    init {
        with(mapper) {
            registerKotlinModule()
            findAndRegisterModules()

            writerWithDefaultPrettyPrinter()

            findAndRegisterModules()
            enable(SerializationFeature.INDENT_OUTPUT)
            setVisibility(
                serializationConfig.defaultVisibilityChecker.withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                    .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                    .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
                    .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
            )
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setSerializationInclusion(JsonInclude.Include.NON_NULL)
        }
    }

}