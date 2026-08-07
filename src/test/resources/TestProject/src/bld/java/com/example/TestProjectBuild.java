package com.example;

import rife.bld.Project;

import java.util.List;

import static rife.bld.dependencies.Repository.MAVEN_CENTRAL;
import static rife.bld.dependencies.Repository.RIFE2_RELEASES;
import static rife.bld.dependencies.Scope.provided;

public class TestProjectBuild extends Project {

    public TestProjectBuild() {
        pkg = "com.example";
        name = "TestProject";
        version = version(0, 1, 0);

        autoDownloadPurge = true;

        repositories = List.of(MAVEN_CENTRAL, RIFE2_RELEASES);

        scope(provided)
                .include(dependency("org.jreleaser", "jreleaser", version(1, 26, 0)));
    }

    public static void main(String[] args) {
        new TestProjectBuild().start(args);
    }
}
