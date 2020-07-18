//TODO
# Java CLI

Built using Micronaut framework and GraalVM executable. CLI built using picocli library.

## GraalVM

1. Install `sdk install java 20.1.0.r11-grl`
2. Use `sdk use java 20.1.0.r11-grl`
3. Install native Image `gu install native-image`
4. List images `gu list`


Gradle
`./gradlew --no-daemon assemble` : Shadow JAR


# CLI Commands

`java -jar build/libs/stackoverflow-cli-0.1-all.jar`: 400 BadRequest

`java -jar build/libs/stackoverflow-cli-0.1-all.jar search`:: 400 BadRequest

`java -jar build/libs/stackoverflow-cli-0.1-all.jar search -q "merge maps" -t java`

`java -jar build/libs/stackoverflow-cli-0.1-all.jar search -q "merge maps" -t java --verbose`

`./stackoverflow-cli search -q "merge maps" -t java --verbose`

# Native Binary creation

`native-image --no-server -cp build/libs/stackoverflow-cli-0.1-all.jar`


# Github Issues

1. Graceful shutdown of Netty Event Loop takes 2 seconds. 
https://github.com/micronaut-projects/micronaut-core/issues/3582


