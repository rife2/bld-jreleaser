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

import java.io.File;
import java.nio.file.Path;

/**
 * Create a JReleaser config file.
 */
public class JReleaserTemplateEvalOperation extends AbstractJReleaserPlatformAwareModelOperation<JReleaserTemplateEvalOperation> {
    public JReleaserTemplateEvalOperation() {
        super("template eval");
    }

    /**
     * Overwrite existing files.
     *
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation overwrite() {
        setOption("--overwrite", EMPTY);
        return this;
    }

    /**
     * Display announce configuration.
     *
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation announce() {
        setOption("--announce", EMPTY);
        return this;
    }

    /**
     * Display assembly configuration.
     *
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation assembly() {
        setOption("--assembly", EMPTY);
        return this;
    }

    /**
     * Display changelog configuration.
     *
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation changelog() {
        setOption("--changelog", EMPTY);
        return this;
    }

    /**
     * Display download configuration.
     *
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation download() {
        setOption("--download", EMPTY);
        return this;
    }

    /**
     * Input file.
     *
     * @param file the input file
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation inputFile(String file) {
        setOption("--input-file", file);
        return this;
    }

    /**
     * Input file.
     *
     * @param file the input file
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation inputFile(File file) {
        return inputFile(file.getAbsolutePath());
    }

    /**
     * Input file.
     *
     * @param file the input file
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation inputFile(Path file) {
        return inputFile(file.toFile());
    }

    /**
     * Input directory.
     *
     * @param directory the input directory
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation inputDirectory(String directory) {
        setOption("--input-directory", directory);
        return this;
    }

    /**
     * Input directory.
     *
     * @param directory the input directory
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation inputDirectory(File directory) {
        return inputDirectory(directory.getAbsolutePath());
    }

    /**
     * Input directory.
     *
     * @param directory the input directory
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation inputDirectory(Path directory) {
        return inputDirectory(directory.toFile());
    }

    /**
     * Target directory.
     *
     * @param directory the target directory
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation targetDirectory(String directory) {
        setOption("--target-directory", directory);
        return this;
    }

    /**
     * Target directory.
     *
     * @param directory the target directory
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation targetDirectory(File directory) {
        return targetDirectory(directory.getAbsolutePath());
    }

    /**
     * Target directory.
     *
     * @param directory the target directory
     * @return this operation instance
     */
    public JReleaserTemplateEvalOperation targetDirectory(Path directory) {
        return targetDirectory(directory.toFile());
    }
}
