// Copyright (C) 2016 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.server.patch;

import com.google.common.cache.Weigher;

/** Computes memory usage for FileList in bytes of memory used */
public class FileListWeigher implements Weigher<PatchListKey, FileList> {

  @Override
  public int weigh(PatchListKey key, FileList value) {
    int size = 16 + 4 * 8 + 2 * 36; // Size of PatchListKey, 64 bit JVM

    // Size of the list of paths ...
    for (String p : value.getPaths()) {
      size += p.length();
    }
    // ... plus new-line separators between paths
    size += value.getPaths().size() - 1;

    return size;
  }
}