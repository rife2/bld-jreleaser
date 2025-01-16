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

import rife.bld.BaseProject;
import rife.bld.operations.AbstractProcessOperation;
import rife.bld.operations.exceptions.ExitStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Create a JReleaser config file.
 */
public class JReleaserInitOperation extends AbstractProcessOperation<JReleaserInitOperation> {
    private static final String EMPTY = "";
    private static final Logger LOGGER = Logger.getLogger(JReleaserInitOperation.class.getName());
    private final Map<String, String> options_ = new ConcurrentHashMap<>();
    private BaseProject project_;

    /**
     * Sets the base directory.
     *
     * @param directory the base directory
     * @return this operation instance
     */
    public JReleaserInitOperation basedir(String directory) {
        options_.put("--basedir", directory);
        return this;
    }

    /**
     * Sets the base directory.
     *
     * @param directory the base directory
     * @return this operation instance
     */
    public JReleaserInitOperation basedir(File directory) {
        return basedir(directory.getAbsolutePath());
    }

    /**
     * Sets the base directory.
     *
     * @param directory the base directory
     * @return this operation instance
     */
    public JReleaserInitOperation basedir(Path directory) {
        return basedir(directory.toFile());
    }

    /**
     * Set log level to debug.
     *
     * @return this operation instance
     */
    public JReleaserInitOperation debug() {
        options_.put("--debug", EMPTY);
        return this;
    }

    @Override
    public void execute() throws IOException, InterruptedException, ExitStatusException {
        if (project_ == null) {
            if (LOGGER.isLoggable(Level.SEVERE) && !silent()) {
                LOGGER.severe("A project must be specified.");
            }
            throw new ExitStatusException(ExitStatusException.EXIT_FAILURE);
        } else {
            super.execute();
        }
    }

    /**
     * Part of the {@link #execute} operation, constructs the command list
     * to use for building the process.
     */
    @Override
    protected List<String> executeConstructProcessCommandList() {
        List<String> args = new ArrayList<>();

        if (project_ != null) {
            args.add(javaTool());
            args.add("-cp");
            args.add(String.format("%s:%s:%s:%s", new File(project_.libTestDirectory(), "*"),
                    new File(project_.libCompileDirectory(), "*"), project_.buildMainDirectory(),
                    project_.buildTestDirectory()));
            args.add("org.jreleaser.cli.Main");
            args.add("init");

            options_.forEach((k, v) -> {
                if (!v.isEmpty()) {
                    args.add(k + '=' + v);
                } else {
                    args.add(k);
                }
            });
        }

        return args;
    }

    /**
     * Configures the operation from a {@link BaseProject}.
     *
     * @param project the project to configure the operation from
     */
    @Override
    public JReleaserInitOperation fromProject(BaseProject project) {
        project_ = project;
        return this;
    }

    /**
     * Sets the format.
     *
     * @param format the format
     * @return this operation instance
     */
    public JReleaserInitOperation format(Format format) {
        options_.put("--format", format.getFormat());
        return this;
    }

    /**
     * Show the help message.
     *
     * @return this operation instance
     */
    public JReleaserInitOperation help() {
        options_.put("--help", EMPTY);
        return this;
    }

    /**
     * Set log level to info.
     *
     * @return this operation instance
     */
    public JReleaserInitOperation info() {
        options_.put("--info", EMPTY);
        return this;
    }

    /**
     * Output directory.
     *
     * @param directory the output directory
     * @return this operation instance
     */
    public JReleaserInitOperation outputDirectory(String directory) {
        options_.put("-output-directory", directory);
        return this;
    }

    /**
     * Output directory.
     *
     * @param directory the output directory
     * @return this operation instance
     */
    public JReleaserInitOperation outputDirectory(File directory) {
        return outputDirectory(directory.getAbsolutePath());
    }

    /**
     * Output directory.
     *
     * @param directory the output directory
     * @return this operation instance
     */
    public JReleaserInitOperation outputDirectory(Path directory) {
        return outputDirectory(directory.toFile());
    }

    /**
     * Overwrite existing files.
     *
     * @return this operation instance
     */
    public JReleaserInitOperation overwrite() {
        options_.put("--overwrite", EMPTY);
        return this;
    }

    /**
     * Sets a System property.
     *
     * @param key   the property key
     * @param value the property value
     * @return this operation instance
     */
    public JReleaserInitOperation systemProperty(String key, String value) {
        options_.put("-D", key + '=' + value);
        return this;
    }

    /**
     * Print version information.
     *
     * @return this operation instance
     */
    public JReleaserInitOperation version() {
        options_.put("--version", EMPTY);
        return this;
    }

    /**
     * Set log level to warn.
     *
     * @return this operation instance
     */
    public JReleaserInitOperation warn() {
        options_.put("--warn", EMPTY);
        return this;
    }

    /**
     * The currently supported formats.
     */
    public enum Format {
        JSON("json"),
        TOML("toml"),
        YAML("yaml");

        private final String format;

        Format(String format) {
            this.format = format;
        }

        public String getFormat() {
            return format;
        }
    }
}
