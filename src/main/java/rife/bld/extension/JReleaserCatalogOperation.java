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
 * Catalog release assets.
 */
public class JReleaserCatalogOperation extends AbstractJReleaserDistributionModelOperation<JReleaserCatalogOperation> {
    public JReleaserCatalogOperation() {
        super("catalog");
    }

    /**
     * Includes the given cataloger.
     *
     * @param cataloger the cataloger name
     * @return this operation instance
     */
    public JReleaserCatalogOperation cataloger(String cataloger) {
        setOption("--cataloger", cataloger);
        return this;
    }

    /**
     * Excludes the given cataloger.
     *
     * @param cataloger the cataloger name
     * @return this operation instance
     */
    public JReleaserCatalogOperation excludeCataloger(String cataloger) {
        setOption("--exclude-cataloger", cataloger);
        return this;
    }

    /**
     * Includes the given deployer by type.
     *
     * @param deployer the deployer type
     * @return this operation instance
     */
    public JReleaserCatalogOperation deployerByType(String deployer) {
        setOption("--deployer", deployer);
        return this;
    }

    /**
     * Excludes the given deployer by type.
     *
     * @param deployer the deployer type
     * @return this operation instance
     */
    public JReleaserCatalogOperation excludeDeployerByType(String deployer) {
        setOption("--exclude-deployer", deployer);
        return this;
    }

    /**
     * Includes the given deployer by name.
     *
     * @param name the deployer name
     * @return this operation instance
     */
    public JReleaserCatalogOperation deployerByName(String name) {
        setOption("--deployer-name", name);
        return this;
    }

    /**
     * Excludes the given deployer by name.
     *
     * @param name the deployer name
     * @return this operation instance
     */
    public JReleaserCatalogOperation excludeDeployerByName(String name) {
        setOption("--exclude-deployer-name", name);
        return this;
    }
}
