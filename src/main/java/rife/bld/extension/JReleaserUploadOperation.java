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
 * Upload assets.
 */
public class JReleaserUploadOperation extends AbstractJReleaserDistributionModelOperation<JReleaserUploadOperation> {
    public JReleaserUploadOperation() {
        super("upload");
    }

    /**
     * Includes the given uploader by type.
     *
     * @param uploader the uploader type
     * @return this operation instance
     */
    public JReleaserUploadOperation uploaderByType(String uploader) {
        setOption("--uploader", uploader);
        return this;
    }

    /**
     * Excludes the given uploader by type.
     *
     * @param uploader the uploader type
     * @return this operation instance
     */
    public JReleaserUploadOperation excludeUploaderByType(String uploader) {
        setOption("--exclude-uploader", uploader);
        return this;
    }

    /**
     * Includes the given uploader by name.
     *
     * @param name the uploader name
     * @return this operation instance
     */
    public JReleaserUploadOperation uploaderByName(String name) {
        setOption("--uploader-name", name);
        return this;
    }

    /**
     * Excludes the given uploader by name.
     *
     * @param name the uploader name
     * @return this operation instance
     */
    public JReleaserUploadOperation excludeUploaderByName(String name) {
        setOption("--exclude-uploader-name", name);
        return this;
    }

    /**
     * Includes the given cataloger.
     *
     * @param cataloger the cataloger name
     * @return this operation instance
     */
    public JReleaserUploadOperation cataloger(String cataloger) {
        setOption("--cataloger", cataloger);
        return this;
    }

    /**
     * Excludes the given cataloger.
     *
     * @param cataloger the cataloger name
     * @return this operation instance
     */
    public JReleaserUploadOperation excludeCataloger(String cataloger) {
        setOption("--exclude-cataloger", cataloger);
        return this;
    }
}
