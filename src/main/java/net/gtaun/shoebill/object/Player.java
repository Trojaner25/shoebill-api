/**
 * Copyright (C) 2011 MK124
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

import net.gtaun.shoebill.data.Area;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.LocationAngle;
import net.gtaun.shoebill.data.LocationRadius;
import net.gtaun.shoebill.data.SpawnInfo;
import net.gtaun.shoebill.data.Time;
import net.gtaun.shoebill.data.Point3D;
import net.gtaun.shoebill.data.Velocity;
import net.gtaun.shoebill.data.WeaponData;
import net.gtaun.shoebill.data.constant.DialogStyle;
import net.gtaun.shoebill.data.constant.FightStyle;
import net.gtaun.shoebill.data.constant.MapIconStyle;
import net.gtaun.shoebill.data.constant.PlayerState;
import net.gtaun.shoebill.data.constant.RecordType;
import net.gtaun.shoebill.data.constant.ShopName;
import net.gtaun.shoebill.data.constant.SpecialAction;
import net.gtaun.shoebill.data.constant.SpectateMode;
import net.gtaun.shoebill.data.constant.WeaponState;
import net.gtaun.shoebill.data.constant.WeaponType;
import net.gtaun.shoebill.exception.AlreadyExistException;
import net.gtaun.shoebill.exception.IllegalLengthException;

/**
 * @author MK124
 *
 */

public interface Player
{
	public static final int INVALID_ID =							0xFFFF;
	public static final int NO_TEAM =								255;
	public static final int MAX_NAME_LENGTH =						24;
	
	public static final int MAX_CHATBUBBLE_LENGTH =					144;
	
	
	boolean isOnline();
	
	int getId();

	PlayerKeyState getKeyState();
	PlayerAttach getPlayerAttach();
	PlayerWeaponSkill getWeaponSkill();
	
	int getPing();
	int getTeamId();
	int getSkinId();
	int getWantedLevel();
	int getCodepage();
	String getIp();
	String getName();
	Color getColor();

	int getUpdateFrameCount();
	float getHealth();
	float getArmour();
	WeaponType getArmedWeapon();
	int getArmedWeaponAmmo();
	int getMoney();
	int getScore();
	int getWeatherId();
	int getCameraMode();
	FightStyle getFightStyle();
	Vehicle getVehicle();
	int getVehicleSeat();
	SpecialAction getSpecialAction();
	Player getSpectatingPlayer();
	Vehicle getSpectatingVehicle();
	
	LocationAngle getLocation();
	Area getWorldBound();
	Velocity getVelocity();
	PlayerState getState();
	Checkpoint getCheckpoint();
	RaceCheckpoint getRaceCheckpoint();
	
	Dialog getDialog();

	boolean isStuntBonusEnabled();
	boolean isSpectating();
	boolean isRecording();
	boolean isControllable();
	
	void setCodepage( int codepage );
	void setName( String name ) throws IllegalArgumentException, IllegalLengthException, AlreadyExistException;

	void setSpawnInfo( float x, float y, float z, int interiorId, int worldId, float angle, int skinId, int teamId, WeaponType weapon1, int ammo1, WeaponType weapon2, int ammo2, WeaponType weapon3, int ammo3 );
	void setSpawnInfo( Point3D pos, int interiorId, int worldId, float angle, int skinId, int teamId, WeaponData weapon1, WeaponData weapon2, WeaponData weapon3 );
	void setSpawnInfo( Location loc, float angle, int skinId, int teamId, WeaponData weapon1, WeaponData weapon2, WeaponData weapon3 );
	void setSpawnInfo( LocationAngle loc, int skin, int team, WeaponData weapon1, WeaponData weapon2, WeaponData weapon3 );
	void setSpawnInfo( SpawnInfo info );
	
	void setColor( Color color );
	void setHealth( float health );
	void setArmour( float armour);
	void setWeaponAmmo( int slot, int ammo );
	void setMoney( int money );
	void giveMoney( int money );
	void setScore( int score );
	void setWeatherId( int weatherId );
	void setFightStyle( FightStyle style );
	
