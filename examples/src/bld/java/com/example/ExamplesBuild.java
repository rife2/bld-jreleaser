package com.example;

import rife.bld.BuildCommand;
import rife.bld.Project;
import rife.bld.extension.JReleaserInitOperation;

import java.util.List;

import static rife.bld.dependencies.Repository.*;
import static rife.bld.dependencies.Scope.*;

public class ExamplesBuild extends Project {
    public ExamplesBuild() {
        pkg = "com.example";
        name = "examples";
        version = version(0, 1, 0);

        javaRelease = 17;

        downloadSources = true;
        autoDownloadPurge = true;

        repositories = List.of(MAVEN_CENTRAL, RIFE2_RELEASES);
        scope(compile)
                .include(dependency("org.jreleaser", "jreleaser", version(1, 16, 0)));
        scope(test)
                .include(dependency("org.junit.jupiter", "junit-jupiter", version(5, 11, 4)))
                .include(dependency("org.junit.platform", "junit-platform-console-standalone", version(1, 11, 4)));
    }

    public static void main(String[] args) {
        new ExamplesBuild().start(args);
    }

    @BuildCommand(value = "jreleaser-init", summary = "Create a JReleaser config file.")
    public void jreleaserInit() throws Exception {
        new JReleaserInitOperation()
                .fromProject(this)
                .overwrite().debug()
                .format(JReleaserInitOperation.Format.JSON)
                .execute();
    }
}