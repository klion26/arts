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

public class OneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length < 2) {
            return true;
        }
        if (bits[bits.length - 2] == 0) {
            return true;
        }
        return !isValide(bits, bits.length - 2);
    }

    private boolean isValide(int[] bits, int length) {
        if (length == 0) {
            return true;
        }
        if (length < 0) {
            return false;
        }

        if (bits[length - 1] == 1) {
            return length > 1 && bits[length - 2] == 1 && isValide(bits, length - 2);
        } else {
            return isValide(bits, length - 1) || (length > 1 && isValide(bits, length - 2));
        }
    }

    public static void main(String[] args) {
        OneBitCharacter oneBitCharacter = new OneBitCharacter();
        int bits[] = new int[]{1, 1, 1, 0};
        System.out.println(oneBitCharacter.isOneBitCharacter(bits));
    }
}

