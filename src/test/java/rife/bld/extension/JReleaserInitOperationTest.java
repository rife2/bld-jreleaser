/*
 * Copyright 2025-2026 the original author or authors.
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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import rife.bld.BaseProject;
import rife.bld.dependencies.Repository;
import rife.bld.dependencies.Scope;
import rife.bld.operations.exceptions.ExitStatusException;
import rife.bld.testing.LoggingExtension;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(LoggingExtension.class)
public class JReleaserInitOperationTest {
    @RegisterExtension
    @SuppressWarnings("unused")
    private static final LoggingExtension LOGGING_EXTENSION = new LoggingExtension("rife.bld.extension");

    @Test
    void testFormat() throws IOException, ExitStatusException, InterruptedException {
        var op = new JReleaserInitOperation();
        var testProject = new TestProject();
        op.fromProject(testProject);


        var yml = new File(testProject.workDirectory(), "jreleaser.yml");
        yml.deleteOnExit();
        op.execute();
        assertTrue(yml.exists(), "jreleaser.yml not found");

        op.format(JReleaserInitOperation.Format.JSON);
        var json = new File(testProject.workDirectory(), "jreleaser.json");
        json.deleteOnExit();
        op.execute();
        assertTrue(json.exists(), "jreleaser.json not found");

        op.format(JReleaserInitOperation.Format.TOML);
        var toml = new File(testProject.workDirectory(), "jreleaser.toml");
        toml.deleteOnExit();
        op.execute();
        assertTrue(toml.exists(), "jreleaser.toml not found");
    }

    static class TestProject extends BaseProject {

        TestProject() {
            workDirectory = new File("src/test/resources/TestProject");
            pkg = "com.example";
            name = "TestProject";
            version = version(0, 1, 0);

            autoDownloadPurge = true;

            repositories = List.of(Repository.MAVEN_CENTRAL, Repository.RIFE2_RELEASES);

            scope(Scope.provided).include(dependency("org.jreleaser", "jreleaser"));
        }
    }
}
