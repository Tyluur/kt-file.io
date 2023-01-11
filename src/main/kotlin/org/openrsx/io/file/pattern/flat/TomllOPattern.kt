package org.openrsx.io.file.pattern.flat

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.teesoft.jackson.dataformat.toml.TOMLMapper
import org.openrsx.io.file.pattern.FlatIOPattern

class TomllOPattern : FlatIOPattern() {

    /**
     * The object mapper for toml files
     */
    override val mapper: ObjectMapper = TOMLMapper()

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