package com.example;

import rife.bld.BuildCommand;
import rife.bld.Project;
import rife.bld.extension.JReleaserInitOperation;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        scope(provided)
                .include(dependency("org.jreleaser", "jreleaser", version(1, 19, 0)));
        scope(test)
                .include(dependency("org.junit.jupiter", "junit-jupiter", version(5, 13, 3)))
                .include(dependency("org.junit.platform", "junit-platform-console-standalone", version(1, 13, 3)));
    }

    public static void main(String[] args) {
        // Enable detailed logging for the extensions
        var level = Level.ALL;
        var logger = Logger.getLogger("rife.bld.extension");
        var consoleHandler = new ConsoleHandler();

        consoleHandler.setLevel(level);
        logger.addHandler(consoleHandler);
        logger.setLevel(level);
        logger.setUseParentHandlers(false);

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
