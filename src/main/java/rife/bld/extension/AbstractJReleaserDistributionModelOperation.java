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
 * Base class for JReleaser operations that rely on distributions.
 */
public class AbstractJReleaserDistributionModelOperation<S extends AbstractJReleaserDistributionModelOperation<S>> extends AbstractJReleaserPlatformAwareModelOperation<S> {
    public AbstractJReleaserDistributionModelOperation(String command) {
        super(command);
    }

    /**
     * Includes the given distribution.
     *
     * @param distribution the distribution name
     * @return this operation instance
     */
    public S distribution(String distribution) {
        setOption("--distribution", distribution);
        return self();
    }

    /**
     * Excludes the given distribution.
     *
     * @param distribution the distribution name
     * @return this operation instance
     */
    public S excludeDistribution(String distribution) {
        setOption("--exclude-distribution", distribution);
        return self();
    }
}
