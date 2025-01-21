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
 * Download assets.
 */
public class JReleaserDownloadOperation extends AbstractJReleaserModelOperation<JReleaserDownloadOperation> {
    public JReleaserDownloadOperation() {
        super("download");
    }

    /**
     * Includes the given downloader by type.
     *
     * @param downloader the downloader type
     * @return this operation instance
     */
    public JReleaserDownloadOperation downloaderByType(String downloader) {
        setOption("--downloader", downloader);
        return this;
    }

    /**
     * Excludes the given downloader by type.
     *
     * @param downloader the downloader type
     * @return this operation instance
     */
    public JReleaserDownloadOperation excludeDownloaderByType(String downloader) {
        setOption("--exclude-downloader", downloader);
        return this;
    }

    /**
     * Includes the given downloader by name.
     *
     * @param name the downloader name
     * @return this operation instance
     */
    public JReleaserDownloadOperation downloaderByName(String name) {
        setOption("--downloader-name", name);
        return this;
    }

    /**
     * Excludes the given downloader by name.
     *
     * @param name the downloader name
     * @return this operation instance
     */
    public JReleaserDownloadOperation excludeDownloaderByName(String name) {
        setOption("--exclude-downloader-name", name);
        return this;
    }
}
