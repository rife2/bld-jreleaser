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
 * Calculate checksum files.
 */
public class JReleaserTemplateGenerateOperation extends AbstractJReleaserOperation<JReleaserTemplateGenerateOperation> {
    public JReleaserTemplateGenerateOperation() {
        super("template generate");
    }

    /**
     * Use snapshot templates.
     *
     * @return this operation instance
     */
    public JReleaserTemplateGenerateOperation snapshot() {
        setOption("--snapshot");
        return this;
    }

    /**
     * Includes the given distribution.
     *
     * @param distribution the distribution name
     * @return this operation instance
     */
    public JReleaserTemplateGenerateOperation distribution(String distribution) {
        setOption("--distribution", distribution);
        return self();
    }

    /**
     * Includes the given distribution by type.
     *
     * @param type the distribution type
     * @return this operation instance
     */
    public JReleaserTemplateGenerateOperation distributionByType(String type) {
        setOption("--distribution-type", type);
        return this;
    }

    /**
     * Excludes the given distribution.
     *
     * @param distribution the distribution name
     * @return this operation instance
     */
    public JReleaserTemplateGenerateOperation excludeDistribution(String distribution) {
        setOption("--exclude-distribution", distribution);
        return self();
    }

    /**
     * Includes the given announcer.
     *
     * @param announcer the announcer name
     * @return this operation instance
     */
    public JReleaserTemplateGenerateOperation announcer(String announcer) {
        setOption("--announcer", announcer);
        return this;
    }

    /**
     * Includes the given assembler by name.
     *
     * @param assembler the assembler name
     * @return this operation instance
     */
    public JReleaserTemplateGenerateOperation assemblerByName(String assembler) {
        setOption("--assembler", assembler);
        return this;
    }

    /**
     * Includes the given assembler by type.
     *
     * @param type the assembler type
     * @return this operation instance
     */
    public JReleaserTemplateGenerateOperation assemblerByType(String type) {
        setOption("--assembler-type", type);
        return this;
    }

    /**
     * Includes the given packager.
     *
     * @param packager the packager name
     * @return this operation instance
     */
    public JReleaserTemplateGenerateOperation packager(String packager) {
        setOption("--packager", packager);
        return self();
    }

    /**
     * Excludes the given packager.
     *
     * @param packager the packager name
     * @return this operation instance
     */
    public JReleaserTemplateGenerateOperation excludePackager(String packager) {
        setOption("--exclude-packager", packager);
        return self();
    }
}
