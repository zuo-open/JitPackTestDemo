/*
 * Copyright (C) 2015 Marie Schweiz & Lars Werkman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.haier.cellarette.baselibrary.lobsterpicker;

import androidx.annotation.ColorInt;

/**
 * Color decorator interface, implementations of this interface can be attached
 * to the {@link LobsterPicker}. {@link LobsterPicker.Chain}
 * will provide a link to the attached parent.
 */
public interface ColorDecorator {
    /**
     * Gets called each time parent of the decorator's color changes
     *
     * @param chain {@link LobsterPicker.Chain} back to the attacked parent.
     * @param color new color
     */
    void onColorChanged(LobsterPicker.Chain chain, @ColorInt int color);
}