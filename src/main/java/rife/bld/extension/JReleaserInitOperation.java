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

/**
 * Create a JReleaser config file.
 */
public class JReleaserInitOperation extends AbstractJReleaserOperation<JReleaserInitOperation> {
    public JReleaserInitOperation() {
        super("init");
    }

    /**
     * Sets the format.
     *
     * @param format the format
     * @return this operation instance
     */
    public JReleaserInitOperation format(Format format) {
        setOption("--format", format.getFormat());
        return this;
    }

    /**
     * Overwrite existing files.
     *
     * @return this operation instance
     */
    public JReleaserInitOperation overwrite() {
        setOption("--overwrite");
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
