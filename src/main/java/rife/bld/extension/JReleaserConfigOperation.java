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
public class JReleaserConfigOperation extends AbstractJReleaserPlatformAwareModelOperation<JReleaserConfigOperation> {
    public JReleaserConfigOperation() {
        super("config");
    }

    /**
     * Display full configuration.
     *
     * @return this operation instance
     */
    public JReleaserConfigOperation full() {
        setOption("--full");
        return this;
    }

    /**
     * Display announce configuration.
     *
     * @return this operation instance
     */
    public JReleaserConfigOperation announce() {
        setOption("--announce");
        return this;
    }

    /**
     * Display assembly configuration.
     *
     * @return this operation instance
     */
    public JReleaserConfigOperation assembly() {
        setOption("--assembly");
        return this;
    }

    /**
     * Display changelog configuration.
     *
     * @return this operation instance
     */
    public JReleaserConfigOperation changelog() {
        setOption("--changelog");
        return this;
    }

    /**
     * Display download configuration.
     *
     * @return this operation instance
     */
    public JReleaserConfigOperation download() {
        setOption("--download");
        return this;
    }
}
