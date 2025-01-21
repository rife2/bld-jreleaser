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
 * Base class for JReleaser operations that are platform aware.
 */
public class AbstractJReleaserPlatformAwareModelOperation<S extends AbstractJReleaserPlatformAwareModelOperation<S>> extends AbstractJReleaserModelOperation<S> {
    public AbstractJReleaserPlatformAwareModelOperation(String command) {
        super(command);
    }

    /**
     * Enables dry-run mode.
     *
     * @return this operation instance
     */
    public S dryRun() {
        setOption("--dry-run", EMPTY);
        return self();
    }

    /**
     * Limits artifact selection to the current platform.
     *
     * @return this operation instance
     */
    public S selectCurrentPlatform() {
        setOption("--select-current-platform", EMPTY);
        return self();
    }

    /**
     * Limits artifact selection to the given platform.
     *
     * @param platform the platform value
     * @return this operation instance
     */
    public S selectPlatform(String platform) {
        setOption("--select-platform", platform);
        return self();
    }

    /**
     * Excludes artifact selection from the given platform.
     *
     * @param platform the platform value
     * @return this operation instance
     */
    public S rejectPlatform(String platform) {
        setOption("--reject-platform", platform);
        return self();
    }
}
