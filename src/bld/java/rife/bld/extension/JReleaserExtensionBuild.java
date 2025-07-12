/*
 * Copyright 2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rife.bld.extension;

import rife.bld.Project;
import rife.bld.publish.PublishDeveloper;
import rife.bld.publish.PublishLicense;
import rife.bld.publish.PublishScm;

import java.util.List;

import static rife.bld.dependencies.Repository.*;
import static rife.bld.dependencies.Scope.compile;
import static rife.bld.dependencies.Scope.test;
import static rife.bld.operations.JavadocOptions.DocLinkOption.NO_MISSING;

public class JReleaserExtensionBuild extends Project {
    public JReleaserExtensionBuild() {
        pkg = "rife.bld.extension";
        name = "JReleaserExtension";
        version = version(0, 9, 0, "SNAPSHOT");

        javaRelease = 17;

        downloadSources = true;
        autoDownloadPurge = true;

        repositories = List.of(MAVEN_LOCAL, MAVEN_CENTRAL, RIFE2_RELEASES, RIFE2_SNAPSHOTS);

        scope(compile)
                .include(dependency("com.uwyn.rife2", "bld", version(2, 2, 1)));
        scope(test)
                .include(dependency("org.junit.jupiter", "junit-jupiter", version(5, 12, 2)))
                .include(dependency("org.junit.platform", "junit-platform-console-standalone", version(1, 12, 2)));
                .include(dependency("org.jreleaser", "jreleaser", version(1,19,0)))
                .include(dependency("org.junit.platform", "junit-platform-console-standalone", version(1, 13, 3)));

        javadocOperation()
                .javadocOptions()
                .author()
                .docLint(NO_MISSING)
                .link("https://rife2.github.io/bld/")
                .link("https://rife2.github.io/rife2/");

        publishOperation()
                .repository(version.isSnapshot() ? repository("rife2-snapshot") : repository("rife2"))
                .repository(repository("github"))
                .info()
                .groupId("com.uwyn.rife2")
                .artifactId("bld-jreleaser")
                .description("JReleaser Extension for bld")
                .url("https://github.com/rife2/bld-jreleaser")
                .developer(new PublishDeveloper()
                        .id("aalmiray")
                        .name("Andres Almiray")
                        .url("https://andresalmiray.com/")
                ).developer(new PublishDeveloper()
                        .id("ethauvin")
                        .name("Erik C. Thauvin")
                        .email("erik@thauvin.net")
                        .url("https://erik.thauvin.net/")
                )
                .license(new PublishLicense()
                        .name("The Apache License, Version 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0.txt")
                )
                .scm(new PublishScm()
                        .connection("scm:git:https://github.com/rife2/bld-jreleaser.git")
                        .developerConnection("scm:git:git@github.com:rife2/bld-jreleaser.git")
                        .url("https://github.com/rife2/bld-jreleaser")
                )
                .signKey(property("sign.key"))
                .signPassphrase(property("sign.passphrase"));
    }


    public static void main(String[] args) {
        new JReleaserExtensionBuild().start(args);
    }
}
