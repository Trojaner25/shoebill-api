/**
 * Copyright (C) 2012 MK124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.gtaun.shoebill.constant;

/**
 * To be used with TextDraw and PlayerTextDraw.
 * 
 * @author MK124
 */
public enum TextDrawFont
{
	DIPLOMA(0),
	FONT2(1),
	BANK_GOTHIC(2),
	PRICEDOWN(3),
	SPRITE_DRAW(4),
	MODEL_PREVIEW(5);
	
	
	public static TextDrawFont get(int value)
	{
		return values() [value];
	}
	
	
	private final int value;
	
	
	private TextDrawFont(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
}
