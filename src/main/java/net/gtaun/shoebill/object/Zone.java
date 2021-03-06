/**
 * Copyright (C) 2011-2014 MK124
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

package net.gtaun.shoebill.object;

import java.util.Collection;

import net.gtaun.shoebill.SampObjectManager;
import net.gtaun.shoebill.data.Area;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.RangeCheckable3D;
import net.gtaun.shoebill.exception.CreationFailedException;

/**
 * 
 * 
 * @author MK124
 */
public interface Zone extends Destroyable, Proxyable<Zone>, RangeCheckable3D
{
	public static Zone get(int id)
	{
		return SampObjectManager.get().getZone(id);
	}
	
	public static Collection<Zone> get()
	{
		return SampObjectManager.get().getZones();
	}
	
    /**
     * Create a Zone with params. If the Creation fails, it will throw a CreationFailedException.
     * @param minX The Min-X Position of the Zone.
     * @param minY The Min-Y Position of the Zone.
     * @param maxX The Max-X Position of the Zone.
     * @param maxY The Max-Y Position of the Zone.
     * @return The created Zone.
     */
	public static Zone create(float minX, float minY, float maxX, float maxY) throws CreationFailedException
	{
		return SampObjectManager.get().createZone(minX, minY, maxX, maxY);
	}

    /**
     * Create a Zone with params. If the Creation fails, it will throw a CreationFailedException.
     * @param area The Area-Position of the Zone.
     * @return The created Zone.
     */
	public static Zone create(Area area) throws CreationFailedException
	{
		return SampObjectManager.get().createZone(area);
	}

	
	public static final int INVALID_ID = -1;
	
	
	int getId();
	Area getArea();
	
	void show(Player player, Color color);
	void hide(Player player);
	void flash(Player player, Color color);
	void stopFlash(Player player);
	
	void showForAll(Color color);
	void hideForAll();
	
	void flashForAll(Color color);
	void stopFlashForAll();
}
