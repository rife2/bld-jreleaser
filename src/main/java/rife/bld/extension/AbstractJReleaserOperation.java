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
 * Base class for all JReleaser operations.
 */
public abstract class AbstractJReleaserOperation<S extends AbstractJReleaserOperation<S>> extends AbstractProcessOperation<S> {
    private static final Logger LOGGER = Logger.getLogger(AbstractJReleaserOperation.class.getName());
    protected static final String EMPTY = "";

    private final Map<String, String> options_ = new ConcurrentHashMap<>();
    private final String command_;

    private BaseProject project_;

    protected AbstractJReleaserOperation(String command) {
        command_ = command;
    }

    protected final S self() {
        return (S) this;
    }

    protected String getCommand() {
        return command_;
    }

    protected BaseProject getProject() {
        return project_;
    }
    
    protected void setOption(String key, String value) {
        options_.put(key, value);
    }

    /**
     * Sets the base directory.
     *
     * @param directory the base directory
     * @return this operation instance
     */
    public S basedir(String directory) {
        setOption("--basedir", directory);
        return self();
    }

    /**
     * Sets the base directory.
     *
     * @param directory the base directory
     * @return this operation instance
     */
    public S basedir(File directory) {
        return basedir(directory.getAbsolutePath());
    }

    /**
     * Sets the base directory.
     *
     * @param directory the base directory
     * @return this operation instance
     */
    public S basedir(Path directory) {
        return basedir(directory.toFile());
    }

    /**
     * Set log level to debug.
     *
     * @return this operation instance
     */
    public S debug() {
        setOption("--debug", EMPTY);
        return self();
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
            args.add(getCommand());

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
    public S fromProject(BaseProject project) {
        project_ = project;
        return self();
    }

    /**
     * Show the help message.
     *
     * @return this operation instance
     */
    public S help() {
        setOption("--help", EMPTY);
        return self();
    }

    /**
     * Set log level to info.
     *
     * @return this operation instance
     */
    public S info() {
        setOption("--info", EMPTY);
        return self();
    }

    /**
     * Output directory.
     *
     * @param directory the output directory
     * @return this operation instance
     */
    public S outputDirectory(String directory) {
        setOption("--output-directory", directory);
        return self();
    }

    /**
     * Output directory.
     *
     * @param directory the output directory
     * @return this operation instance
     */
    public S outputDirectory(File directory) {
        return outputDirectory(directory.getAbsolutePath());
    }

    /**
     * Output directory.
     *
     * @param directory the output directory
     * @return this operation instance
     */
    public S outputDirectory(Path directory) {
        return outputDirectory(directory.toFile());
    }

    /**
     * Sets a System property.
     *
     * @param key   the property key
     * @param value the property value
     * @return this operation instance
     */
    public S systemProperty(String key, String value) {
        setOption("-D", key + '=' + value);
        return self();
    }

    /**
     * Print version information.
     *
     * @return this operation instance
     */
    public S version() {
        setOption("--version", EMPTY);
        return self();
    }

    /**
     * Set log level to warn.
     *
     * @return this operation instance
     */
    public S warn() {
        setOption("--warn", EMPTY);
        return self();
    }
}
