# kt-file.io

This library/wrapper handles file management elegantly.

---

In my experience doing operations on multiple file types, I found the need for a centralized library to handle this. 

Using this library, you can read/write from any file type using the _exact_ same syntax. 

### Usage

##### Reading

```kotlin
val pattern = YamlIOPattern()
val result = pattern.save(sample, path)
```

##### Writing

```kotlin
val pattern = YamlIOPattern()
val dataRead = pattern.load<SampleData>(path)
```

Refer to the [unit tests](https://github.com/Tyluur/kt-file.io/tree/main/src/test/kotlin/org/openrsx/io/file/pattern/flat) for more examples of I/O

### Supported

- [JSON](https://github.com/Tyluur/kt-file.io-api/blob/main/src/test/kotlin/org/openrsx/io/file/pattern/flat/JsonIOPatternTest.kt)
- [TOML](https://github.com/Tyluur/kt-file.io-api/blob/main/src/test/kotlin/org/openrsx/io/file/pattern/flat/TomllOPatternTest.kt)
- [YAML](https://github.com/Tyluur/kt-file.io-api/blob/main/src/test/kotlin/org/openrsx/io/file/pattern/flat/YamlIOPatternTest.kt)

### Credits

- [FasterXML](https://github.com/FasterXML) 
