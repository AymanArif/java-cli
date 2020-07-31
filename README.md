# Java CLI

# Table Of Contents

- [Java CLI](#java-cli)
- [Run commands](#run-commands)
  * [GraalVM install](#graalvm-install)
  * [Build project](#build-project)
  * [CLI Commands to check JAR](#cli-commands-to-check-jar)
  * [Native Binary creation](#native-binary-creation)
- [TODO: Add Oauth2 for Stack Exchange](#todo-add-oauth2-for-stack-exchange)
- [Github Issues](#github-issues)

<p align="center">
  🔨 Built using <b>Micronaut</b> framework and <b>GraalVM</b> executable. CLI built using <b>Picocli</b> library.🔨
</p>



<p align="center">
  <a href=https://docs.gradle.org/current/userguide/userguide.html">
    <img alt="Gradle" src="https://gradle.org/images/gradle-knowledge-graph-logo.png?20170228" width="60" />
  </a>
  <a href="https://micronaut.io/learn.html">
    <img alt="GraalVM" src="https://www.opencodez.com/wp-content/uploads/2019/08/Micronaut.png" width="60" />
  </a>
  <a href="https://www.graalvm.org/docs/">
    <img alt="Micronaut" src="https://www.graalvm.org/resources/img/graalvm.png" width="100" />
  </a>
  <a href="https://picocli.info/">
    <img alt="Picocli" src="https://img.stackshare.io/service/10857/picocli.png" width="60" />
  </a>

  
  
  
    - name: Install GraalVM using sdkman
      run: sdk install java 20.1.0.r11-grl
    - name: Use GraalVm
      run: sdk use java 20.1.0.r11-grl
    - name: Install Native Image executable using gu
      run: gu install native-image
    - name: List GrallVM CLI
      run: gu list
  



# Run commands 

## GraalVM install 

Use [SDKMan](https://sdkman.io/) for easy switching between Java Version (among others)

1. Install GraalVM-specific Java 11 JDK.
- `sdk install java 20.1.0.r11-grl`

2. Use GraalVm's Java 11
- `sdk use java 20.1.0.r11-grl`

3. Install Native Image for native executable JARs
- `gu install native-image`

4. [Check] List images
- `gu list`


## Build project

`./gradlew --no-daemon assemble`

- This builds Shadow JAR of the project.


## CLI Commands to check JAR

- `java -jar build/libs/stackoverflow-cli-0.1-all.jar`

- `java -jar build/libs/stackoverflow-cli-0.1-all.jar search`
- `java -jar build/libs/stackoverflow-cli-0.1-all.jar search -q "merge maps" -t java`

- `java -jar build/libs/stackoverflow-cli-0.1-all.jar search -q "merge maps" -t java --verbose`

## Native Binary creation

`native-image --no-server -cp build/libs/stackoverflow-cli-0.1-all.jar`
- Builds the JAR to binary executable, which doesn't require java for executing.

Use command to run the native-executable: `./stackoverflow-cli search -q "merge maps" -t java --verbose`


# Add Oauth2 for Stack Exchange


API Link: https://api.stackexchange.com/docs/authentication

Register API here: https://stackapps.com/apps/oauth/register


Running only `auth` package

./gradlew --no-daemon run --args="auth" 

## Store credentails

Credentials are stored in: `~/.stackoverflow-cli/credentials.properties`

# Github Issues

1. Graceful shutdown of Netty Event Loop (Micronaut's HTTP client) takes 2 seconds. 
https://github.com/micronaut-projects/micronaut-core/issues/3582


