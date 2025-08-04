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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import rife.bld.BaseProject;
import rife.bld.operations.exceptions.ExitStatusException;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JReleaserInitOperationTest {
    @TempDir
    private File tmpDir;

    @BeforeAll
    static void beforeAll() {
        var level = Level.ALL;
        var logger = Logger.getLogger("rife.bld.extension");
        var consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(level);
        logger.addHandler(consoleHandler);
        logger.setLevel(level);
        logger.setUseParentHandlers(false);
    }

    @Test
    void testFormat() throws IOException, ExitStatusException, InterruptedException {
        var op = new JReleaserInitOperation();

        op.fromProject(new BaseProject()).basedir(tmpDir.getAbsolutePath());
        op.execute();
        assertTrue(new File(tmpDir, "jreleaser.yml").exists(), "jreleaser.yml not found");

        op.format(JReleaserInitOperation.Format.JSON);
        op.execute();
        assertTrue(new File(tmpDir, "jreleaser.json").exists(), "jreleaser.json not found");

        op.format(JReleaserInitOperation.Format.TOML);
        op.execute();
        assertTrue(new File(tmpDir, "jreleaser.toml").exists(), "jreleaser.toml not found");
    }
}
