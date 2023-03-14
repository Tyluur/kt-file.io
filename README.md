# kt-file.io
This library/wrapper handles file management in a simple fashion.

---

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

Refer to `src/test/` for more examples of I/O.

- [Json](https://github.com/Tyluur/kt-file.io-api/blob/main/src/test/kotlin/org/openrsx/io/file/pattern/flat/JsonIOPatternTest.kt)
- [TOML](https://github.com/Tyluur/kt-file.io-api/blob/main/src/test/kotlin/org/openrsx/io/file/pattern/flat/TomllOPatternTest.kt)
- [YAML](https://github.com/Tyluur/kt-file.io-api/blob/main/src/test/kotlin/org/openrsx/io/file/pattern/flat/YamlIOPatternTest.kt)