	void setVehicle( Vehicle vehicle, int seat );
	void setVehicle( Vehicle vehicle );
	
	void setLocation( float x, float y, float z );
	void setLocation( Point3D pos );
	void setLocation( Location loc );
	void setLocation( LocationAngle loc );

	void setLocationFindZ( float x, float y, float z );
	void setLocationFindZ( Point3D pos );
	void setLocationFindZ( Location loc );
	void setLocationFindZ( LocationAngle loc );
	
	void setAngle( float angle );
	void setInteriorId( int interiorId );
	void setWorldId( int worldId );
	void setWorldBound( Area bound );
	void setVelocity( Point3D vel );

	void sendMessage( Color color, String message );
	void sendMessage( Color color, String format, Object... args );
	
	void sendChat( Player player, String message );
	void sendChatToAll( String message );
	void sendDeathMessage( Player killer, int reason );
	
	void sendGameText( int time, int style, String text );
	void sendGameText( int time, int style, String format, Object... args );
	
	void spawn();
	void setDrunkLevel( int level );
	int getDrunkLevel();
	
	void applyAnimation( String animlib, String animname, float delta, int loop, int lockX, int lockY, int freeze, int time, int forcesync );
	void clearAnimations( int forcesync );
	int getAnimationIndex();
	
	void playSound( int sound, float x, float y, float z );
	void playSound( int sound, Point3D pos );
	
	void markerForPlayer( Player player, Color color );
	void showNameTagForPlayer( Player player, boolean show );
	
	void kick();
	void ban();
	void ban( String reason );
	
	Menu getMenu();
	
	void setCameraPosition( float x, float y, float z );
	void setCameraPosition( Point3D pos );
	
	void setCameraLookAt( float x, float y, float z );
	void setCameraLookAt( Point3D pos );
	
	void setCameraBehind();
	Point3D getCameraPosition();
	Point3D getCameraFrontVector();
	
	boolean isInAnyVehicle();
	boolean isInVehicle( Vehicle veh );
	boolean isAdmin();
	boolean isStreamedIn( Player forPlayer );
	
	void setCheckpoint( Checkpoint checkpoint );
	void disableCheckpoint();
	void setRaceCheckpoint( RaceCheckpoint checkpoint );
	void disableRaceCheckpoint();
	
	void setTeam( int team );
	void setSkin( int skin );

	WeaponState getWeaponState();
	
	void giveWeapon( WeaponType type, int ammo );
	void giveWeapon( WeaponData data );
	
	void resetWeapons();

	Time getTime();
	
	void setTime( int hour, int minute );
	void setTime( Time time );
	
	void toggleClock( boolean toggle );
	void forceClassSelection();
	void setWantedLevel( int level );
	void playCrimeReport( int suspectId, int crimeId );
	void setShopName( ShopName shop );
	
	Vehicle getSurfingVehicle();
	void removeFromVehicle();
	
	void toggleControllable( boolean toggle );
	void setSpecialAction( SpecialAction action );

	void setMapIcon( int iconId, float x, float y, float z, int markerType, Color color, MapIconStyle style );
	void setMapIcon( int iconId, Point3D pos, int markerType, Color color, MapIconStyle style );
	
	void removeMapIcon( int iconId );
	void enableStuntBonus( boolean enabled );
	
	void toggleSpectating( boolean toggle );
	void spectate( Player player, SpectateMode mode );
	void spectate( Vehicle veh, SpectateMode mode );
	
	void startRecord( RecordType type, String recordName );
	void stopRecord();
	
	IObject getSurfingObject();
	String getNetworkStats();
	
	Player getAimedTarget();
	
	void playAudioStream( String url );
	void playAudioStream( String url, float x, float y, float z, float distance );
	void playAudioStream( String url, Point3D location, float distance );
	void playAudioStream( String url, LocationRadius loc );
	void stopAudioStream();

	void removeBuilding( int modelId, float x, float y, float z, float radius );
	void removeBuilding( int modelId, Point3D pos, float radius );
	void removeBuilding( int modelId, LocationRadius loc );

	void showDialog( Dialog dialog, DialogStyle style, String caption, String text, String button1, String button2 );
	void cancelDialog();
}