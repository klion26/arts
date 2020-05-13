/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public static void main(String[] args) {
        WordSubsets wordSubsets = new WordSubsets();
        String[] A = new String[]{"cccbb","aacbc","bbccc","baaba","acaba"};
        String[] B = new String[]{"cb","b","cb"};
        for (String str : wordSubsets.wordSubsets(A, B)) {
            System.out.println(str);
        }
    }

    public List<String> wordSubsets(String[] A, String[] B) {

        final int ALPHA_COUNT = 26;
        Integer[][] counts = new Integer[A.length][ALPHA_COUNT];
        calculateCharCount(A, counts, ALPHA_COUNT);

        Integer[] needCount = initList(ALPHA_COUNT, 0);
        calculateNeededCount(B, needCount, ALPHA_COUNT);

        return calculateResult(A, counts, needCount, ALPHA_COUNT);
    }

    private void calculateCharCount(
            String[] A,
            Integer[][] counts,
            int ALPHA_COUNT) {
        int idx;
        for (int i = 0; i < A.length; ++i) {
            Integer[] innerCount = initList(ALPHA_COUNT, 0);
            counts[i] = innerCount;
            String str = A[i];
            int len = str.length();
            for (int j = 0; j < len; ++j) {
                idx = str.charAt(j) - 'a';
                innerCount[idx] = innerCount[idx] + 1;
            }
        }
    }

    private void calculateNeededCount(
            String[] B,
            Integer[] needCount,
            int ALPHA_COUNT) {
        int idx;
        for (int i = 0; i < B.length; ++i) {
            Integer[] innerCount = initList(ALPHA_COUNT, 0);

            String str = B[i];
            int strLen = str.length();
            for (int j = 0; j < strLen; ++j) {
                idx = str.charAt(j) - 'a';
                innerCount[idx] = innerCount[idx] + 1;
            }

            for (int j = 0; j < ALPHA_COUNT; ++j) {
                if (innerCount[j] > needCount[j]) {
                    needCount[j] = innerCount[j];
                }
            }
        }
    }

    private List<String> calculateResult(
            String[] A,
            Integer[][] counts,
            Integer[] needCount,
            int ALPHA_COUNT) {
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < A.length; ++i) {
            Integer[] count = counts[i];
            int j = 0;
            for (;j < ALPHA_COUNT; ++j) {
                if (count[j] < needCount[j]) {
                    break;
                }
            }

            if (j < ALPHA_COUNT) {
                for (; j < ALPHA_COUNT; ++j) {
                    if (count[j] != 0 || needCount[j] != 0) {
                        break;
                    }
                }
            }

            if (j == ALPHA_COUNT) {
                ret.add(A[i]);
            }
        }
        return ret;
    }

    private Integer[] initList(int length, Integer init) {
        Integer[] list = new Integer[length];
        for (int i = 0; i < length; ++i) {
            list[i] = init;
        }
        return list;
    }
}

