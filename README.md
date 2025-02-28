# [JReleaser](https://jreleaser.org/) Extension for [b<span style="color:orange">l</span>d](https://rife2.com/bld) 

[![License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java](https://img.shields.io/badge/java-17%2B-blue)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![bld](https://img.shields.io/badge/2.2.1-FA9052?label=bld&labelColor=2392FF)](https://rife2.com/bld)
[![Release](https://flat.badgen.net/maven/v/metadata-url/repo.rife2.com/releases/com/uwyn/rife2/bld-jreleaser/maven-metadata.xml?color=blue)](https://repo.rife2.com/#/releases/com/uwyn/rife2/bld-jreleaser)
[![Snapshot](https://flat.badgen.net/maven/v/metadata-url/repo.rife2.com/snapshots/com/uwyn/rife2/bld-jreleaser/maven-metadata.xml?label=snapshot)](https://repo.rife2.com/#/snapshots/com/uwyn/rife2/bld-jreleaser)
[![GitHub CI](https://github.com/rife2/bld-jreleaser/actions/workflows/bld.yml/badge.svg)](https://github.com/rife2/bld-jreleaser/actions/workflows/bld.yml)

To install, please refer to the [extensions documentation](https://github.com/rife2/bld/wiki/Extensions).

To generate a JReleaser config file, add the following to your build file:

```java
@BuildCommand(value = "jreleaser-init", summary = "Create a JReleaser config file.")
public void jreleaserInit() throws Exception {
    new JReleaserInitOperation()
            .fromProject(this)
            .overwrite().debug()
            .format(JReleaserInitOperation.Format.JSON)
            .execute();
}
```

Then run the following command:
```
./bld jreleaser-init
```

- [View Examples Project](https://github.com/rife2/bld-jreleaser/blob/master/examples/src/bld/java/com/example/)

Please check the [documentation](https://rife2.github.io/bld-jreleaser/rife/bld/extension/package-summary.html) for all available configuration options.

## JReleaser Dependency

Don't forget to add the [JReleaser](https://jreleaser.org/) dependency to your build file, as they are not provided by the extension. For example:

```java
repositories = List.of(MAVEN_CENTRAL);
scope(provided)
     .include(dependency("org.jreleaser", "jreleaser", version(1, 17, 0)));
```
