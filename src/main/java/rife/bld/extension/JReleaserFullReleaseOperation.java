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
 * Perform a full release.
 */
public class JReleaserFullReleaseOperation extends AbstractJReleaserDistributionModelOperation<JReleaserFullReleaseOperation> {
    public JReleaserFullReleaseOperation() {
        super("full-release");
    }

    /**
     * Includes the given uploader by type.
     *
     * @param uploader the uploader type
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation uploaderByType(String uploader) {
        setOption("--uploader", uploader);
        return this;
    }

    /**
     * Excludes the given uploader by type.
     *
     * @param uploader the uploader type
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation excludeUploaderByType(String uploader) {
        setOption("--exclude-uploader", uploader);
        return this;
    }

    /**
     * Includes the given uploader by name.
     *
     * @param name the uploader name
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation uploaderByName(String name) {
        setOption("--uploader-name", name);
        return this;
    }

    /**
     * Excludes the given uploader by name.
     *
     * @param name the uploader name
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation excludeUploaderByName(String name) {
        setOption("--exclude-uploader-name", name);
        return this;
    }

    /**
     * Includes the given cataloger.
     *
     * @param cataloger the cataloger name
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation cataloger(String cataloger) {
        setOption("--cataloger", cataloger);
        return this;
    }

    /**
     * Excludes the given cataloger.
     *
     * @param cataloger the cataloger name
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation excludeCataloger(String cataloger) {
        setOption("--exclude-cataloger", cataloger);
        return this;
    }

    /**
     * Includes the given deployer by type.
     *
     * @param deployer the deployer type
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation deployerByType(String deployer) {
        setOption("--deployer", deployer);
        return this;
    }

    /**
     * Excludes the given deployer by type.
     *
     * @param deployer the deployer type
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation excludeDeployerByType(String deployer) {
        setOption("--exclude-deployer", deployer);
        return this;
    }

    /**
     * Includes the given deployer by name.
     *
     * @param name the deployer name
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation deployerByName(String name) {
        setOption("--deployer-name", name);
        return this;
    }

    /**
     * Excludes the given deployer by name.
     *
     * @param name the deployer name
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation excludeDeployerByName(String name) {
        setOption("--exclude-deployer-name", name);
        return this;
    }

    /**
     * Includes the given announcer.
     *
     * @param announcer the announcer name
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation announcer(String announcer) {
        setOption("--announcer", announcer);
        return this;
    }

    /**
     * Excludes the given announcer.
     *
     * @param announcer the announcer name
     * @return this operation instance
     */
    public JReleaserFullReleaseOperation excludeAnnouncer(String announcer) {
        setOption("--exclude-announcer", announcer);
        return this;
    }
}
