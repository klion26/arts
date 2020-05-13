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

public class MinimumFaillingSum {

    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        int[][] dp = new int[row][];
        int column = A[0].length;
        int ans = Integer.MAX_VALUE;
        dp[0] = new int[column];
        for (int j = 0; j < column; ++j) {
            dp[0][j] = A[0][j];
        }
        int left, upper, right;
        for (int i = 1; i < row; ++i) {
            dp[i] = new int[column];
            for (int j = 0; j < column; ++j) {
                left = (j == 0) ? Integer.MAX_VALUE : dp[i-1][j-1];
                upper = dp[i-1][j];
                right = (j == column - 1) ? Integer.MAX_VALUE : dp[i - 1][j+1];
                dp[i][j] = Math.min(left, Math.min(upper, right)) + A[i][j];
            }
        }
        for (int j = 0; j < column; ++j) {
            if (ans > dp[row - 1][j]) {
                ans = dp[row - 1][j];
            }
        }
        return ans;
    }

}

