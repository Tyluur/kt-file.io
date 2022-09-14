package org.openrsx.io.file.pattern

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

/**
 * @author Tyluur <itstyluur@icloud.com>
 * @since September 13, 2022
 */
class YamlIOPattern : FlatIOPattern() {

    /**
     * The instance of an object mapper for YAML Files
     */
    override val mapper: ObjectMapper = ObjectMapper(YAMLFactory())

    /**
     * Initial dependencies for the storage pattern
     */
    init {
        with(mapper) {
            registerKotlinModule()

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