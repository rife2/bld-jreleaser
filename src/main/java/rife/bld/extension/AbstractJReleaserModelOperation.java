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
 * Base class for JReleaser operations that resolve a model.
 */
public class AbstractJReleaserModelOperation<S extends AbstractJReleaserModelOperation<S>> extends AbstractJReleaserOperation<S> {
    public AbstractJReleaserModelOperation(String command) {
        super(command);
    }

    /**
     * Input configFile.
     *
     * @param configFile the input configFile
     * @return this operation instance
     */
    public S configFile(String configFile) {
        setOption("--config-file", configFile);
        return self();
    }

    /**
     * Input configFile.
     *
     * @param configFile the input configFile
     * @return this operation instance
     */
    public S configFile(File configFile) {
        return configFile(configFile.getAbsolutePath());
    }

    /**
     * Input configFile.
     *
     * @param configFile the input configFile
     * @return this operation instance
     */
    public S configFile(Path configFile) {
        return configFile(configFile.toFile());
    }

    /**
     * Searches for a .git directory at the project's root directory.
     *
     * @return this operation instance
     */
    public S gitRootSearch() {
        setOption("--git-root-search", EMPTY);
        return self();
    }

    /**
     * Sets strict mode.
     *
     * @return this operation instance
     */
    public S strict() {
        setOption("--strict", EMPTY);
        return self();
    }

    /**
     * Sets a project property.
     *
     * @param key   the property key
     * @param value the property value
     * @return this operation instance
     */
    public S projectProperty(String key, String value) {
        setOption("-P", key + '=' + value);
        return self();
    }
}
